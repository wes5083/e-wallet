package com.demo.ewallet.vo;

import com.demo.ewallet.entity.Wallet;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletTransactionVo extends BaseEntityVo implements Serializable {

    private static final long serialVersionUID = 912566806993795257L;

    private Long walletId;

    @NotBlank
    private String transType;

    @NotNull
    private BigDecimal transAmount;

    private LocalDateTime transTime;

    private String comment;

}
