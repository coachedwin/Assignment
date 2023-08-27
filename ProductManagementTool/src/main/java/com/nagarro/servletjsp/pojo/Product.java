package com.nagarro.servletjsp.pojo;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Product  {
	@Id
	private String id;	
	private String title;
	private String quantity;
	private String size;
	@Lob
	private byte[] image;
	
	private String path;
	public Product() {}
	public Product(String title, String quantity, String size, byte[] image,String path) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.size = size;
		this.image = image;
		this.path=path;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Product [title=" + title + ", quantity=" + quantity + ", size=" + size + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	
	
	
	

}
