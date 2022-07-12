package TestPackage;


import java.util.ArrayList;
import java.util.Random;

public class TestClass {

	public static void main(String[] args) {
		//Human h = new Human(); 추상클래스는 인스턴스화 할수없음
		//생성자(no parameters)
		String classType = null;
		ArrayList<Human> list = new ArrayList<>();
		int randomNumber = 0;
		Random random = new Random();
		
		for(int idx=0; idx<5; idx++) {
			randomNumber = random.nextInt(1000);
			System.out.println(randomNumber);
			if(randomNumber%2 == 0) {
				Warrior w = new Warrior();
				list.add(w);
			}else if(randomNumber%2 == 1) {
				Magician m = new Magician();
				list.add(m);
			}
		}
		
		for(int idx=0; idx<list.size(); idx++) {
			classType = list.get(idx).getClass().getName();
			if(classType.equals("TestPackage.Warrior")){
				Warrior warrior = (Warrior) list.get(idx);
				warrior.useWeapon();
			}else if(classType.equals("TestPackage.Magician")) {
				Magician magician = (Magician) list.get(idx);
				magician.useMagic();
			}
		}
		
		


	}

}
