package cryptosim.operations;

import cryptosim.DataType;
import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;

public class ConstMultOp extends Operation{
	public DataVar a;
	
	public ConstMultOp(DataVar a, String description) {
		super(1, description);
		this.a = a;
	}
	
	public DataVar getOutputVar() {
		DataVar output = new DataVar(a.value * 5, "ConstMult output");
		return output;
	}
	
	public int getDuration() {
		return 10;
	}
	
	public String getLabel() {
		return "Const Mult";
	}
}