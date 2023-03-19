package com.demo.ewallet.controller;

import com.demo.ewallet.service.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/walletTransactions")
public class WalletTransactionController {

    private final WalletTransactionService walletTransactionService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getWalletTransactions(@PathVariable Long userId) {
        return ResponseEntity.ok(walletTransactionService.getWalletTransactions(userId));
    }

}
