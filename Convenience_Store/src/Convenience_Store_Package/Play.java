package Convenience_Store_Package;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class Play {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	//write부분
		FileOutputStream fileoutputStream = new FileOutputStream("D:\\Convenience_Store\\data\\Product.txt");
		//객체저장스트림(객체를 파일스트림과 연결한다.)-파이프연결
		BufferedOutputStream bufferedoutputStream = new BufferedOutputStream(fileoutputStream);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedoutputStream);

		//저장할객체들의 내용과 그것들을 컨테이너에 저장해둠(고객들의 이름만 저장해본다) 

		ArrayList<Product> product = new ArrayList<Product>();

		Product pro1 = new Product(1,"과자",1000,10,"2022-10-27");
		Product pro2 = new Product(2,"아이스크립",1500,20,"2023-10-27");
		product.add(pro1);
		product.add(pro2);

		//컨테이너에 저장된것들을 통째로 파일에 저장한다.(객체스트림-->파일스트림-->실제파일에 저장)
		objectOutputStream.writeObject(pro1);
		objectOutputStream.writeObject(pro2);
		objectOutputStream.writeObject(product);
		objectOutputStream.close();//스트림들을 닫는다.
//reading부분
		
		//파일과 연결시키는 부분(파일스틞)
		FileInputStream fileinputStream = new FileInputStream("D:\\Convenience_Store\\data\\Product.txt");
		//커스텀 클래스(직접제작한 특수한클래스)ㄹ,ㄹ 연결시키는부분
		BufferedInputStream bufferedinputStream = new BufferedInputStream(fileinputStream);
		//최종적으로 객체의 일기(read)를 위한 부분
		ObjectInputStream objectInputSteam = new ObjectInputStream(bufferedinputStream);

		
		//어레이리스트를 읽어와서 리스트에 연결해준다.
		Product product1 = (Product) objectInputSteam.readObject();
		Product product2 = (Product) objectInputSteam.readObject();
		ArrayList<Product> listproduct =(ArrayList<Product>)  objectInputSteam.readObject();
		objectInputSteam.close();//스트림들을 닫느다
		
		for(int idx=0; idx<listproduct.size(); idx++) {
			listproduct.get(idx).putProduct();
		}
	}

}
