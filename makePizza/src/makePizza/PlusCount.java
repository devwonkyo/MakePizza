package makePizza;

import java.util.Scanner;

public class PlusCount extends Thread{
	Count count;
	boolean isRunning = true;
	Scanner scan = new Scanner(System.in);

	public PlusCount(Count count) {
		super();
		this.count = count;
	}
	
	public void run() {
		while(isRunning) {
			if(count.getCount()>=105||count.getCount()<=0) {
				
				break;
			}
			if(scan.nextLine().equals("")) {
				count.setCount(count.getCount()+3);
			}
		}
	}
	
}


