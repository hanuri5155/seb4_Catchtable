package com.se_b4.catchtable.controller;


import com.se_b4.catchtable.dto.UserDTO;
import com.se_b4.catchtable.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/signinsignup")
    public String signinsignup(@ModelAttribute("user") UserDTO userDTO){
        return "users/signinsignup";
    }

    @PostMapping("/signinsignup")
    public String save(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/signinsignup";
        }
        userService.create(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getPhone_number()
        );
        return "redirect:/";
    }
}
