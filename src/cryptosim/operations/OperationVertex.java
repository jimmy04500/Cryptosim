package cryptosim.operations;

import java.util.ArrayList;

public class OperationVertex {
	private Operation operation;
	public ArrayList<OperationVertex> toVertices;
	public ArrayList<OperationVertex> fromVertices;
	private int startTime;
	private int finishTime;
	
	public OperationVertex(Operation op) {
		operation = op;
		toVertices = new ArrayList<OperationVertex>();
		fromVertices = new ArrayList<OperationVertex>();
	}
	
	public void addToVertex(OperationVertex vertex) {
		// Handle number of processors
		toVertices.add(vertex);
	}
	
	public void addFromVertex(OperationVertex vertex) {
		fromVertices.add(vertex);
	}
	
	public void setStartTime(int time) {
		startTime = time;
		finishTime = time + operation.getDuration();
	}
	
	public int getStartTime() {
		return startTime;
	}
	public int getFinishTime() {
		return finishTime;
	}
	public Operation getOperation() {
		return operation;
	}
}
