package joinFrame;

public class JoinVo {
	private String id, pwd, email, name, gender, birth;
	
	public JoinVo(String id, String pwd, String email, String name, String gender, String barth) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		this.gender = gender;
		this.birth = barth;
	}
	
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getBirth() {
		return birth;
	}
}
