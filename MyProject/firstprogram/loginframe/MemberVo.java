package loginframe;

public class MemberVo {
	private String id;
	private String pw;
	private String name;
	
	public MemberVo() {

	}
	
	public MemberVo(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pw) {
		this.pw = pw;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public String getName() {
		return name;
	}
}
