import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class StartPanel extends JPanel implements ActionListener {
	public JButton button1 = new JButton("Sākt"), button2 = new JButton("iziet");
	public StartPanel() {
		 JLabel label = new JLabel("TESTS");
		    
		 button1.setPreferredSize(new Dimension(140, 40));
		 button2.setPreferredSize(new Dimension(140, 40));
		 button1.addActionListener(this);
		 button2.addActionListener(this);
		    
		 label.setFont(new Font("SansSerif", Font.BOLD, 32));
		 GridBagLayout layout = new GridBagLayout();
	     GridBagConstraints gbc = new GridBagConstraints(); 
	        
		 setLayout(layout);
		 gbc.fill = GridBagConstraints.VERTICAL;  
		 gbc.gridx = 0;
		 gbc.gridy = 0;  
		 add(label, gbc);
		    
		 gbc.fill = GridBagConstraints.VERTICAL;  
		 gbc.gridx = 0;
		 gbc.gridy = 1;  
		 add(button1, gbc);
		    
		 gbc.fill = GridBagConstraints.VERTICAL;	    
		 gbc.gridx = 0;
		 gbc.gridy = 2;
		 add(button2, gbc);
		    
		 setBackground(Color.gray);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			Main.start = System.nanoTime();
			
			Main.showTest();
		}
		else {
			System.exit(0);
		}
	}
}
