package com.demo.ewallet.repo;

import com.demo.ewallet.entity.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepo extends JpaRepository<WalletTransaction, Long> {

}
