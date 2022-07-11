package TestPackage;

public class Warrior extends Human {
	
	String weapon;
	
	Warrior() {
		this.hName=null;
		this.hHp=0.0f;
		this.hMp=0.0f;
		this.hSt=0.0f;
		this.weapon="단검";
	}
	
	
	Warrior(String n, float h, float m, float s) {
		this.hName=n;
		this.hHp=h;
		this.hMp=m;
		this.hSt=s;
		this.weapon="단검";
	}

	public void Attack() {System.out.println("공격중..");}
	
	public void Check() {System.out.println("Warrior Class");} //오버라이딩
	
	//human 쿨래스가 가지고 있던 풋터를 오버라이드 한것.(무기정보 출력때문에)
	public void putHuman() {
		System.out.println("이름 : "+ this.hName +" 체력 : "+this.hHp + " 마력 : "+this.hMp+" 스태미너 : "+this.hSt+" 무기는 "+this.weapon);}
	
	public void useWeapon() {
		System.out.println(weapon + " 사용");

	}
}
