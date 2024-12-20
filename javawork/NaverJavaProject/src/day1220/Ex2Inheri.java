package day1220;
class SuperObj2
{
	private String schoolName;
	
	public SuperObj2() {
		// TODO Auto-generated method stub
		schoolName="청담고등학교";
	}
	
	SuperObj2(String schoolName)
	{
		this.schoolName=schoolName;
	}
	
	public void write()
	{
		System.out.println("학교명 : "+schoolName);
	}
}

class SubObj2 extends SuperObj2
{
	private String studentName;
	
	public SubObj2() {
		studentName="이름없음";
	}
	
	SubObj2(String schoolName,String studentName)
	{
		super(schoolName);
		this.studentName=studentName; // 만약 정보가 sub 에 없으면 무조건 super 에서 출력됨
	}
	
	//w shift space -> super 의 write 를 override (재정의) 한다. / 다른변수를 주어도 되지만, 통일성을 위해 super 에서 맞춰 가져오는게 좋음.
	@Override
	public void write() {
		// TODO Auto-generated method stub
		super.write(); //super 가 처리한 로직 실행. 호출 위치 상관없음. 원하는 위치에 삽입 가능.
		System.out.println("학생이름 : "+studentName);
	}
}

class SubObj22 extends SuperObj2
{
	private String teacherName;
	
	public SubObj22() {
		teacherName="이름없음";
	}
	
	SubObj22(String schoolName,String teacherName)
	{
		super(schoolName);
		this.teacherName=teacherName;
	}
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("선생님 이름 : "+teacherName);
		super.write();
	}
}
//////////////////////////////////
public class Ex2Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj2 s1=new SubObj2();
		SubObj2 s2=new SubObj2("강남 고등학교","홍길동");
		
		s1.write();
		System.out.println();
		s2.write();
		System.out.println();
		
		SubObj22 s3=new SubObj22();
		s3.write();
		
		System.out.println();
		
		SubObj22 s4=new SubObj22("강남 중학교","김나나");
		s4.write();
		
	}

}
