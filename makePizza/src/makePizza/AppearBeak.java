package makePizza;

public class AppearBeak extends Thread {
	
	CheckRun checkRun; //메인쓰레드 진행상태
	
	AppearBeak(CheckRun checkRun){
		this.checkRun = checkRun;
	}
	
	public void setCheckRun(CheckRun checkRun) {
		this.checkRun = checkRun;
	}
	
	public void run() {
		for(int i = 0 ; i<120; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(true) {
			if(checkRun.isRun) { //메인쓰레드가 진행상태면 대기
				try {
					sleep(1);
					//System.out.println("메인쓰레드 진행중");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//continue;
			}
			else { //대기상태면 탈출
				checkRun.isBeak = true;
				//System.out.println("백쓰레드 활성화");
				break;
			}
		}
	}

}
