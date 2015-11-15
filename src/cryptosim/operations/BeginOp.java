package cryptosim.operations;

import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;

public class BeginOp extends Operation {
	DataVar input;
	
	public BeginOp(DataVar input) {
		super(0, "begin");
		this.input = input;
	}
	
	public DataVar getOutputVar() {
		return input;
	}
	
	public int getDuration() {
		return 0;
	}

	
	public String getLabel() {
		return "Begin";
	}
	
	public Queue<Dependency> getOutputQueue() {
		return null;
	}
}
