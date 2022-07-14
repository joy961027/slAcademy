package Park_Package;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Park_Play {

	public static void main(String[] args) throws SQLException {
		String tmpNumber;
		int checkid = 0;
		int menu; // menu 선택 번호
		int tmpTime;
		
		
		Scanner input = new Scanner(System.in);
		while(true) {
			ParkDAO pd = new ParkDAO();
			pd.ConnectDB();
			ArrayList<Park> listpark = pd.SelectAll();
			System.out.println("[1] 차량입고");
			System.out.println("[2] 차량출고");
			System.out.println("[3] 주차된 차량번호조회");
			System.out.println("[4] 종료");
			System.out.print("=> ");
			menu = input.nextInt();
			input.nextLine();
			switch(menu) {
			case 1: 
			{ // menu 1번을 누를때 실행
				if(listpark.size()<5) 
				{
					while(true) {
						boolean tmpcheck=false;
						System.out.println("차량번호를 입력해주세요 :");
						System.out.println("예 : 12가 1234");
						System.out.print("=> ");
						tmpNumber=input.nextLine();
						for(int idx=0; idx<listpark.size(); idx++) {
							if(listpark.get(idx).getpNumber().equals(tmpNumber)) {
								tmpcheck=true;
								checkid=idx;
							}
						}
						if(tmpcheck) { // 같은차량 존재
							System.out.println("같은 차량이 이미 존재합니다");
						}

						else {
							while(true) {
								System.out.print("들어온시간을 입력해주세요 : ");
								System.out.println("예 : 12시 34분 => 1234");
								System.out.print("=> ");
								tmpTime = input.nextInt();
								input.nextLine(); //flush
								int tmpHour = tmpTime/100;
								int tmpMinute = tmpTime%100;
								if(tmpHour >=24) { // 잘못입력 로직
									System.out.println("잘못입력하셨습니다. 다시 입력해주세요 ");
								}else if(tmpMinute >=60) { // 잘못입력 로직
									System.out.println("잘못입력하셨습니다. 다시 입력해주세요 ");
								}
								else 
								{
									Park p = new Park(tmpNumber, tmpTime);
									listpark.add(p);
									pd.InsertMember(p);
									break;
								}

							} // end of 시간등록 while
							break;
						} // 차량 입고 종료
					}
				}
				else //주차장이 만차일때
				{
					System.out.println("만차입니다.");
				}
			}break;// end of case 1


			case 2:// menu 2번을 누를때 실행
			{


				while(true) 
				{
					boolean tmpcheck=false;
					System.out.println("차량번호를 입력해주세요 :");
					System.out.println("예 : 12가 1234");
					System.out.print("=> ");
					tmpNumber=input.nextLine();
					for(int idx=0; idx<listpark.size(); idx++) {
						if(listpark.get(idx).getpNumber().equals(tmpNumber)) {
							tmpcheck=true;
							checkid=idx;
						}
					}
					if(tmpcheck) 
					{ // 같은차량 존재
						while(true) 
						{
							System.out.print("나가는시간을 입력해주세요 : ");
							System.out.println("예 : 12시 34분 => 1234");
							System.out.print("=> ");
							tmpTime = input.nextInt();
							input.nextLine(); //flush
							int tmpoutHour = tmpTime/100;
							int tmpoutMinute = tmpTime%100;
							if(tmpoutHour >=24 || tmpoutHour < 0) { // 잘못입력 로직
								System.out.println("잘못입력하셨습니다. 다시 입력해주세요 ");
							}else if(tmpoutMinute >=60) { // 잘못입력 로직
								System.out.println("잘못입력하셨습니다. 다시 입력해주세요 ");
							}
							else 
							{
								tmpoutHour = tmpoutHour*60;
								int totaloutTime= tmpoutHour+tmpoutMinute;
								int tmpinHour = listpark.get(checkid).getpTime()/100;
								int tmpinMinute = listpark.get(checkid).getpTime()%100;
								tmpinHour = tmpinHour*60;
								int totalinTime= tmpinHour+tmpinMinute;
								int receipe = (totaloutTime-totalinTime)/10*1000;
								System.out.println("지불금액은 : " + receipe);
								pd.DeletePark(listpark.get(checkid));
								listpark.remove(listpark.get(checkid));
								
								break;
							}

						} // end of 시간등록 while
						break;
					}

					else 
					{
						System.out.println("그번호로 주차된 차량이 없습니다.");
					} // 차량 입고 종료
				}


			}break; // end of case 2

			case 3: // menu 3번을 누를때 실행
			{
				for(int idx=0; idx<listpark.size(); idx++) {
					System.out.println(listpark.get(idx).getpNumber());
				}
			}
			break; // end of case 3

			case 4: // menu 3번을 누를때 실행
			{
				System.out.println("종료합니다");
				
				return;
			}

			default : // menu 1~3번을 제외한것을 누를때 실행
			{
				System.out.println("1~4번을 입력해주세요");
			} //end of case default

			}// end of switch

		} // end of while





	}// end of main

}// end of class
