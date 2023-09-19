package com.example.redditclone.controller;


import com.example.redditclone.dto.RegisterRequest;
import com.example.redditclone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);

    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verifyUserAccount(@PathVariable String token){
        authService.verifyToken(token);
        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
    }
}
