/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookweb.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "payment")
public class Payment implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentID;

    @Column(name = "payment_name")
    private String paymentName;

    @Column(name = "payment_image")
    private String paymentImage;
    
    
    @OneToMany(mappedBy = "payment")
    private List<Orders> orders;

    
    public Payment() {
    }

    

    public Payment(Integer paymentID, String paymentName, String paymentImage) {
		super();
		this.paymentID = paymentID;
		this.paymentName = paymentName;
		this.paymentImage = paymentImage;
	}



	public Integer getPaymentID() {
		return paymentID;
	}



	public void setPaymentID(Integer paymentID) {
		this.paymentID = paymentID;
	}



	public String getPaymentName() {
		return paymentName;
	}



	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}



	public String getPaymentImage() {
		return paymentImage;
	}



	public void setPaymentImage(String paymentImage) {
		this.paymentImage = paymentImage;
	}



	public List<Orders> getOrders() {
		return orders;
	}



	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}



	@Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentID != null ? paymentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentID == null && other.paymentID != null) || (this.paymentID != null && !this.paymentID.equals(other.paymentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.get.entites.Payment[ paymentID=" + paymentID + " ]";
    }
    
}
