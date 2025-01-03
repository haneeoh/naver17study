package day1219;

public class Ex8StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Happy";
		//String->StringBuffer
		StringBuffer sb=new StringBuffer(str);
		//인스턴스 변수인 경우 변수명만 출력시 자동으로 toString()이 호출됨
		//toString을 갖고 있지 않는경우 값이 아닌 주소가 출력된다
		System.out.println(sb);
		System.out.println(sb.toString());
		
		//String 은 값 자체를 변경할 수 없지만 StringBuffer는 문자열 편집이 가능하다
		sb.append('A');
		sb.append(100);
		sb.append("Bitcamp");
		System.out.println(sb); //문자열이 계속 추가됨
		
		//삭제
		sb.delete(5, 9);//5~8인덱스 부분 제거 (마지막은 -1)
		System.out.println(sb);
		
		//중간삽
		sb.insert(3, "java");//3번 인덱스 앞에 삽입
		System.out.println(sb);
		
		//중간의 문자열 변경
		sb.replace(3, 7, "Hello");//4~7을 지우고 그 자리에 Hello 를 넣는다 (시작 -1)
		System.out.println(sb);
		
		//데이타를 json 데이타로 변환
		String name="캔디";
		int age=23;
		
		StringBuffer sb2=new StringBuffer();
		sb2.append("{\"name\":");
		sb2.append("\""+name+"\",");
		sb2.append("\"age\":");
		sb2.append("23}");
		
		System.out.println(sb2);
	}

}
