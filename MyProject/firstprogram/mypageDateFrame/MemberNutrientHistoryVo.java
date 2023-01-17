package mypageDateFrame;

public class MemberNutrientHistoryVo {
	private String manu;
	private String foodName;
	private String amount;
	private int kcal;
	
	public MemberNutrientHistoryVo(String manu, String foodName, String amount, int kcal) {
		this.manu = manu;
		this.foodName = foodName;
		this.amount = amount;
		this.kcal = kcal;
	}
	
	public String getManu() {
		return manu;
	}
	public String getFoodName() {
		return foodName;
	}
	public String getAmount() {
		return amount;
	}
	public int getKcal() {
		return kcal;
	}
	
}
