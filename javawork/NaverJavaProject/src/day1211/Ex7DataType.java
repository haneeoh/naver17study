package day1211;

public class Ex7DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="Candy";
		int age=32;
		float height=163.8f;
		double weight=56.7;
		char blood='B';
		/*
		 * 이름 : Candy님
		 * 나이 : 32세
		 * 키 : 163.8Cm
		 * 몸무게 : 56.7Kg
		 * 혈액형 : B형
		 * 
		 * printf를 이용해서 위와같이 출력해보세요
		 */
		
		System.out.printf("이름 : %s님\n나이 : %d세\n키 : %5.1fCm\n몸무게 : %4.1fKg\n혈액형 : %c형\n",name,age,height,weight,blood);
		//위와 똑같이 나오도록 println을 이용해서 출력해보세요
		System.out.println("-------------------");
		System.out.println("이름 : "+name+"님");
		System.out.println("나이 : "+age+"세");
		System.out.println("키 : "+height+"Cm");
		System.out.println("몸무게 : "+weight+"Kg");
		System.out.println("혈액형 : "+blood+"형");
	}

}
