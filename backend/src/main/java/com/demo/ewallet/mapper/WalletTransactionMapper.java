package com.demo.ewallet.mapper;


import com.demo.ewallet.entity.WalletTransaction;
import com.demo.ewallet.vo.WalletTransactionVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = WalletMapper.class)
public interface WalletTransactionMapper {

    WalletTransactionVo toVo(WalletTransaction entity);

    WalletTransaction toEntity(WalletTransactionVo vo);

    List<WalletTransactionVo> toVos(List<WalletTransaction> entity);


}
