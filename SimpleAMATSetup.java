import java.util.Scanner;

public class SimpleAMATSetup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double hitTime[] = new double[100]; 
		double missRate[] = new double[100];
		Scanner input = new Scanner(System.in);
		System.out.println("How many levels of memory are there (up to 100)?");
		int levels = input.nextInt();
		
		//Generate some level numbers
		double hitTimeBest = 1;
		double hitTimeWorst = 200;
		
		double missRateBest = 0.45;
		double missRateWorst = 0.99;
		
		hitTime[0]=hitTimeBest;
		missRate[0] = missRateWorst;
		for(int x=1;x<levels-1;x++)
		{
			hitTime[x] = (hitTimeBest+hitTimeWorst)*((double)x/levels); //CHECK
			missRate[x] = (missRateBest-missRateWorst)*(1 - (double)x/levels) + missRateWorst; //CHECK
			
		}
		hitTime[levels-1] = 50000; //it's disk, it's terrible
		missRate[levels-1] = 0.0 ;//it's disk, hit rate is 100%
		
		AMAT(0,levels,hitTime,missRate);
		
		
	}
	
	public static double AMAT(int level, int maxLevel, double hitTime[], double missRate[])
	{
		double AMATvalue = 0.0;
		if(level == maxLevel - 1 )
		{
			//disk
			AMATvalue = hitTime[level];
			System.out.println("AMAT of Disk = "+ AMATvalue);
			
		}else
			if(level == maxLevel - 2 )
			{
				//Main Memory
				AMATvalue = hitTime[level] + missRate[level] * AMAT(level+1,maxLevel, hitTime, missRate);
				System.out.println("AMAT of RAM = "+ AMATvalue);
			}
			else
			{
				//Cache
				AMATvalue = hitTime[level] + missRate[level] * AMAT(level+1,maxLevel, hitTime, missRate);
				System.out.println("AMAT of L"+(level+1) +" cache = "+ AMATvalue);
			}
		return AMATvalue;
	}

}