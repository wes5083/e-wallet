package com.demo.ewallet.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo extends BaseEntityVo implements Serializable {

    private static final long serialVersionUID = -2792975424842708640L;

    @NotBlank
    private String userName;

    private String password;

    private String phone;

    private String firstName;

    private String lastName;

    private String email;
}
