package Animal_Package;

import java.util.ArrayList;

public class Play { 

	public static void main(String[] args) {
		ArrayList<Animal> something =new ArrayList<Animal>();	
		
		Fish fish1 = new Fish("돌돔",80,true);
		Bird bird1 =new Bird("닭",100,true);

		something.add(fish1);
		something.add(bird1);
		
		Fish someObject1 = (Fish)something.get(0);
		Bird someObject2 = (Bird)something.get(1);
		
		someObject1.putFishInfo();
		someObject2.putBirdInfo();
		String objectType = someObject1.getClass().getName();
		System.out.println();
		System.out.println(someObject2.getClass().getName());
		
		if(objectType.equals("Animal_Package.Fish")) {
			System.out.println("어류타입이다.");
		}else if(objectType.equals("Animal_Package.Bird")) {
			System.out.println("조류타입이다.");
		}
	}

}
