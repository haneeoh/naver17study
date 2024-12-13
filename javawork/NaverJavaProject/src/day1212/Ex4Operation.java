package day1212;

public class Ex4Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//관계연산자(>,<,>=,<=,==), 논리연산자(&&,||,!) -> 결과값은 무조건 boolean (and,or,
		int kor=89,eng=100,mat=89;
		boolean f=false; //boolean 참/거짓
		
		System.out.println(kor>eng);//f
		System.out.println(kor<eng);//t
		System.out.println(kor==mat);//t
		System.out.println(kor!=eng);//f
		System.out.println(kor>eng && ++eng>mat);//f : false && true : 1번째 조건이 false일 경우 두번째 조건은 비교하지 않는다.
		System.out.println(eng); //100
		System.out.println(kor>eng || ++eng>mat);//t : false || true : 1번째 조건이 true일 경우 두번째조건은 비교하지 않는다.
		System.out.println(eng);//1 증가 되어있음
		System.out.println(!(kor>eng));//t
		System.out.println(!f);//t
		
	}

}
