package day1220;

import day1220_2.Apple;

class Orange extends Apple
{
	public void play()
	{
		this.job();//public
		this.study();//protected
		//this.draw(); //오류:디폴트값은 상속시에도 접근불가
		this.process();
		//오버라이드 값이 있을 경우, 현재 클라스의 오버라이드 메서드가 출력됨
	}
	
	@Override //오버라이드 하는 순간 메서드가 덮어씌워짐
	protected void process() { //더 넓은 범위는 허용. 그렇지만 보통 그대로 가져다 씀.
	//void process() { //오류
	//private void process() { //오류
	//public void process() { //문제없음
		// TODO Auto-generated method stub
		super.process();
		System.out.println("Oracle,Mysql 공부를 더 깊게 합니다.");
	}
}

public class Ex4Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange or=new Orange();
		or.play();
	}

}