package com.demo.ewallet.repo;

import com.demo.ewallet.entity.Wallet;
import com.demo.ewallet.entity.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionRepo extends JpaRepository<WalletTransaction, Long> {


}
