package bonsai_websote.data.models.models.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idToken;

    @Column(name = "token")
    private String token;

    @Column(name = "create_date")
    private Date createDate;

    @OneToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "fk_auth_account")
    private Account tokenAccount;


    public AuthenticationToken(Account account){
        this.tokenAccount = account;
        this.createDate = new Date();
        this.token = UUID.randomUUID().toString();
    }

    public AuthenticationToken(){}
}
