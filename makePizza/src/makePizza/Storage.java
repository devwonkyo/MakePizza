package makePizza;

import java.util.List;
import java.util.Scanner;

public class Storage extends Thread{
	List<Ingredient> ingredientList;
	Scanner scan = new Scanner(System.in);
	
	public void input_ingredient_list(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	public void printIngredientPrice() {
		int count = 1;
		for(Ingredient ingredient : ingredientList ) {
			System.out.println(count+"."+ingredient.getName() + "  --> 가격 : " + ingredient.price );
			count++;
		}
	}
	
	public int buyIngredient() {
		boolean run = true;
		int purchased_amount = 0;
		while(run) {
			System.out.println("================================================================");
			printIngredientPrice();
			System.out.println("================================================================");
			System.out.println();
			System.out.println("재료의 가격들이에요.");
			System.out.println();
			System.out.println("현재 구매한 금액은 "+purchased_amount+"원 이에요");
			System.out.println("구매할 재료의 번호를 입력해주세요. 구매를 종료하려면 'x'를 입력해주세요.");
			System.out.println();
			System.out.println("================================================================");
			int purchase_quantity = 0;
			System.out.print("입력>>");
			String input = scan.next();
			System.out.println();
			PlaySounds playBeep = new PlaySounds("C:\\sounds/button.wav");
			PlaySounds playBuy = new PlaySounds("C:\\sounds/cash.wav");
			playBeep.start();
			switch(input) {
			case "1"://꿀
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(0).buy(purchase_quantity);
					purchased_amount += 2000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(0).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "2"://도우
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(1).buy(purchase_quantity);
					purchased_amount += 2000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(1).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "3"://피망
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(2).buy(purchase_quantity);
					purchased_amount += 1000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(2).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "4"://치즈
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(3).buy(purchase_quantity);
					purchased_amount += 3000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(3).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "5"://버섯
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(4).buy(purchase_quantity);
					purchased_amount += 1000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(4).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "6"://올리브
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(5).buy(purchase_quantity);
					purchased_amount += 1000*purchase_quantity;
					System.out.println(ingredientList.get(5).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "7"://불고기
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(6).buy(purchase_quantity);
					purchased_amount += 3000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(6).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "8"://포테이토
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(7).buy(purchase_quantity);
					purchased_amount += 3000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(7).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "9"://페페로니
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(8).buy(purchase_quantity);
					purchased_amount += 2000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(8).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "10"://냉동날개
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(9).buy(purchase_quantity);
					purchased_amount += 3000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(9).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "11"://토마토소스
				System.out.println("구매할 수량을 입력해주세요. 구매를 취소하려면 '0'(숫자)을  눌러주세요");
				System.out.print("입력>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>구매를 취소했어요");
					playBeep.run();
				}else {
					ingredientList.get(10).buy(purchase_quantity);
					purchased_amount += 1000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(10).getName()+"을 "+purchase_quantity+"개 구입했습니다.");
					playBuy.run();
				}
				break;
			case "x":
				System.out.println(">>구매를 종료할게요.");
				System.out.println();
				run = false;
				break;
			default:
				System.out.println(">>잘못된 선택이에요. 다시 선택해주세요");
				System.out.println();
				break;
			}
		}
		return purchased_amount;
		
	}
	
	public void run() {
		while(true) {
			for(int i = 0 ; i<ingredientList.size(); i++) {
				if(ingredientList.get(i).num == 0) {
					new Warning();
					try {
						PlaySounds playerror = new PlaySounds("C:\\sounds/error.wav");
						playerror.start();
						sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
}
