package makePizza;

public class GameWithBeak {
	Count count = new Count();
	String[] countArray = new String[100];
	boolean runningGame = true;
	int gold = 0;
	
	public int getGold() {
		return gold;
	}
	
	public void startGame() {
		PlusCount plusCount = new PlusCount(count);
		MinusCount minusCount = new MinusCount(count);
		
		plusCount.start();
		minusCount.start();
		while(runningGame) {
			if(count.getCount()>=100) {//시작하고 한번 출력하고 엔딩
				Printing.clearScreen();
				System.out.print("당신 >>>>     ");
				for(int i = 0 ; i <countArray.length; i++) {
					if(i<=count.getCount()) {
						countArray[i] = "■";
					}
					else {
						countArray[i] = "■";
					}
					System.out.print(countArray[i]);
				}
				//빈네모는어딧어요?
				System.out.print("     <<<<백종원  ");
				System.out.println();
				PlaySounds playgood = new PlaySounds("C:\\sounds/good.wav");
				PlaySounds playYes = new PlaySounds("C:\\sounds/yes.wav");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				playgood.start();
				Printing.printGood();
				System.out.println();
				System.out.println("백종원 : 잘하네?");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PlaySounds playcash = new PlaySounds("C:\\sounds/cash.wav");
				playcash.start();
				Printing.printMoney();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				playYes.run();
				System.out.println();
				System.out.println(">>축하해요!! 백종원님과의 불시검문에서 걸리지 않아 보상 10만원을 받았어요!!");
				gold = 100000;
				break;
			}
			else if(count.getCount()<=0) {//끝났을때 한번 출력하고 엔딩
				Printing.clearScreen();
				System.out.print("당신 >>>>     ");
				for(int i = 0 ; i <countArray.length; i++) {
					if(i<=count.getCount()) {
						countArray[i] = "□";
					}
					else {
						countArray[i] = "□";
					}
					System.out.print(countArray[i]);
				}
				System.out.print("     <<<<백종원  ");
				System.out.println();
				PlaySounds playfail = new PlaySounds("C:\\sounds/fail.wav");
				playfail.start();
				Printing.printFail();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PlaySounds playbaby = new PlaySounds("C:\\sounds/baby.wav");
				playbaby.run();
				
				System.out.println();
				System.out.println(">>안타깝네요.. 백종원님의 불시검문에  당하여 벌금 10만원을 부과당했어요..");
				gold = -100000;
				break;
			}else { //게임 실행중이구여
				Printing.clearScreen();
				System.out.print("당신 >>>>     ");
				for(int i = 0 ; i <countArray.length; i++) {
					if(i<=count.getCount()) {
						countArray[i] = "■";
					}
					else {
						countArray[i] = "□";
					}
					System.out.print(countArray[i]);
				}
				System.out.print("     <<<<백종원  ");
				System.out.println();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

}
