import javax.swing.JFrame;
public class SegmentMain {
	
	public static void main(String [] args) {		
		JFrame frame = new JFrame("Memory Allocation");
		frame.add(new Segment());
		frame.setSize(750, 900); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
}
}
