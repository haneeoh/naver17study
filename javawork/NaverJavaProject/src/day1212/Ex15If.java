package day1212;

import java.util.Scanner;

public class Ex15If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*
		 * 상품 (sang) 과 수량 (su),단가(dan)을 입력받은후
		 * 총금액(total)을 출력하시오
		 * 단,수량이5개 이상이면 총금액의 10프로를 할인된 금액(dctotal)
		 * 으로 다시 출력해주세요
		 * 
		 * (예)
		 * 상품명 : 바나나킥
		 * 수량 : 5개
		 * 단가 : 1000원
		 * 총금액 : 5000원
		 * 
		 * 10프로 DC된 금액은 4500원 입니다 -> 5개 이상인 경우에만 출력되는 문
		 */
		
		String sang;
		int su,dan,total,dctotal;
		System.out.println("상품 이름을 입력하세요");
		sang=sc.nextLine();
		System.out.println("수량을 입력하세요");
		su=sc.nextInt();
		System.out.println("단가를 입력하세요");
		dan=sc.nextInt();
		total=su*dan;
		
		System.out.printf("상품명 : %s\n",sang);
		System.out.printf("수량 : %d\n",su);
		System.out.printf("단가 : %d\n",dan);
		System.out.printf("총금액 : %d\n",total);
		if(su>=5)
		{
			dctotal=((int)(total*0.9));
			System.out.println("-");
			System.out.printf("10프로 DC된 금액은 %d원 입니다\n",dctotal);
		}
	}

}
