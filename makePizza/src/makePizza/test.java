package makePizza;

public class test {
	String s;
	int sleepTime;
	
	
	public void printA() {
		s = "aaa";
		sleepTime = 10;
	}
	
	public void printB() {
		s = "bbb";
		sleepTime = 100;
	}
	
	public void printC() {
		s = "bbb";
		sleepTime = 1000;
	}
	
	public void run() {
		for(int i = 0 ; i < s.length() ; i++) {
			System.out.print(s.charAt(i));
			//sleep(sleepTime);
		}
		
	}
}
