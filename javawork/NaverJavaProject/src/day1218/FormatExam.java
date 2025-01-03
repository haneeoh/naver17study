package day1218;

import java.util.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class FormatExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date); 
		
		//내가 원하는 포멧양식으로 출력해보자 
		//M:월,m:분,H:24시간,h:12시간,E요일,a:오전/오후 
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd a hh:mm"); 
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm EEE"); //3개는 간단(수)
		SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-dd a hh:mm EEEE"); // 4개는 풀(수요일)
		
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		
		int num1=45678900;
		int num2=34567;
		
		NumberFormat nf1=NumberFormat.getInstance();
		System.out.println("num1="+nf1.format(num1));
		System.out.println("num1="+nf1.format(num2));
		
		NumberFormat nf2=NumberFormat.getCurrencyInstance();//Locale 지정하지 않으면 대한민국
		System.out.println("num1="+nf2.format(num1));
		System.out.println("num1="+nf2.format(num2));

	}

}
