package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="red|green|yellow|white|black";
		//String msg="red,green,yellow,white,black";//,는 분리가 잘 됨
		//|로 분리해서 출력
//		String []arr=msg.split("|"); // 분리가 잘 안됨
//		for(String a:arr)
//		{
//			System.out.println(a);
//		}
		
		StringTokenizer st=new StringTokenizer(msg, "|");
		System.out.println("분리할 총 토큰 수 : "+st.countTokens());
		
//		for(int i=0;i<st.countTokens();i++)//->countTokens가 고정값이 아니므로 nextToken을 진행하면서 갯수가 줄어기때문에
//		{
//			System.out.println(st.nextToken());//->이런식으로 진행하면 결과값이 3개만 나옴
//		}
		
		//방법1 for 문으로 꼭 작성하고싶다면
		int count=st.countTokens();
		for (int i=0;i<count;i++)
		{
			System.out.println(st.nextToken());
		}
		System.out.println();
		
		StringTokenizer st2=new StringTokenizer(msg, "|");
		//방법2
		while(st2.hasMoreTokens()) // hasMoreTokens가 트루 인 동안
		{
			System.out.println(st2.nextToken());
		}
		//잘 안씀 tokenizer를
		
		System.out.println();
		String []arr2=msg.split("|");
		System.out.println("총 "+arr2.length+"개");//각자 다 단어로 인식해서 총 글자수가 나옴
		
		String []arr3=msg.split("\\|"); //정규표현식!
		System.out.println("total "+arr3.length+"ea");//제대로 출력
		
		for(String a:arr3)
			System.out.println(a);
		System.out.println();
		//아래 데이타를 . 으로 분리하여 출력하시오
		String msg2="이미자.손태영.강호동.이영자.박진아";
		
		String []arr4=msg2.split("\\.");
		System.out.println("total "+arr4.length+"ea");
		
		for(String a:arr4)
			System.out.println(a);
	}

}
