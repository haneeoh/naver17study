package day1218;

class Car3
{
	String company ="현대자동차";
	String model="그랜저";
	String color="검정";
	int maxSpeed=350;
	int speed;
}
public class Book219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car3 myCar3=new Car3();
		
		System.out.println("제작회사: "+myCar3.company);
		System.out.println("모델명: "+myCar3.model);
		System.out.println("색깔: "+myCar3.color);
		System.out.println("최고속도: "+myCar3.maxSpeed);
		System.out.println("현재속도: "+myCar3.speed);
		System.out.println();
		
		myCar3.speed=60;
		System.out.println("수정된 속도:"+myCar3.speed);

	}

}