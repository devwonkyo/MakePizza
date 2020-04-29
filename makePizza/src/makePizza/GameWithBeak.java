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
			if(count.getCount()>=100) {//�����ϰ� �ѹ� ����ϰ� ����
				Printing.clearScreen();
				System.out.print("��� >>>>     ");
				for(int i = 0 ; i <countArray.length; i++) {
					if(i<=count.getCount()) {
						countArray[i] = "��";
					}
					else {
						countArray[i] = "��";
					}
					System.out.print(countArray[i]);
				}
				//��׸�¾�����?
				System.out.print("     <<<<������  ");
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
				System.out.println("������ : ���ϳ�?");
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
				System.out.println(">>�����ؿ�!! �������԰��� �ҽð˹����� �ɸ��� �ʾ� ���� 10������ �޾Ҿ��!!");
				gold = 100000;
				break;
			}
			else if(count.getCount()<=0) {//�������� �ѹ� ����ϰ� ����
				Printing.clearScreen();
				System.out.print("��� >>>>     ");
				for(int i = 0 ; i <countArray.length; i++) {
					if(i<=count.getCount()) {
						countArray[i] = "��";
					}
					else {
						countArray[i] = "��";
					}
					System.out.print(countArray[i]);
				}
				System.out.print("     <<<<������  ");
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
				System.out.println(">>��Ÿ���׿�.. ���������� �ҽð˹���  ���Ͽ� ���� 10������ �ΰ����߾��..");
				gold = -100000;
				break;
			}else { //���� �������̱���
				Printing.clearScreen();
				System.out.print("��� >>>>     ");
				for(int i = 0 ; i <countArray.length; i++) {
					if(i<=count.getCount()) {
						countArray[i] = "��";
					}
					else {
						countArray[i] = "��";
					}
					System.out.print(countArray[i]);
				}
				System.out.print("     <<<<������  ");
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
