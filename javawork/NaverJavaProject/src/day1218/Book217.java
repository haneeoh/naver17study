package day1218;

class Car2
{
	String model;
	boolean start;
	int speed;
}

public class Book217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//변수 전부 private 이 아니므로 같은 패키지에서 접근가능
		
		Car2 myCar2=new Car2();
		myCar2.model="bmw";
		myCar2.start=true;
		myCar2.speed=120;
		
		System.out.println("모델명: "+myCar2.model);
		System.out.println("시동여부: "+myCar2.start);
		System.out.println("현재속도: "+myCar2.speed);
		
		
	}

}
