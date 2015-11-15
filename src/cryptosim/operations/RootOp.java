package cryptosim.operations;

import cryptosim.Dependency;
import cryptosim.Queue;

public class RootOp extends Operation {
	
	public Queue<Dependency> getOutputQueue() {
		return null;
	}
	
	public String getLabel() {
		return "Root Operation";
	}

}
