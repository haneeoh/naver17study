package day1216;

public class Ex5String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("String 클래스의 멤버 메소드에 대한 공부");
		String str1="Apple";
		String str2="Have a Nice Day!!";
		String str3="Orange";
		String str4=new String("Apple");
		
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str3="+str3);
		
		System.out.println("str2의 길이 : "+str2.length());
		System.out.println("str1의 0번 글자 : "+str1.charAt(0));
		System.out.println("str2의 3번 글자 : "+str2.charAt(3));
		System.out.println("str3의 1번 글자 : "+str3.charAt(1));
		
		System.out.println();
		System.out.println("str1에서 l의 위치는 : "+str1.indexOf('l'));//첫번째 자리 0
		System.out.println("str2에서 a의 위치는 : "+str2.indexOf('a'));
		System.out.println("str2에서 마지막 a의 위치는 : "+str2.lastIndexOf('a'));
		System.out.println("str3에서 x의 위치는 : "+str2.indexOf('x'));//해당 문자가 없을 경우 -1이 발생
		
		//객체타입에서는 ==동등연산자가 주소를 비교하는 연산
		System.out.println();
		System.out.println(str1==str4);//f
		System.out.println(str2=="Orange");//true
		System.out.println(str3=="apple");//f
		
		//문자열을 정확하게 오류없이 비교하기 위해서는 equals 사용
		System.out.println();
		System.out.println(str1.equals(str4));
		System.out.println(str1.equals("apple"));//false 대소문자까지 모두 맞아야 true
		System.out.println(str1.equalsIgnoreCase("apPle"));//대소문자 상관없이 true
		
		System.out.println("문자열 비교-compareTo");
		int n=str1.compareTo("Apple");
		System.out.println(n);//0대소문자까지 같을 경우
		
		n=str1.compareTo("Banana");
		System.out.println(n); //문자열1이 문자열2보다 작을 경우 마이너스값 -1:'A'하고 'B'하고 비교 
		
		n=str3.compareTo(str1);//"Orange","Apple"을 비교 'O','A'
		System.out.println(n);//14 : 알파벳 순서가 거꾸로 되어있을 경우 양수값으로 출력 즉,알파벳 차이만큼 출력 
		
		System.out.println();
		System.out.println("str2를 모두 대문자로 변환 : "+str2.toUpperCase());
		System.out.println("str2를 모두 소문자로 변환 : "+str2.toLowerCase());
		
		System.out.println();
		System.out.println("str2 가 Have로 시작하면 true:"+str2.startsWith("Have"));
		System.out.println("str2 가 Happy로 시작하면 true:"+str2.startsWith("Happy"));
		System.out.println("str1 가 Have로 시작하지 않으면 false:"+str1.startsWith("Have"));
		
		System.out.println("str2 가 Day!!로 끝나면 true:"+str2.endsWith("Day!!"));
		System.out.println("str2 가 Day!로 끝나면 true:"+str2.endsWith("Day!"));
		
		System.out.println("=".repeat(50));
		System.out.println(str1.repeat(5));
		
		System.out.println("*".repeat(30));
		System.out.println(str2.replace("a","*"));
		System.out.println(str2.replace("Nice","Happy"));
		
		System.out.println();
		System.out.println(str2.substring(7));//7번 인덱스부터 끝까지 추출
		System.out.println(str2.substring(7,10));//7부터 9번 인덱스까지 추출
		
	}

}
