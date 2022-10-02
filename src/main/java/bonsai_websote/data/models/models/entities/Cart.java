package bonsai_websote.data.models.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private long idCart;
    private boolean status;
    private Set<Product> listProduct;

}
