package makePizza;

import java.util.List;

public class HotWing extends Food {
	Ingredient freezedWing;
	
	
	public HotWing(String name) {
		this.name = name;
	}
	
	public HotWing(String name,Ingredient frezzedWing,String ovenType,int price) {
		this.name = name;
		this.freezedWing = freezedWing;
		this.ovenType = ovenType;
		this.price = price;
	}
	
	public void into_electro_oven() { // ovenType°ª ÀÔ·Â
		ovenType = "Electro";
	}
	
	public void inputIngredient(Ingredient ingredient) {
		freezedWing = ingredient;
	}
	
	public String outputIngredient() {
		return freezedWing.name;
	}
}
