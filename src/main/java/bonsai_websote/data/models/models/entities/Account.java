package bonsai_websote.data.models.models.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private long idAccount;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotNull(message = "Please enter your correct username !!!")
    private String userName;


    @Column(name = "password", length = 100, nullable = false, unique = true)
    @NotNull(message = "Please enter your correct password !!!")
    private String passWord;


    @ManyToOne(targetEntity = Role.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_account_role", referencedColumnName = "id_role", nullable = false)
    private Role role;

}
