package cryptosim;

import cryptosim.operations.Operation;

public class DataVar {
	public DataType type;
	public double value;
	public String description;
	private boolean isFinished;
	
	public DataVar(double val, String info) {
		value = val;
		description = info;
		isFinished = false;
	}
	
	public DataVar(DataVar var) {
		value = var.value;
		description = var.description;
	}
	
	public boolean isFinished() {
		return isFinished;
	}
	
	public void setFinished(boolean finish) {
		isFinished = finish;
	}
}
