package bonsai_websote.data.models.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long idProduct;

    @Column(name = "product_name", length = 100, nullable = false)
    @NotNull(message = "Please enter your product name !!!")
    private String productName;

    @Column(name = "url_iamge")
    private String urlImage;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    @NotNull(message = "Please enter your product price !!!")
    private double productPrice;

    @Column(name = "product_amount", nullable = false)
    @NotNull(message = "Please enter your product amount !!!")
    private long productAmount;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Category.class)
    @JoinColumn(name = "fk_product_category", referencedColumnName = "id_category", nullable = false)
    private Category productCategory;
}
