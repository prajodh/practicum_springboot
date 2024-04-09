package iu.edu.ppsunder.primenumbers.controller;

import iu.edu.ppsunder.primenumbers.model.Customer;
import iu.edu.ppsunder.primenumbers.service.IAuthenticationService;
import iu.edu.ppsunder.primenumbers.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin({"*"})
public class AuthenticationController {
    private final IAuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    IAuthenticationService authenticationService,
                                    TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        customer.getUsername(),
                        customer.getPassword()
                )
        );
        return tokenService.generateToken(authentication);
    }



    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) {
        try {
            return authenticationService.register(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
