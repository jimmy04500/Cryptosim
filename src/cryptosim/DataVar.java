package cryptosim;

import cryptosim.operations.Operation;

public class DataVar {
	public DataType type;
	public double value;
	public String description;
	private boolean isAvailable;
	
	public DataVar(double val, String info) {
		value = val;
		description = info;
		isAvailable = true;
	}
	
	public DataVar(DataVar var) {
		value = var.value;
		description = var.description;
	}
}
