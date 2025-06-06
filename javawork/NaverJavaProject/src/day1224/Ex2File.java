package day1224;

import java.io.File;

public class Ex2File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1=new File("/Users/haneeoh/Desktop/naver1210/score.txt");
		File file2=new File("/Users/haneeoh/Desktop/naver1210");
		System.out.println(file1.length()); //byte 단위
		System.out.println(file1.canExecute());//true
		System.out.println(file1.canRead());//true
		System.out.println(file1.canWrite());//true
		
		System.out.println(file1.exists());//true,	파일이 존재하면 true
		System.out.println(file1.isDirectory());//false 디렉토리인가
		System.out.println(file2.isDirectory());//true
		
		System.out.println(file1.isFile());//true 파일인가?
		System.out.println(file2.isFile());//false : is ~~~ ->물어보는 형식
		
		//file1이 디렉토리라면 목록을 출력하라
		if(file1.isDirectory())
		{
			String []list=file1.list();
			for(String s:list)
				System.out.println(s);
		}else {
			System.out.println("file1은 파일입니다");
		}
		
		//file2이 디렉토리라면 목록을 출력하라
		if(file2.isDirectory())
		{
			System.out.println("** 파일2 목록 **");
			String []list=file2.list();
			int n=0;
			for(String s:list)
				System.out.println(++n+":"+s);
		}else {
			System.out.println("file2는 파일입니다");
		}
		System.out.println("=".repeat(30));
		System.out.println(file1.getAbsolutePath());//Users/haneeoh/Desktop/naver1210/score.txt
		System.out.println(file1.getName());//파일명 score.txt
		System.out.println(file1.getParent());//Users/haneeoh/Desktop/naver1210
		
	}

}
