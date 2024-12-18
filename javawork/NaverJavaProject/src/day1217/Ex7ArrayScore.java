package day1217;

import java.util.Scanner;

public class Ex7ArrayScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 인원수를 입력 후 그 인원수만큼 이름과 점수를 입력하고
		 * 등수와 총점과 평균을 구하여 출력하시오
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		int inwon;
		int []score,rank;//배열은 선언시 앞에 한번만 붙이면 됨
		String []name;
		int total=0;
		double avg;
		
		System.out.println("인원 수 입력");
		inwon=Integer.parseInt(sc.nextLine());
		//인원수만큼 배열 할당
		score=new int[inwon];
		rank=new int[inwon];
		name=new String[inwon];
		
		//이름과 점수 입력
		for(int i=0;i<inwon;i++)
		{
			System.out.println(i+1+"번지 이름 입력");
			name[i]=sc.nextLine();
			System.out.println("점수 입력");
			score[i]=Integer.parseInt(sc.nextLine());
			//합계 구하기
			total+=score[i];
		}
		
		//평균 구하기
		avg=(double)total/inwon;
		
		//등수구하기
		for(int i=0;i<inwon;i++)
		{
			rank[i]=1;
			for(int j=0;j<inwon;j++)
			{
				if(score[j]>score[i])
					rank[i]++;
			}
		}
		
		//출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(40));
		for(int i=0;i<inwon;i++)
		{
			System.out.println(i+1+"\t"+name[i]+"\t"+score[i]+"\t"+rank[i]);
		}
		System.out.println("=".repeat(40));
		System.out.println("총점:"+total+"\t\t평균:"+avg);
		
	}

}
