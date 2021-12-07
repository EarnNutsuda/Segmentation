public class block {

	int blockSum = 0;
	int[] location = new int[5];
	int[] blockSize = new int[5];
	float[] blockRatio = new float[5];
	
	public block(int[] bSize) {
		this.blockSize = bSize;
	}
	
	
	public void blockLocation(int size,int start) {
		float initLocation=0;
		blockSum=0;
		for(int i =0;i<blockSize.length;i++) {
			blockSum+=blockSize[i];
		}
		System.out.println("Block Location");
		for(int j =0;j<blockRatio.length;j++) {
			blockRatio[j]=(float)blockSize[j]/blockSum;
			initLocation+=blockRatio[j];
			location[j]=(int) (40+size*initLocation);
			System.out.println(blockSize[j]+ " ----> "+ blockRatio[j]+ " --------> "+location[j]);
		}
	}


}
