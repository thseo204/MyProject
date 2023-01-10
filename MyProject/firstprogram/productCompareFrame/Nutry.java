package productCompareFrame;

public class Nutry {
	String engName;
	String korName;
	String value;

	public Nutry() {

	}

	public Nutry(String engName, String korName, String value) {
		this.engName = engName;
		this.korName = korName;
		this.value = value;
	}

	public Nutry(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
