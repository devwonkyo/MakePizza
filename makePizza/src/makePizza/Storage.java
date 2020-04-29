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
			System.out.println(count+"."+ingredient.getName() + "  --> ���� : " + ingredient.price );
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
			System.out.println("����� ���ݵ��̿���.");
			System.out.println();
			System.out.println("���� ������ �ݾ��� "+purchased_amount+"�� �̿���");
			System.out.println("������ ����� ��ȣ�� �Է����ּ���. ���Ÿ� �����Ϸ��� 'x'�� �Է����ּ���.");
			System.out.println();
			System.out.println("================================================================");
			int purchase_quantity = 0;
			System.out.print("�Է�>>");
			String input = scan.next();
			System.out.println();
			PlaySounds playBeep = new PlaySounds("C:\\sounds/button.wav");
			PlaySounds playBuy = new PlaySounds("C:\\sounds/cash.wav");
			playBeep.start();
			switch(input) {
			case "1"://��
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(0).buy(purchase_quantity);
					purchased_amount += 2000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(0).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "2"://����
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(1).buy(purchase_quantity);
					purchased_amount += 2000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(1).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "3"://�Ǹ�
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(2).buy(purchase_quantity);
					purchased_amount += 1000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(2).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "4"://ġ��
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(3).buy(purchase_quantity);
					purchased_amount += 3000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(3).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "5"://����
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(4).buy(purchase_quantity);
					purchased_amount += 1000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(4).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "6"://�ø���
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(5).buy(purchase_quantity);
					purchased_amount += 1000*purchase_quantity;
					System.out.println(ingredientList.get(5).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "7"://�Ұ��
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(6).buy(purchase_quantity);
					purchased_amount += 3000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(6).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "8"://��������
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(7).buy(purchase_quantity);
					purchased_amount += 3000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(7).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "9"://����δ�
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(8).buy(purchase_quantity);
					purchased_amount += 2000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(8).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "10"://�õ�����
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(9).buy(purchase_quantity);
					purchased_amount += 3000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(9).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "11"://�丶��ҽ�
				System.out.println("������ ������ �Է����ּ���. ���Ÿ� ����Ϸ��� '0'(����)��  �����ּ���");
				System.out.print("�Է�>>");
				purchase_quantity = scan.nextInt();
				System.out.println();
				if(purchase_quantity == 0) {
					System.out.println(">>���Ÿ� ����߾��");
					playBeep.run();
				}else {
					ingredientList.get(10).buy(purchase_quantity);
					purchased_amount += 1000*purchase_quantity;
					System.out.println(">>"+ingredientList.get(10).getName()+"�� "+purchase_quantity+"�� �����߽��ϴ�.");
					playBuy.run();
				}
				break;
			case "x":
				System.out.println(">>���Ÿ� �����ҰԿ�.");
				System.out.println();
				run = false;
				break;
			default:
				System.out.println(">>�߸��� �����̿���. �ٽ� �������ּ���");
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
