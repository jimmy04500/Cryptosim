package cryptosim.operations;

import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;
import cryptosim.utils.Node;

public abstract class Operation {
	private static int ID_COUNTER = 1;
	
	protected DataVar[] inputs;
	private DataVar output;
	public int OP_ID;
	public String description;
	private Node parentNode;
	
	public Operation(Node parent) {
		this("Empty Op", parent);
	}
	
	public Operation(String description, Node parentNode, DataVar ... inputs) {
		this.inputs = inputs;
		this.description = description;
		output = getOutputVar();
		this.parentNode = parentNode;
		
		OP_ID = ID_COUNTER;
		ID_COUNTER++;
	}
	
	public DataVar getOutput() {
		return output;
	}
	
	public boolean resolved() {
		boolean resolved = true;
		for (DataVar var : inputs) {
			if (!var.isFinished()) {
				resolved = false;
			}
		}
		return resolved;
	}
	
	public String toString() {
		return "[" + description + " (" + getLabel() + ")" + "] duration: " + getDuration();
	}
	
	public abstract int getDuration();
	public abstract String getLabel();
	
	protected abstract DataVar getOutputVar();
}
