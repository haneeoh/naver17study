package day1224;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex4FileReadWrite {
	static final String FILENAME="/Users/haneeoh/Desktop/naver1210/member.txt";
	
	public static void fileRead() throws IOException
	{
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME); //파일을 읽어서 전체출력할때 사용하는 메서드
			br=new BufferedReader(fr);
			//제목
			System.out.println("\t전체 멤버 명단");
			System.out.println();
			System.out.println("번호\t이름\t나이\t주거지");
			System.out.println("=".repeat(30));
			int n=0;
			while(true)
			{
				String line=br.readLine();
				if(line==null)
					break;
				//,로 분리하기
				String []m=line.split(",");//데이타가 "이름,나이,주거지" 이런 모양임
				System.out.println(++n+"\t"+m[0]+"\t"+m[1]+"세\t"+m[2]);
			}
			System.out.println();
			
		}catch (FileNotFoundException e) {
			System.out.println("** 해당 파일을 찾을 수 없습니다. **");
		}finally {
			if(fr!=null) fr.close(); //nullpoint exception 을 처리하지 않을 경우 if 문이라도 넣어줘야 익셉션이 어떠한 경우에도 발생하지 않음.
			if(br!=null) br.close();
		}
	}
	
	public static void fileSave() throws IOException
	{
		FileWriter fw=null;
		Scanner sc=new Scanner(System.in);
		String name,age,addr;
		
		fw=new FileWriter(FILENAME, true);//추가모드로 생성(기존의 내용이 있으면계속 추가됨)
		//추가할 데이터 입력
		System.out.print("추가할 이름은? : ");
		name=sc.nextLine();
		System.out.print("나이는? : ");
		age=sc.nextLine();
		System.out.print("주거지는? : ");
		addr=sc.nextLine();
		
		//파일에 추가
		fw.write(name+","+age+","+addr+"\n");
		//파일닫기
		if(fw!=null) fw.close();
		System.out.println();//메뉴와 메뉴 사이 한줄 띄기
	}
	
	public static void fileDelete()
	{
		//파일삭제
		File file=new File(FILENAME);
		if(file.exists())
		{
			System.err.println("파일을 삭제합니다.(모든 멤버 삭제)");
			file.delete();
		}else {
			System.out.println("삭제할 파일이 없습니다.");
		}
		System.out.println();
	}
	
	public static int getMenu()
	{
		int menu=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("1.멤버추가  2.전체출력  3.전체멤버삭제  4.종료");
		try {
			menu=Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			menu=2; //메뉴에 문자가 들어올 경우 그냥 전체 출력을 하겠다.
		}
		return menu;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true)
		{
			switch(getMenu())
			{
			case 1->fileSave(); //화살표 쓰면 break 안해도됨 오류:throws 로 처리
			case 2->fileRead();
			case 3->fileDelete();
			default->{
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);//시스템 정상종료(어디에 있던지)
			}
			}
		}

	}

}
