package day1216;

public class Ex10LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=1;i<=1;i++)//행에 대한 반복
//		{
//			for(int j=2;j<=9;j++)//열에 대한 반복
//			{
//				System.out.print("["+j+"단]\t");
//			}
//			System.out.println();
//		}
//		System.out.println("=".repeat(75));
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x1="+j+"\t");
//		}
//		System.out.println();
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x2="+j*2+"\t");
//		}
//		System.out.println();
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x3="+j*3+"\t");
//		}
//		System.out.println();
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x4="+j*4+"\t");
//		}
//		System.out.println();
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x5="+j*5+"\t");
//		}
//		System.out.println();
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x6="+j*6+"\t");
//		}
//		System.out.println();
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x7="+j*7+"\t");
//		}
//		System.out.println();
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x8="+j*8+"\t");
//		}
//		System.out.println();
//		for(int j=2;j<=9;j++)
//		{
//			System.out.print(j+"x9="+j*9+"\t");
//		}
//		System.out.println();
		
		for(int dan=2;dan<=9;dan++)
			System.out.print("["+dan+"단]\t");
		System.out.println();
		System.out.println("=".repeat(65));
		
		for(int i=1;i<=9;i++)
		{
			for(int dan=2;dan<=9;dan++)
			{
				System.out.print(dan+"x"+i+"="+dan*i+"\t");
			}
			System.out.println();
		}
		

	}

}