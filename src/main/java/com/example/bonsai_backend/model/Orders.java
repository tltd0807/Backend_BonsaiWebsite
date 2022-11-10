package com.example.bonsai_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(columnDefinition = "DOUBLE PRECISION DEFAULT 0.0 NULL", name = "total_price")
    private BigDecimal totalPrice;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "order_status", columnDefinition = "BOOLEAN DEFAULT FALSE NOT NULL")
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;


    @OneToMany(mappedBy = "orders")
    private List<LineItem> lineItems;

}
