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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userID;

    @Column(name = "user_name")
    private String userName;
    
    
    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_phoneNB")
    private String userphoneNB;

    @Column(name = "user_image")
    private String userImage;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_pass")
    private String accountPass;
    
    
    @OneToMany(mappedBy = "user")
    private List<Orders> orders;
    
    
    @OneToMany(mappedBy = "user")
    private List<Selling> sellings;
    
    
    @OneToOne
    @JoinColumn(name="role_id")
    private Role role;

    public User() {
    }

    



    public User(Integer userID, String userName, Integer userAge, String userphoneNB, String userImage,
			String accountName, String accountPass) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userAge = userAge;
		this.userphoneNB = userphoneNB;
		this.userImage = userImage;
		this.accountName = accountName;
		this.accountPass = accountPass;
	}





	public Integer getUserID() {
		return userID;
	}





	public void setUserID(Integer userID) {
		this.userID = userID;
	}





	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}





	public Integer getUserAge() {
		return userAge;
	}





	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}





	public String getUserphoneNB() {
		return userphoneNB;
	}





	public void setUserphoneNB(String userphoneNB) {
		this.userphoneNB = userphoneNB;
	}





	public String getUserImage() {
		return userImage;
	}





	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}





	public String getAccountName() {
		return accountName;
	}





	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}





	public String getAccountPass() {
		return accountPass;
	}





	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}





	public List<Orders> getOrders() {
		return orders;
	}





	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}





	public List<Selling> getSellings() {
		return sellings;
	}





	public void setSellings(List<Selling> sellings) {
		this.sellings = sellings;
	}





	public Role getRole() {
		return role;
	}





	public void setRole(Role role) {
		this.role = role;
	}





	@Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.get.entites.User[ userID=" + userID + " ]";
    }
    
}
