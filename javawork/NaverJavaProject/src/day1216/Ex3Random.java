package day1216;

import java.util.Scanner;

public class Ex3Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 임의의 난수를 구한 후 숫자 알아맞추기
		 * 맞췄을경우
		 * 		계속 하시겠습니까? y
		 * 			=>새로운 난수 발생, 카운트 변수 0으로 초기화
		 *		y가 아닐경우 프로그램 종료
		 */
		Scanner sc=new Scanner(System.in);
		int su,rnd,count;
		
		Exit:  //레이블은 대소문자 상관없이 임의로 지정하면 됨
			while(true)
			{
				rnd=(int)(Math.random()*100)+1;
				count=0;
				
				while(true)
				{
					System.out.print(++count + "회 : ");
					//su=sc.nextInt();
					su=Integer.parseInt(sc.nextLine());//숫자->문자 입력이 불가능하므로 처음부터 문자로 출력
					
					if(rnd>su)
						System.out.println("\t"+su+"보다 큽니다");
					else if(rnd<su)
						System.out.println("\t"+su+"보다 작습니다");
					else {
						System.out.println("\t 정답입니다");
						System.out.println("숫자 맞추기 게임을 계속하려면 y,그만하려면 n");
						char ch=sc.nextLine().charAt(0);
						if(ch=='y' || ch=='Y') {
							System.out.println("새로운 난수를 발생합니다");
							//break;//현재속한 while문만 빠져나간다
							continue Exit; // 바깥쪽 반복문의 조건식으로 이동
						}else {
							break Exit; //Exit에 포함된 바깥쪽 while문을 전부 빠져나간다
						}
					}
					
				}
			}
		
		System.out.println("프로그램을 종료합니다");
	}

}