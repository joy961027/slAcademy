package Animal_Package;

public class Animal {
	String aName;
	int aHp;
	boolean aLife;

	public Animal() {
		aName=null;
		aHp=0;
		aLife=true;
	}
	
	public Animal(String n, int h, boolean l) {
		aName=n;
		aHp=h;
		aLife=l;
	}
	
	public void move() {
		System.out.println("움직인다.");
	}
	public void die() {
		System.out.println("죽는다.");
		aLife=false;
	}

}
