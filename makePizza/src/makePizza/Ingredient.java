package makePizza;

public class Ingredient {
	String name;
	int num;
	int price;
	
	public Ingredient() {
		
	}
	
	public Ingredient(String name) {
		this.name = name;
		num = 0;
	}
	
	
	public Ingredient(String name, int num, int price) {
		this.name = name;
		this.num = num;
		this.price = price;
	}
	
	
	


	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getNum() {
		return num;
	}





	public void setNum(int num) {
		this.num = num;
	}





	public void buy(int buyNum) {
		num += buyNum;
	}


	
	
}
