package com.se_b4.catchtable.service;

import com.se_b4.catchtable.authority.UserAuthority;
import com.se_b4.catchtable.entity.*;
import com.se_b4.catchtable.dto.UserDTO;
import com.se_b4.catchtable.repository.AdminRepository;
import com.se_b4.catchtable.repository.MemberRepository;
import com.se_b4.catchtable.repository.OwnerRepository;
import com.se_b4.catchtable.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 회원과 관련된 로직을 작성하는 클래스입니다.
@RequiredArgsConstructor
@Service
public class UserService {
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

//    public UserDTO Signin(UserDTO userDTO) throws UsernameNotFoundException {
//        Optional<UserEntity> byUserid = this.userRepository.findByUserid(userDTO.getUserid());
//        if (byUserid.isPresent()) {
//            UserEntity userEntity = byUserid.get();
//            System.out.println("Received userid: " + userDTO.getUserid());
//            System.out.println("Received password: " + userDTO.getPassword());
//            // 비밀번호를 암호화된 형태로 비교
//            if (!passwordEncoder.matches(userDTO.getPassword(), userEntity.getPassword())) {
//                throw new BadCredentialsException("비밀번호가 잘못되었습니다.");
//            } else {
//                return UserDTO.toUserDTO(userEntity);
//            }
//        } else {
//            throw new UsernameNotFoundException("유저를 찾을 수 없습니다.");
//        }
//    }

//    public UserDTO Signin (UserDTO userDTO) {
//        /*
//            1. 회원이 입력한 이메일로 DB에서 조회를 함
//            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
//         */
//        Optional<UserEntity> byUserid = this.userRepository.findByUserid(userDTO.getUserid());
//        if (byUserid.isPresent()) {
//            // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
//            UserEntity userEntity = byUserid.get();
//            if (passwordEncoder.matches(userDTO.getPassword(), userEntity.getPassword())) {
//                // 비밀번호 일치
//                // entity -> dto 변환 후 리턴
//                UserDTO dto = UserDTO.toUserDTO(userEntity);
//                return dto;
//            } else {
//                // 비밀번호 불일치(로그인실패)
//                return null;
//            }
//        } else {
//            // 조회 결과가 없다(해당 이메일을 가진 회원이 없다)
//            return null;
//        }
//    }
//    @Override
//    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//        Optional<UserEntity> byUserid = this.userRepository.findByUserid(userid);
//        if (byUserid.isEmpty()) {
//            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
//        }
//        UserEntity user = byUserid.get();
//        List<GrantedAuthority> authorities = new ArrayList<>();
////        if ("admin".equals(username)) {
////            authorities.add(new SimpleGrantedAuthority(MemberAuthority.ADMIN.getName()));
////        } else {
////            authorities.add(new SimpleGrantedAuthority(MemberAuthority.USER.getName()));
////        }
//        return new CurrentUser(user.getUserid(), user.getPassword(), authorities, user);
//    }

//    public List<UserDTO> findAll() {
//        List<UserEntity> userEntityList = userRepository.findAll();
//        List<UserDTO> userDTOList = new ArrayList<>();
//        for (UserEntity userEntity: userEntityList) {
//            userDTOList.add(UserDTO.toUserDTO(userEntity));
//            // 아래랑 같은 의미
//            //UserDTO userDTO = UserDTO.toUserDTO(userEntity);
//            //UserDTOList.add(userDTO);
//        }
//        return userDTOList;
//    }
}