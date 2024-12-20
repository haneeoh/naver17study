package day1220;

class SuperObj1
{
	SuperObj1()
	{
		System.out.println("super 생성자");
	}
	
	SuperObj1(String msg)
	{
		System.out.println("super 메세지 받는 생성자 : "+msg);
	}
}
////////////////////////////////
class SubObj1 extends SuperObj1 //sub는 super로부터 상속받는다
{
	SubObj1()
	{
		//첫줄에 super()가 생략되어있다- 직접 쓸 경우 첫줄이어야 한다.(아랫줄에 쓰여지면 오류)
		super();//부모의 디폴트 생성자를 호출 (안써도 자동생성. 생략 가능)
		System.out.println("sub 생성자");
	}
	
	SubObj1(String msg)
	{
		super(msg); //생략 불가능 : 생략할경우 super 기본 생성자(디폴트값)만 들어감 : super() ->자동입력됨
		System.out.println("sub의 두번째 생성자");
	}
}
///////////////////////////////

public class Ex1Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj1 sub1=new SubObj1(); // 상속관계이기때문에 sub를 호출하면 super가 먼저 호출됨
		SubObj1 sub2=new SubObj1("Hello");
		
	}

}
