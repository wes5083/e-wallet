package com.demo.ewallet.controller;

import com.demo.ewallet.service.WalletService;
import com.demo.ewallet.vo.ResponseVo;
import com.demo.ewallet.vo.WalletRequestVo;
import com.demo.ewallet.vo.WalletVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    /**
     * Get wallet info, include transaction record
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getWallet(@PathVariable Long userId) {
        return ResponseEntity.ok(ResponseVo.success(walletService.getWallet(userId)));
    }

    /**
     * open a wallet
     *
     * @param walletVo
     * @return
     */
    @PostMapping("/open")
    public ResponseEntity<?> openWallet(@RequestBody WalletVo walletVo) {
        return ResponseEntity.ok(walletService.addWallet(walletVo));
    }

    /**
     * top up
     *
     * @param walletRequestVo
     * @return
     */
    @PostMapping("/topUp")
    public ResponseEntity<?> popup(@RequestBody WalletRequestVo walletRequestVo) {
        return ResponseEntity.ok(walletService.topUp(walletRequestVo));
    }

    /**
     * withdraw
     *
     * @param walletRequestVo
     * @return
     */
    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody WalletRequestVo walletRequestVo) {
        return ResponseEntity.ok(walletService.withdraw(walletRequestVo));
    }

    /**
     * transact from a wallet to another
     *
     * @param walletRequestVo
     * @return
     */
    @PostMapping("/transaction")
    public ResponseEntity<?> transaction(@RequestBody WalletRequestVo walletRequestVo) {
        return ResponseEntity.ok(walletService.transaction(walletRequestVo));
    }

}
