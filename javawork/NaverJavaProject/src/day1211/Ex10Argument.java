package day1211;

public class Ex10Argument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("doble 형 Argument 값 읽기");
		//3과목의 점수를 double형으로 읽어서 총점과 평균을 구해보자
		double score1=Double.parseDouble(args[0]);
		double score2=Double.parseDouble(args[1]);
		double score3=Double.parseDouble(args[2]);
		double total=score1+score2+score3;
		double average=total/3;
		
		System.out.printf("점수1 : %5.1f점\n",score1);
		System.out.printf("점수2 : %5.1f점\n",score2);
		System.out.printf("점수3 : %5.1f점\n",score3);
		System.out.printf("총 점 : %5.1f점\n",total);
		System.out.printf("평 균 : %5.1f점\n",average);

	}

}