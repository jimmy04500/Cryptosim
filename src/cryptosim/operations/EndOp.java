package cryptosim.operations;

import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;

public class EndOp extends Operation {
	
	public EndOp() {
		super("End", null);
	}
	
	public DataVar getOutputVar() {
		return null;
	}
	
	public int getDuration() {
		return 0;
	}

	
	public String getLabel() {
		return "End of protocol";
	}
	
	public Queue<Dependency> getOutputQueue() {
		return null;
	}
}
