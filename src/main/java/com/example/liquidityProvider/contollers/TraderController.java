package com.example.liquidityProvider.contollers;

import com.example.liquidityProvider.services.TraderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TraderController {
    private final TraderService traderService;
    @GetMapping("/register")
    public ResponseEntity<String> authenticate(Authentication authentication){
        return ResponseEntity.status(HttpStatus.OK).body(traderService.authenticate(authentication));
    }
}
