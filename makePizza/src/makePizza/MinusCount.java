package makePizza;

public class MinusCount extends Thread{
	Count count;

	public MinusCount(Count count) {
		super();
		this.count = count;
	}
	
	public void run() {
		while(true) {
			if(count.getCount()>=100 || count.getCount()<=0) {
				break;
			}
			try {
				sleep(100);
				count.setCount(count.getCount()-1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
