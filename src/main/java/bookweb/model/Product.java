/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookweb.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "book")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Integer productID;

    @Column(name = "product_name")
    private String productName;
   
   
    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "product_image")
    private String productImage;


    @Column(name = "product_description")
    @Lob
    private String productDescription;
    
    
    @OneToMany(mappedBy = "product")
    private List<Orderdetail> orderdetails;
    
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    
    
    
    public Product(Integer productID, String productName, Double productPrice, String productImage,
			String productDescription) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productDescription = productDescription;
	}









	public Integer getProductID() {
		return productID;
	}









	public void setProductID(Integer productID) {
		this.productID = productID;
	}









	public String getProductName() {
		return productName;
	}









	public void setProductName(String productName) {
		this.productName = productName;
	}









	public Double getProductPrice() {
		return productPrice;
	}









	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}









	public String getProductImage() {
		return productImage;
	}









	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}









	public String getProductDescription() {
		return productDescription;
	}









	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}









	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}









	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}









	public Category getCategory() {
		return category;
	}









	public void setCategory(Category category) {
		this.category = category;
	}









	@Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.get.entites.Book[ productID=" + productID + " ]";
    }

}
