package listPanel;

public class BigCtgVo {
	private String bigCtg;
	
	public BigCtgVo() {
		
	}
	
//	public BigCtgVo(String big_ctg) {
//		this.bigCtg = big_ctg;
//	}
	
	public void setBigCtg(String big_ctg) {
		this.bigCtg = big_ctg;
	}
	
	public String getBigCtg() {
		return bigCtg;
	}
	
	public String toString() {
		String str = bigCtg.toString();
		return str;
	}
}
