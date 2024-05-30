package com.se_b4.catchtable.controller;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.se_b4.catchtable.dto.UserDTO;
import com.se_b4.catchtable.repository.UserRepository;
import com.se_b4.catchtable.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

//    @GetMapping("/signin")
//    public String signin(Model model) {
//        model.addAttribute("user", new UserDTO());
//        return "users/signin";
//    }

    @PostMapping("/signinsignup")
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
    public String login(@ModelAttribute UserDTO userDTO, Model model, HttpSession session) {
//        UserDTO signinResult = userService.loadUserByUsername(userDTO);
//        if (signinResult != null) {
//            // login 성공
//            session.setAttribute("loggedInUser", signinResult.getUserid());
//            return "redirect:/";
//        } else {
//            // login 실패
//            return "users/signin";
//        }
        return "users/signin";
    }

//    @PostMapping("/signin")
//    public String signin(@ModelAttribute UserDTO userDTO, Model model, HttpSession session) {
//        try {
//            UserDTO signinResult = userService.Signin(userDTO);
//            session.setAttribute("loggedInUser", signinResult); // 로그인 성공 시 사용자 정보를 세션에 저장
//            return "redirect:/";  // 로그인 성공 시 리다이렉트
//        } catch (UsernameNotFoundException e) {
//            model.addAttribute("errorMessage", "유저를 찾을 수 없습니다.");
//        } catch (BadCredentialsException e) {
//            model.addAttribute("errorMessage", "비밀번호가 잘못되었습니다.");
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "로그인 중 오류가 발생했습니다.");
//        }
//        model.addAttribute("user", userDTO);  // 로그인 실패 시 모델에 다시 추가
//        model.addAttribute("loginError", "Invalid userid or password.");
//        return "users/signinsignup";  // 로그인 실패 시 로그인 페이지로 돌아감
//    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}