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
	
	 
	public Cook(String name) { //�丮�� �̸� ����
		this.name = name;
	}
	
	public void setOrder(List<Food> order,List<Pizza> pizzaList,HotWing hotWing,List<Ingredient> ingredientList) { //�ֹ��� ���
		this.order = order;
		this.pizzaList = pizzaList;
		this.hotWing = hotWing;
		this.ingredientList = ingredientList;
		useIngredientList.add(new Ingredient("��"));//0
		useIngredientList.add(new Ingredient("����"));//1
		useIngredientList.add(new Ingredient("�Ǹ�"));//2
		useIngredientList.add(new Ingredient("ġ��"));//3
		useIngredientList.add(new Ingredient("����"));//4
		useIngredientList.add(new Ingredient("�ø���"));//5
		useIngredientList.add(new Ingredient("�Ұ��"));//6
		useIngredientList.add(new Ingredient("��������"));//7
		useIngredientList.add(new Ingredient("����δ�"));//8
		useIngredientList.add(new Ingredient("�õ�����"));//9
		useIngredientList.add(new Ingredient("�丶��ҽ�"));//10	
	}


	public boolean makeFood() {    //���ĸ����
		boolean ingredientExist = true;
		for(Food food : order) {
			switch(food.name) {
				case "��������δ�����":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(8).num++;
					useIngredientList.get(3).num++;
					break;
				case "�����޺���̼�����":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(8).num++;
					useIngredientList.get(4).num++;
					useIngredientList.get(5).num++;
					useIngredientList.get(3).num++;
					break;
				case "����������������":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(7).num++;
					useIngredientList.get(3).num++;
					break;
				case "����Ұ������":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(6).num++;
					useIngredientList.get(3).num++;
					break;
				case "���������������":
					useIngredientList.get(1).num++;
					useIngredientList.get(3).num++;
					useIngredientList.get(0).num++;
					break;
				case "ȭ������δ�����":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(8).num++;
					useIngredientList.get(3).num++;
					break;
				case "ȭ���޺���̼�����":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(8).num++;
					useIngredientList.get(4).num++;
					useIngredientList.get(5).num++;
					useIngredientList.get(3).num++;
					break;
				case "ȭ��������������":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(7).num++;
					useIngredientList.get(3).num++;
					break;
				case "ȭ���Ұ������":
					useIngredientList.get(1).num++;
					useIngredientList.get(10).num++;
					useIngredientList.get(2).num++;
					useIngredientList.get(6).num++;
					useIngredientList.get(3).num++;
					break;
				case "ȭ��������������":
					useIngredientList.get(1).num++;
					useIngredientList.get(3).num++;
					useIngredientList.get(0).num++;
					break;
				case "����":
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
		CheckRun checkRun = new CheckRun();     //�����尣�� run , stop ����
		String input;
		System.out.println(">> 10�ʾȿ� �ʿ��� ������ ������� �Է����ּ���!!");
		System.out.println();
		orderCheck();//���� �ֹ�Ȯ��
		for(Food food : order) {
			checkRun.setRun(true);
			timer.setCheckRun(checkRun);
			PlaySounds fire = new PlaySounds("C:\\sounds/fire.wav");
			switch(food.name) {
			case "��������δ�����":
				ElectroOvenPizza makedElecPepe = new ElectroOvenPizza("��������δ�����");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("��������δ� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(0).outputTopping());
				System.out.println();
				Thread timerThread = new Thread(timer);
				timerThread.start();
				for(int i = 0 ; i < pizzaList.get(0).topping.size(); i++) { //����δ� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
						case "��":
							if(ingredientList.get(0).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(0));
								ingredientList.get(0).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							break;
						case "����":
							if(ingredientList.get(1).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(1));
								ingredientList.get(1).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						case "�Ǹ�":
							if(ingredientList.get(2).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(2));
								ingredientList.get(2).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						case "ġ��":
							if(ingredientList.get(3).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(3));
								ingredientList.get(3).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							break;
						case "����":
							if(ingredientList.get(4).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(4));
								ingredientList.get(4).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						case "�ø���":
							if(ingredientList.get(5).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(5));
								ingredientList.get(5).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						case "�Ұ��":
							if(ingredientList.get(6).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(6));
								ingredientList.get(6).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						case "��������":
							if(ingredientList.get(7).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(7));
								ingredientList.get(7).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						case "����δ�":
							if(ingredientList.get(8).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(8));
								ingredientList.get(8).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						case "�õ�����":
							if(ingredientList.get(9).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(9));
								ingredientList.get(9).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						case "�丶��ҽ�":
							if(ingredientList.get(10).num > 0)
							{
								makedElecPepe.inputTopping(ingredientList.get(10));
								ingredientList.get(10).num--;
								System.out.println("�־����.");
							}
							else {
								System.out.println("��� �����ؿ�.");
							}
							
							break;
						default:
							Ingredient empty = new Ingredient();
							makedElecPepe.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println(">>��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecPepe.into_electro_oven();
				}else{
					makedElecPepe.ovenType ="Classic";
				}
				
				String reason = "���� "+makedElecPepe.name+"�� ���״µ� ";
				if(makedElecPepe.outputTopping().equals(pizzaList.get(0).outputTopping()) &&
						makedElecPepe.ovenType.equals(pizzaList.get(0).ovenType)) {
					makedElecPepe.setSuccess(true);
				}
				if(!makedElecPepe.outputTopping().equals(pizzaList.get(0).outputTopping())){
					makedElecPepe.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedElecPepe.ovenType.equals(pizzaList.get(0).ovenType)) {
					makedElecPepe.setSuccess(false);
					reason += "�������ڰ� �ƴϿ���..";
				}
				makedElecPepe.setReason(reason);
				makedOrder.add(makedElecPepe);
				fire.run();
				break;
			case "�����޺���̼�����":
				ElectroOvenPizza makedElecCombi = new ElectroOvenPizza("�����޺���̼�����");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("�����޺���̼� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(1).outputTopping());  //���� �޺���̼� ���� ���� ���
				System.out.println();		
				Thread timerThread1 = new Thread(timer);
				timerThread1.start();
				for(int i = 0 ; i < pizzaList.get(1).topping.size(); i++) { //���� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedElecCombi.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedElecCombi.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println(">>��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				 
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecCombi.into_electro_oven();
				}else{
					makedElecCombi.ovenType ="Classic";
				}
				
					reason = "���� "+makedElecCombi.name+"�� ���״µ� ";
				if(makedElecCombi.outputTopping().equals(pizzaList.get(1).outputTopping()) &&
						makedElecCombi.ovenType.equals(pizzaList.get(1).ovenType)) {
					makedElecCombi.setSuccess(true);
				}
				if(!makedElecCombi.outputTopping().equals(pizzaList.get(1).outputTopping())){
					makedElecCombi.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedElecCombi.ovenType.equals(pizzaList.get(1).ovenType)) {
					makedElecCombi.setSuccess(false);
					reason += "�������ڰ� �ƴϿ���..";
				}
				makedElecCombi.setReason(reason);
				makedOrder.add(makedElecCombi);
				fire.run();
				break;
			case "����������������":
				ElectroOvenPizza makedElecPotato = new ElectroOvenPizza("����������������");      //������������ ��ü����
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("������������ ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(2).outputTopping());
				System.out.println();
				Thread timerThread2 = new Thread(timer);
				timerThread2.start();
				for(int i = 0 ; i < pizzaList.get(2).topping.size(); i++) { //���� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedElecPotato.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedElecPotato.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				 
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecPotato.into_electro_oven();
				}else{
					makedElecPotato.ovenType ="Classic";
				}
					reason = "���� "+makedElecPotato.name+"�� ���״µ� ";
				if(makedElecPotato.outputTopping().equals(pizzaList.get(2).outputTopping()) &&
						makedElecPotato.ovenType.equals(pizzaList.get(2).ovenType)) {
					makedElecPotato.setSuccess(true);
				}
				if(!makedElecPotato.outputTopping().equals(pizzaList.get(2).outputTopping())){
					makedElecPotato.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedElecPotato.ovenType.equals(pizzaList.get(2).ovenType)) {
					makedElecPotato.setSuccess(false);
					reason += "�������ڰ� �ƴϿ���..";
				}
				makedElecPotato.setReason(reason);
				makedOrder.add(makedElecPotato);
				fire.run();
				break;
			case "����Ұ������":
				ElectroOvenPizza makedElecBulgogi = new ElectroOvenPizza("����Ұ������");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("����Ұ�� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(3).outputTopping());
				System.out.println();
				Thread timerThread3 = new Thread(timer);
				timerThread3.start();
				for(int i = 0 ; i < pizzaList.get(3).topping.size(); i++) { //���� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedElecBulgogi.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedElecBulgogi.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				 
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecBulgogi.into_electro_oven();
				}else{
					makedElecBulgogi.ovenType ="Classic";
				}
				//fire.run();
					reason = "���� "+makedElecBulgogi.name+"�� ���״µ� ";
				if(makedElecBulgogi.outputTopping().equals(pizzaList.get(3).outputTopping()) &&
						makedElecBulgogi.ovenType.equals(pizzaList.get(3).ovenType)) {
					makedElecBulgogi.setSuccess(true);
				}
				if(!makedElecBulgogi.outputTopping().equals(pizzaList.get(3).outputTopping())){
					makedElecBulgogi.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedElecBulgogi.ovenType.equals(pizzaList.get(3).ovenType)) {
					makedElecBulgogi.setSuccess(false);
					reason += "�������ڰ� �ƴϿ���..";
				}
				makedElecBulgogi.setReason(reason);
				makedOrder.add(makedElecBulgogi);
				fire.run();
				break;
			case "���������������":
				ElectroOvenPizza makedElecGor = new ElectroOvenPizza("���������������");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("����������� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(4).outputTopping());
				System.out.println();
				Thread timerThread4 = new Thread(timer);
				timerThread4.start();
				for(int i = 0 ; i < pizzaList.get(4).topping.size(); i++) { //���� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedElecGor.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedElecGor.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				 
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("1")) {
					makedElecGor.into_electro_oven();
				}else{
					makedElecGor.ovenType ="Classic";
				}
				//fire.run();
					reason = "���� "+makedElecGor.name+"�� ���״µ� ";
				if(makedElecGor.outputTopping().equals(pizzaList.get(4).outputTopping()) &&
						makedElecGor.ovenType.equals(pizzaList.get(4).ovenType)) {
					makedElecGor.setSuccess(true);
				}
				if(!makedElecGor.outputTopping().equals(pizzaList.get(4).outputTopping())){
					makedElecGor.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedElecGor.ovenType.equals(pizzaList.get(4).ovenType)) {
					makedElecGor.setSuccess(false);
					reason += "�������ڰ� �ƴϿ���..";
				}
				makedElecGor.setReason(reason);
				makedOrder.add(makedElecGor);
				fire.run();
				break;
			case "ȭ������δ�����":
				ClassicOvenPizza makedClassicPepe = new ClassicOvenPizza("ȭ������δ�����");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("ȭ������δ� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(5).outputTopping());
				System.out.println();
				Thread timerThread5 = new Thread(timer);
				timerThread5.start();
				for(int i = 0 ; i < pizzaList.get(5).topping.size(); i++) { //ȭ�� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicPepe.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicPepe.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicPepe.into_classic_oven();
				}else{
					makedClassicPepe.ovenType ="Electro";
				}
				//fire.run();
					reason = "���� "+makedClassicPepe.name+"�� ���״µ� ";
				if(makedClassicPepe.outputTopping().equals(pizzaList.get(5).outputTopping()) &&
						makedClassicPepe.ovenType.equals(pizzaList.get(5).ovenType)) {
					makedClassicPepe.setSuccess(true);
				}
				if(!makedClassicPepe.outputTopping().equals(pizzaList.get(5).outputTopping())){
					makedClassicPepe.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedClassicPepe.ovenType.equals(pizzaList.get(5).ovenType)) {
					makedClassicPepe.setSuccess(false);
					reason += "ȭ�����ڰ� �ƴϿ���..";
				}
				makedClassicPepe.setReason(reason);
				makedOrder.add(makedClassicPepe);
				fire.run();
				break;
			case "ȭ���޺���̼�����":
				ClassicOvenPizza makedClassicCombi = new ClassicOvenPizza("ȭ���޺���̼�����");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("ȭ���޺���̼� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(6).outputTopping());
				System.out.println();
				Thread timerThread6 = new Thread(timer);
				timerThread6.start();
				for(int i = 0 ; i < pizzaList.get(6).topping.size(); i++) { //ȭ�� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicCombi.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicCombi.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicCombi.into_classic_oven();
				}else{
					makedClassicCombi.ovenType ="Electro";
				}
				//fire.run();
					reason = "���� "+makedClassicCombi.name+"�� ���״µ� ";
				if(makedClassicCombi.outputTopping().equals(pizzaList.get(6).outputTopping()) &&
						makedClassicCombi.ovenType.equals(pizzaList.get(6).ovenType)) {
					makedClassicCombi.setSuccess(true);
				}
				if(!makedClassicCombi.outputTopping().equals(pizzaList.get(6).outputTopping())){
					makedClassicCombi.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedClassicCombi.ovenType.equals(pizzaList.get(6).ovenType)) {
					makedClassicCombi.setSuccess(false);
					reason += "ȭ�����ڰ� �ƴϿ���..";
				}
				makedClassicCombi.setReason(reason);
				makedOrder.add(makedClassicCombi);
				fire.run();
				break;
			case "ȭ��������������":
				ClassicOvenPizza makedClassicPotato = new ClassicOvenPizza("ȭ��������������");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("ȭ���������� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(7).outputTopping());
				System.out.println();
				Thread timerThread7 = new Thread(timer);
				timerThread7.start();
				for(int i = 0 ; i < pizzaList.get(7).topping.size(); i++) { //ȭ�� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicPotato.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicPotato.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				 
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicPotato.into_classic_oven();
				}else{
					makedClassicPotato.ovenType ="Electro";
				}
				//fire.run();
					reason = "���� "+makedClassicPotato.name+"�� ���״µ� ";
				if(makedClassicPotato.outputTopping().equals(pizzaList.get(7).outputTopping()) &&
						makedClassicPotato.ovenType.equals(pizzaList.get(7).ovenType)) {
					makedClassicPotato.setSuccess(true);
				}
				if(!makedClassicPotato.outputTopping().equals(pizzaList.get(7).outputTopping())){
					makedClassicPotato.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedClassicPotato.ovenType.equals(pizzaList.get(7).ovenType)) {
					makedClassicPotato.setSuccess(false);
					reason += "ȭ�����ڰ� �ƴϿ���..";
				}
				makedClassicPotato.setReason(reason);
				makedOrder.add(makedClassicPotato);
				fire.run();
				break;
			case "ȭ���Ұ������":
				ClassicOvenPizza makedClassicBulgogi = new ClassicOvenPizza("ȭ���Ұ������");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("ȭ���Ұ�� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(8).outputTopping());
				System.out.println();
				Thread timerThread8 = new Thread(timer);
				timerThread8.start();
				for(int i = 0 ; i < pizzaList.get(8).topping.size(); i++) { //ȭ�� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicBulgogi.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicBulgogi.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				 
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicBulgogi.into_classic_oven();
				}else{
					makedClassicBulgogi.ovenType ="Electro";
				}
				//fire.run();
					reason = "���� "+makedClassicBulgogi.name+"�� ���״µ� ";
				if(makedClassicBulgogi.outputTopping().equals(pizzaList.get(8).outputTopping()) &&
						makedClassicBulgogi.ovenType.equals(pizzaList.get(8).ovenType)) {
					makedClassicBulgogi.setSuccess(true);
				}
				if(!makedClassicBulgogi.outputTopping().equals(pizzaList.get(8).outputTopping())){
					makedClassicBulgogi.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedClassicBulgogi.ovenType.equals(pizzaList.get(8).ovenType)) {
					makedClassicBulgogi.setSuccess(false);
					reason += "ȭ�����ڰ� �ƴϿ���..";
				}
				makedClassicBulgogi.setReason(reason);
				makedOrder.add(makedClassicBulgogi);
				fire.run();
				break;
			case "ȭ��������������":
				ClassicOvenPizza makedClassicGor = new ClassicOvenPizza("ȭ��������������");
				ingredientList.get(1).num--;
				System.out.println();
				System.out.println("ȭ���������� ���ڸ� ����ſ���");
				System.out.println("�ʿ��� ���� >> "+pizzaList.get(9).outputTopping());
				System.out.println();
				Thread timerThread9 = new Thread(timer);
				timerThread9.start();
				for(int i = 0 ; i < pizzaList.get(9).topping.size(); i++) { //ȭ�� ���� ���θ���Ʈ��ŭ �Է�
					System.out.print("�Է�>>");
					input = scan.next();
					if(!checkRun.isRun) {
						System.out.println(">>��Ḧ ���� �ð��� �������");
						break;
					}
					switch(input) {
					case "��":
						if(ingredientList.get(0).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(0));
							ingredientList.get(0).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(1).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(1));
							ingredientList.get(1).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ǹ�":
						if(ingredientList.get(2).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(2));
							ingredientList.get(2).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "ġ��":
						if(ingredientList.get(3).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(3));
							ingredientList.get(3).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						break;
					case "����":
						if(ingredientList.get(4).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(4));
							ingredientList.get(4).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�ø���":
						if(ingredientList.get(5).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(5));
							ingredientList.get(5).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�Ұ��":
						if(ingredientList.get(6).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(6));
							ingredientList.get(6).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "��������":
						if(ingredientList.get(7).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(7));
							ingredientList.get(7).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "����δ�":
						if(ingredientList.get(8).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(8));
							ingredientList.get(8).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�õ�����":
						if(ingredientList.get(9).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(9));
							ingredientList.get(9).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
					case "�丶��ҽ�":
						if(ingredientList.get(10).num > 0)
						{
							makedClassicGor.inputTopping(ingredientList.get(10));
							ingredientList.get(10).num--;
							System.out.println("�־����.");
						}
						else {
							System.out.println("��� �����ؿ�.");
						}
						
						break;
						default:
							Ingredient empty = new Ingredient();
							makedClassicGor.inputTopping(empty);
							System.out.println("�־����.");
							break;
					}
					PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
					beep.start();
				}
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				 
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("2")) {
					makedClassicGor.into_classic_oven();
				}else{
					makedClassicGor.ovenType = "Electro";
				}
				//fire.run();
					reason = "���� "+makedClassicGor.name+"�� ���״µ� ";
				if(makedClassicGor.outputTopping().equals(pizzaList.get(9).outputTopping()) &&
						makedClassicGor.ovenType.equals(pizzaList.get(9).ovenType)) {
					makedClassicGor.setSuccess(true);
				}
				if(!makedClassicGor.outputTopping().equals(pizzaList.get(9).outputTopping())){
					makedClassicGor.setSuccess(false);
					reason +="���� ������ �̻��ؿ�.. ";
				}
				if(!makedClassicGor.ovenType.equals(pizzaList.get(9).ovenType)) {
					makedClassicGor.setSuccess(false);
					reason += "ȭ�����ڰ� �ƴϿ���..";
				}
				makedClassicGor.setReason(reason);
				makedOrder.add(makedClassicGor);
				fire.run();
				break;
			case "����":
				HotWing makedHotwing = new HotWing("����");
				Thread timerThread10 = new Thread(timer);
				timerThread10.start();
				System.out.println();
				System.out.println("������ ����ſ���");
				System.out.println("�ʿ��� ���� >> �õ�����");
				System.out.println();
				System.out.print("�Է�>>");
				input = scan.next();
				if(!checkRun.isRun) {
					System.out.println(">>��Ḧ ���� �ð��� �������");
					break;
				}
				switch(input) {
				case "��":
					if(ingredientList.get(0).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(0));
						ingredientList.get(0).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					break;
				case "����":
					if(ingredientList.get(1).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(1));
						ingredientList.get(1).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				case "�Ǹ�":
					if(ingredientList.get(2).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(2));
						ingredientList.get(2).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				case "ġ��":
					if(ingredientList.get(3).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(3));
						ingredientList.get(3).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					break;
				case "����":
					if(ingredientList.get(4).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(4));
						ingredientList.get(4).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				case "�ø���":
					if(ingredientList.get(5).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(5));
						ingredientList.get(5).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				case "�Ұ��":
					if(ingredientList.get(6).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(6));
						ingredientList.get(6).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				case "��������":
					if(ingredientList.get(7).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(7));
						ingredientList.get(7).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				case "����δ�":
					if(ingredientList.get(8).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(8));
						ingredientList.get(8).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				case "�õ�����":
					if(ingredientList.get(9).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(9));
						ingredientList.get(9).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				case "�丶��ҽ�":
					if(ingredientList.get(10).num > 0)
					{
						makedHotwing.inputIngredient(ingredientList.get(10));
						ingredientList.get(10).num--;
						System.out.println("�־����.");
					}
					else {
						System.out.println("��� �����ؿ�.");
					}
					
					break;
				default:
					Ingredient empty = new Ingredient("ȣȣ");
					makedHotwing.inputIngredient(empty);
					System.out.println("�־����.");
					break;
			}
				PlaySounds beep = new PlaySounds("C:\\sounds/button.wav");
				beep.start();
				
				checkRun.setRun(false);
				timer.setCheckRun(checkRun);
				System.out.println();
				System.out.println("��� ���� �Ͻðھ��? \n1.����      2.ȭ��");
				 
				System.out.print("�Է�>>");
				input = scan.next();
				if(input.equals("1")) {
					makedHotwing.into_electro_oven();
				}else{
					makedHotwing.ovenType ="Classic";
				}
				//fire.run();
					reason = "���� ������ ���״µ� ";
				if(makedHotwing.outputIngredient().equals(hotWing.outputIngredient()) &&
						makedHotwing.ovenType.equals(hotWing.ovenType)) {
					makedHotwing.setSuccess(true);
				}
				if(!makedHotwing.outputIngredient().equals(hotWing.outputIngredient())){
					makedHotwing.setSuccess(false);
					reason +="��ᰡ �̻��ؿ�.. ";
				}
				if(!makedHotwing.ovenType.equals(hotWing.ovenType)) {
					makedHotwing.setSuccess(false);
					reason += "ȭ���� ����̾��?..";
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
	
	public void orderCheck() {    //���� �ֹ� Ȯ��
		System.out.print("������ �ϴ� �޴� >>");
		for(Food food : order) {
			System.out.print(food.name+" ");
		}
		System.out.println();
	}
	
	public int put(int totalMoney) {    //�޴�����.
		int money = totalMoney;
		int pay = 0;
		boolean allPass = true;
		for(Food food : makedOrder) {
			if(!food.success) {
				allPass = false;
				break;
			}
		}
		String checking = ">>>>>>>>>>>>>>�մ��� Ȯ�����̿���";
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
		PlaySounds playBeep = new PlaySounds("C:\\sounds/button.wav"); //������� �� ȿ����
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
			case "��������δ�����":
				if(food.success) {
					money += pizzaList.get(0).price;
					pay += pizzaList.get(0).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "�����޺���̼�����":
				if(food.success) {
					money += pizzaList.get(1).price;
					pay += pizzaList.get(1).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "����������������":
				if(food.success) {
					money += pizzaList.get(2).price;
					pay += pizzaList.get(2).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "����Ұ������":
				if(food.success) {
					money += pizzaList.get(3).price;
					pay += pizzaList.get(3).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "���������������":
				if(food.success) {
					money += pizzaList.get(4).price;
					pay += pizzaList.get(4).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "ȭ������δ�����":
				if(food.success) {
					money += pizzaList.get(5).price;
					pay += pizzaList.get(5).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "ȭ���޺���̼�����":
				if(food.success) {
					money += pizzaList.get(6).price;
					pay += pizzaList.get(6).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "ȭ��������������":
				if(food.success) {
					money += pizzaList.get(7).price;
					pay += pizzaList.get(7).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "ȭ���Ұ������":
				if(food.success) {
					money += pizzaList.get(8).price;
					pay += pizzaList.get(8).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "ȭ��������������":
				if(food.success) {
					money += pizzaList.get(9).price;
					pay += pizzaList.get(9).price;
					Printing.printPizza();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
					playFail.run();
					playNope.run();
				}
				break;
			case "����":
				if(food.success) {
					money += hotWing.price;
					pay += hotWing.price;
					Printing.printHotwing();
					System.out.println(food.name+"�� ���־����");
					playCash.run();
					playYes.run();
				}else {
					Printing.printFail();
					System.out.println(food.reason);
					System.out.println("�� ������ ���� �ȳ��ھ��.");
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
		System.out.println("�� "+ pay +"�� �޾Ҿ��!");
		return money;
	}
	
	
}














