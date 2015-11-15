package cryptosim.utils;

import cryptosim.DataVar;
import cryptosim.operations.Operation;
import cryptosim.operations.OperationVertex;

public class Node {
	public String desc;
	public int numP;
	OperationVertex head;
	OperationVertex tail;
	
	public DataVar input;
	
	public Node(DataVar in) {
		//head = new OperationVertex(null, null);
		//tail = head;
		desc = "Description not set";
		numP = 1;
		input = in;
	}
	
	public Node(String description, int numProcessors) {
		desc = description;
		numP = numProcessors;
	}
	
	public void append(Operation operation) {
		
	}
}
