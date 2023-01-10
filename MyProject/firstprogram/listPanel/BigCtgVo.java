package listPanel;

public class BigCtgVo {
	private String big_ctg;
	
	public BigCtgVo() {
		
	}
	
	public BigCtgVo(String big_ctg) {
		this.big_ctg = big_ctg;
	}
	
	public void setBigCtg(String big_ctg) {
		this.big_ctg = big_ctg;
	}
	
	public String getBigCtg() {
		return big_ctg;
	}
	
	public String toString() {
		String str = big_ctg.toString();
		return str;
	}
}
