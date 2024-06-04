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
import jakarta.servlet.http.HttpSession;

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
    public String login(@Valid @ModelAttribute("user") UserDTO userDTO, Model model, HttpSession session, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDTO);  // 유효성 검사 실패 시 모델에 다시 추가
            return "users/signinsignup";
        }

        UserDTO signinResult = userService.Signin(userDTO);

        if (signinResult != null) {
            // login 성공
            session.setAttribute("loggedUuid", signinResult.getUuid());
            session.setAttribute("loggedUserid", signinResult.getUserid());

            return "redirect:/";
        } else {
            // login 실패
            return "users/signin";
        }
    }


//    // 로그아웃
//    @PostMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/";
//    }
}