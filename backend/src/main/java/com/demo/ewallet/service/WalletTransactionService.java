package com.demo.ewallet.service;

import com.demo.ewallet.vo.ResponseVo;
import com.demo.ewallet.vo.WalletVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class WalletTransactionService {
    private final WalletService walletService;

    public ResponseVo getWalletTransactions(Long userId) {
        WalletVo walletVo = walletService.getWallet(userId);
        return ResponseVo.success(walletVo.getWalletTransactionVos());
    }


}
