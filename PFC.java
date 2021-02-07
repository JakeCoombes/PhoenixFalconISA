import java.io.*;
import java.util.*;

public class PFC {

	public static void main(String[] args) {
		
		String assemblyFileName;	//Assembly textfile name
		File assemblyFile;			//File link to the actual file
		Scanner input = new Scanner(System.in); //Instance of scanner to get keyboard input

		//Prompt user for assembly file input
		System.out.println("Enter the name of the assembly file");
		assemblyFileName = input.nextLine();
		
		
		assemblyFile = new File(assemblyFileName);
		
		//If the file doesn't exist prompt the user and exit
		if(!assemblyFile.exists())
		{
			System.out.println(assemblyFileName + "file does not exist!");
			System.exit(0);
		}
	
		//Create an instance of Virtual Machine, and pass it the file to parse it up!
		VirtualMachine vm = new VirtualMachine(assemblyFile);
		
		System.out.println("Total Program Size (Number of Instructions)" + vm.getTotalNumberOfInstructions());
		
		for(int x=0;x<vm.getTotalNumberOfInstructions();x++)
		{
			System.out.println("Instruction "+x+": " + vm.getInstruction(x));
			System.out.println("Cycles: " + vm.getInstructionCycleCount(x));
		}
		
		System.out.println("Single-cycle CPI = " + vm.calculateSinglecycleCPI() );
		System.out.println("Multi-cycle CPI = " + vm.calculateMulticycleCPI() );
		System.out.println("Pipelined CPI = " + vm.calculatePipelinedCPI() );
		System.out.println("Single-cycle Run Time: " + vm.getTotalSingleCycleRunTime() + " nanoseconds");
		System.out.println("Multi-cycle Run Time: " + vm.getTotalMultiCycleRunTime() + " nanoseconds");
		System.out.println("Pipelined Run Time: " + vm.getTotalPipelinedRunTime() + " nanoseconds");
		
		vm.doAmdahlsLawForSpeedup();
	}

}