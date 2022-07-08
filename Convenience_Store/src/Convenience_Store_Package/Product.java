package Convenience_Store_Package;

import java.io.Serializable;

public class Product implements Serializable {
	int pNumber, pPrice, pQuantity;
	String pName, pExpired;

	public Product() {
		// TODO Auto-generated constructor stub
		this.pNumber=0;
		this.pName=null; 
		this.pPrice=0;
		this.pQuantity=0;
		this.pExpired=null;
	}
	
	public Product(int pN, String pNae, int pP, int pQ, String pE) {
		// TODO Auto-generated constructor stub
		this.pNumber=pN;
		this.pName=pNae; 
		this.pPrice=pP;
		this.pQuantity=pQ;
		this.pExpired=pE;
	}
	

	public int getpNumber() {
		return(this.pNumber);
	}
	
	public String getpName() {
		return(this.pName);
	}

	public int getpPrice() {
		return(this.pPrice);
	}

	public int getpQuantity() {
		return(this.pQuantity);
	}
	
	public String getpExpired() {
		return(this.pExpired);
	}
	
	public void putpNumber() {
		System.out.println("고유번호는 : "+ pNumber);
		
	}
	
	public void putpName() {
		System.out.println("이름은 : "+ pName);
		
	}
	
	public void putpPrice() {
		System.out.println("가격은 : "+ pPrice);
		
	}
	
	public void putpQuantity() {
		System.out.println("갯수는 : "+ pQuantity);
		
	}
	
	public void putpExpired() {
		System.out.println("유통기한은 : "+ pExpired);
		
	}
	
	public void putProduct() {
		System.out.println("고유번호는 : "+ pNumber);
		System.out.println("이름은 : "+ pName);
		System.out.println("가격은 : "+ pPrice);
		System.out.println("갯수는 : "+ pQuantity);
		System.out.println("유통기한은 : "+ pExpired);
		
	}
	
	

}
