package cryptosim.operations;

import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;

public abstract class Operation {
	public static int ID_COUNTER = 1;
	
	public int OP_ID;
	public int dependencies;
	public String description;
	
	public Operation() {
		this(1, "Empty operation");
	}
	
	public Operation(int in, String info) {
		dependencies = in;
		OP_ID = ID_COUNTER;
		ID_COUNTER++;
		description = info;
	}
	
	public void decrementNum() {
		dependencies--;
	}
	
	public boolean resolvedDeps() {
		return dependencies == 0;
	}
	
	public String toString() {
		return "[" + description + " (" + getLabel() + ")" + "] duration: " + getDuration();
	}
	
	public abstract int getDuration();
	public abstract DataVar getOutputVar();
	public abstract String getLabel();
}
