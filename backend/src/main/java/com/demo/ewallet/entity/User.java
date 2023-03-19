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

    @Column(name = "user_name", unique = true)
    @NonNull
    private String userName;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "pass_key")
    @NonNull
    private String passKey;

    @Column(name = "phone", nullable = false)
    @NonNull
    private String phone;

    @Column(name = "first_name", nullable = false)
    @NonNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NonNull
    private String lastName;

    @Column(name = "email", nullable = false)
    @NonNull
    private String email;

    @Column(name = "type")
    @NonNull
    private String type;
}