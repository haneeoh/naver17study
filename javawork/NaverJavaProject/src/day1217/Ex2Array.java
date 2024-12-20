package day1217;

public class Ex2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []ch;//배열선언
		
		ch=new char[4];//0~3q번 인덱스까지 데이타를 넣을 수 있다
		
		System.out.println("배열크기 : "+ch.length);
		//배열에 데이타 넣기
		ch[0]='H';
		ch[1]=65;//아스키코드값 'A'
		ch[2]='x';
		ch[3]='t';
		
		//출력 #1
		for(int i=0;i<ch.length;i++)//<=를 넣으면 배열0~4번까지 출력되므로 항상 <를 넣어야함
			System.out.println("ch["+i+"]="+ch[i]);
		System.out.println();
		//출력 #2
		for(char a:ch)
			System.out.println(a);//i라는 인덱스값은 출력불가, 값만 얻을 수 있음
		
		System.out.println("=".repeat(30));
		char []ch2=new char[5]; //바로 선언해도 상관없음
		ch2=new char[] {'a','n','x','y','u'}; //선언과 동시에 가로로 주면 에러안나지만 new char[] 선언문을 집어넣으면 따로넣어도 상관없음
		for(int i=0;i<ch2.length;i++)
		{
			System.out.println("ch2["+i+"]="+ch2[i]);
		}
		//출력#3
		System.out.println("=".repeat(30));
		char []ch3= {'s','r','t','v','i','c'};
		for(char a:ch3)
			System.out.println(a);
	}

}
