package day1218;

class Car
{
	static String carCompany="현대";
	
	private String carName;
	private int carPrice;
	
	public static void setCarCompany(String carCompany)
	{
	//static 메서드에서는 static 변수만이 접근 가능하다
		Car.carCompany=carCompany;
	}
	public void setCarName(String carName)
	{
		this.carName=carName;
	}
	public void setCarPrice(int carPrice)
	{
		this.carPrice=carPrice;
	}
	//getter method 따로만들기
	public String getCarName()
	{
		return carName;//this 는 생략가능 
	}
	public int getCarPrice()
	{
		return carPrice;//호출을 하던 안하던 만들어놓아야 언제든 변경 가능 
	}
	//한번에 만들기
	public void setData(String carName, int carPrice)
	{
		this.setCarName(carName);
		this.setCarPrice(carPrice);
	}
}
public class Ex9Object {
	
	public static void writeCarInfo(Car myCar)
	{
		System.out.println("=".repeat(30));
		System.out.println("자동차명 : "+myCar.getCarName());
		System.out.println("가격 : "+myCar.getCarPrice());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("현재 자동차회사명:"+Car.carCompany);
		Car.setCarCompany("삼성");
		System.out.println("변경된 자동차 회사명:"+Car.carCompany);
		
		System.out.println("값 변경");
		
		Car car1=new Car();
		car1.setCarName("그랜저");
		car1.setCarPrice(39000000);
		
		Car car2=new Car();
		car2.setData("소나타",32000000);
		
		Car car3=new Car();
		car3.setData("Mini",50000000);
		
//		System.out.println("car1 자동차명 : "+car1.getCarName());
//		System.out.println("car1 가격 : "+car1.getCarPrice());
//		System.out.println("=".repeat(30));
//		System.out.println("car1 자동차명 : "+car2.getCarName());
//		System.out.println("car1 가격 : "+car2.getCarPrice());
		
		writeCarInfo(car1);
		writeCarInfo(car2);
		writeCarInfo(car3);
	
	}

}
