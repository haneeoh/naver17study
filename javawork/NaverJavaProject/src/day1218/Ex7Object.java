package day1218;

class Apple
{
	//접근 지정자 생략시 default 가 되는데, 같은 패키지에서는
	//private 을 제외하고 모두 직접 접근이 가능하다
	static String message="Hello";//변수 
	static final String EMP="비트캠프";//상수
	String name="캔디"; // 인스턴스 멤버 변수
	
}
///////////////////////////////////////
public class Ex7Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다른 클래스의 static 변수는 클래스명.변수명 이렇게 접근한다.
		System.out.println("메세지 : "+Apple.message);
		System.out.println("EMP : "+Apple.EMP);
		
		Apple.message="Happy Day";//디폴트값이기때문에 변경가능
		System.out.println(Apple.message);
		
		//Apple.EMP="삼성전자"; //final상수는 값 변경이 불가능 : 오류 
		
		//다른 클래스의 인스턴스 변수를 접근하려면 new로 생성된 인스턴스 변수가 있어야 한다
		Apple a=new Apple();
		System.out.println("이름="+a.name);
		//System.out.println("이름="+Apple.name);//오류발생: 인스턴스 변수는 반드시 인스턴스 변수로 가져와야함
		a.name="미라";
		System.out.println("a의 이름="+a.name);
		
		Apple b=new Apple();
		b.name="영자";
		
		System.out.println("b의 이름="+b.name);
	}

}
