package cryptosim.operations;

import cryptosim.DataVar;
import cryptosim.Dependency;
import cryptosim.Queue;

public class ModOp extends Operation {
	public DataVar value, modulo;
	
	public ModOp(DataVar value, DataVar modulo) {
		super("Mod", null, value, modulo);
		this.value = value;
		this.modulo = modulo;
	}

	public DataVar getOutputVar() {
		DataVar output = new DataVar(value.value % modulo.value, "Modulo output");
		return output;
	}
	
	public Queue<Dependency> getOutputQueue() {
		return null;
	}
	
	public int getDuration() {
		return 15;
	}
	
	public String getLabel() {
		return "Modulo";
	}
}
