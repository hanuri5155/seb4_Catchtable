package com.se_b4.catchtable.service;

import com.se_b4.catchtable.authority.UserAuthority;
import com.se_b4.catchtable.entity.UserEntity;
import com.se_b4.catchtable.dto.UserDTO;
import com.se_b4.catchtable.repository.UserRepository;
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

    // 가입한 유저를 DB 에 삽입
    public void create(
            String username, String userid, String password, String phone_number, UserAuthority authority
    ){
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setUserid(userid);
        user.setPassword(passwordEncoder.encode(password)); // Spring Security 에서 제공하는 passwordEncoder로 비밀번호를 암호화
        user.setPhone_number(phone_number);
        user.setAuthority(authority);
        this.userRepository.save(user);
    }

    public UserDTO Signin(UserDTO userDTO) throws UsernameNotFoundException {
        Optional<UserEntity> byUserid = this.userRepository.findByUserid(userDTO.getUserid());
        if(byUserid.isPresent()) {
            UserEntity userEntity = byUserid.get();
            if(!userEntity.getPassword().equals(userDTO.getPassword())) {
                throw new UsernameNotFoundException("비밀번호가 잘못되었습니다.");
            }else{
                return UserDTO.toUserDTO(userEntity);
            }
        }
        else return null;
    }

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