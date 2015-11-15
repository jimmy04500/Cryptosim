package cryptosim.operations;

import cryptosim.DataType;
import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;
import cryptosim.utils.Node;

public class SendOp extends Operation {

	public SendOp(int in) {
		super(in);
	}
	
	// Returns input, no change
	public DataVar getOutputVar() {
		return new DataVar(5, "hi");
	}
	
	public int getDuration() {
		return 5;
	}
	
	public String getLabel() {
		return "Send Operation";
	}
	
	public Queue<Dependency> getOutputQueue() {
		return null;
	}
}
