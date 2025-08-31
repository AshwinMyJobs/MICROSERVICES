package com.products.dto;

import java.util.Arrays;

public class Product {

	String id;
	
	String categoryLevel1;
	String categoryLevel2;
	String categoryLevel3;
	
	String[] subCatogeries;

	public Product() {
	}
	 
	public Product(String id, String categoryLevel1, String categoryLevel2, String categoryLevel3, String[] subCatogeries) {
		super();
		this.id = id;
		this.categoryLevel1 = categoryLevel1;
		this.categoryLevel2 = categoryLevel2;
		this.categoryLevel3 = categoryLevel3;
		this.subCatogeries = subCatogeries;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryLevel1() {
		return categoryLevel1;
	}

	public void setCategoryLevel1(String categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}

	public String getCategoryLevel2() {
		return categoryLevel2;
	}

	public void setCategoryLevel2(String categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}

	public String getCategoryLevel3() {
		return categoryLevel3;
	}

	public void setCategoryLevel3(String categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}

	public String[] getSubCatogeries() {
		return subCatogeries;
	}

	public void setSubCatogeries(String[] subCatogeries) {
		this.subCatogeries = subCatogeries;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryLevel1=" + categoryLevel1 + ", categoryLevel2=" + categoryLevel2
				+ ", categoryLevel3=" + categoryLevel3 + ", subCatogeries=" + Arrays.toString(subCatogeries) + "]";
	}
}
