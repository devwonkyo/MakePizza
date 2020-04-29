package makePizza;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlaySounds extends Thread {
	
	String fileName;
	boolean stop = false;
	Clip clip;
	
	
	
	public PlaySounds(String fileName) {
		super();
		this.fileName = fileName;
		
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		
	}

	public void run() {
		try {
			if(fileName.equals("C:\\sounds/music.wav")||fileName.equals("C:\\sounds/beakmusic.wav")) {
				AudioInputStream sound = AudioSystem.getAudioInputStream(new File(fileName));
				Clip clip = AudioSystem.getClip();
				clip.stop();
				clip.open(sound);
		        clip.start();
		        clip.loop(-1);
		        while(true) {
		        	try {
						sleep(1000);
					} catch (InterruptedException e) {
						clip.stop();
						return;
					}
		        	
		        	
		        }
			}
			else if(fileName.equals("C:\\sounds/applause.wav")||fileName.equals("C:\\sounds/door.wav")||fileName.equals("C:\\sounds/step.wav")
					||fileName.equals("C:\\sounds/good.wav")||fileName.equals("C:\\sounds/error.wav")) {
				AudioInputStream sound = AudioSystem.getAudioInputStream(new File(fileName));
				Clip clip = AudioSystem.getClip();
				clip.stop();
				clip.open(sound);
		        clip.start();
		        for(int i = 0 ; i < 1 ; i++) {
		        	try {
						sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	clip.stop();
		        }
			}
			else if(fileName.equals("C:\\sounds/bell.wav")||fileName.equals("C:\\sounds/shotgun.wav")
					||fileName.equals("C:\\sounds/dingdong.wav")||fileName.equals("C:\\sounds/beep.wav")
					||fileName.equals("C:\\sounds/yes.wav")||fileName.equals("C:\\sounds/baby.wav")||fileName.equals("C:\\sounds/nope.wav")) {
				AudioInputStream sound = AudioSystem.getAudioInputStream(new File(fileName));
				Clip clip = AudioSystem.getClip();
				clip.open(sound);
		        clip.start();
		        
			}
			else {
				AudioInputStream sound = AudioSystem.getAudioInputStream(new File(fileName));
				Clip clip = AudioSystem.getClip();
				clip.stop();
				clip.open(sound);
		        clip.start();
		        for(int i = 0 ; i < 1 ; i++) {
		        	try {
						sleep(700);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	clip.stop();
		        }
			}
			
	  
			
            
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	
}
