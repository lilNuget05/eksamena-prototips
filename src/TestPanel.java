import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.border.Border;

public class TestPanel extends JPanel implements ActionListener {
	
	public static JPanel topPanel = new JPanel(), desriptionPanel = new JPanel(), taskPanel = new JPanel(),enterPanel = new JPanel(), botPanel = new JPanel();
	//top panel components
	public static JLabel virsrakstsLabel = new JLabel("Virsraksts"), uzdLabel = new JLabel("0. uzdevums"), pointsLabel = new JLabel("1 Point ");
	//desription panel components
	public static JLabel descriptionLabel = new JLabel("Description about the the task you have to complete.");
	//submit panel components
	public JButton submitButton = new JButton("Atbildēt");
	//bot panel components
	public static JButton backButton = new JButton("   iepriekšējais   "), nextButton = new JButton("   nākamais   ");
	
	//type1
	public static JRadioButton[] radioArray;
	//type2
	public static JCheckBox[] boxArray;
	//type3
	public static JTextField field = new JTextField("");
	public static JLabel taskLabel = new JLabel("");
	
	
	public TestPanel() {
		//setBackground(Color.green);
		FlowLayout layout = (FlowLayout)getLayout();
		layout.setVgap(0);
		setLayout(layout);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		topPanel.setPreferredSize(new Dimension(580,50));
        topPanel.setBackground(Color.gray);
        topPanel.setBorder(blackline);
        addCompTop();
        add(topPanel);
        
        desriptionPanel.setPreferredSize(new Dimension(580,100));
        desriptionPanel.setBackground(Color.lightGray);
        addCompDesription();
        add(desriptionPanel);
        
        taskPanel.setPreferredSize(new Dimension(580,110));
        //taskPanel.setBackground(Color.blue);
        add(taskPanel);
        
        enterPanel.setPreferredSize(new Dimension(580,50));
        enterPanel.setBackground(Color.cyan);
        addCompSubmit();
        add(enterPanel);
        
        botPanel.setPreferredSize(new Dimension(580,50));
        botPanel.setBackground(Color.white);
        botPanel.setBorder(blackline);
        addCompBot();
        add(botPanel);
        
        
	}
	
	public void addCompTop() {
		topPanel.setLayout(new BorderLayout(20, 5));
		topPanel.add(virsrakstsLabel, BorderLayout.WEST);
		uzdLabel.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(uzdLabel, BorderLayout.CENTER);
		topPanel.add(pointsLabel, BorderLayout.EAST);
	}
	public void addCompDesription() {
		desriptionPanel.setLayout(new BorderLayout());
		desriptionPanel.add(descriptionLabel, BorderLayout.NORTH);
	}
	public void addCompSubmit() {
		enterPanel.setLayout(new BorderLayout());
		enterPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));
		submitButton.addActionListener(this);
		enterPanel.add(submitButton, BorderLayout.CENTER);
		
	}	
	public void addCompBot() {
		botPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		botPanel.setLayout(new BorderLayout());
		backButton.addActionListener(this);
		nextButton.addActionListener(this);
		botPanel.add(backButton, BorderLayout.WEST);
		botPanel.add(nextButton, BorderLayout.EAST);

	}
	
	public static void setTestById(LinkedList array) {
		// Iegūst pareizo testu
		for(Object el : array) {
			Test element = (Test) el;
			if (element.id == Main.currentId) {
				// saliek top paneli
				virsrakstsLabel.setText(element.virsraksts);
				uzdLabel.setText(Integer.toString(element.id)+". Uzdevums");
				// saliek desription paneli
				descriptionLabel.setText(element.apraksts);
				// saliek atbildes veidu 
				//not done
				if (element instanceof TestType1) {
					TestType1 item1 = (TestType1) element;
					taskPanel.removeAll();
					taskPanel.setLayout(new GridLayout(2,2));
					ButtonGroup bg =new ButtonGroup();
					radioArray = new JRadioButton[item1.varianti.length];
					for (int i=0;i<item1.varianti.length;i++) {
						radioArray[i] = new JRadioButton(item1.varianti[i]);
						if (item1.answer == i) {
							radioArray[i].setSelected(true);
						}
						bg.add(radioArray[i]);
						taskPanel.add(radioArray[i]);
					}
					
				}
				// done
				else if (element instanceof TestType2) {
					TestType2 item2 = (TestType2) element;
					taskPanel.removeAll();
					taskPanel.setLayout(new GridLayout(2,2));
					boxArray = new JCheckBox[item2.varianti.length];
					for (int i=0;i<item2.varianti.length;i++) {
						boxArray[i] = new JCheckBox(item2.varianti[i], item2.answers[i]);
						// metode kas add random seciba
						taskPanel.add(boxArray[i]);
					}
					
				}
				//done
				else {
					TestType3 item3 = (TestType3) element;
					taskPanel.removeAll();
					taskPanel.setLayout(new FlowLayout( FlowLayout.LEFT, 5,5));
					if (item3.text == null) {
						taskLabel.setText("");
					}
					else {
						taskLabel.setText(item3.text);
					}
					field.setColumns( 20 );
					field.setText(item3.answer);
					taskPanel.add(taskLabel);
					taskPanel.add(field);
				}
				
				// saliek pogam vajadzigo
				if(Main.currentId == 1) {
					backButton.setVisible(false);
					nextButton.setVisible(true);
				}
				else if(Main.currentId == array.size()) {
					backButton.setVisible(true);
					nextButton.setVisible(false);
				}
				else {
					backButton.setVisible(true);
					nextButton.setVisible(true);
				}
			}
		}
		
	}
	
	public void saveData() {
		for(Object element : Main.taskArray) {
			Test el = (Test) element;
			if(el.id == Main.currentId) {
				if(el instanceof TestType1) {
					for (int i=0;i<radioArray.length;i++) {
						if(radioArray[i].isSelected()) {
							((TestType1) element).answer = i;
						}
					}
				}
				if(el instanceof TestType2) {
					for (int i=0;i<((TestType2) element).answers.length;i++) {
						((TestType2) element).answers[i] = boxArray[i].isSelected();
					}
				}
				if(el instanceof TestType3) {
					((TestType3) element).answer = field.getText();
				}
				
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			if(Main.currentId == Main.taskArray.size()) {
				saveData();
				int izvele = JOptionPane.showConfirmDialog(null, "Pabeigt testu?", "Test", JOptionPane.OK_CANCEL_OPTION);
				if (izvele == 0) {
					
					Main.finish = System.nanoTime();
					Main.showEndResult();
				}
			}
			else {
				saveData();
				Main.currentId++;
				setTestById(Main.taskArray);
				this.repaint();
			}
		}
		else if(e.getSource() == backButton) {
			Main.currentId--;
			setTestById(Main.taskArray);
			this.repaint();
		}
		else if(e.getSource() == nextButton) {
			Main.currentId++;
			setTestById(Main.taskArray);
			this.repaint();
		}
	}
}
