package day1219;

public class Sawon {

	 //멤버변수 사원명 sawonName, 기본급 gibonPay, 직급 position
	 //수당 suDang, 가족 수 famSu
	private String sawonName;
	private String position;
	private int gibonPay;
	private int suDang;
	private int famSu;
	
	 //디폴트 생성자
	 //사원명, 직급, 가족수를 인자로 받는 생성자
	
	public Sawon(String sawonName, String position, int famSu) {
		this.sawonName = sawonName;
		this.position = position;
		this.famSu = famSu;
	}
	
	//setter & getter method

	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getGibonPay() {
		return gibonPay;
	}

	public void setGibonPay(int gibonPay) {
		this.gibonPay = gibonPay;
	}

	public int getSuDang() {
		return suDang;
	}

	public void setSuDang(int suDang) {
		this.suDang = suDang;
	}

	public int getFamSu() {
		return famSu;
	}

	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	
	 //직급에 따라 gibonPay를 구하는데부장->450,과장->300,대리->250,사원->150
	 //getGibonPay()
	
	public int getGibonPay()
	{
		
	}
	
	 //직급에 따라 수당을 구하는데 부장,과장->70 	대리,사원->50
	 //getSudang()
	public int getSuDang()
	{
		
	}
	
	 //getGibonPay() 값을 받아서 세금 5프로를 구해서 반환하는
	 //getTax()
	public int getTax()
	{
		
	}
	
	 //가족수가5인 이상이면 30반환, 5인 미만 2인 이상은 10 반환, 나머지는0
	 //getFamSudang()
	public int getFamSudang()
	{
		if (famSu>5)
		{
			
		}
		if (famSu<5 && famSu>2)
		{
			
		}
		else
			
	}
	
	 //실수령액을 구해서 반환하는 메서드 기본급+수당-세금+가족수당을 구해서 반환
	 //getNetPay
	public int getNetPay()
	{
		
	}
	
	
	
}







