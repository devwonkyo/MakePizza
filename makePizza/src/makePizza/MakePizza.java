package makePizza;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MakePizza{
	final static int MAXINCOME  =  300000;
	static List<Ingredient> ingredientList = new ArrayList<Ingredient>();
	static List<List<Food>> orderList = new ArrayList<List<Food>>();
	static List<Integer> priceList = new ArrayList<Integer>();
	static List<Food> menuList = new ArrayList<Food>();
	static List<Pizza> pizzaList = new ArrayList<Pizza>();
	static Storage storage = new Storage();  //창고 선언
	static HotWing hotWing = new HotWing("핫윙");
	static CheckRun checkRun = new CheckRun();
	
	public static void main(String args[]) {
	
		Printing print = new Printing(ingredientList,orderList); //사용할 기능을 프린트 할 클래스
		Order order = new Order(orderList,menuList);             //주문서 클래스         
		Scanner scan = new Scanner(System.in);
		AppearBeak appearBeak = new AppearBeak(checkRun);
		boolean isRunning = true;
		String selectedMenu = null;
		int totalMoney = 100000;
		int orderCount = 1;
		boolean autoOrder = false;  //자동 주문 여부
		
	
		
		GameWithBeak game = new GameWithBeak();
		//game.startGame();
		print.printLogo(); //로고출력
		print.start();//설명서 thread로 출력 -->  쓰레드 2
		init();//설명서 출력하는 동시에 시작시 필요한 재료객체 초기화 -->메인
		appearBeak.start(); //2분후 백선생 출동 -->쓰레드 3
		storage.start();//재료 재고 검사 --> 쓰레드 4
		PlaySounds playNewMusic = new PlaySounds("C:\\sounds/music.wav");
		Order newOrder = new Order(orderList,menuList);
		PlaySounds playMusic = new PlaySounds("C:\\sounds/music.wav");   //배경음악 --> 쓰레드 5
		//멈추려면 playMusic.interrupt();
		
		playMusic.start();
		
		String skip = scan.nextLine();
		if(skip.equals("")) {// x키누르면 0.001초마다 글차출력
			print.setSleep(1); 
		}
		
		try {
			print.join(); //쓰레드 합류해야함.
		} catch (InterruptedException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("이름을 입력해주세요 :");
		System.out.print("입력>>");
		String name = scan.next();
		PlaySounds playApplause = new PlaySounds("C:\\sounds/applause.wav"); 
		playApplause.start();
		Cook cook = new Cook(name); //요리사 객체생성
		System.out.println(">>"+cook.name+"님께서 골목피자집을 오픈 했어요.!!");
		Printing.printMenu();
		String explain = ">>메뉴판이에요. 메뉴는 주문받기를 누르는 순간 자동으로 들어와요!";
		for(int i = 0; i<explain.length();i++) {
			System.out.print(explain.charAt(i));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		while(isRunning) { //게임 시작	
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(totalMoney <= 0 || totalMoney >= MAXINCOME) { //게임종료
				isRunning = false;
				break;
			}
			
			if(checkRun.isBeak) {
				selectedMenu = "6";
			}
			else {
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("================================================================");
				System.out.println("메뉴를 선택해주세요                                                                            ");
				System.out.println("                                                                                    현재 자금 : "+totalMoney+"원");
				System.out.println();
				System.out.println("1.주문리스트확인        2.주문받기        3.음식만들기        4.재료재고확인        5.재료사기");
				System.out.println();
				System.out.println("================================================================");
				System.out.print("입력>>");
				selectedMenu = scan.next();
				System.out.println();
				PlaySounds playBeep = new PlaySounds("C:\\sounds/button.wav"); 
				playBeep.start();
			}		
				switch(selectedMenu) {
				case "1"://주문 확인
					checkRun.setRun(true);
					print.setOrderList(orderList);//출력할 주문리스트 넣기.
					print.printOrderList();       //주문 리스트 출력	
					checkRun.setRun(false);
					break;
				
				case "2"://주문 받기 -- 가격계산
					checkRun.setRun(true);//자동주문 스레드
					if(order.isAlive()) {
						System.out.println(">>이미 자동주문 상태에요");
					}
					else {
						order.start(); //주문하고 , 주문리스트 전역객체에 넣기
						System.out.println(">>지금부터 30초마다 자동으로 주문이 들어올거에요. 주문이 들어올 때마다 종소리가 들려와요!");
					}
					checkRun.setRun(false);
					break;
				
				case "3"://음식 만들기    //재료 - , 주문서 -, 가격-
					checkRun.setRun(true);
					if(!orderList.isEmpty()) {
						cook.setOrder(orderList.get(0),pizzaList,hotWing,ingredientList); //1번째 주문서, 피자,핫윙객체,재료객체 넣어줌
						System.out.println();
						if(cook.makeFood()) {
							totalMoney = cook.put(totalMoney);//피자 내놓기.
							orderList.remove(0);//만든주문서 삭제
						}
						else {
							System.out.println(">>부족한 재료가 있어요. 재료의 재고를 확인하고 채워주세요.");
						}
					}
					else {
						System.out.println(">>현재 들어온 주문이 없어요.");
					}
					checkRun.setRun(false);
					break;
				
				case "4"://재료 재고 확인
					checkRun.setRun(true);
					System.out.println(">>재료를 확인해주세요");
					System.out.println();
					print.printIngredientList();
					checkRun.setRun(false);
					break;
				
				case "5"://재료사기  재료+ 자산 - 
					checkRun.setRun(true);
					boolean run = true;
					while(run) { 													//재료 사기 전 재고 확인.
						System.out.println("재료를 구매할 거에요.");	
						System.out.println("그 전에 재료의 수량을 확인하실래요?                   (yes/no)");
						System.out.print("입력>>");
						String input = scan.next();
						System.out.println();
						switch(input) {	
						case "yes":
							System.out.println(">>재료를 확인해주세요");
							print.printIngredientList();     //재료 재고 확인
							run = false;
							break;
						case "no":
							run = false;
							break;
						default:
							System.out.println(">>잘못 입력하셨네요.. 다시 입력해주세요.");
							break;
						}					
					}				
					System.out.println();
					System.out.println();
					totalMoney -= storage.buyIngredient();//재료 구매후 자산.		
					checkRun.setRun(false);
					break;
				
				case "6":
					playMusic.interrupt();//기존음악스레드 정지
					order.interrupt();//자동주문 정지
					PlaySounds playstep = new PlaySounds("C:\\sounds/step.wav");
					PlaySounds playdoor = new PlaySounds("C:\\sounds/door.wav");
					
					
					
					
					playstep.start();                   //발소리와 발자국그림
					for(int i = 0;i<4;i++) {
						if(i%2==0) {
							Printing.printFoot2();
						}
						else {
							Printing.printFoot1();
						}
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					playdoor.run();//문열리는 소리
					Printing.printBeak();
					System.out.println();
					System.out.println("백종원 : 불시검문 왔어유    놀랐쥬?"); //백종원 사진
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					PlaySounds playBeakmusic = new PlaySounds("C:\\sounds/beakmusic.wav"); //미니게임 배경음악
					playBeakmusic.start();
					GameWithBeak game2 = new GameWithBeak();
					Printing.printMiniGame();//게임설명
					scan.nextLine();
					if(scan.nextLine().equals("")) { //enter누르면 게임시작
						PlaySounds playbell = new PlaySounds("C:\\sounds/bell.wav");
						playbell.run();
						for(int i = 3; i>0; i--) {
							System.out.println(i+"초 후 게임이 시작될거에요\n");
							playbell.run();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					PlaySounds playgun = new PlaySounds("C:\\sounds/shotgun.wav");
					playgun.run();	
					game2.startGame();
					totalMoney += game2.getGold();
				
					playBeakmusic.interrupt();
					try {
						Thread.sleep(3500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					newOrder.start();//다시 자동주문 
					playNewMusic.start();//다시 배경음악
					checkRun.setBeak(false);//백종원 탈퇴
					}
					break;
				default:
					System.out.println(">>메뉴를 다시 선택해주세요");
					System.out.println();
					System.out.println();
					checkRun.setRun(false);
					break;
				}
			}
			
			
		
		
		if(totalMoney >= 300000) {    //장사 완료엔딩
			playNewMusic.interrupt();
			playMusic.interrupt();
			newOrder.interrupt();
			order.interrupt();
			System.out.println("축하해요. 오늘의 장사를 깔끔하게 끝냈어요.");
			System.out.println("오늘의 매출 : "+totalMoney+"원 이에요");
			System.out.println("게임을 종료할게요");
		}
		else {//장사 실패 엔딩
			totalMoney = 0;
			
			playNewMusic.interrupt();
			playMusic.interrupt();
			newOrder.interrupt();
			order.interrupt();
			System.out.println("현재 자금 : "+totalMoney+"원");
			System.out.println("자금이 바닥 났어요..");
			System.out.println("당신은 첫 장사부터 말아먹었어요.. 게임을 종료할게요..");
		}
	
		
	}//main 
	

	public static void init() {					//자료 초기화
		
		//재료 객체 초기화.
		/*
		Ingredient honey = new Ingredient("꿀",5,2000);
		Ingredient dough = new Ingredient("도우",5,2000);
		Ingredient pimento = new Ingredient("피망",5,1000);
		Ingredient cheeze = new Ingredient("치즈",5,3000);
		Ingredient mushroom = new Ingredient("버섯",5,1000);
		Ingredient olive = new Ingredient("올리브",5,1000);
		Ingredient bulgogi = new Ingredient("불고기",5,3000);
		Ingredient potato = new Ingredient("포테이토",5,3000);
		Ingredient peperoni = new Ingredient("페페로니",5,2000);
		Ingredient freezedWing = new Ingredient("냉동날개",3,3000);
		Ingredient tomatoSorce = new Ingredient("토마토소스",5,1000);
		*/
		Ingredient honey = new Ingredient("꿀",15,2000);
		Ingredient dough = new Ingredient("도우",15,2000);
		Ingredient pimento = new Ingredient("피망",15,1000);
		Ingredient cheeze = new Ingredient("치즈",15,3000);
		Ingredient mushroom = new Ingredient("버섯",15,1000);
		Ingredient olive = new Ingredient("올리브",15,1000);
		Ingredient bulgogi = new Ingredient("불고기",15,3000);
		Ingredient potato = new Ingredient("포테이토",15,3000);
		Ingredient peperoni = new Ingredient("페페로니",15,2000);
		Ingredient freezedWing = new Ingredient("냉동날개",13,3000);
		Ingredient tomatoSorce = new Ingredient("토마토소스",15,1000);
		
		ingredientList.add(honey);
		ingredientList.add(dough);
		ingredientList.add(pimento);
		ingredientList.add(cheeze);
		ingredientList.add(mushroom);
		ingredientList.add(olive);
		ingredientList.add(bulgogi);
		ingredientList.add(potato);
		ingredientList.add(peperoni);
		ingredientList.add(freezedWing);
		ingredientList.add(tomatoSorce);
		
		
		
		storage.input_ingredient_list(ingredientList);
		
		
		List<Ingredient> pepetopping = new ArrayList<Ingredient>();
		pepetopping.add(tomatoSorce);
		pepetopping.add(pimento);
		pepetopping.add(peperoni);
		pepetopping.add(cheeze);
		ElectroOvenPizza elecPeperoni = new ElectroOvenPizza("오븐페페로니피자",pepetopping,"Electro",15000);
		
		List<Ingredient> combitopping = new ArrayList<Ingredient>();
		combitopping.add(tomatoSorce);
		combitopping.add(pimento);
		combitopping.add(peperoni);
		combitopping.add(mushroom);
		combitopping.add(olive);
		combitopping.add(cheeze);
		ElectroOvenPizza elecCombination = new ElectroOvenPizza("오븐콤비네이션피자",combitopping,"Electro",16000);
		
		
		List<Ingredient> potatotopping = new ArrayList<Ingredient>();
		potatotopping.add(tomatoSorce);
		potatotopping.add(pimento);
		potatotopping.add(potato);
		potatotopping.add(cheeze);
		ElectroOvenPizza elecPotato = new ElectroOvenPizza("오븐포테이토피자",potatotopping,"Electro",15000);
		
		
		List<Ingredient> bulgogitopping = new ArrayList<Ingredient>();
		bulgogitopping.add(tomatoSorce);
		bulgogitopping.add(pimento);
		bulgogitopping.add(bulgogi);
		bulgogitopping.add(cheeze);
		ElectroOvenPizza elecBulgogi = new ElectroOvenPizza("오븐불고기피자",bulgogitopping,"Electro",16000);
		
		
		List<Ingredient> gortopping = new ArrayList<Ingredient>();	
		gortopping.add(cheeze);
		gortopping.add(honey);
		ElectroOvenPizza elecGorgon = new ElectroOvenPizza("오븐고르곤졸라피자",gortopping,"Electro",13000);
		
		
		
		
		ElectroOvenPizza classicPeperoni = new ElectroOvenPizza("화덕페페로니피자",pepetopping,"Classic",17000);
		
		ElectroOvenPizza classicCombination = new ElectroOvenPizza("화덕콤비네이션피자",combitopping,"Classic",18000);
		
		ElectroOvenPizza classicPotato = new ElectroOvenPizza("화덕포테이토피자",potatotopping,"Classic",17000);
		
		ElectroOvenPizza classicBulgogi = new ElectroOvenPizza("화덕불고기피자",bulgogitopping,"Classic",18000);
		
		ElectroOvenPizza classicGorgon = new ElectroOvenPizza("화덕고르곤졸라피자",gortopping,"Classic",15000);
		

		hotWing.name = "핫윙"; hotWing.freezedWing = freezedWing; hotWing.ovenType="Electro"; hotWing.price = 7000;
		
		menuList.add(elecPeperoni);
		menuList.add(elecCombination);
		menuList.add(elecPotato);
		menuList.add(elecBulgogi);
		menuList.add(elecGorgon);
		
		menuList.add(classicPeperoni);
		menuList.add(classicCombination);
		menuList.add(classicPotato);
		menuList.add(classicBulgogi);
		menuList.add(classicGorgon);
		menuList.add(hotWing);
		
		pizzaList.add(elecPeperoni);
		pizzaList.add(elecCombination);
		pizzaList.add(elecPotato);
		pizzaList.add(elecBulgogi);
		pizzaList.add(elecGorgon);
		
		pizzaList.add(classicPeperoni);
		pizzaList.add(classicCombination);
		pizzaList.add(classicPotato);
		pizzaList.add(classicBulgogi);
		pizzaList.add(classicGorgon);
		
	}


	
	
}
