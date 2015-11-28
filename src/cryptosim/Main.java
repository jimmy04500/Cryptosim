package cryptosim;

import cryptosim.operations.*;
import cryptosim.utils.CoreUtil;
import cryptosim.utils.Node;

public class Main {

	public static void main(String[] args) {
		test3();
	}
	
	/*
	 * 	begin
	 * 	constadd1
	 * 	const1
	 * 	const2
	 * 	const3
	 * 	const4
	 */
	public static void test1() {
		TimeLine main = new TimeLine();
		Node alice = new Node("Alice", 2);
		
		InputVar sample = new InputVar(10, "input");
		
		BeginOp begin = new BeginOp(alice, sample);
		DataVar begin_out = begin.getOutput();
		
		ConstAddOp constadd1 = new ConstAddOp("constAdd1", alice, begin_out);
		DataVar constadd1_out = constadd1.getOutput();
		ConstMultOp const1 = new ConstMultOp("const1", alice, constadd1_out);
		DataVar const1_out = const1.getOutput();
		ConstAddOp const2 = new ConstAddOp("const2", alice, const1_out);
		DataVar const2_out = const2.getOutput();
		ConstMultOp const3 = new ConstMultOp("const3", alice, const2_out);
		DataVar const3_out = const3.getOutput();
		ConstMultOp const4 = new ConstMultOp("const4", alice, const3_out);
		DataVar const4_out = const4.getOutput();
		
		main.addStartOp(begin);
		main.addDependency(begin, constadd1);
		main.addDependency(constadd1, const1);
		main.addDependency(const1, const2);
		main.addDependency(const2, const3);
		main.addDependency(const3, const4);
		
		main.process();
		main.printFinished();
	}
	
	public static void test2() {
		TimeLine main = new TimeLine();
		Node alice = new Node("Alice", 2);
		
		InputVar sample = new InputVar(10, "input");
		
		BeginOp begin = new BeginOp(alice, sample);
		DataVar begin_out = begin.getOutput();
		
		ConstAddOp constadd1 = new ConstAddOp("constAdd1", alice, begin_out);
		DataVar constadd1_out = constadd1.getOutput();
		
		ConstMultOp const1 = new ConstMultOp("const1", alice, constadd1_out);
		DataVar const1_out = const1.getOutput();
		ConstAddOp const2 = new ConstAddOp("const2", alice, constadd1_out);
		DataVar const2_out = const2.getOutput();
		
		ConstMultOp const3 = new ConstMultOp("const3", alice, const1_out);
		DataVar const3_out = const3.getOutput();
		ConstMultOp const4 = new ConstMultOp("const4", alice, const2_out);
		DataVar const4_out = const4.getOutput();
		
		main.addStartOp(begin);
		main.addDependency(begin, constadd1);
		main.addDependency(constadd1, const1);
		main.addDependency(constadd1, const2);
		main.addDependency(const1, const3);
		main.addDependency(const2, const4);
		
		main.process();
		main.printFinished();
	}
	
	public static void test3() {
		TimeLine main = new TimeLine();
		Node alice = new Node("Alice", 2);
		
		InputVar sample = new InputVar(10, "input");
		
		BeginOp begin = new BeginOp(alice, sample);
		DataVar begin_out = begin.getOutput();
		
		ConstAddOp constadd1 = new ConstAddOp("constAdd1", alice, begin_out);
		DataVar constadd1_out = constadd1.getOutput();
		
		ConstMultOp const1 = new ConstMultOp("const1", alice, begin_out);
		DataVar const1_out = const1.getOutput();
				
		main.addStartOp(begin);
		main.addDependency(begin, constadd1);
		main.addDependency(begin, const1);
		
		main.process();
		main.printFinished();
	}
}
