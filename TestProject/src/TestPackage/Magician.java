package TestPackage;

public class Magician extends Human {

	String magic;
	public Magician() {
		
		super();
		magic="fire ball";
	}
	
	public Magician(String n, float h, float m, float s, String ma) {
		super(n,h,m,s);
		magic =ma;
	}
	
	public void useMagic(){
		System.out.println(magic + " 사용");
	}

}
