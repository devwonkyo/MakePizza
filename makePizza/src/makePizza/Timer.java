package makePizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Timer extends JFrame implements Runnable{
	Container contentPane;
	JLabel countNumber;
	CheckRun checkRun;
	
	public Timer() {
		/*
		setTitle("타이머");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JLabel countNumber = new JLabel("");
		countNumber.setFont(new Font("글씨",Font.BOLD,100));
		countNumber.setForeground(Color.red);
		contentPane.add(countNumber,BorderLayout.CENTER);
		setSize(400,400);
		
		setVisible(true);
		
		for(int i = 10; i>=0 ; i --) {
			countNumber.setText("      "+Integer.toString(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == 0) {
				dispose();
			}
		}*/
		
		
	}
	public void setCheckRun(CheckRun checkRun) {
		this.checkRun = checkRun;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		setTitle("타이머");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JLabel countNumber = new JLabel("");
		countNumber.setFont(new Font("글씨",Font.BOLD,100));
		countNumber.setForeground(Color.red);
		contentPane.add(countNumber,BorderLayout.CENTER);
		setSize(400,400);
		setVisible(true);
		PlaySounds playTimer = new PlaySounds("C:\\sounds/beep.wav");
		for(int i = 10; i>=0 ; i --) {
			if(i<5) {
				playTimer.run();
			}
			countNumber.setText("      "+Integer.toString(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!checkRun.isRun) { //run을 false로 만들면 타이머 종료 >>run은 음식 1개 만들기.
				countNumber.setText("");
				dispose();
				break;
			}
			if(i == 0) { //0초 되면 타이머 종료 후 run을 false로
				checkRun.setRun(false);
				countNumber.setText("");
				dispose();
			}
		}
	}
	 
}
