package day1217;

import java.util.Scanner;

public class Ex10ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []datas= {5,20,18,4,6,12,9,19,1,3};
		System.out.println("갯수:"+datas.length);
		int searchNum;
		boolean find;
		/*
		 * 숫자를 입력하면 그 숫자가 몇번째 있는지 출력
		 * 없을 경우, 해당 숫자가 없습니다 라고 출력
		 * 0을 입력시 검색종료
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			find=false;//입력값을 찾았을 경우 true로 변경
			System.out.print("검색 할 숫자는? (종료:0)");
			searchNum=sc.nextInt();
			if(searchNum==0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			for(int i=0;i<datas.length;i++)
			{
				if(searchNum==datas[i])
				{
					find=true;
					System.out.println((i+1)+"번째에 있습니다");
					break;
				}
			}
			//못찾았을 경우
			if(!find) {//find==false라고 적어도 됨
				System.out.println("해당 숫자는 없습니다.");
			}
		}
	}

}