package cryptosim.utils;

import cryptosim.operations.Operation;

public class CoreObject {
	public CoreObject next;
	private Operation operation;
	
	private int startTime;
	private int finishTime;
	
	
	public CoreObject(Operation operation, int startTime) {
		this.operation = operation;
		this.startTime = startTime;
		this.finishTime = startTime + operation.getDuration();
		next = null;
	}
	
	public int getDuration() {
		return operation.getDuration();
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
