package makePizza;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Warning extends JFrame {
	Container contentPane;

	public Warning() throws HeadlessException {
		setTitle("��� ���� ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		ImageIcon warning = new ImageIcon("C:\\images/warning.png");
		JLabel imageLabel = new JLabel(warning);
		JLabel textLabel = new JLabel("                       ������ ��ᰡ �־��! ��Ḧ �����ϼ���!");
		JButton exitButton  = new JButton("�ݱ�"); 
		
		//textLabel.setHorizontalAlignment();
		
		contentPane.add(imageLabel,BorderLayout.NORTH);
		contentPane.add(textLabel,BorderLayout.CENTER);
		contentPane.add(exitButton,BorderLayout.SOUTH);
		
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		setSize(400,400);
		setVisible(true);
	}
	
	
	
}
