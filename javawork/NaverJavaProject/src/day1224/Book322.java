package day1224;
//320p
//class Vehicle
//{
//	public void run()
//	{
//		System.out.println("차량이 달립니다");
//	}
//}

//abstract 클래스에는 일반메서드, 추상메서드 둘 다 가능
//abstract class Vehicle 
//{
//	public abstract void run();
//}

//어차피 추상메서드만 있는 경우 interface 로 변경 가능하다.
//자바는 인터페이스를 더 권장
interface Vehicle
{
	public void run();
}
///////////////
//class Bus extends Vehicle
//인터페이스 사용시 implements 사용
class Bus implements Vehicle
{
	@Override
	public void run() {
		System.out.println("버스가 달립니다");
		// TODO Auto-generated method stub
	}
}
///////////////
//class Taxi extends Vehicle
class Taxi implements Vehicle
{
	@Override
	public void run() {
		System.out.println("택시가 달립니다");
	}
}
///////////////
class Driver
{
	//매개변수 다형성
	public void drive(Vehicle vehicle)
	{
		vehicle.run();
	}
}
////////////////
public class Book322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver=new Driver();
		
		Bus bus=new Bus();
		driver.drive(bus);
		
		Taxi taxi=new Taxi();
		driver.drive(taxi);
		
	}

}







