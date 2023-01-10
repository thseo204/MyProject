package productCompareFrame;

public class NutrientVo {
	private String food_code;
	private int portion_size;
	private String unit;
	private String total;
	private int kcal;
//	private Nutry[] nutri = new Nutry[73];
	private String[] nutri = new String[73];
	
//	private String moisture_g, protein_g, fat_g, carbs_g, total_sugars_g, glucose_g,
//			fruit_sugar_g, sugar_alcohol_g, erythritol_g, total_dietary_fiber_g, calcium_mg, 
//			iron_mg, magnesium_g, phosphorus_mg, potassium_mg, salt_mg, spelter_mg, cuprum_mg, 
//			cuprum, manganese_mg, manganese, selenium, iodine, chlorine_mg, vitaminA, 
//			batb_carotene, vitaminD, vitaminD3, vitaminD1, vitaminE_mg, vitaminE_mg_TE, 
//			vitaminK_mg, vitaminK, vitaminK1, vitaminK2, vitaminB1_mg, vitaminB1, vitaminB2_mg,
//			vitaminB2, niacin_mg, pantothenic_acid_mg, pantothenic_acid, vitaminB6_mg, vitaminB6,
//			Biotion, folic_acid, vitaminB12_mg, vitaminB12, vitaminC_g, vitaminC_mg, choline_mg, 
//			leucine_mg, tryptophan_mg, histidine_mg, arginine_mg, cysteine_mg, proline_mg, taurine_mg,
//			cholesterol_g, cholesterol_mg, total_saturated_fatty_acids_g, linoleic_acid_mg,
//			alpa_linoleic_acid_mg, gamma_linoleic_acid_mg, arachidonic_acid_mg, eicosapentaenoic_acid_mg,
//			docosahexaenoic_mg, sum_of_epa_and_kha_mg, omega3_fatty_acids_g, trans_fatty_acids_g,
//			total_unsaturated_fatty_acids_g, ash_g, caffeine_mg;
	
	public NutrientVo(String food_code, int portion_size, String total, int kcal, String[] nutri) {
		this.food_code = food_code;
		this.portion_size = portion_size;
//		this.unit = unit;
		this.total = total;
		this.kcal = kcal;
//		for(int i = 0; i < nutri.length; i++) {
			this.nutri = nutri;
//		}
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
