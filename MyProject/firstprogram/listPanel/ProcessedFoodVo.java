package listPanel;

public class ProcessedFoodVo {
	private String food_code;
	private String food_name;
	private String manufacturer;
	private String big_ctg;
	private String detail_ctg;
	private int kcal;
	private String total;
	private String portion_size;
	private String unit;
	
	
	public ProcessedFoodVo(String food_code, String food_name, String manufacturer, String big_ctg, String detail_ctg) {
		this.food_code = food_code;
		this.food_name = food_name;
		this.manufacturer = manufacturer;
		this.big_ctg = big_ctg;
		this.detail_ctg = detail_ctg;
	}
	// compare 프레임에 사용될 생성자.
	public ProcessedFoodVo(String manufacturer, String food_name, String big_ctg, String detail_ctg, String total, String portion_size, int kcal) {
		this.manufacturer = manufacturer;
		this.food_name = food_name;
		this.big_ctg = big_ctg;
		this.detail_ctg = detail_ctg;
		this.total = total;
		this.portion_size = portion_size;
		this.kcal = kcal;
	}
	// list 프레임에 사용될 생성자.
	public ProcessedFoodVo(String food_code, String food_name, String detail_ctg, String manufacturer, int kcal) {
		this.food_code = food_code;
		this.food_name = food_name;
		this.detail_ctg = detail_ctg;
		this.manufacturer = manufacturer;
		this.kcal = kcal;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getFoodCode() {
		return food_code;
	}
	public String getFoodName() {
		return food_name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public String getBigCtg() {
		return big_ctg;
	}
	public String getDetailCtg() {
		return detail_ctg;
	}
	public int getKcal() {
		return kcal;
	}
	public String getTotal() {
		return total;
	}
	public String getPortionSize() {
		return portion_size;
	}
	public String getUnit() {
		return unit;
	}
	
}
