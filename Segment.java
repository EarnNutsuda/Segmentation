import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Segment extends JPanel implements ActionListener  {

int[] bSize = {1,4,3,5,5};
int[] pSize = {3,5,1,1,1};
	JPanel W = new JPanel();
	JPanel panelm = new JPanel(new GridLayout(6,1));
	JPanel panel = new JPanel(new GridLayout(1,2));
	JPanel panel2 = new JPanel(new GridLayout(2,1));
	JPanel List1 = new JPanel(new GridLayout(5,4));
	JPanel List2 = new JPanel(new GridLayout(5,4));
	JPanel List3 = new JPanel(new GridLayout(3,1));
	block blockObj = new block(bSize);
	Process processObj = new Process(pSize,blockObj);
	
	JLabel mainL1 = new JLabel("Input Block Size (kb)");
	JLabel lb0 = new JLabel("Block B0");
	JLabel lb1 = new JLabel("Block B1");
	JLabel lb2 = new JLabel("Block B2");
	JLabel lb3 = new JLabel("Block B3");
	JLabel lb4 = new JLabel("Block B4");
	JTextField tb0 = new JTextField("1");
	JTextField tb1 = new JTextField("4");
	JTextField tb2 = new JTextField("3");
	JTextField tb3 = new JTextField("5");
	JTextField tb4 = new JTextField("5");
	
	JLabel mainL2 = new JLabel("Input Process Size (kb)");
	JLabel lp0 = new JLabel("Process P0");
	JLabel lp1 = new JLabel("Process P1");
	JLabel lp2 = new JLabel("Process P2");
	JLabel lp3 = new JLabel("Process P3");
	JLabel lp4 = new JLabel("Process P4");
	JTextField tp0 = new JTextField("3");
	JTextField tp1 = new JTextField("5");
	JTextField tp2 = new JTextField("1");
	JTextField tp3 = new JTextField("1");
	JTextField tp4 = new JTextField("1");
	
	JButton f1 = new JButton("First-Fit");
	JButton f2 = new JButton("Best-Fit");
	JButton f3 = new JButton("Worst-Fit");
	
	JLabel mainLabel1 = new JLabel("Input process size and avaliable memory portion ",JLabel.CENTER);
	JLabel mainLabel11 = new JLabel("input 0 if there is no process",JLabel.CENTER);
	JLabel mainLabel2 = new JLabel("Allocation Strategies",JLabel.CENTER);
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.setBackground(Color.lightGray);
}


	Segment(){
		blockObj.blockLocation(600,40);
		processObj.processLocation(600,40);

		super.setLayout(new GridLayout(1,2));
		List1.add(lb0);
		List1.add(tb0);
		List1.add(lb1);
		List1.add(tb1);
		List1.add(lb2);
		List1.add(tb2);
		List1.add(lb3);
		List1.add(tb3);
		List1.add(lb4);
		List1.add(tb4);
	
		List2.add(lp0);
		List2.add(tp0);
		List2.add(lp1);
		List2.add(tp1);
		List2.add(lp2);
		List2.add(tp2);
		List2.add(lp3);
		List2.add(tp3);
		List2.add(lp4);
		List2.add(tp4);
		
		List3.add(f1);
		List3.add(f2);
		List3.add(f3);
		panel.add(List1);
		panel.add(List2);
		panel2.add(mainLabel1);
		panel2.add(mainLabel11);
		panelm.add(panel2);
		panelm.add(panel);
		panelm.add(mainLabel2);
		panelm.add(List3);
		add(panelm);
		add(processObj);
		
		f1.addActionListener(this);
		f2.addActionListener(this);
		f3.addActionListener(this);
	}

		@Override
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			bSize[0]=Integer.parseInt(tb0.getText());
            bSize[1]=Integer.parseInt(tb1.getText());
            bSize[2]=Integer.parseInt(tb2.getText());
            bSize[3]=Integer.parseInt(tb3.getText());
            bSize[4]=Integer.parseInt(tb4.getText());
            
            pSize[0]=Integer.parseInt(tp0.getText());
            pSize[1]=Integer.parseInt(tp1.getText());
            pSize[2]=Integer.parseInt(tp2.getText());
            pSize[3]=Integer.parseInt(tp3.getText());
            pSize[4]=Integer.parseInt(tp4.getText());
            
	        if (s.equals("First-Fit")) {
	        	processObj.first=true;
	        	processObj.best=false;
	        	processObj.worst=false;
	            blockObj.blockLocation(600,40);
	    		processObj.processLocation(600,40);
	            repaint();
	        }
	        else if (s.equals("Worst-Fit")) {
	        	processObj.worst=true;
	        	processObj.best=false;
	        	processObj.first=false;
	            blockObj.blockLocation(600,40);
	    		processObj.processLocation(600,40);
	            repaint();
	        }
	        else if (s.equals("Best-Fit")) {
	        	processObj.best=true;
	        	processObj.first=false;
	        	processObj.worst=false;
	            blockObj.blockLocation(600,40);
	    		processObj.processLocation(600,40);
	            repaint();
	        }
				
				
			}
		}
		
			
	
	


