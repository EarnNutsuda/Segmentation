import java.awt.*;
import javax.swing.*;

public class Process extends JPanel {
	int[] processSize = new int[5];
	int[] processLocation = new int[5];
	int[] processLength = new int[5];
	int[] allocate = new int[5];
	int[] allocateCheck = new int[5];
	float[] pRatio = new float[5];
	boolean first = true;
	boolean worst = false;
	boolean best = false;
	block block;
	Font font = new Font("Courier", Font.BOLD, 20);

	public Process(int[] pSize, block block) {
		this.processSize = pSize;
		this.block = block;
	}

	void firstFitAllocate() {
		for (int i = 0; i < 5; i++) {
			allocate[i] = 999;
			allocateCheck[i] = 0;
		}

		for (int i = 0; i < processSize.length; i++) {
			for (int j = 0; j < block.blockSize.length; j++) {

				if (allocate[j] == 999 && processSize[i] <= block.blockSize[j] && processSize[i] != 0) {
					allocate[j] = i;
					allocateCheck[i] = 1;
					break;
				}
			}
		}
		System.out.println("Process Allocation");
		for (int i = 0; i < 5; i++)
			System.out.println("Allocation " + i + "<--- " + "process " + allocate[i]);
		System.out.println("");
	}

	void worstFit() {
		for (int i = 0; i < 5; i++) {
			allocate[i] = 999;
			allocateCheck[i] = 0;
		}
		for (int i = 0; i < processSize.length; i++) {
			int index = -1;
			for (int j = 0; j < block.blockSize.length; j++) {
				if (allocate[j] == 999 && processSize[i] <= block.blockSize[j] && processSize[i] != 0) {
					if (index == -1)
						index = j;
					else if (block.blockSize[index] < block.blockSize[j])
						index = j;
				}
			}
			if (index != -1) {
				allocate[index] = i;
				allocateCheck[i] = 1;
			}
		}
		for (int i = 0; i < 5; i++)
			System.out.println("Allocation " + i + "<--- " + "process " + allocate[i]);
	}

	void bestFit() {
		for (int i = 0; i < 5; i++) {
			allocate[i] = 999;
			allocateCheck[i] = 0;
		}

		for (int i = 0; i < processSize.length; i++) {
			int index = -1;
			for (int j = 0; j < block.blockSize.length; j++) {
				if (allocate[j] == 999 && processSize[i] <= block.blockSize[j] && processSize[i] != 0) {
					if (index == -1)
						index = j;
					else if (block.blockSize[index] > block.blockSize[j])
						index = j;
				}

			}

			if (index != -1) {
				allocate[index] = i;
				allocateCheck[i] = 1;
			}

		}
		for (int i = 0; i < 5; i++)
			System.out.println("Allocation " + i + "<--- " + "process " + allocate[i]);

	}

	public float[] calRatio() {
		for (int j = 0; j < pRatio.length; j++) {
			pRatio[j] = (float) processSize[j] / block.blockSum;
		}
		return pRatio;
	}

	public void processLocation(int size, int start) {
		if (first)
			firstFitAllocate();
		else if (worst)
			worstFit();
		else if (best)
			bestFit();

		calRatio();
		int cur;
		System.out.println("Block Location and Length");
		for (int i = 0; i < allocate.length; i++) {
			cur = allocate[i];
			if (cur != 999) {

				if (i == 0) {
					processLocation[cur] = 40;
				} else {
					processLocation[cur] = block.location[i - 1];
				}
				processLength[cur] = (int) (pRatio[cur] * size);

				System.out.println("Block" + i + " ---> go to P" + cur + " Length:" + processLength[cur] + " Ration:"
						+ pRatio[cur] + " Location:" + processLocation[cur]);

			}

		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(100, 40, 150, 600);
		g.setColor(Color.black);
		g.drawLine(100, 40, 250, 40);
		g.drawLine(100, 40, 100, 640);
		g.drawLine(250, 40, 250, 640);
		g.drawLine(100, 640, 250, 640);

		for (int i = 0; i < allocate.length; i++) {
			int cur = allocate[i];
			if (cur != 999) {
				g.setColor(Color.orange);
				g.fillRect(100, processLocation[cur], 150, processLength[cur]);
				g.setColor(Color.black);
				g.drawString("P" + cur + ": " + String.valueOf(processSize[cur]) + " kb", 150,
						processLocation[cur] + processLength[cur] / 2);
			}
		}
		
		int count = 0;
		for (int i = 0; i < allocateCheck.length; i++) {
			if (allocateCheck[i] != 1 && processSize[i] != 0) {
				g.setColor(Color.red);
				g.drawString("Process " + i + " can't be allocated", 100, 670 + count * 20);
				count += 1;
			}
		}

		g.setColor(Color.black);
		for (int i = 0; i < block.location.length; i++) {
			g.drawLine(100, block.location[i], 250, block.location[i]);
			if (block.blockSize[i] > 0) {
				if (i > 0)
					g.drawString("Block" + i + ": " + String.valueOf(block.blockSize[i]) + " kb", 260,
							(block.location[i] + block.location[i - 1]) / 2);
				else
					g.drawString("Block" + i + ": " + String.valueOf(block.blockSize[i]) + " kb", 260,
							(40 + block.location[i]) / 2);
			}
		}

		repaint();

	}
}
