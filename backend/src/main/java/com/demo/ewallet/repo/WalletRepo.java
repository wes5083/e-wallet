package com.demo.ewallet.repo;

import com.demo.ewallet.entity.User;
import com.demo.ewallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WalletRepo extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findOneByUserId(Long userId);

    List<Wallet> findByUser(User user);

}
