package com.demo.ewallet.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletVo extends BaseEntityVo implements Serializable {

    private static final long serialVersionUID = -859118596496524653L;

    @NotNull
    private Long userId;

    @NotNull
    private BigDecimal balance;

    @NotBlank
    private String currency;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserVo userVo;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<WalletTransactionVo> walletTransactionVos;

}
