package makePizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food {
	Ingredient dough;
	List<Ingredient> topping = new ArrayList<Ingredient>();
	
	public void inputTopping(Ingredient ingredient) {
		topping.add(ingredient);
	}
	
	public String outputTopping() {
		String toppings ="";
		for(Ingredient ingredient : topping) {
			toppings += ingredient.name+" ";
		}
		return toppings;
		
		
		
	}
}
