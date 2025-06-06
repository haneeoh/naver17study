package day1220;
//추상클래스는 객체 생성을 할 수 없다 (어나니머스로 생성 가능)
//자식 클래스로 하여금 반드시 구현하게 할 목적으로 추상 메서드를 만든다.
//만약 자식클래스가 추상 메서드를 오버라이드 하지 않았을 경우 그 클래스도 추상화 시켜야 한다.

abstract class Parent2
{
	//부모가 process 에서 하는 일이 없을 경우
	//그렇다고 안만들면 자식클래스에서 오버라이드를 할 수 없음
	//이럴경우 미완성 선언만 하는데 이 경우 abstract 메서드로 만든다(미완성 메서드)
	
	abstract public void process();//추상메서드는 일반 클래스에 멤버로 올 수 없다
	
	//추상 클래스는 추상메서드뿐아니라 일반메서드도 구현이 가능하다
	//부모만이 가진 메서드
	public void study() {
		System.out.println("자바 공부를 한다.");
	}
}

class Your1 extends Parent2
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("벽지 공사");
	}
	//Your1 이 가진 메서드 (오버라이드 되지 않은)
	public void draw() {
		System.out.println("그림을 그린다");
	}
}

class Your2 extends Parent2
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("타일 공사");
	}
}

////////
public class Ex6Abstract {
	
	public static void yourProcess(Parent2 p)
	{
		p.process();
		p.study();//부모가 가진 다른 메소드는 호출 가능
		
		//p.draw();//오류 발생 (오버라이드가 되지 않아서 따로 생성해야함)
		//((Your1)p).draw(); //다운캐스팅 후 호출하면 가능.
		//그러나 p 에 Your2 가 생성되어 있는 경우에는 오류가 발생한다. 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		yourProcess(new Your1());
		yourProcess(new Your2());
		
		//yourProcess(new Prent2()); // 오류:추상클래스는 new 로 생성할 수 없다
	}

}
