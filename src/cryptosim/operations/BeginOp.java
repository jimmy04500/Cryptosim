package cryptosim.operations;

import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;
import cryptosim.utils.Node;

public class BeginOp extends Operation {
	
	public BeginOp(Node parent, DataVar input) {
		super("begin", parent, input);
	}
	
	public DataVar getOutputVar() {
		return new DataVar(inputs[0]);
	}
	
	public int getDuration() {
		return 0;
	}

	
	public String getLabel() {
		return "Begin";
	}
}
