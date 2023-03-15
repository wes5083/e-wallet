package com.demo.ewallet.mapper;


import com.demo.ewallet.entity.Wallet;
import com.demo.ewallet.vo.WalletVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, WalletTransactionMapper.class})
public interface WalletMapper {

    @Mapping(source = "user", target = "userVo")
    @Mapping(source = "walletTransactions", target = "walletTransactionVos")
    WalletVo toVo(Wallet entity);

    Wallet toEntity(WalletVo vo);

}
