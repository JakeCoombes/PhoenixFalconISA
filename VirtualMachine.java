import java.util.*;
import java.io.*;

public class VirtualMachine {
	
	private Instruction program[] = new Instruction[10000];
	private int instructionCount = 0;
	public VirtualMachine(File f)
	{
		//f should exist, try to parse it....
		
		try {
			Scanner input = new Scanner(f);
			while(input.hasNext())
			{
				program[instructionCount] = new Instruction(input.nextLine());
				instructionCount++;
			}
			
		} catch (FileNotFoundException e) {
			//Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem trying to read assembly file!");
			System.exit(0);
		}		
	}
	
	public int getTotalNumberOfInstructions()
	{
		return instructionCount;
	}
	
	public String getInstruction(int instructionNumber)
	{
		return program[instructionNumber].toString();
	}
	
	public int getInstructionCycleCount(int instructionNumber)
	{
		return program[instructionNumber].getCycleCount();
	}
	
	public double calculateMulticycleCPI()
	{
		int i;
		double totalCycles = 0.0;		
		//check if instruction count is 0
		if(instructionCount == 0) 
			return 0.0;
		//otherwise add the cycle count for each instruction
		for(i = 0; i < instructionCount; i++) {
			totalCycles += getInstructionCycleCount(i);
		}
		
		return totalCycles/instructionCount;
	}

	public double calculateSinglecycleCPI()
	{
		int i;
		double totalCycles = 0.0;
		//check if instruction count is 0
		if(instructionCount == 0) 
			return 0.0;
		//otherwise add 1 for each instruction
		for(i = 0; i < instructionCount; i++) {
			totalCycles += 1;
		}
		
		return totalCycles/instructionCount;		
	}
	
	public int getTotalSingleCycleRunTime()
	{
		int longestCycle = 0, totalCycles, i;
		//find longest cycle count
		for(i=0; i < instructionCount; i++) {
			if(getInstructionCycleCount(i) > longestCycle) {
				longestCycle = getInstructionCycleCount(i);
			}
		}
		//calculate total cycles run time
		totalCycles = longestCycle * instructionCount * 2;
				
		return totalCycles;
	}
	
	public int getTotalMultiCycleRunTime()
	{
		int i, cycle = 2;
		int runTime = 0;
		
		
		for(i = 0; i < instructionCount; i++) {
			runTime += getInstructionCycleCount(i);
		}
	
		return runTime*cycle;
	}
	
	public double calculatePipelinedCPI() 
	{
		double totalCycles;
		
		if(instructionCount == 0)
			return 0.0;	
		
		totalCycles =  8+(instructionCount-1);
		
		return totalCycles/instructionCount;
	}
	
	public int getTotalPipelinedRunTime()
	{
		int totalCycles;
		
		if(instructionCount == 0)
			return 0;
		
		totalCycles = 8 + (instructionCount-1);
		
		return totalCycles * 22;
	}
	
	public void doAmdahlsLawForSpeedup() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("which instrucyion would you like to speed up?");
		int x=1;
		System.out.println((x++)+". ADD\n"+ (x++) +". LOAD\n"+ (x++) + ". STORE\n"+ (x++) + ". MULTIPLY\n"+
		(x++) + ". DIVIDE\n"+ (x++) + ". BRANCH\n"+ (x++) + ". TRAP\n"+ (x++) + ". COMP\n"+ (x++) + ". SLT\n"+		
				(x++) +". AND\n"+ (x++) + ". OR\n"+ (x++) + ". XOR\n"+ (x++) + ". SHIFTLA\n"+ (x++) + 
				". SHIFTLL\n"+ (x++) + ". SHIFTR\n"+ (x++) + ". NOR\n"+ (x++) + ". MOVE\n"+ (x++) + ". JUMP\n");
		String choice = input.nextLine();
		Instruction i = new Instruction(choice);
		
		System.out.println("By a factor of what do you want to speed up this instruction (multiplicative)?");
		
		double p = input.nextDouble(); //buffer out end line char
		input.close();
		
		
		double speedup = 0.0;
		
		double f = 0.0;
		
		int instCount = 0;
		
		for(x=0;x<instructionCount;x++) {
			if(program[x].toString().equalsIgnoreCase(i.toString()))
				instCount++;
		}
		
		f = (double)instCount/(double)instructionCount;
		
		//calculate speed up here
		speedup = 1/ ( (1-f) + (f/p));
		
		System.out.println("Overall speed up of this program with a single cycle data path is: "+ speedup);
	}
	
}