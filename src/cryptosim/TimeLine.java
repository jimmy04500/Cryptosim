package cryptosim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import cryptosim.operations.BeginOp;
import cryptosim.operations.Operation;
import cryptosim.operations.OperationVertex;
import cryptosim.utils.CoreUtil;
import cryptosim.utils.Node;

public class TimeLine {
	private HashMap<Integer, OperationVertex> dictOps;
	
	private CoreUtil coreUtil;
	private ArrayList<Node> nodes;
	private ArrayList<OperationVertex> startOps;
	private ArrayList<OperationVertex> processed;
	private ArrayList<OperationVertex> unprocessed;
	private int currentTime;
	private int c = 0;
	
	public TimeLine() {
		dictOps = new HashMap<Integer, OperationVertex>();
		nodes = new ArrayList<Node>();
		startOps = new ArrayList<OperationVertex>();
		coreUtil = new CoreUtil(2);
		processed = new ArrayList<OperationVertex>();
		unprocessed = new ArrayList<OperationVertex>();
		currentTime = 0;
	}
	
	public void addNode(Node n) {
		nodes.add(n);
	}
	
	public void addStartOp(BeginOp operation) {
		if (nodes.size() == startOps.size())
			System.out.println("Adding more begin operations than the number of nodes");
		OperationVertex beginOp = new OperationVertex(operation);
		startOps.add(beginOp);
		dictOps.put(beginOp.getOperation().OP_ID, beginOp);
		unprocessed.add(beginOp);
	}
	
	public void process() {
		while (!unprocessed.isEmpty()) {
			ArrayList<OperationVertex> toBeProcessed = new ArrayList<OperationVertex>();
			// Add all operations with resolved dependencies into toBeProcessed
			for (int i = 0; i < unprocessed.size(); i++) {
				OperationVertex temp = unprocessed.get(i);
				boolean resolved = false;
				boolean completed = true;
				if (temp.getOperation().resolved()) {
					resolved = true;
				}
				for (OperationVertex op : temp.fromVertices) {
					if (currentTime < op.getFinishTime()) completed = false;
				}
				if (resolved && completed) {
					toBeProcessed.add(temp);
					unprocessed.remove(temp);
					i--;
				}
			}
			for (int i = 0; i < toBeProcessed.size(); i++) {
				OperationVertex temp = toBeProcessed.get(i);
				int startTime = coreUtil.scheduleOperation(currentTime, temp.getOperation());
				temp.setStartTime(startTime);
				temp.getOperation().getOutput().setFinished(true);
				processed.add(temp);
			}
			coreUtil.clearPreviousOps(currentTime);
			currentTime = coreUtil.getNextLowestAvailable();
			c++;
			if (c == 3) {
				//break;
			}
		}
	}
	
	public void addDependency(Operation from, Operation to) {
		OperationVertex fromV;
		OperationVertex toV;
		if (!dictOps.containsKey(from.OP_ID)) {
			fromV = new OperationVertex(from);
			dictOps.put(from.OP_ID, fromV);
			unprocessed.add(fromV);
		} else {
			fromV = dictOps.get(from.OP_ID);
		}
		
		if (!dictOps.containsKey(to.OP_ID)) {
			toV = new OperationVertex(to);
			dictOps.put(to.OP_ID, toV);
			unprocessed.add(toV);
		} else {
			toV = dictOps.get(to.OP_ID);
		}
		
		fromV.addToVertex(toV);
		toV.addFromVertex(fromV);
	}
	
	public void printFinished() {
		System.out.println("[Printing Timeline]");
		for (OperationVertex vertex : processed) {
			System.out.println(vertex.getOperation().toString() + " startTime: " + vertex.getStartTime() + " finishTime: " + vertex.getFinishTime());
		}
	}
}
