package com.demo.ewallet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_wallet_transaction")
@Data
@NoArgsConstructor
public class WalletTransaction extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7033654031709059827L;

    @Column(name = "wallet_id", nullable = false)
    @NonNull
    private Long walletId;

    @Column(name = "trans_type", nullable = false)
    @NonNull
    private String transType;

    @Column(name = "trans_amount", nullable = false)
    @NonNull
    private BigDecimal transAmount;

    @Column(name = "trans_time", nullable = false)
    @NonNull
    private LocalDateTime transTime;

    @Column(name = "comment")
    @NonNull
    private String comment;
}