package day1219;

import java.util.Calendar;

public class Student {
	private String stuName;
	private String stuAddress;
	private String stuBlood;
	private int stuBirthYear;
	private int stuScore;
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName; //구역안에 같은 이름이 있을경우 this 를 반드시 붙여줘야함
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getStuBlood() {
		return stuBlood;
	}
	public void setStuBlood(String stuBlood) {
		this.stuBlood = stuBlood;
	}
	public int getStuBirthYear() {
		return stuBirthYear;
	}
	public void setStuBirthYear(int birthYear) {
		this.stuBirthYear = birthYear;
	}
	public int getStuScore() {
		return stuScore;
	}
	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}
	
	//한꺼번에 변경할경우
	public void changeStudent(String stuName, String stuAdress, String stuBlood)
	{
		this.setStuName(stuName);
		this.setStuAddress(stuAdress);
		this.setStuBlood(stuBlood);
	}
	
	//stuScore 에 대한 절대평가 (A~F) 반환하는 메서드
	public char getScoreGrade()
	{
		char grade=switch(stuScore/10)
				{
					case 10,9->'A';
					case 8->'B';
					case 7->'C';
					case 6->'D';
					default->'F';
				};
		return grade;
	}
	
	//stuBirthYear로 나이를 구해서 반환(현재년도-태어난년도)
	public int getAge()
	{
		//현재 년도 Calendar 로 구하기
		Calendar cal=Calendar.getInstance();
		int curYear=cal.get(Calendar.YEAR);
		
		return curYear-stuBirthYear;
	}
}

