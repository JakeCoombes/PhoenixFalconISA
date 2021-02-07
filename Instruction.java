
public class Instruction {

	enum OpCodes{
		ADD, LOAD, STORE, MULTIPLY, DIVIDE, BRANCH, TRAP, COMP, SLT, AND, OR, XOR, SHIFTLA, SHIFTLL, SHIFTR, NOR, MOVE, JUMP
	}
	
	private OpCodes opcode;
	
	public Instruction(String inst)
	{
		if(inst.equalsIgnoreCase("add"))
		{
			opcode = OpCodes.ADD;
		}
		
		if(inst.equalsIgnoreCase("load"))
		{
			opcode = OpCodes.LOAD;
		}
		
		if(inst.equalsIgnoreCase("store"))
		{
			opcode = OpCodes.STORE;
		}
		
		if(inst.equalsIgnoreCase("multiply"))
		{
			opcode = OpCodes.MULTIPLY;
		}
		
		if(inst.equalsIgnoreCase("divide"))
		{
			opcode = OpCodes.DIVIDE;
		}
		
		if(inst.equalsIgnoreCase("branch"))
		{
			opcode = OpCodes.BRANCH;
		}
		
		if(inst.equalsIgnoreCase("trap"))
		{
			opcode = OpCodes.TRAP;
		}
		
		if(inst.equalsIgnoreCase("comp"))
		{
			opcode = OpCodes.COMP;
		}
		
		if(inst.equalsIgnoreCase("slt"))
		{
			opcode = OpCodes.SLT;
		}
		
		if(inst.equalsIgnoreCase("and"))
		{
			opcode = OpCodes.AND;
		}
		
		if(inst.equalsIgnoreCase("or"))
		{
			opcode = OpCodes.OR;
		}
		
		if(inst.equalsIgnoreCase("xor"))
		{
			opcode = OpCodes.XOR;
		}
		
		if(inst.equalsIgnoreCase("shiftla"))
		{
			opcode = OpCodes.SHIFTLA;
		}
		
		if(inst.equalsIgnoreCase("shiftll"))
		{
			opcode = OpCodes.SHIFTLL;
		}
		
		if(inst.equalsIgnoreCase("shiftr"))
		{
			opcode = OpCodes.SHIFTR;
		}
		
		if(inst.equalsIgnoreCase("nor"))
		{
			opcode = OpCodes.NOR;
		}
		
		if(inst.equalsIgnoreCase("move"))
		{
			opcode = OpCodes.MOVE;
		}
		
		if(inst.equalsIgnoreCase("jump"))
		{
			opcode = OpCodes.JUMP;
		}
		
	}
	
	public int getCycleCount()
	{
		switch(opcode)
		{
		case ADD:
			return 1;
		case LOAD:
			return 5;
		case STORE:
			return 3;
		case MULTIPLY:
			return 15;
		case DIVIDE:
			return 52;
		case BRANCH:
			return 5;
		case TRAP:
			return 22;
		case COMP:
			return 88;
		case SLT:
			return 13;
		case AND:
			return 2;
		case OR:
			return 3;
		case XOR:
			return 1;
		case SHIFTLA:
			return 6;
		case SHIFTLL:
			return 7;
		case SHIFTR:
			return 8;
		case NOR:
			return 12;
		case MOVE:
			return 11;
		case JUMP:
			return 2;
				
		}
		System.out.println("Warning: unspecified instruction processed Instruction.getCycleCount()");
		return -1000; //something went wrong.
	}
	
	public String toString()
	{
		if(opcode == OpCodes.ADD)
		{
			
			return "add";
		}
		
		if(opcode ==  OpCodes.LOAD)
		{
			
			return "load";
		}
		
		if(opcode == OpCodes.STORE)
		{
			return "store";
		}
		
		if(opcode == OpCodes.MULTIPLY)
		{
			return "multiply";
		}
		
		if(opcode == OpCodes.DIVIDE)
		{
			return "divide";
		}
		
		if(opcode == OpCodes.BRANCH)
		{
			return "branch";
		}
		
		if(opcode == OpCodes.TRAP)
		{
			return "trap";
		}
		
		if(opcode == OpCodes.COMP)
		{
			return "comp";
		}
		
		if(opcode == OpCodes.SLT)
		{
			return "slt";
		}
		
		if(opcode == OpCodes.AND)
		{
			return "and";
		}
		
		if(opcode == OpCodes.OR)
		{
			return "or";
		}
		
		if(opcode == OpCodes.XOR)
		{
			return "xor";
		}
		
		if(opcode == OpCodes.SHIFTLA)
		{
			return "shiftla";
		}
		
		if(opcode == OpCodes.SHIFTLL)
		{
			return "shiftll";
		}
		
		if(opcode == OpCodes.SHIFTR)
		{
			return "shiftr";
		}
		
		if(opcode == OpCodes.NOR)
		{
			return "nor";
		}
		
		if(opcode == OpCodes.MOVE)
		{
			return "move";
		}
		
		if(opcode == OpCodes.JUMP)
		{
			return "jump";
		}
		System.out.println("Warning: unspecified instruction processed Instruction.toString()");
		return "";//something went wrong
	}

}