package cryptosim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import cryptosim.operations.BeginOp;
import cryptosim.operations.Operation;
import cryptosim.operations.OperationVertex;
import cryptosim.operations.RootOp;
import cryptosim.utils.CoreUtil;
import cryptosim.utils.Node;

public class TimeLine {
	private HashMap<Integer, OperationVertex> dictOps;
	
	private ArrayList<Node> nodes;
	private ArrayList<OperationVertex> startOps;
	public CoreUtil coreUtil;
	private ArrayList<OperationVertex> processed;
	private ArrayList<OperationVertex> unprocessed;
	private int currentTime;
	
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
		dictOps.put(beginOp.operation.OP_ID, beginOp);
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
				if (temp.operation.resolvedDeps()) {
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
				int startTime = coreUtil.scheduleOperation(currentTime, temp.operation);
				temp.setStartTime(startTime);
				for (OperationVertex op : temp.toVertices) {
					op.operation.decrementNum();
				}
				processed.add(temp);
			}
			coreUtil.clearPreviousOps(currentTime);
			currentTime = coreUtil.getNextLowestAvailable();
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
		for (OperationVertex vertex : processed) {
			System.out.println(vertex.operation.toString() + " startTime: " + vertex.getStartTime() + " finishTime: " + vertex.getFinishTime());
		}
	}
}
