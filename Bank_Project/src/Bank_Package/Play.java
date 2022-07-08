package Bank_Package;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	public static void main(String[] args) throws IOException,FileNotFoundException, ClassNotFoundException {


		String tmpAcc = null;//임시변수(계좌번호)
		int tmpBalance = 0; //임시변수(잔액)
		int tmpBankid = 0; //계좐번호 id
		int menu=0;  //메뉴번호
		boolean checkValue = false; // 계좌번호 찾기 불값
		//컨테이너에 미리 2~3명의 젇보 입력
		FileOutputStream fileoutputStream = new FileOutputStream("D:\\file\\Bank.txt");

		//객체저장스트림(객체를 파일스트림과 연결한다.)-파이프연결

		BufferedOutputStream bufferedoutputStream = new BufferedOutputStream(fileoutputStream);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedoutputStream);

		//저장할객체들의 내용과 그것들을 컨테이너에 저장해둠(고객들의 이름만 저장해본다) 

		ArrayList<Bank> userNames = new ArrayList<Bank>();
		Bank b1 = new Bank("kim","111",100);
		Bank b2 = new Bank("park","222",200);
		Bank b3 = new Bank("choi","333",300);
		Bank b4 = new Bank("lee","444",400);
		
		userNames.add(b1);
		userNames.add(b2);
		userNames.add(b3);
		userNames.add(b4);
//		
		//컨테이너에 저장된것들을 통째로 파일에 저장한다.(객체스트림-->파일스트림-->실제파일에 저장)
		objectOutputStream.writeObject(b1);
		objectOutputStream.writeObject(b3);
		objectOutputStream.writeObject(userNames);
		objectOutputStream.close();//스트림들을 닫는다.



		FileInputStream fileoutStream = new FileInputStream("D:\\file\\Bank.txt");
		BufferedInputStream bufferedinputStream = new BufferedInputStream(fileoutStream);
		ObjectInputStream objectInputSteam = new ObjectInputStream(bufferedinputStream);
		Bank bank1 = (Bank) objectInputSteam.readObject();
		Bank bank3 = (Bank) objectInputSteam.readObject();
		ArrayList<Bank> bank =(ArrayList<Bank>) objectInputSteam.readObject();
		objectInputSteam.close();
		bank1.putBank();
		bank3.putBank();
		for(int idx=0; idx<bank.size(); idx++) {
			bank.get(idx).putBank();
		}
			
	
//		 String filename = "D:\\file\\Bank.txt";
//	     File f = new File(filename);
//	     ArrayList<Bank> bank = new ArrayList<Bank>();
//	     FileReader fr = new FileReader(filename);
//	        BufferedReader br = new BufferedReader(fr);
//	 
//	     String line;
//	     String[] arr = null;
//	 
//	        // 프로그램 실행 시 전화번호부 읽어들이기
//	     if (f.exists()) {
//	         while ((line = br.readLine()) != null) { // 한줄씩 읽어들임
//	             arr = line.split(",");
//	             bank.add(new Bank(arr[0], arr[1], Integer.parseInt(arr[2])));
//	            }
//	        }
		
//		while(true) //1차 메뉴구성
//		{
//
//			cls();			
//			System.out.println("[1] 계좌번호 입력");
//			System.out.println("[2] 프로그램종료");
//			System.out.print("메뉴 입력 : ");
//			Scanner input = new Scanner(System.in);
//			menu = input.nextInt();
//			input.nextLine(); //flush
//			switch(menu) 
//			{
//			case 1 : //1번입력 부분 
//			{
//				while(true) 
//				{
//					cls();
//					System.out.print("계좌번호를 입력해주세요 : ");
//					tmpAcc = input.nextLine();
//					for(int idx=0;idx<bank.size(); idx++) 
//					{
//						if(bank.get(idx).getBankAccount().equals(tmpAcc)) 
//						{
//							checkValue = true;
//							tmpBankid = idx;
//						}
//					}
//					if(checkValue){
//						//2차 메뉴구성
//						while(true) 
//						{
//							cls();
//
//							System.out.println("[1] 입금");
//							System.out.println("[2] 출금");
//							System.out.println("[3] 잔액조회");
//							System.out.println("[4] 종료");
//							menu = input.nextInt();
//							input.nextLine(); //flush
//							switch(menu) 
//							{
//							case 1 : // 2차메뉴 입금부분 deposit()사용
//							{
//								cls();
//								System.out.print("입금액을 입력해주세요 : ");
//								tmpBalance = input.nextInt();
//								input.nextLine(); //flush
//								if(bank.get(tmpBankid).deposit(tmpBalance) != -1) //입금 기능 호출 및 에러 처리
//								{
//									System.out.println("현재 잔액은 " + bank.get(tmpBankid).check() +"입니다"); 
//									pause();
//								}
//								else
//								{
//									pause();
//									continue;
//								}
//
//
//							}break;
//							case 2 : // 2차메뉴 출금부분 withdraw()사용
//							{
//								cls();
//								System.out.print("출금액을 입력해주세요 : ");
//								tmpBalance = input.nextInt();
//								input.nextLine(); //flush
//								if(bank.get(tmpBankid).withdraw(tmpBalance) != -1) //출금 기능 호출 및 에러 처리
//								{
//									System.out.println("현재 잔액은 " + bank.get(tmpBankid).check() +"입니다"); 
//									pause();
//								}
//								else
//								{
//									pause();
//									continue;
//								}
//
//
//							}break;
//							case 3 : // 2차메뉴 잔액조회 부분 check()사용
//							{
//								cls();
//								System.out.println("현재 잔액은 " + bank.get(tmpBankid).check() +"입니다"); 
//								pause();
//							}break;
//							case 4  : // 2차메뉴 종료
//							{
//								cls();
//								System.out.println("프로그램이 종료됩니다.");
//								pause();
//								System.exit(0); 
//							}
//							default : // 2차메뉴 1,2,3,4 외 다른것을 입력할경우
//							{
//								cls();
//								System.out.println("다시입력해주세요");
//								pause();
//							}
//
//							}
//						}// end of while
//					}else // 1차메뉴에서 계좌번호가 틀린경우
//					{
//						cls();
//						System.out.println("계좌번호가 존재하지 않습니다. 다시 입력해주세요");
//						pause();
//						continue;
//					}
//				}//end of while
//			}
//			case 2 : //1차메뉴 종료부분
//			{
//				cls();
//				System.out.println("프로그램이 종료됩니다.");
//				pause();
//				System.exit(0);;
//			}
//			default : { //1차 메뉴 1,2 제외 다른것 선택일경우
//				input.close();
//				cls();
//				System.out.println("다시입력해주세요");
//				pause();
//			}
//
//
//			}// end of switch
//
//
//		}// end of while


	}// end of main

	public static void cls() { // cmd창에서 cls하기 
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(Exception e) {
			System.out.println("cls에러");
		}
	}

	public static void pause() { // cmd창에서 pause하기
		try {
			new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
		}catch(Exception e) {
			System.out.println("pause에러");
		}


	}
}// end of class



/*
}
	Bank b = null; //고객정보의 객체를 연결한 레퍼런스
	String tmpName= null;//임시변수(이름)
	String tmpAcc = null;//임시변수(계좌번호)
	int tmpBalance = 0; //임시변수(잔액)
	int tmpNumber = 0; //임시변수(선택)
	int tmpBankid = 0;
	boolean checkValue = false;
	ArrayList<Bank> bank = new ArrayList<Bank>();//고객 정보를 저장해둘 보관소(컨테이너)
	int menu=0;
	// 메뉴구현 프로토타입
	// 무한 반복문

	while(true) 
	{
		//			Runtime runtime =Runtime.getRuntime();
		//			try {
		//				//runtime.exec("cmd /c " + cmd);
		//				runtime.exec("cmd /c "+ "cls");
		//				}catch(IOException e) {
		//					e.printStackTrace();
		//				}
		//메뉴출력
		cls();
		System.out.println("1.고객정보등록");
		System.out.println("2.고객이름조회");
		System.out.println("3.고객목록출력");
		System.out.println("4.입금");
		System.out.println("5.출금");
		System.out.println("6.종료");
		//메뉴선택
		Scanner input = new Scanner(System.in);
		System.out.print("원하는 메뉴를 입력하세요 : ");
		menu = input.nextInt();
		//메뉴처리
		switch(menu)
		{
		case 1:
		{
			System.out.println("고객정보등록 메뉴를 실행했습니다.");
			for(int idx=0; idx<2; idx++) 
			{
				b = new Bank();

				Scanner input2 = new Scanner(System.in);
				System.out.print("이름: "); tmpName = input2.nextLine();
				System.out.print("계좌번호: "); tmpAcc = input2.nextLine();
				System.out.print("잔액: "); tmpBalance = input2.nextInt();
				b.setBank(tmpName, tmpAcc, tmpBalance);
				bank.add(b);
			}
			pause();

		}break;
		case 2:
		{
			System.out.println("고객이름조회 메뉴를 실행했습니다.");
			Scanner input3 = new Scanner(System.in);
			System.out.println("이름 이나 계좌 번호를 선택해주세요.\n1 : 이름\n2 : 계좌  "); tmpNumber = input3.nextInt();

			if(tmpNumber == 1) 
			{
				System.out.print("이름을 적어주세요 : "); 
				input3.nextLine();
				tmpName = input3.nextLine();
				for(int idx=0;idx<bank.size(); idx++) 
				{
					if(bank.get(idx).getBankName().equals(tmpName)) 
					{
						checkValue = true;
					}
				}
				if(checkValue){
					System.out.println("이름이 존재합니다.");
				}else
				{
					System.out.println("이름이 존재하지 않습니다.");
				}
			}else if (tmpNumber ==2)
			{
				System.out.print("계좌번호를 적어주세요 : ");
				input3.nextLine();
				tmpAcc = input3.nextLine();
				for(int idx=0;idx<bank.size(); idx++) 
				{
					if(bank.get(idx).getBankAccount().equals(tmpAcc)) 
					{
						checkValue = true;
					}

				}
				if(checkValue){
					System.out.println("계좌번호가 존재합니다.");
				}else
				{
					System.out.println("계좌번호가 존재하지 않습니다.");
				}
			}else
			{
				System.out.println("1 또는 2를 적어주세요.");
			}
			pause();
		}break;
		case 3:
		{

			System.out.println("고객목록출력 메뉴를 실행했습니다.");
			for(int idx=0; idx<bank.size(); idx++) 
			{
				bank.get(idx).putBank();
			}
			pause();

		}break;	
		case 4:
		{
			System.out.println("입금메뉴를 실행했습니다.");
			Scanner input4 = new Scanner(System.in);
			System.out.println("계좌 번호를 적어주세요. : "); tmpAcc = input4.nextLine();

			for(int idx=0;idx<bank.size(); idx++) 
			{
				if(bank.get(idx).getBankAccount().equals(tmpAcc)) 
				{
					tmpBankid = idx;
					checkValue = true;
				}

			}
			if(checkValue){
				bank.get(tmpBankid).check();
				System.out.println("얼마를 입금하시겠습니까? : "); tmpBalance = input4.nextInt();
				bank.get(tmpBankid).deposit(tmpBalance);
				bank.get(tmpBankid).check();

			}else
			{
				System.out.println("계좌번호가 존재하지 않습니다.");
			}
			pause();
		}break;	
		case 5:
		{
			System.out.println("출금메뉴를 실행했습니다.");
			Scanner input4 = new Scanner(System.in);
			System.out.println("계좌 번호를 적어주세요. : "); tmpAcc = input4.nextLine();

			for(int idx=0;idx<bank.size(); idx++) 
			{
				if(bank.get(idx).getBankAccount().equals(tmpAcc)) 
				{
					tmpBankid = idx;
					checkValue = true;
				}

			}
			if(checkValue){
				System.out.println("현재잔액은 : " + bank.get(tmpBankid).check() + "입니다.");  
				System.out.println("얼마를 출금하시겠습니까? : "); tmpBalance = input4.nextInt();
				bank.get(tmpBankid).withdraw(tmpBalance);
				System.out.println("남은잔액은 : " + bank.get(tmpBankid).check() + "입니다.");  

			}else
			{
				System.out.println("계좌번호가 존재하지 않습니다.");
			}
			pause();
		}break;	
		case 6:
		{
			System.out.println("종료되었습니다.");
			pause();
		}break;	
		default :{
			System.out.println("다시메뉴를 선택해주십시오");
			pause();

		}
		}


	}// end of while
/*


/*

강사님이 한것
Bank b = null; //고객정보의 객체를 연결한 레퍼런스
String tmpName= null;//임시변수(이름)
String tmpAcc = null;//임시변수(계좌번호)
int tmpBalance = 0; //임시변수(잔액)
int tmpNumber = 0; //임시변수(선택)
boolean checkValue = false;
ArrayList<Bank> bank = new ArrayList<Bank>();//고객 정보를 저장해둘 보관소(컨테이너)

for(int idx=0; idx<2; idx++) 
{
	b = new Bank();

	Scanner input = new Scanner(System.in);
	System.out.print("이름: "); tmpName = input.nextLine();
	System.out.print("계좌번호: "); tmpAcc = input.nextLine();
	System.out.print("잔액: "); tmpBalance = input.nextInt();
	b.setBank(tmpName, tmpAcc, tmpBalance);
	bank.add(b);
}

for(int idx=0; idx<bank.size(); idx++) 
{
	bank.get(idx).putBank();
}
Scanner input = new Scanner(System.in);
System.out.println("이름 이나 계좌 번호를 적어주세요.\n1 : 이름\n2 : 계좌  "); tmpNumber = input.nextInt();

if(tmpNumber == 1) 
{
	System.out.print("이름을 적어주세요 : "); 
	input.nextLine();
	tmpName = input.nextLine();
	for(int idx=0;idx<bank.size(); idx++) 
	{
		if(bank.get(idx).getBankName().equals(tmpName)) 
		{
			checkValue = true;
		}
	}
	if(checkValue){
		System.out.print("이름이 존재합니다.");
	}else
	{
		System.out.print("이름이 존재하지 않습니다.");
	}
}else if (tmpNumber ==2)
{
	System.out.print("계좌번호를 적어주세요 : ");
	input.nextLine();
	tmpAcc = input.nextLine();
	for(int idx=0;idx<bank.size(); idx++) 
	{
		if(bank.get(idx).getBankAccount().equals(tmpAcc)) 
		{
			checkValue = true;
		}

	}
	if(checkValue){
		System.out.print("계좌번호가 존재합니다.");
	}else
	{
		System.out.print("계좌번호가 존재하지 않습니다.");
	}
}else
{
	System.out.print("1 또는 2를 적어주세요.");
}
 */


/*
public static void main(String[] args) {
	// TODO Auto-generated method stub
	ArrayList<Bank> b1 = new ArrayList<>();
	for(int i=0; i<2; i++) {
		Bank b = new Bank();
		b1.add(b);
		b1.get(i).setBank();
	}
	for(int i=0; i<2; i++) {
		b1.get(i).putBank();
	}
	Scanner input = new Scanner(System.in);
	System.out.print("찾으시는 이름이나 계좌번호가 있으신가요? 1번:이름, 2번:계좌 ");
	int tmpNumber= input.nextInt();
	if(tmpNumber==1) {
		System.out.print("이름을 입력해주세요 : ");
		Scanner input2 = new Scanner(System.in);
		String tmpName = input2.nextLine();
		if(b1.contains(tmpName)) {
			System.out.print("찾으시는 이름이 존재합니다.");
		}else {
			System.out.print("찾으시는 이름이 존재하지 않습니다.");
		}
	}else if(tmpNumber==2) {
		System.out.print("계좌번호를 입력해주세요 : ");
		Scanner input2 = new Scanner(System.in);
		String tmpAccount = input2.nextLine();
		Bank b = new Bank("",tmpAccount,0);
		if(b1.contains(b)) {
			System.out.print("찾으시는 계좌번호가 존재합니다.");
		}else {
			System.out.print("찾으시는 계좌번호가 존재하지 않습니다.");
		}

	}else {System.out.print("잘못 입력하셨습니다.");


	}

}
 */



