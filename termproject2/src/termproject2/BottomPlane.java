package termproject2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPlane extends JPanel  {
	JButton button1 = new JButton("PLAY");
	
	
	
	
	public BottomPlane() { 
		
		button1 = new JButton("PLAY/PAUSE");
		
		button1.setFocusable(false);
		
		
		ActionListener buttonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o == button1) {
					boolean a = GamePlay.play;
					GamePlay.setplay(!a);
				}
				
				
			
			}
			
		
			
			};
		
		button1.addActionListener(buttonListener);
		
		
		this.add(button1);
		
		
		
		
	

	
	
	}
}