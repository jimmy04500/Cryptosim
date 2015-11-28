package cryptosim.operations;

import cryptosim.DataVar;
import cryptosim.utils.Node;

public class ConstMultOp extends Operation{
	
	public ConstMultOp(String description, Node parent, DataVar input) {
		super(description, parent, input);
	}
	
	protected DataVar getOutputVar() {
		DataVar output = new DataVar(inputs[0].value * 5, "ConstMult output");
		return output;
	}
	
	public int getDuration() {
		return 10;
	}
	
	public String getLabel() {
		return "Const Mult";
	}
}