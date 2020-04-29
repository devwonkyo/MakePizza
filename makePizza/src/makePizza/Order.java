package makePizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Order extends Thread {
	//List<List<Food>> orderList = new ArrayList<List<Food>>();
	List<List<Food>> orderList;
	List<Food> menuList;
	Random random = new Random();
	int menu;
	Scanner scan = new Scanner(System.in);
	boolean autoOrder = true;
	
	public Order(List<List<Food>> orderList,List<Food> menuList) {
		this.orderList = orderList;
		this.menuList = menuList;
	}
	
	public void setAutoOrder(boolean autoOrder) {
		this.autoOrder = autoOrder;
	}
	
	/*
	public List<List<Food>> inputOrder(List<Food> menuList) {
		price = 0;
		List<Food> order = new ArrayList<Food>();
		boolean run = true;
		
		while(run) {
			if(price == 0) {
				System.out.println("현재 선택한 메뉴가 없어요. 총 가격은 "+ price + "원 이에요.");
			}else {
				String orderMenu = "";
				for(Food food : order) {
					orderMenu += food.name+" ";
				}
				System.out.println("현재 선택한 메뉴는 "+orderMenu+"에요. 총 가격은 "+ price + "원 이에요");
			}
			System.out.println();
			System.out.println("주문할 메뉴의 번호를 입력해주세요.    주문을 그만하려면 'x'를 눌러주세요.");
			
			
			switch(scan.next()) {
			case "1":
				order.add(menuList.get(0));
				price += 15000;
				break;
			case "2":
				order.add(menuList.get(1));
				price += 16000;
				break;
			case "3":
				order.add(menuList.get(2));
				price += 15000;
				break;
			case "4":
				order.add(menuList.get(3));
				price += 16000;
				break;
			case "5":
				order.add(menuList.get(4));
				price += 13000;
				break;
			case "6":
				order.add(menuList.get(5));
				price += 18000;
				break;
			case "7":
				order.add(menuList.get(6));
				price += 19000;
				break;
			case "8":
				order.add(menuList.get(7));
				price += 18000;
				break;
			case "9":
				order.add(menuList.get(8));
				price += 19000;
				break;
			case "10":
				order.add(menuList.get(9));
				price += 16000;
				break;
			case "0":
				order.add(menuList.get(10));
				price += 7000;
				break;
			case "x":
				System.out.println("주문을 종료할게요");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요");
			}
		}
		System.out.println();
		
		if(!order.isEmpty()) { //주문들어왔을 때만 주문서에 넣기.
			orderList.add(order);
			System.out.println("주문이 들어왔어요! 주문 리스트를 확인해주세요! 안하셔도 되구요!");	
		}else {
			System.out.println("다음에 다시 주문해주세요!");	
		}
		System.out.println();
		
		return orderList;
	}
	*/
	public void autoOrder() {
		List<Food> order = new ArrayList<Food>();
		
		for(int i = 0 ; i < random.nextInt(3)+1 ;i++) {  //random.nextInt(3)+1 1~3회 주문
			menu = random.nextInt(11);		
			switch(menu) {
			case 1:
				order.add(menuList.get(0));
				break;
			case 2:
				order.add(menuList.get(1));
				break;
			case 3:
				order.add(menuList.get(2));
				break;
			case 4:
				order.add(menuList.get(3));
				break;
			case 5:
				order.add(menuList.get(4));
				break;
			case 6:
				order.add(menuList.get(5));
				break;
			case 7:
				order.add(menuList.get(6));
				break;
			case 8:
				order.add(menuList.get(7));
				break;
			case 9:
				order.add(menuList.get(8));
				break;
			case 10:
				order.add(menuList.get(9));
				break;
			case 0:
				order.add(menuList.get(10));
				break;		
			}
		
		}	
		orderList.add(order); //주문서에 주문넣기.
		PlaySounds playdingdong = new PlaySounds("C:\\sounds/dingdong.wav");
		playdingdong.run();	
	}
	
	public void run() {
		while(autoOrder) {
			this.autoOrder();
			for(int i = 0 ; i < 20 ; i++) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					autoOrder = false;
					break;
				}
			}			
		}
	}
	
	
	
}
