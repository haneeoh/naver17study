package day1211;

public class Ex2DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor=90;
		int eng=93;
		System.out.println("합계="+kor+eng);//String+int+int :묵시적 형변환에 의해서 String+int=String
		//int+int=int 이므로,먼저 계산을 해야만 한다
		System.out.println("합계="+(kor+eng));
		
		//진법변환
		int a=056;//앞에 0을 붙이면 8진수로 인식 - 0 1 2 3 4 5 6 7
		int b=0x12a;//앞에 0x를 붙이면 16진수로인식 - 0 1 2 3 4 5 6 7 8 9 a b c d e f
		System.out.println("a="+a);//	8진수를 10진수로 변경 : 6x8의0승+5x8의1승:6+40=46
		System.out.println("b="+b);//	16진수를 10진수로 변경 : 10(a)x16의0승+2x16의1승+1x16의2승:10+32+256=298
		
		int c=047;
		int d=0xa9;
		System.out.println("c="+c);	//4x8+7ㅌ=39
		System.out.println("d="+d);	//9x16의0승+10(a)x16의1승:9+160=169
	}

}
