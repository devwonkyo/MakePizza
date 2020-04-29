package makePizza;

import java.util.List;

public class ClassicOvenPizza extends Pizza{
	
	public ClassicOvenPizza(String name) {
		this.name = name;
	}
	
	public ClassicOvenPizza(String name,List<Ingredient> topping,String ovenType,int price) {
		
		this.name = name;
		this.topping = topping;
		this.ovenType = ovenType;
		this.price = price;	
	}
	
	public ClassicOvenPizza(String name,List<Ingredient> topping) {
		
		this.name = name;
		this.topping = topping;
		
	}
	
	
	
	public void into_classic_oven() {	// ovenType°ª ÀÔ·Â
		ovenType = "Classic";
	}
	
}
