package day1219;

import java.util.Scanner;

public class Ex1ObjectArray {
	Student []stuArray=new Student[3]; //초기값은 null
	
	public void inputData()
	{
		//System.out.println("inputData");
		Scanner sc=new Scanner(System.in);		
		for(int i=0;i<stuArray.length;i++)
		{
			//생성부터
			stuArray[i]=new Student();
			
			System.out.print("학생 이름? : ");
			String name=sc.nextLine();
			System.out.print("혈액형은? : ");
			String blood=sc.nextLine();
			System.out.print("태어난 년도는? : ");
			int birthYear=Integer.parseInt(sc.nextLine());
			System.out.print("점수는? : ");
			int score=Integer.parseInt(sc.nextLine());
			System.out.println();
			
			//s에 데이타 넣기
			stuArray[i].setStuName(name);
			stuArray[i].setStuBlood(blood);
			stuArray[i].setStuBirthYear(birthYear);
			stuArray[i].setStuScore(score);
		}
	}
	
	public static void showTitle() //멤버변수를 이용하는게 아니므로 static 으로 만들어도 가능
	{
		//System.out.println("showTitle");
		System.out.println("이름\t혈액형\t나이\t점수\t학점");
		System.out.println("=".repeat(40));
	}
	
	public void writeDataArray()
	{
		//System.out.println("write");
		for(Student s:stuArray)
		{
			System.out.println(s.getStuName()+"\t"+s.getStuBlood().toUpperCase()+"형\t"
					+s.getAge()+"\t"+s.getStuScore()+"점\t"+s.getScoreGrade());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1ObjectArray ex1=new Ex1ObjectArray();
		//데이타 입력
		ex1.inputData();
		//제목출력
		showTitle();
		//데이타출력
		ex1.writeDataArray();
		
	}

}
