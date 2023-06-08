import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.Border;

public class EndPanel extends JPanel implements ActionListener {
	public static JPanel topPanel = new JPanel(), midPanel = new JPanel(), botPanel = new JPanel();
	//toppanel
	public static JLabel t1 = new JLabel("Testa rezultāti"), t2 = new JLabel("procenti% pareizi"), t3 = new JLabel("laiks");
	//mid
	
	//bot panel
	public static JButton btn1 = new JButton("iziet"), btn2 = new JButton("atkārtot");
	public EndPanel() {
		FlowLayout layout = (FlowLayout)getLayout();
		layout.setVgap(0);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		topPanel.setPreferredSize(new Dimension(580,70));
        topPanel.setBackground(Color.gray);
        topPanel.setBorder(blackline);
        topPanel.setLayout(new BorderLayout(40, 0));
        addCompTop();
        add(topPanel);
        midPanel.setPreferredSize(new Dimension(580,230));
        midPanel.setBackground(Color.lightGray);
        addCompMid();
        add(midPanel);
        botPanel.setPreferredSize(new Dimension(580,60));
        botPanel.setBackground(Color.gray);
        botPanel.setBorder(blackline);
        addCompBot();
        add(botPanel);

	}

	private void addCompTop() {
		topPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		topPanel.add(t1, BorderLayout.WEST);
		t2.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(t2, BorderLayout.CENTER);
		topPanel.add(t3, BorderLayout.EAST);
	}
	
	private void addCompMid() {
		
		midPanel.setLayout(new FlowLayout(1, 100, 5));
		for(Object element : Main.taskArray) {
			Test el = (Test) element;
			if(el.correct) {
				JLabel text1 = new JLabel(el.virsraksts);
				
				midPanel.add(text1);
				JLabel text2 = new JLabel(el.id+".udz");
				midPanel.add(text2);
				JLabel text3 = new JLabel("pareizi  ");
				midPanel.add(text3);
			}
			else {
				JLabel text1 = new JLabel(el.virsraksts);
				midPanel.add(text1);
				JLabel text2 = new JLabel(el.id+".udz");
				midPanel.add(text2);
				JLabel text3 = new JLabel("nepareizi");
				midPanel.add(text3);
			}
			
		}
		
		
	}
	
	private void addCompBot() {
		botPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		botPanel.setLayout(new BorderLayout());
		btn1.addActionListener(this);
		
		botPanel.add(btn1, BorderLayout.WEST);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== btn1) {
			System.exit(0);
		}
		
			
	}
}
