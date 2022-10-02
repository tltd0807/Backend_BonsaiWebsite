package bonsai_websote.data.models.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private long idCustomer;

    @Column(name = "customer_name", length = 100, nullable = false)
    @NotNull(message = "Please enter your name !!!")
    private String customerName;

    @Column(name = "customer_age", length = 5)
    private int customerAge;

    @Column(name = "customer_birthday", length = 20)
    private Date customerBirthday;

    @Column(name = "customer_address", nullable = false)
    @NotNull(message = "Please enter your address !!!")
    private String customerAddress;

    @Column(name = "customer_sex",length = 10)
    private String customerSex;

    @OneToMany(mappedBy = "orderCustomer", cascade = CascadeType.ALL)
    private Set<Order> order;
}
