package cryptosim.operations;

import cryptosim.DataType;
import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;

public class ReceiveOp extends Operation{
	
	public ReceiveOp(int in) {
		super(in, "");
	}
	
	// Returns a copy of the input variable
	public DataVar getOutputVar() {
		DataVar output = new DataVar(null);
		//output.nextAvailableTime += getDuration();
		return output;
	}
	
	public int getDuration() {
		return 1;
	}
	
	public String getLabel() {
		return "Receive Operation";
	}
	
	public Queue<Dependency> getOutputQueue() {
		return null;
	}
}
