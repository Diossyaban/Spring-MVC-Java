package com.bootcamp.firstproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.bootcamp.firstproject.enumuration.ConditionType;

@Entity
@Table(name = "product")
public class Product {

    @Id
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Column(name="prod_id")
	private Long prodId;
	
	@Column(name="title")
	@Size(max=25)
	@NotBlank(message="Field title harus diisi")
	private String title;
	
	@Size(max=225)
	@NotBlank(message="Field description harus diisi")
	private String description;
	
	@Digits(integer = 8,fraction = 2)
	private Double price;
	

	@Column(name="stock")
	private int stock;
	
	@Column(name="condition")
	@Enumerated(EnumType.STRING)
	private ConditionType conditionType;
	
	@Column(name="manufacture")
	@Size(max=25)
	private String manufacture;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prod_cate_id") 
	private Category category;
	
	@Column(name="prod_image")
	@Size(max=255)
	private String productImage;

	public Product() {
		super();
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public ConditionType getConditionType() {
		return conditionType;
	}

	public void setConditionType(ConditionType conditionType) {
		this.conditionType = conditionType;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Product(Long prodId, @Digits(integer = 8, fraction = 2) Double price, int stock) {
		this.prodId = prodId;
		this.price = price;
		this.stock = stock;
	}

	public Product(Long prodId, @Size(max = 25) @NotBlank(message = "Field title harus diisi") String title,
			@Size(max = 225) @NotBlank(message = "Field description harus diisi") String description,
			@Digits(integer = 8, fraction = 2) Double price, int stock, ConditionType conditionType,
			@Size(max = 25) String manufacture, Category category, @Size(max = 255) String productImage) {
		this.prodId = prodId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.conditionType = conditionType;
		this.manufacture = manufacture;
		this.category = category;
		this.productImage = productImage;
	}
}
