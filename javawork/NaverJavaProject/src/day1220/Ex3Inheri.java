package day1220;

import day1220_2.DbServerSystem;

class DataProcess extends DbServerSystem
{
	private String sql;
	
	public DataProcess() {
		sql="select";
		//this.dbServerName="Mysql"; //protected 인 경우 직접 접근 가능(상속관계일 경우에만)
		//this.serverPort=9000;//오류 : default 멤버 변수는 상속관계라 하더라도 접근불가
	}
	
	public DataProcess(String dbServerName, int serverPort, String sql)
	{
		super(dbServerName,serverPort);
		this.sql=sql;
	}
	
	public void process()
	{
		//서브클라스에 오버라이드 메서드가 없는 경우 this 로 호출해도 상속받음 메서드가 호출된다.
		//이런 경우 this 로 호출해도 되고 super 로 호출해도 된다
		//하지만 오버라이드 메서드가 있는 경우 부모 메서드 호출시 반드시 super 로 호출 
		//this.serverStart();
		super.serverStart();
		System.out.println("SQL문 "+sql+"처리함");
		this.serverClose();
		System.out.println();
	}
}
public class Ex3Inheri {
	
	public static void main(String[] args) {
		DataProcess data1=new DataProcess();
		data1.process();
		
		DataProcess data2=new DataProcess("MariaDB",3000,"insert");
		data2.process();
		
	}

}







