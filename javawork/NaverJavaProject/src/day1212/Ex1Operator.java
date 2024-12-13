package day1212;

public class Ex1Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//증감 연산자, ++변수 (전치1순위) , 변수++(후치끝순위)
		int a,b,m,n;
		a=b=5;//대입연산자는 오른쪽부터(b=5,a=5순서)
		m=++a;//먼저 a가 증가된 후 m으로 대입된다
		n=b++;//먼저 대입 후 b가 증가된다
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		a=b=m=n=5;
		m=a++*++b;//5*6
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		n=a++ + ++b; //붙여 쓸 경우 헷갈려서 에러(3개까지는가능) : 6+7
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		a=5;
		System.out.println(a++);//먼저 출력후 증가된다
		System.out.println(++a);//먼저 증가후 출력된다(위에서 출력됐으니까6+1)
		
		a=b=m=n=5;
		a*=b-- -++n*3;//a*(5-18)=-65
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
	}

}
