package com.example.myauthentication.security;

import com.example.myauthentication.domain.Token;
import com.example.myauthentication.domain.User;
import com.example.myauthentication.service.UserService;
import com.example.myauthentication.token.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> login(
            final HttpServletRequest req,
            final HttpServletResponse res,
            @Validated @RequestBody Token.Request request) throws Exception {

        User user = userService.findByIdPw(request.getId()).orElseThrow(() -> new IllegalArgumentException("not found!"));

        if(!request.getSecret().equals(user.getPassword())) {
            throw new IllegalArgumentException("check password");
        }

        Authentication authentication = new UserAuthentication(request.getId(), null, null);
        String token = JwtTokenProvider.generateToken(authentication);

        Token.Response response = Token.Response.builder().token(token).build();

        return ResponseEntity.ok(response);
    }


}
