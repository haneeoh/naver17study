package day1216;

public class Ex9LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("다중 for문을 이용해서 * 찍어보기");
		for(int i=1;i<=5;i++)//행에 대한 반복
		{
			for(int j=1;j<=5;j++)//열에 대한 반복
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=".repeat(15));
		
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)//반복횟수 변경 => 행의 갯수=별의 갯수 이므로 j<=i로 설정
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=".repeat(15));
		
		for(int i=1;i<=5;i++)//행
		{
			//for(int j=i;j<=5;j++)//열
			for(int j=5;j>=i;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=".repeat(15));
	}

}