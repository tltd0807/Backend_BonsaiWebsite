package bonsai_websote.data.models.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orderdetail")
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orderdetail")
    private long idOrderdetail;

    @Column(name = "orderdetail_quantity", nullable = false, length = 10)
    @NotNull(message = "Please enter your quantity you want to buy !!!")
    private long orderDetailQuantity;


    @Column(name = "total_price_quantity", nullable = false)
    private double totalPriceQuantity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", nullable = false)
    private Order orderdetailOrder;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false)
    private Product orderdetailProduct;
}
