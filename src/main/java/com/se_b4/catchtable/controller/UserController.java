package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.dto.UserDTO;
import com.se_b4.catchtable.repository.UserRepository;
import com.se_b4.catchtable.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/signinsignup")
    public String signinsignup(Model model) {
        model.addAttribute("user", new UserDTO());
        return "users/signinsignup";
    }

//    @GetMapping("/signinsignup")
//    public String signinsignup(@ModelAttribute("user") UserDTO userDTO){
//        return "users/signinsignup";
//    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDTO);  // 유효성 검사 실패 시 모델에 다시 추가
            return "users/signinsignup";
        }
        userService.create(
                userDTO.getUsername(),
                userDTO.getUserid(),
                userDTO.getPassword(),
                userDTO.getPhone_number(),
                userDTO.getAuthority()
        );
        return "redirect:/";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute UserDTO userDTO, Model model) {
        UserDTO signinResult = userService.Signin(userDTO);
        if (signinResult != null) {
            return "redirect:/";
        } else {
            model.addAttribute("user", userDTO);  // 로그인 실패 시 모델에 다시 추가
            return "users/signinsignup";
        }
    }
}