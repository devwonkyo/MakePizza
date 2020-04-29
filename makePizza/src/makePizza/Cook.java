package makePizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Cook {
	String name;
	List<Food> order;
	List<Food> makedOrder = new ArrayList<Food>();
	List<Ingredient> useIngredientList = new ArrayList<Ingredient>();
	List<Ingredient> ingredientList;
	List<Pizza> pizzaList;
	HotWing hotWing;
	Scanner scan = new Scanner(System.in);
	
	 
	public Cook(String name) { //요리사 이름 설정
		this.name = name;
	}
	
	public void setOrder(List<Food> order,List<Pizza> pizzaList,HotWing hotWing,List<Ingredient> ingredientList) { //주문서 등록
		this.order = order;
		this.pizzaList = pizzaList;
		this.hotWing = hotWing;
		this.ingredientList = ingredientList;
		useIngredientList.add(new Ingredient("꿀"));//0
		useIngredientList.add(new Ingredient("도우"));//1
		useIngredientList.add(new Ingredient("피망"));//2
		useIngredientList.add(new Ingredient("치즈"));//3
		useIngredientList.add(new Ingredient("버섯"));//4
		useIngredientList.add(new Ingredient("올리브"));//5
		useIngredientList.add(new Ingredient("불고기"));//6
		useIngredientList.add(new Ingredient("포테이토"));//7
		useIngredientList.add(new Ingredient("페페로니"));//8
		useIngredientList.add(new Ingredient("냉동날개"));//9
		useIngredientList.add(new Ingredient("토마토소스"));//10	
	}


	public boolean makeFood() {    //음식만들기
		boolean ingredientExist = true;
		for(Food food : order) {
			switch(food.name) {
				case "오븐페페로니피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(8).num++;
					useIngredientList.get(3).num++;
					break;
				case "오븐콤비네이션피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(8).num++;
					useIngredientList.get(4).num++;
					useIngredientList.get(5).num++;
					useIngredientList.get(3).num++;
					break;
				case "오븐포테이토피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(7).num++;
					useIngredientList.get(3).num++;
					break;
				case "오븐불고기피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(6).num++;
					useIngredientList.get(3).num++;
					break;
				case "오븐고르곤졸라피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(3).num++;
					useIngredientList.get(0).num++;
					break;
				case "화덕페페로니피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(8).num++;
					useIngredientList.get(3).num++;
					break;
				case "화덕콤비네이션피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(8).num++;
					useIngredientList.get(4).num++;
					useIngredientList.get(5).num++;
					useIngredientList.get(3).num++;
					break;
				case "화덕포테이토피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(7).num++;
					useIngredientList.get(3).num++;
					break;
				case "화덕불고기피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(6).num++;
					useIngredientList.get(3).num++;
					break;
				case "화덕고르곤졸라피자":
					useIngredientList.get(1).num++;
					useIngredientList.get(3).num++;
					useIngredientList.get(0).num++;
					break;
				case "핫윙":
					useIngredientList.get(9).num++;
					break;					
			}
		}
		
		for(int i = 0; i<ingredientList.size();i++ ) {
			if(ingredientList.get(i).num<useIngredientList.get(i).num) {
				ingredientExist = false;
				useIngredientList.clear();
				return ingredientExist;
			}
		}
		
		Timer timer = new Timer();
		CheckRun checkRun = new CheckRun();     //쓰레드간의 run , stop 제어
		String input;
		System.out.println(">> 10초안에 필요한 토핑을 순서대로 입력해주세요!!");
		System.out.println();
		orderCheck();//들어온 주문확인
		for(Food food : order) {
			checkRun.setRun(true);
			timer.setCheckRun(checkRun);
			PlaySounds fire = new PlaySounds("C:\\sounds/fire.wav");
			switch(food.name) {
			case "오븐페페로니피자":
				ElectroOvenPizza makedElecPepe = new ElectroOvenPizza("오븐페페로니피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("오븐페페로니 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(0).outputTopping());
				System.out.println();
				Thread timerThread = new Thread(timer);
				timerThread.start();
				for(int i = 0 ; i < pizzaList.get(0).topping.size(); i++) { //페페로니 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
						case "꿀":
							if(ingredientList.get(0).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(0));
								ingredientList.get(0).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							break;
						case "도우":
							if(ingredientList.get(1).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(1));
								ingredientList.get(1).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						case "피망":
							if(ingredientList.get(2).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(2));
								ingredientList.get(2).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						case "치즈":
							if(ingredientList.get(3).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(3));
								ingredientList.get(3).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							break;
						case "버섯":
							if(ingredientList.get(4).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(4));
								ingredientList.get(4).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						case "올리브":
							if(ingredientList.get(5).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(5));
								ingredientList.get(5).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						case "불고기":
							if(ingredientList.get(6).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(6));
								ingredientList.get(6).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						case "포테이토":
							if(ingredientList.get(7).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(7));
								ingredientList.get(7).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						case "페페로니":
							if(ingredientList.get(8).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(8));
								ingredientList.get(8).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						case "냉동날개":
							if(ingredientList.get(9).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(9));
								ingredientList.get(9).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						case "토마토소스":
							if(ingredientList.get(10).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(10));
								ingredientList.get(10).num--;
								System.out.println("넣었어요.");
							}
							else {
								System.out.println("재고가 부족해요.");
							}
							
							break;
						default:
							Ingredient empty = new Ingredient();
							makedElecPepe.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println(">>어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecPepe.into_electro_oven();
				}else{
					makedElecPepe.ovenType ="Classic";
				}
				
				String reason = "저는 "+makedElecPepe.name+"를 시켰는데 ";
				if(makedElecPepe.outputTopping().equals(pizzaList.get(0).outputTopping()) &&
						makedElecPepe.ovenType.equals(pizzaList.get(0).ovenType)) {
					makedElecPepe.setSuccess(true);
				}
				if(!makedElecPepe.outputTopping().equals(pizzaList.get(0).outputTopping())){
					makedElecPepe.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedElecPepe.ovenType.equals(pizzaList.get(0).ovenType)) {
					makedElecPepe.setSuccess(false);
					reason += "오븐피자가 아니에요..";
				}
				makedElecPepe.setReason(reason);
				makedOrder.add(makedElecPepe);
				fire.run();
				break;
			case "오븐콤비네이션피자":
				ElectroOvenPizza makedElecCombi = new ElectroOvenPizza("오븐콤비네이션피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("오븐콤비네이션 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(1).outputTopping());  //오븐 콤비네이션 피자 토핑 출력
				System.out.println();		
				Thread timerThread1 = new Thread(timer);
				timerThread1.start();
				for(int i = 0 ; i < pizzaList.get(1).topping.size(); i++) { //오븐 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedElecCombi.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println(">>어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				 
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecCombi.into_electro_oven();
				}else{
					makedElecCombi.ovenType ="Classic";
				}
				
					reason = "저는 "+makedElecCombi.name+"를 시켰는데 ";
				if(makedElecCombi.outputTopping().equals(pizzaList.get(1).outputTopping()) &&
						makedElecCombi.ovenType.equals(pizzaList.get(1).ovenType)) {
					makedElecCombi.setSuccess(true);
				}
				if(!makedElecCombi.outputTopping().equals(pizzaList.get(1).outputTopping())){
					makedElecCombi.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedElecCombi.ovenType.equals(pizzaList.get(1).ovenType)) {
					makedElecCombi.setSuccess(false);
					reason += "오븐피자가 아니에요..";
				}
				makedElecCombi.setReason(reason);
				makedOrder.add(makedElecCombi);
				fire.run();
				break;
			case "오븐포테이토피자":
				ElectroOvenPizza makedElecPotato = new ElectroOvenPizza("오븐포테이토피자");      //포테이토피자 객체생성
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("오븐포테이토 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(2).outputTopping());
				System.out.println();
				Thread timerThread2 = new Thread(timer);
				timerThread2.start();
				for(int i = 0 ; i < pizzaList.get(2).topping.size(); i++) { //오븐 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedElecPotato.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				 
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecPotato.into_electro_oven();
				}else{
					makedElecPotato.ovenType ="Classic";
				}
					reason = "저는 "+makedElecPotato.name+"를 시켰는데 ";
				if(makedElecPotato.outputTopping().equals(pizzaList.get(2).outputTopping()) &&
						makedElecPotato.ovenType.equals(pizzaList.get(2).ovenType)) {
					makedElecPotato.setSuccess(true);
				}
				if(!makedElecPotato.outputTopping().equals(pizzaList.get(2).outputTopping())){
					makedElecPotato.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedElecPotato.ovenType.equals(pizzaList.get(2).ovenType)) {
					makedElecPotato.setSuccess(false);
					reason += "오븐피자가 아니에요..";
				}
				makedElecPotato.setReason(reason);
				makedOrder.add(makedElecPotato);
				fire.run();
				break;
			case "오븐불고기피자":
				ElectroOvenPizza makedElecBulgogi = new ElectroOvenPizza("오븐불고기피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("오븐불고기 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(3).outputTopping());
				System.out.println();
				Thread timerThread3 = new Thread(timer);
				timerThread3.start();
				for(int i = 0 ; i < pizzaList.get(3).topping.size(); i++) { //오븐 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedElecBulgogi.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				 
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecBulgogi.into_electro_oven();
				}else{
					makedElecBulgogi.ovenType ="Classic";
				}
				//fire.run();
					reason = "저는 "+makedElecBulgogi.name+"를 시켰는데 ";
				if(makedElecBulgogi.outputTopping().equals(pizzaList.get(3).outputTopping()) &&
						makedElecBulgogi.ovenType.equals(pizzaList.get(3).ovenType)) {
					makedElecBulgogi.setSuccess(true);
				}
				if(!makedElecBulgogi.outputTopping().equals(pizzaList.get(3).outputTopping())){
					makedElecBulgogi.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedElecBulgogi.ovenType.equals(pizzaList.get(3).ovenType)) {
					makedElecBulgogi.setSuccess(false);
					reason += "오븐피자가 아니에요..";
				}
				makedElecBulgogi.setReason(reason);
				makedOrder.add(makedElecBulgogi);
				fire.run();
				break;
			case "오븐고르곤졸라피자":
				ElectroOvenPizza makedElecGor = new ElectroOvenPizza("오븐고르곤졸라피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("오븐고르곤졸라 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(4).outputTopping());
				System.out.println();
				Thread timerThread4 = new Thread(timer);
				timerThread4.start();
				for(int i = 0 ; i < pizzaList.get(4).topping.size(); i++) { //오븐 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedElecGor.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				 
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecGor.into_electro_oven();
				}else{
					makedElecGor.ovenType ="Classic";
				}
				//fire.run();
					reason = "저는 "+makedElecGor.name+"를 시켰는데 ";
				if(makedElecGor.outputTopping().equals(pizzaList.get(4).outputTopping()) &&
						makedElecGor.ovenType.equals(pizzaList.get(4).ovenType)) {
					makedElecGor.setSuccess(true);
				}
				if(!makedElecGor.outputTopping().equals(pizzaList.get(4).outputTopping())){
					makedElecGor.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedElecGor.ovenType.equals(pizzaList.get(4).ovenType)) {
					makedElecGor.setSuccess(false);
					reason += "오븐피자가 아니에요..";
				}
				makedElecGor.setReason(reason);
				makedOrder.add(makedElecGor);
				fire.run();
				break;
			case "화덕페페로니피자":
				ClassicOvenPizza makedClassicPepe = new ClassicOvenPizza("화덕페페로니피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("화덕페페로니 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(5).outputTopping());
				System.out.println();
				Thread timerThread5 = new Thread(timer);
				timerThread5.start();
				for(int i = 0 ; i < pizzaList.get(5).topping.size(); i++) { //화덕 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicPepe.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicPepe.into_classic_oven();
				}else{
					makedClassicPepe.ovenType ="Electro";
				}
				//fire.run();
					reason = "저는 "+makedClassicPepe.name+"를 시켰는데 ";
				if(makedClassicPepe.outputTopping().equals(pizzaList.get(5).outputTopping()) &&
						makedClassicPepe.ovenType.equals(pizzaList.get(5).ovenType)) {
					makedClassicPepe.setSuccess(true);
				}
				if(!makedClassicPepe.outputTopping().equals(pizzaList.get(5).outputTopping())){
					makedClassicPepe.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedClassicPepe.ovenType.equals(pizzaList.get(5).ovenType)) {
					makedClassicPepe.setSuccess(false);
					reason += "화덕피자가 아니에요..";
				}
				makedClassicPepe.setReason(reason);
				makedOrder.add(makedClassicPepe);
				fire.run();
				break;
			case "화덕콤비네이션피자":
				ClassicOvenPizza makedClassicCombi = new ClassicOvenPizza("화덕콤비네이션피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("화덕콤비네이션 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(6).outputTopping());
				System.out.println();
				Thread timerThread6 = new Thread(timer);
				timerThread6.start();
				for(int i = 0 ; i < pizzaList.get(6).topping.size(); i++) { //화덕 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicCombi.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicCombi.into_classic_oven();
				}else{
					makedClassicCombi.ovenType ="Electro";
				}
				//fire.run();
					reason = "저는 "+makedClassicCombi.name+"를 시켰는데 ";
				if(makedClassicCombi.outputTopping().equals(pizzaList.get(6).outputTopping()) &&
						makedClassicCombi.ovenType.equals(pizzaList.get(6).ovenType)) {
					makedClassicCombi.setSuccess(true);
				}
				if(!makedClassicCombi.outputTopping().equals(pizzaList.get(6).outputTopping())){
					makedClassicCombi.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedClassicCombi.ovenType.equals(pizzaList.get(6).ovenType)) {
					makedClassicCombi.setSuccess(false);
					reason += "화덕피자가 아니에요..";
				}
				makedClassicCombi.setReason(reason);
				makedOrder.add(makedClassicCombi);
				fire.run();
				break;
			case "화덕포테이토피자":
				ClassicOvenPizza makedClassicPotato = new ClassicOvenPizza("화덕포테이토피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("화덕포테이토 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(7).outputTopping());
				System.out.println();
				Thread timerThread7 = new Thread(timer);
				timerThread7.start();
				for(int i = 0 ; i < pizzaList.get(7).topping.size(); i++) { //화덕 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicPotato.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				 
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicPotato.into_classic_oven();
				}else{
					makedClassicPotato.ovenType ="Electro";
				}
				//fire.run();
					reason = "저는 "+makedClassicPotato.name+"를 시켰는데 ";
				if(makedClassicPotato.outputTopping().equals(pizzaList.get(7).outputTopping()) &&
						makedClassicPotato.ovenType.equals(pizzaList.get(7).ovenType)) {
					makedClassicPotato.setSuccess(true);
				}
				if(!makedClassicPotato.outputTopping().equals(pizzaList.get(7).outputTopping())){
					makedClassicPotato.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedClassicPotato.ovenType.equals(pizzaList.get(7).ovenType)) {
					makedClassicPotato.setSuccess(false);
					reason += "화덕피자가 아니에요..";
				}
				makedClassicPotato.setReason(reason);
				makedOrder.add(makedClassicPotato);
				fire.run();
				break;
			case "화덕불고기피자":
				ClassicOvenPizza makedClassicBulgogi = new ClassicOvenPizza("화덕불고기피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("화덕불고기 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(8).outputTopping());
				System.out.println();
				Thread timerThread8 = new Thread(timer);
				timerThread8.start();
				for(int i = 0 ; i < pizzaList.get(8).topping.size(); i++) { //화덕 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicBulgogi.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				 
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicBulgogi.into_classic_oven();
				}else{
					makedClassicBulgogi.ovenType ="Electro";
				}
				//fire.run();
					reason = "저는 "+makedClassicBulgogi.name+"를 시켰는데 ";
				if(makedClassicBulgogi.outputTopping().equals(pizzaList.get(8).outputTopping()) &&
						makedClassicBulgogi.ovenType.equals(pizzaList.get(8).ovenType)) {
					makedClassicBulgogi.setSuccess(true);
				}
				if(!makedClassicBulgogi.outputTopping().equals(pizzaList.get(8).outputTopping())){
					makedClassicBulgogi.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedClassicBulgogi.ovenType.equals(pizzaList.get(8).ovenType)) {
					makedClassicBulgogi.setSuccess(false);
					reason += "화덕피자가 아니에요..";
				}
				makedClassicBulgogi.setReason(reason);
				makedOrder.add(makedClassicBulgogi);
				fire.run();
				break;
			case "화덕고르곤졸라피자":
				ClassicOvenPizza makedClassicGor = new ClassicOvenPizza("화덕고르곤졸라피자");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("화덕고르곤졸라 피자를 만들거에요");
				System.out.println("필요한 토핑 >> "+pizzaList.get(9).outputTopping());
				System.out.println();
				Thread timerThread9 = new Thread(timer);
				timerThread9.start();
				for(int i = 0 ; i < pizzaList.get(9).topping.size(); i++) { //화덕 피자 토핑리스트만큼 입력
					System.out.print("입력>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>재료를 넣을 시간이 지났어요");
						break;
					}
					switch(input) {
					case "꿀":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "도우":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "피망":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "치즈":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						break;
					case "버섯":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "올리브":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "불고기":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "포테이토":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "페페로니":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "냉동날개":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
					case "토마토소스":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("넣었어요.");
						}
						else {
							System.out.println("재고가 부족해요.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicGor.inputTopping(empty);
							System.out.println("넣었어요.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				 
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicGor.into_classic_oven();
				}else{
					makedClassicGor.ovenType = "Electro";
				}
				//fire.run();
					reason = "저는 "+makedClassicGor.name+"를 시켰는데 ";
				if(makedClassicGor.outputTopping().equals(pizzaList.get(9).outputTopping()) &&
						makedClassicGor.ovenType.equals(pizzaList.get(9).ovenType)) {
					makedClassicGor.setSuccess(true);
				}
				if(!makedClassicGor.outputTopping().equals(pizzaList.get(9).outputTopping())){
					makedClassicGor.setSuccess(false);
					reason +="피자 토핑이 이상해요.. ";
				}
				if(!makedClassicGor.ovenType.equals(pizzaList.get(9).ovenType)) {
					makedClassicGor.setSuccess(false);
					reason += "화덕피자가 아니에요..";
				}
				makedClassicGor.setReason(reason);
				makedOrder.add(makedClassicGor);
				fire.run();
				break;
			case "핫윙":
				HotWing makedHotwing = new HotWing("핫윙");
				Thread timerThread10 = new Thread(timer);
				timerThread10.start();
				System.out.println();
				System.out.println("핫윙을 만들거에요");
				System.out.println("필요한 토핑 >> 냉동날개");
				System.out.println();
				System.out.print("입력>>");
				input = scan.next();
				if(!checkRun.isRun) {
					System.out.println(">>재료를 넣을 시간이 지났어요");
					break;
				}
				switch(input) {
				case "꿀":
					if(ingredientList.get(0).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(0));
						ingredientList.get(0).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					break;
				case "도우":
					if(ingredientList.get(1).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(1));
						ingredientList.get(1).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				case "피망":
					if(ingredientList.get(2).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(2));
						ingredientList.get(2).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				case "치즈":
					if(ingredientList.get(3).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(3));
						ingredientList.get(3).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					break;
				case "버섯":
					if(ingredientList.get(4).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(4));
						ingredientList.get(4).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				case "올리브":
					if(ingredientList.get(5).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(5));
						ingredientList.get(5).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				case "불고기":
					if(ingredientList.get(6).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(6));
						ingredientList.get(6).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				case "포테이토":
					if(ingredientList.get(7).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(7));
						ingredientList.get(7).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				case "페페로니":
					if(ingredientList.get(8).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(8));
						ingredientList.get(8).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				case "냉동날개":
					if(ingredientList.get(9).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(9));
						ingredientList.get(9).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				case "토마토소스":
					if(ingredientList.get(10).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(10));
						ingredientList.get(10).num--;
						System.out.println("넣었어요.");
					}
					else {
						System.out.println("재고가 부족해요.");
					}
					
					break;
				default:
					Ingredient empty = new Ingredient("호호");
					makedHotwing.inputIngredient(empty);
					System.out.println("넣었어요.");
					break;
			}
				PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
				beep.start();
				
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("어떻게 조리 하시겠어요? \n1.오븐      2.화덕");
				 
				System.out.print("입력>>");
				input = scan.next();
				if(input.equals("1")) {
					makedHotwing.into_electro_oven();
				}else{
					makedHotwing.ovenType ="Classic";
				}
				//fire.run();
					reason = "저는 핫윙을 시켰는데 ";
				if(makedHotwing.outputIngredient().equals(hotWing.outputIngredient()) &&
						makedHotwing.ovenType.equals(hotWing.ovenType)) {
					makedHotwing.setSuccess(true);
				}
				if(!makedHotwing.outputIngredient().equals(hotWing.outputIngredient())){
					makedHotwing.setSuccess(false);
					reason +="재료가 이상해요.. ";
				}
				if(!makedHotwing.ovenType.equals(hotWing.ovenType)) {
					makedHotwing.setSuccess(false);
					reason += "화덕에 구우셨어요?..";
				}
				makedHotwing.setReason(reason);
				makedOrder.add(makedHotwing);
				fire.run();
				break;
				
			}
		}
		useIngredientList.clear();
		return ingredientExist;
		
	}
	
	public void orderCheck() {    //들어온 주문 확인
		System.out.print("만들어야 하는 메뉴 >>");
		for(Food food : order) {
			System.out.print(food.name+" ");
		}
		System.out.println();
	}
	
	public int put(int totalMoney) {    //메뉴제공.
		int money = totalMoney;
		int pay = 0;
		boolean allPass = true;
		for(Food food : makedOrder) {
			if(!food.success) {
				allPass = false;
				break;
			}
		}
		String checking = ">>>>>>>>>>>>>>손님이 확인중이에요";
		for(int i = 0 ; i<checking.length(); i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(checking.charAt(i));
		}
		/*
		PlaySounds playBeep = new PlaySounds("C:\\sounds/button.wav"); //만들었을 때 효과음
		if(allPass) {
			playBeep.setFileName("C:\\sounds/cash.wav");
			playBeep.start();
		}
		else {
			playBeep.setFileName("C:\\sounds/fail.wav");
			playBeep.start();
		}
		*/

		PlaySounds playCash = new PlaySounds("C:\\sounds/cash.wav");
		PlaySounds playFail = new PlaySounds("C:\\sounds/fail.wav");
		PlaySounds playYes = new PlaySounds("C:\\sounds/yes.wav");
		PlaySounds playNope = new PlaySounds("C:\\sounds/nope.wav");
		
		for(Food food : makedOrder) {
			switch(food.name) {
			case "오븐페페로니피자":
				if(food.success) {
					money += pizzaList.get(0).price;
					pay += pizzaList.get(0).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "오븐콤비네이션피자":
				if(food.success) {
					money += pizzaList.get(1).price;
					pay += pizzaList.get(1).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "오븐포테이토피자":
				if(food.success) {
					money += pizzaList.get(2).price;
					pay += pizzaList.get(2).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "오븐불고기피자":
				if(food.success) {
					money += pizzaList.get(3).price;
					pay += pizzaList.get(3).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "오븐고르곤졸라피자":
				if(food.success) {
					money += pizzaList.get(4).price;
					pay += pizzaList.get(4).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "화덕페페로니피자":
				if(food.success) {
					money += pizzaList.get(5).price;
					pay += pizzaList.get(5).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "화덕콤비네이션피자":
				if(food.success) {
					money += pizzaList.get(6).price;
					pay += pizzaList.get(6).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "화덕포테이토피자":
				if(food.success) {
					money += pizzaList.get(7).price;
					pay += pizzaList.get(7).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "화덕불고기피자":
				if(food.success) {
					money += pizzaList.get(8).price;
					pay += pizzaList.get(8).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "화덕고르곤졸라피자":
				if(food.success) {
					money += pizzaList.get(9).price;
					pay += pizzaList.get(9).price;
					Printing.printPizza();
					System.out.println(food.name+"가 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
			case "핫윙":
				if(food.success) {
					money += hotWing.price;
					pay += hotWing.price;
					Printing.printHotwing();
					System.out.println(food.name+"이 맛있어보여요");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("이 음식의 돈은 안내겠어요.");
					playFail.run();
					playNope.run();
				}
				break;
	
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		makedOrder.clear();
		System.out.println("총 "+ pay +"원 받았어요!");
		return money;
	}
	
	
}














