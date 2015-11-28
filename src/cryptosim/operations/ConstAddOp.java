package cryptosim.operations;

import cryptosim.DataVar;
import cryptosim.utils.Node;

public class ConstAddOp extends Operation {
	
	public ConstAddOp(String description, Node parent, DataVar input) {
		super(description, parent, input);
	}
	
	protected DataVar getOutputVar() {
		DataVar output = new DataVar(inputs[0].value + 5, "ConstAdd output");
		return output;
	}
	
	public int getDuration() {
		return 8;
	}
	
	public String getLabel() {
		return "Const Add";
	}
}
