package day1224;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class Ex12FileList {
	static final String FILENAME="/Users/haneeoh/Desktop/naver1210/sawon.txt";
	
	List<String> sawonList=new Vector<String>();
	
	public Ex12FileList() {
		//파일에서 이름을 읽어서 sawonList 에 추가해주세요
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				try {
					System.out.println(s+" ");
				}catch (FileNotFoundException e) {
					System.out.println("**해당 파일을 찾을 수 없습니다.**");
				}finally {
					try {
						br.close();
						fr.close();
					} catch (IOException|NullPointerException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
	
	public void sawonMemberList() throws IOException
	{
		//사원 이름을 번호와 함께 출력해주세요
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			System.out.println("전체 사원 리스트");
			System.out.println();
			System.out.println("번호\t이름");
			System.out.println("=".repeat(20));
			int n=0;
			
			while(true)
			{
				String line=br.readLine();
				if(line==null)
					break;
				String []m=line.split(",");//m을 다른걸로 대입해야할것같은데 방법을모르겠음..
				System.out.println(++n+"\t"+m[0]);
			}
			System.out.println();
			
		}catch (FileNotFoundException e) {
			System.out.println("**해당 파일을 찾을 수 없습니다.**");
		}finally {
			if(fr!=null) fr.close();
			if(br!=null) br.close();
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex12FileList ex12=new Ex12FileList();
		ex12.sawonMemberList();
	}

}