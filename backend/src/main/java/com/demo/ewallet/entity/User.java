package com.demo.ewallet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3359957755950740451L;

    @Column(name = "account", unique = true, nullable = false)
    @NonNull
    private String account;

    @Column(name = "password", nullable = false)
    @NonNull
    private String password;

    @Column(name = "pass_key", nullable = false)
    @NonNull
    private String passKey;

    @Column(name = "phone", nullable = false)
    @NonNull
    private String phone;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;


}