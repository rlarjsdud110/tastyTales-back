package com.example.tastytales.controller;

import com.example.tastytales.dto.UserDTO;
import com.example.tastytales.dto.request.UserRequestDTO;
import com.example.tastytales.dto.response.FoodResponseDTO;
import com.example.tastytales.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO){
        userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공 ");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDTO userRequestDTO){
        String accessToken = userService.login(userRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(accessToken);
    }
}
