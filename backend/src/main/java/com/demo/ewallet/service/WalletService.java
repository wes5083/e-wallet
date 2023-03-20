package com.demo.ewallet.service;

import com.demo.ewallet.entity.Wallet;
import com.demo.ewallet.entity.WalletTransaction;
import com.demo.ewallet.enums.WalletTransactionEnum;
import com.demo.ewallet.exception.NotSupportException;
import com.demo.ewallet.mapper.WalletMapper;
import com.demo.ewallet.repo.UserRepo;
import com.demo.ewallet.repo.WalletRepo;
import com.demo.ewallet.repo.WalletTransactionRepo;
import com.demo.ewallet.utils.Constants;
import com.demo.ewallet.vo.ResponseVo;
import com.demo.ewallet.vo.WalletRequestVo;
import com.demo.ewallet.vo.WalletVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class WalletService {

    private final UserRepo userRepo;
    private final WalletRepo walletRepo;
    private final WalletMapper walletMapper;

    private final WalletTransactionRepo walletTransactionRepo;

    /**
     * Get wallet info, include transaction record
     *
     * @param userId
     * @return
     */
    public WalletVo getWallet(Long userId) {
        var wallet = walletRepo.findOneByUserId(userId).orElse(null);
        return walletMapper.toVo(wallet);
    }

    /**
     * Open a wallet
     *
     * @param walletVo
     * @return
     */
    public ResponseVo addWallet(WalletVo walletVo) {
        var walletDB = walletRepo.findOneByUserId(walletVo.getUserId()).orElse(null);
        if (walletDB != null) {
            throw new NotSupportException(Constants.WALLET_ALREADY_EXIST);
        }

        var wallet = new Wallet();
        wallet.setBalance(BigDecimal.ZERO);
        wallet.setCurrency(walletVo.getCurrency());
        wallet.setUserId(walletVo.getUserId());

        return ResponseVo.success(walletMapper.toVo(walletRepo.save(wallet)));
    }


    /**
     * top up service
     *
     * @param walletRequestVo
     * @return
     */
    public ResponseVo topUp(WalletRequestVo walletRequestVo) {
        var result = validateAndTransactionOperateUser(walletRequestVo.getUserId(), walletRequestVo.getAmount(), WalletTransactionEnum.TOP_UP);
        return ResponseVo.success(result);
    }

    /**
     * withdraw
     *
     * @param walletRequestVo
     * @return
     */
    public ResponseVo withdraw(WalletRequestVo walletRequestVo) {
        var result = validateAndTransactionOperateUser(walletRequestVo.getUserId(), walletRequestVo.getAmount(), WalletTransactionEnum.WITHDRAW);
        return ResponseVo.success(result);
    }

    /**
     * transact from a wallet to another
     *
     * @param walletRequestVo
     * @return
     */
    public ResponseVo transaction(WalletRequestVo walletRequestVo) {
        var toUserName = walletRequestVo.getToUserName();
        var amount = walletRequestVo.getAmount();

        var toUser = userRepo.findOneByUserName(toUserName).orElse(null);
        if (toUser == null) {
            throw new NotSupportException(toUserName + Constants.SEPARATOR_COMMA_DASH + Constants.USER_ALREADY_EXIST);
        }

        var wallet = updateWallet(toUser.getId(), amount);
        transactionToUser(wallet.getId(), amount, WalletTransactionEnum.TRANSACTION);

        var result = validateAndTransactionOperateUser(walletRequestVo.getUserId(), walletRequestVo.getAmount(), WalletTransactionEnum.TRANSACTION);
        return ResponseVo.success(result);
    }


    private WalletVo validateAndTransactionOperateUser(Long userId, BigDecimal amount, WalletTransactionEnum type) {

        if (BigDecimal.ZERO.compareTo(amount) >= 0) {
            throw new NotSupportException(amount + Constants.SEPARATOR_COMMA_DASH + Constants.TRANSACTION_AMOUNT_NOT_SUPPORT);
        }

        if (type.equals(WalletTransactionEnum.WITHDRAW) || type.equals(WalletTransactionEnum.TRANSACTION)) {
            amount = amount.negate();
        }

        var wallet = updateWallet(userId, amount);
        transactionToUser(wallet.getId(), amount, type);
        return wallet;

    }


    private void transactionToUser(Long walletId, BigDecimal amount, WalletTransactionEnum type) {
        WalletTransaction walletTransaction = new WalletTransaction();

        walletTransaction.setWalletId(walletId);
        walletTransaction.setTransAmount(amount);
        walletTransaction.setTransType(type.name());
        walletTransaction.setTransTime(LocalDateTime.now());
        walletTransactionRepo.save(walletTransaction);
    }

    private WalletVo updateWallet(Long userId, BigDecimal amount) {

        var wallet = walletRepo.findOneByUserId(userId).orElse(null);
        if (wallet == null) {
            throw new NotSupportException(userId + Constants.SEPARATOR_COMMA_DASH + Constants.WALLET_NOT_OPENED);
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0 && amount.abs().compareTo(wallet.getBalance()) > 0) {
            throw new NotSupportException(wallet.getBalance() + Constants.SEPARATOR_COMMA_DASH + Constants.WALLET_NOT_ENOUGH);
        }

        wallet.setBalance(wallet.getBalance().add(amount));

        return walletMapper.toVo(walletRepo.save(wallet));
    }
}
