package com.demo.ewallet.mapper;


import com.demo.ewallet.entity.User;
import com.demo.ewallet.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    UserVo toVo(User entity);

    User toEntity(UserVo vo);

}
