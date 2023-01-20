package listPanel;

public class ProcessedFoodVo {
	private String foodCode, foodName, manufacturer, 
				bigCtg, detailCtg, total, portionSize, unit;
	private int kcal;
	
	
	public ProcessedFoodVo(String food_code, String food_name, String manufacturer, String big_ctg, String detail_ctg) {
		this.foodCode = food_code;
		this.foodName = food_name;
		this.manufacturer = manufacturer;
		this.bigCtg = big_ctg;
		this.detailCtg = detail_ctg;
	}
	// compare 프레임에 사용될 생성자.
	public ProcessedFoodVo(String manufacturer, String food_name, String big_ctg, String detail_ctg, String total, String portion_size, int kcal) {
		this.manufacturer = manufacturer;
		this.foodName = food_name;
		this.bigCtg = big_ctg;
		this.detailCtg = detail_ctg;
		this.total = total;
		this.portionSize = portion_size;
		this.kcal = kcal;
	}
	// list 프레임에 사용될 생성자.
	public ProcessedFoodVo(String food_code, String food_name, String detail_ctg, String manufacturer, int kcal) {
		this.foodCode = food_code;
		this.foodName = food_name;
		this.detailCtg = detail_ctg;
		this.manufacturer = manufacturer;
		this.kcal = kcal;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getFoodCode() {
		return foodCode;
	}
	public String getFoodName() {
		return foodName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public String getBigCtg() {
		return bigCtg;
	}
	public String getDetailCtg() {
		return detailCtg;
	}
	public int getKcal() {
		return kcal;
	}
	public String getTotal() {
		return total;
	}
	public String getPortionSize() {
		return portionSize;
	}
	public String getUnit() {
		return unit;
	}
	
}
