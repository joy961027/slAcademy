package TestPackage;

public abstract class Human {
	//클래스 내부의 데이터들 (속성 :fields, properties)
	//이름(문자열타입)-hName
	//체력(숫자타입 : 실수)-hHp
	//마력(숫자타입 : 실수)-hMp
	//스태머니(숫자타입 : 실수)-hSt
	
	String hName;
	float hHp;
	float hMp;
	float hSt;
	
	//생성자(Constructor) 라는것은 이 클래스로 객체를 만들어낼때, 가지고있는 데이터들을 초기화 할때 사용함
	// 특징은 클래스오 이름이 같고, 리턴타입이 아예없다는것(void가 아니고 없음)
	//new르 사용해서 객체를 만들어낼대 자동으로 작동됨.
	Human() {
		hName=null;
		hHp=0.0f;
		hMp=0.0f;
		hSt=0.0f;
	}
	
	Human(String n, float h, float m, float s) {
		hName=n;
		hHp=h;
		hMp=m;
		hSt=s;
	}
	
	
	//Human Class소속의 메소드라는것을 출력해줌.(알려줌)
	public void Check() {System.out.println("Human Class");}
	public void putHuman() {System.out.println(hName +" "+hHp + " "+hMp+" "+hSt);}


	
	
}
