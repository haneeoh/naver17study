package day1219;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex12SawonArray {

	//showTitle: 제목 출력
	//사원명 직급 기본급 수당 가족수당 세금 실수령액
	
	public static void showTitle()
	{
		System.out.println("사원명\t직급\t기본급\t\t수당\t\t가족수당\t\t세금\t\t실수령액");
		System.out.println("=".repeat(90));
	}

	//writeSawon(Sawon sawon) : 한개의 사원 데이타 출력
	public static void writeSawon(Sawon sawon)
	{
		NumberFormat nf=NumberFormat.getInstance(); //세자릿수마다 , 찍히게
		
		System.out.println(sawon.getSawonName()+"\t"+sawon.getPosition()+"\t+"
				+nf.format(sawon.getGibonPay())+"원\t+"+nf.format(sawon.getSuDang())+"원\t+"
				+nf.format(sawon.getFamSudang())+"\t-"+nf.format(sawon.getTax())+"\t="
				+nf.format(sawon.getNetPay()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inwon;
		Sawon []mySawon;

		//인원수를 입력 후 인원수만큼 배열 메모리 할당
		Scanner sc=new Scanner(System.in);
		System.out.print("직원 수를 입력하세요 : ");
		inwon=Integer.parseInt(sc.nextLine());
		
		mySawon=new Sawon[inwon];

		//배열에 데이타 입력 후 생성자 통해 데이타 저장하기
		for(int i=0;i<inwon;i++)
		{
			System.out.print("사원명 : ");
			String sawonName=sc.nextLine();
			System.out.print("직급 : ");
			String pos=sc.nextLine();
			System.out.print("가족 수 : ");
			int famSu=Integer.parseInt(sc.nextLine());
			
			System.out.println();
			
			//사원생성 방법1
//			mySawon[i]=new Sawon();
//			mySawon[i].setSawonName(sawonName));
//			mySawon[i].setPosition(position));
//			mySawon[i].setFamSu(famSu));
			
			//사원생성 방법2
			mySawon[i]=new Sawon(sawonName, pos, famSu);
		}
		
		//제목출력
		showTitle();
		
		//반복문 통해서 데이타 출력하는 메서드 호출
		for (Sawon s:mySawon)
			writeSawon(s);
	}

}









