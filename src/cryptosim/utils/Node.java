package cryptosim.utils;

import cryptosim.DataVar;
import cryptosim.operations.Operation;
import cryptosim.operations.OperationVertex;

public class Node {
	private String name;
	private int numProcessors;
	
	public Node(String name) {
		this(name, 1);
	}
	
	public Node(String name, int numProcessors) {
		this.name = name;
		this.numProcessors = numProcessors;
	}
	
	public String getName() {
		return name;
	}
}
