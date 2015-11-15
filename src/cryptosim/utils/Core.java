package cryptosim.utils;

import java.util.ArrayList;

import cryptosim.operations.Operation;

public class Core {
	private CoreObject head;
	private CoreObject tail;
	
	public Core() {
		head = null;
		tail = null;
	}
	
	public int append(Operation op) {
		return append(op, tail.getFinishTime());
	}
	
	public int append(Operation op, int startTime) {
		CoreObject next = new CoreObject(op, startTime);
		if (head == null) {
			head = next;
		} else {
			tail.next = next;
		}
		tail = next;
		return startTime;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	// needed?
	/*
	public boolean isAvailable(int time) {
		return tail.endTime <= time;
	}
	*/
	
	public void print() {
		CoreObject temp = head;
		while (temp != null) {
			Operation tempOp = temp.getOperation();
			System.out.println(tempOp.description + " " + tempOp.OP_ID + " startTime: " + temp.getStartTime() + " duration: " + tempOp.getDuration());
			temp = temp.next;
		}
	}
	
	public int availableTime() {
		return tail == null? 0 : tail.getFinishTime();
	}
	
	public void clear(int time) {
		while (head != null && head.getFinishTime() <= time) {
			head = head.next;
		}
		tail = head;
		if (tail != null) {
			while (tail.next != null) {
				tail = tail.next;
			}
		}
	}
}
