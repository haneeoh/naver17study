package day0106db;

public class PersonDto {
	private int num;
	private int age;
	private String name;
	private String hp;
	private String blood;
	
	public PersonDto() {
	}

	public PersonDto(int age, String name, String hp, String blood) {
		super();
		this.age = age;
		this.name = name;
		this.hp = hp;
		this.blood = blood;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}
	
	

}
