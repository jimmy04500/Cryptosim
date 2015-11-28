package cryptosim.operations;

import cryptosim.DataType;
import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;
import cryptosim.utils.Node;

public class SendOp extends Operation {

	public SendOp(DataVar input, Node sourceNode, Node ... destNodes) {
		super("Send", null, input);
	}
	
	// Returns input, no change
	public DataVar getOutputVar() {
		return new DataVar(inputs[0]);
	}
	
	public int getDuration() {
		return 5;
	}
	
	public String getLabel() {
		return "Send Operation";
	}
}
