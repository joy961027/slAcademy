package Animal_Package;

public class Bird extends Animal{

	public Bird() {
	}

	public Bird(String n, int h, boolean l) {
		super(n, h, l);
		

	
	}

	public void fly() {
		System.out.println("날아간다.");
	}

	public void putBirdInfo() {
		System.out.println("이름은 : "+ aName + " 체력은 : " + aHp + " 생존여부는 " + aLife);
	}
}
