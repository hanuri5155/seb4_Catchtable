package com.se_b4.catchtable.service;

import com.se_b4.catchtable.authority.UserAuthority;
import com.se_b4.catchtable.entity.*;
import com.se_b4.catchtable.dto.UserDTO;
import com.se_b4.catchtable.repository.AdminRepository;
import com.se_b4.catchtable.repository.MemberRepository;
import com.se_b4.catchtable.repository.OwnerRepository;
import com.se_b4.catchtable.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

// 회원과 관련된 로직을 작성하는 클래스입니다.
@RequiredArgsConstructor
@Service
public class UserService { // implements UserDetailsService
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;
    private final OwnerRepository ownerRepository;
    private final AdminRepository adminRepository;

    public void create(String username, String userid, String password, String phoneNumber, UserAuthority authority) {

        if (authority == UserAuthority.USER) {
            MemberEntity member = MemberEntity.builder()
                    .username(username)
                    .userid(userid)
                    .password(passwordEncoder.encode(password))
                    .phone_number(phoneNumber)
                    .authority(authority)
                    .build();
            memberRepository.save(member);
        } else if (authority == UserAuthority.OWNER) {
            OwnerEntity owner = OwnerEntity.builder()
                    .username(username)
                    .userid(userid)
                    .password(passwordEncoder.encode(password))
                    .phone_number(phoneNumber)
                    .authority(authority)
                    .build();
            ownerRepository.save(owner);
        } else if (authority == UserAuthority.ADMIN) {
            AdminEntity admin = AdminEntity.builder()
                    .username(username)
                    .userid(userid)
                    .password(passwordEncoder.encode(password))
                    .phone_number(phoneNumber)
                    .authority(authority)
                    .build();
            adminRepository.save(admin);
        }
    }

    public UserDTO Signin(UserDTO userDTO) throws UsernameNotFoundException {
        Optional<UserEntity> byUserid = this.userRepository.findByUserid(userDTO.getUserid());
        if (byUserid.isPresent()) {
            UserEntity userEntity = byUserid.get();
            System.out.println("Received userid: " + userDTO.getUserid());
            System.out.println("Received password: " + userDTO.getPassword());
            // 비밀번호를 암호화된 형태로 비교
            if (!passwordEncoder.matches(userDTO.getPassword(), userEntity.getPassword())) {
                throw new BadCredentialsException("비밀번호가 잘못되었습니다.");
            } else {
                return UserDTO.toUserDTO(userEntity);
            }
        } else {
            throw new UsernameNotFoundException("유저를 찾을 수 없습니다.");
        }
    }
}