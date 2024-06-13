package com.furniture.Entity;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="order_tracking_number",nullable=false)
	private String orderTrackingNumber;
	
	@Column(name="total_quantity",nullable=false)
	private int totalQuantity;
	
	@Column(name="total_price")
	private BigDecimal totalPrice;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date_created")
	@CreationTimestamp
	private LocalDate dateCreated;
	
	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDate lastUpdate;

	
	
	public Long getId() {
		return id;
	}


	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}


	public int getTotalQuantity() {
		return totalQuantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public User getUser() {
		return user;
	}


	public Order(String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status,
			User user) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.user = user;
	}
	
	

	public Order(String orderTrackingNumber, String status, User user) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
		this.status = status;
		this.user = user;
	}


	public Order() {
	}

	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private Set<OrderDetails> orderItems = new HashSet<>();
	
	@Override
	public String toString() {
		return "Order [orderTrackingNumber=" + orderTrackingNumber + ", totalQuantity=" + totalQuantity
				+ ", totalPrice=" + totalPrice + ", status=" + status + ", user=" + user + "]";
	}


	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}


	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setUser(User user) {
		this.user = user;
	}




	
	
	
}
