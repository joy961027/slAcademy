package Animal_Package;

public class Fish extends Animal{

	public Fish() {
	}

	public Fish(String n, int h, boolean l) {
		super(n, h, l);
		

	
	}

	public void swim() {
		System.out.println("헤엄치는중..");
	}

	public void putFishInfo() {
		System.out.println("이름은 : "+ aName + " 체력은 : " + aHp + " 생존여부는 " + aLife);
	}
}
