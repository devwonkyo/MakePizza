package makePizza;

public class AppearBeak extends Thread {
	
	CheckRun checkRun; //���ξ����� �������
	
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
			if(checkRun.isRun) { //���ξ����尡 ������¸� ���
				try {
					sleep(1);
					//System.out.println("���ξ����� ������");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//continue;
			}
			else { //�����¸� Ż��
				checkRun.isBeak = true;
				//System.out.println("�龲���� Ȱ��ȭ");
				break;
			}
		}
	}

}
