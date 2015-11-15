package cryptosim;

import cryptosim.operations.*;
import cryptosim.utils.CoreUtil;
import cryptosim.utils.Node;

public class Main {

	public static void main(String[] args) {
		TimeLine main = new TimeLine();
		
		DataVar sample = new DataVar(10, "input");
		BeginOp begin = new BeginOp(sample);
		ConstAddOp constadd1 = new ConstAddOp(sample, "constAdd1");
		ConstMultOp const1 = new ConstMultOp(sample, "const1");
		ConstMultOp const2 = new ConstMultOp(sample, "const2");
		ConstMultOp const3 = new ConstMultOp(sample, "const3");
		ConstMultOp const4 = new ConstMultOp(sample, "const4");
		
		main.addStartOp(begin);
		main.addDependency(begin, const1);
		main.addDependency(const1, constadd1);
		main.addDependency(constadd1, const2);
		main.addDependency(const2, const3);
		
		main.process();
		main.printFinished();
	}
}
