package makePizza;

import java.util.List;

public class ElectroOvenPizza extends Pizza{
	
	
	public ElectroOvenPizza(String name) {
		this.name = name;
	}
	
	
	
	public ElectroOvenPizza(String name,List<Ingredient> topping,String ovenType,int price) {
		this.name = name;
		this.topping = topping;
		this.ovenType = ovenType;
		this.price = price;	
	}
	
	public ElectroOvenPizza(String name,List<Ingredient> topping) {
		
		this.name = name;
		this.topping = topping;
		
	}

	public void into_electro_oven() {	// ovenType°ª ÀÔ·Â
		ovenType = "Electro";
	}
}
