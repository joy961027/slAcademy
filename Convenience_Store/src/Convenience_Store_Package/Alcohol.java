package Convenience_Store_Package;

public class Alcohol extends Product {
	private int age;
	

	public Alcohol() {
		// TODO Auto-generated constructor stub
		this.pNumber=0;
		this.pName=null;
		this.pPrice=0;
		this.pQuantity=0;
		this.pExpired=null;
	}
	
	public void checkage() {
		System.out.println("나이가 어떻게되세요?");
	}
}
