package day0106db;

public class ShopDto {
	private int idx; // 변수명은 컬럼명과 달라도되지만 헷갈리므로 같은걸 추천
	private String sangpum;
	private int su;
	private int danga;
	
	public ShopDto() {
		
	}
	
	//idx 빼고 만들기 
	public ShopDto(String sangpum, int su, int danga) {
		super();
		this.sangpum = sangpum;
		this.su = su;
		this.danga = danga;
	}
	
	//setter getter 는 모두
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getSangpum() {
		return sangpum;
	}

	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDanga() {
		return danga;
	}

	public void setDanga(int danga) {
		this.danga = danga;
	}
	
	

}
