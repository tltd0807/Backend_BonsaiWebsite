package com.example.bonsai_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "account_name", nullable = false, length = 100, unique = true)
    @NotNull(message = "Please enter your accountName !")
    private String accountName;

    @Column(name="account_password", nullable = false, length = 50)
    @NotNull(message = "Please enter your password !")
    private String accountPassword;

    @Column(name = "user_name", length = 50)
    private String userName;
    @Column(name = "user_image")
    private String userImage;

    @Column(name = "user_age",length = 2)
    private Integer userAge;

    @Column(name = "user_phone", length = 10)
    private String userPhone;



    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "users")
    @JsonBackReference
    private List<Orders> orders;


    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Cart> cart;


}
