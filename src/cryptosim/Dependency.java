package cryptosim;

import cryptosim.operations.Operation;

public class Dependency {
	public Operation from;
	public Operation to;
	
	public Dependency(Operation from, Operation to) {
		this.from = from;
		this.to = to;
	}
}
