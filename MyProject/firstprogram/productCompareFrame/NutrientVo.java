package productCompareFrame;

public class NutrientVo {
	private String food_code;
	private int portion_size;
	private String unit;
	private String total;
	private int kcal;
	private String[] nutri = new String[73];
	
	public NutrientVo(String food_code, int portion_size, String total, int kcal, String[] nutri) {
		this.food_code = food_code;
		this.portion_size = portion_size;
		this.total = total;
		this.kcal = kcal;
		this.nutri = nutri;
	}
	
	public String getFoodCode() {
		return food_code;
	}
	public int getPortionSize() {
		return portion_size;
	}
	public String getUnit() {
		return unit;
	}
	public String getTotal() {
		return total;
	}
	public int getKcal() {
		return kcal;
	}
	public String[] getNutry() {
		return nutri;
	}
//	public String getNutryValue(int i) {
//		return nutri[i];
//	}
}
