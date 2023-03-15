package com.demo.ewallet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "t_wallet")
@Data
@NoArgsConstructor
public class Wallet extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2018259836547507608L;

    @Column(name = "user_id", nullable = false)
    @NonNull
    private Long userId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id")
    private List<WalletTransaction> walletTransactions;

    @Column(name = "balance", nullable = false)
    @NonNull
    private BigDecimal balance;

    @Column(name = "currency", nullable = false)
    @NonNull
    private String currency;

}