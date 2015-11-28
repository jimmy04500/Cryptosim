package cryptosim.operations;

import cryptosim.DataType;
import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;

public class SumOp extends Operation {
	public DataVar a, b;
	
	public SumOp(DataVar a, DataVar b) {
		super("Sum", null);
		//if (a.type != DataType.INT || b.type != DataType.INT)
			//throw new Error("Type Mismatch");
		this.a = a;
		this.b = b;
	}
	
	public DataVar getOutputVar() {
		DataVar output = new DataVar(a.value + b.value, "Sum output");
		
		return output;
	}
	
	public String getLabel() {
		return "Sum";
	}
	
	public int getDuration() {
		return 2;
	}
}
