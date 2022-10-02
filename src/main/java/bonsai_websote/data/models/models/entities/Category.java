package bonsai_websote.data.models.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private long idCategory;

    @Column(name = "category_name", nullable = false)
    @NotNull(message = "Please enter your category name !!!")
    private String categoryName;

    @Column(name = "quantity_of_product", nullable = false)
    @NotNull(message = "Please enter your quantity of product !!!")
    private long quantityOfProduct;


    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
    private Set<Product> product;
}
