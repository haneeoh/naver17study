package day1226;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame{
	
	JTable table;
	static final String FILENAME="/Users/haneeoh/Desktop/naver1210/student.txt";
	List<Student> list=new ArrayList<Student>();
	
	public Ex5TableStudent() {
		super("학생 성적 관리");
		this.setBounds(300, 100, 400, 300);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void studentFileRead()
	{
		//파일을 읽어서 list 변수에 담기
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String stuScore=br.readLine();
				if(stuScore==null)
					break;
				
				String []s=stuScore.split("\\|");
				Student stu=new Student();
				stu.setName(s[0]);
				stu.setKor(Integer.parseInt(s[1]));
				stu.setEng(Integer.parseInt(s[2]));
				
				list.add(stu);
			}
			System.out.println("총 "+list.size()+"명 읽었습니다.");//확인용
		} catch (IOException|NullPointerException e) {
			// TODO: handle exception
			System.out.println("저장된 학생 정보가 없습니다.");
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public void initDesign()
	{
		this.studentFileRead();//파일을 읽어서 list 변수에 담는다
		//list 의 데이타를 읽어서 테이블에 출력 후
		//프레임에 출력하시오
		//제목은 이름,국어,영어,총점,평균
//		Vector<String> title=new Vector<String>();
//		title.add("이름");
//		title.add("국어");
//		title.add("영어");
//		title.add("총점");
//		title.add("평균");
//		
//		Vector<Vector<String>> data=new Vector<Vector<String>>();
//		
//		for(Student s:list)
//		{
//			Vector<String>  student=new Vector<String>();
//			student.add(s.getName());
//			student.add(String.valueOf(s.getKor()));
//			student.add(String.valueOf(s.getEng()));
//			student.add(String.valueOf(s.getEng()+s.getKor()));
//			student.add(String.valueOf((s.getEng()+s.getKor())/2.0));
//			
//			data.add(student);
//		}
		
		String []title= {"이름","국어","영어","총점","평균"};
		
		String [][]data=new String[list.size()][5];
		
		int i=0;
		for(Student s:list)
		{
			data[i][0]=s.getName();
			data[i][1]=String.valueOf(s.getKor());
			data[i][2]=String.valueOf(s.getEng());
//			data[i][3]=String.valueOf(s.getEng()+s.getKor());
//			data[i][4]=String.valueOf((s.getEng()+s.getKor())/2.0);
			int sum=s.getKor()+s.getEng();
			double avg=sum/2.0;
			data[i][3]=String.valueOf(sum);
			data[i][4]=String.valueOf(avg);
			
			i++;
		}
		
		table=new JTable(data, title);
		this.add("North",new JLabel("시험점수",JLabel.CENTER));
		this.add("Center",new JScrollPane(table));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5TableStudent();

	}

}
