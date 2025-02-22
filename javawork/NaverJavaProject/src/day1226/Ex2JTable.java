package day1226;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame{
	JTable table;
	
	public Ex2JTable() {
		super("JTable 공부");
		this.setBounds(300, 100, 300, 300);//시작 위치와 크기 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X버튼 클릭시 종료(프로그램 종료)
		this.initDesign();//보여지기 전에 디자인 추가
		this.setVisible(true);//프레임 보이게 하기
	}
	
	public void initDesign()
	{
		//기본 레이아웃은 BorderLayout 인데
		//이 레이아웃은 동서남북 센터로 위치를 정하는 레이아웃이다
		//방법1//많이 쓰는 방법
//		String []title= {"이름","혈액형","나이"};
//		String [][]data= {
//				{"이미자","AB","23"},
//				{"손기자","A","34"},
//				{"박민영","B","19"}
//		};
		//방법2//복잡해서 잘 쓰지 않음
		Vector<String> title=new Vector<String>();
		title.add("이름");
		title.add("혈액형");
		title.add("나이");
		
		Vector<String> data1=new Vector<String>();
		data1.add("박민영");
		data1.add("AB");
		data1.add("23");
		
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		data.add(data1);
//		data.add(data2);
//		data.add(data3);
		
		//jtable 생성
		table=new JTable(data, title);
		
		//North 에 JLabel 을 추가해보자
		this.add("North",new JLabel("데이터출력테이블",JLabel.CENTER));
		
		//frame 의 center에 추가
		//this.add("Center",table);//제목이 나오지 않음. 데이터가 많을경우 스크롤 불가능.
		this.add("Center",new JScrollPane(table));//JScrollPane 으로 생성해서 넣어야 제목과 스크롤이 나타남
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2JTable ex2=new Ex2JTable();
	}

}
