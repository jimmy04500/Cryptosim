package cryptosim.operations;

import cryptosim.DataVar;

public class ConstAddOp extends Operation {
	public DataVar a;
	
	public ConstAddOp(DataVar a, String description) {
		super(1, description);
		this.a = a;
	}
	
	public DataVar getOutputVar() {
		DataVar output = new DataVar(a.value + 5, "ConstAdd output");
		return output;
	}
	
	public int getDuration() {
		return 8;
	}
	
	public String getLabel() {
		return "Const Mult";
	}
}
