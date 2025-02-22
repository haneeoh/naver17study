package day1219;

import java.util.Scanner;

public class Ex2ObjectArray {
	
	public static void dataInput(Student s)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("학생 이름은? : ");
		String name=sc.nextLine();
		System.out.print("학생 주소는? : ");
		String addr=sc.nextLine();
		System.out.print("학생 혈액형은? : ");
		String blood=sc.nextLine();
		
		s.changeStudent(name, addr, blood);
		System.out.println();
	}
	public static void showTitle()
	{
		System.out.println("이름\t혈액형\t주소");
		System.out.println("=".repeat(35));
	}
	public static void writeStudent(Student s)
	{
		System.out.println(s.getStuName()+"\t"+s.getStuBlood().toUpperCase()+"형\t"+s.getStuAddress());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int inwon;
		Student []stuArray;
		
		System.out.print("입력할 인원 수 : ");
		inwon=Integer.parseInt(sc.nextLine());
		//메모리할당
		stuArray=new Student[inwon];
		
		//데이타입력 : 레퍼런스 타입은 주소를 공유하기 때문에 메인에서 알아서 주솟값으로 변환해서 값을 돌려줌
		for(int i=0;i<stuArray.length;i++)
		{
			stuArray[i]=new Student();//생성
			dataInput(stuArray[i]);
		}
		//제목출력
		showTitle();
		//내용출력
		for(int i=0;i<stuArray.length;i++)
			writeStudent(stuArray[i]);
	}

}
