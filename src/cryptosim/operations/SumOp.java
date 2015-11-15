package cryptosim.operations;

import cryptosim.DataType;
import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;

public class SumOp extends Operation {
	public DataVar a, b;
	
	public SumOp(DataVar a, DataVar b) {
		super(2);
		//if (a.type != DataType.INT || b.type != DataType.INT)
			//throw new Error("Type Mismatch");
		this.a = a;
		this.b = b;
	}
	
	public DataVar getOutputVar() {
		DataVar output = new DataVar(a.value + b.value, "Sum output");
		
		return output;
	}
	
	public Queue<Dependency> getOutputQueue() {
		/*
		Queue<Dependency> queue = new Queue<Dependency>();
		
		BeginOp begin = new BeginOp();
		EndOp end = new EndOp();
		HomomorphicEncryptOp homomorph = new HomomorphicEncryptOp(1);
		SampleOp sample = new SampleOp(1);
		queue.enqueue(new Dependency(begin, homomorph));
		queue.enqueue(new Dependency(homomorph, sample));
		queue.enqueue(new Dependency(sample, end));
		return queue;
		*/
		return null;
	}
	
	public String getLabel() {
		return "Sum";
	}

}
