package productListFrame;

public class NutrientDietaryReferenceVo {
	private String gender;
	private String age;
	private int kcal;
	private String[] nutri = new String[73];
	
	public NutrientDietaryReferenceVo(String gender, String age, int kcal, String[] nutri) {
		this.gender = gender;
		this.age = age;
		this.kcal = kcal;
		this.nutri = nutri;
	}
	
	public String getGender() {
		return gender;
	}
	public String getAge() {
		return age;
	}
	public int getKcal() {
		return kcal;
	}
	public String[] getNutry() {
		return nutri;
	}
}
