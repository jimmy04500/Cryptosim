package cryptosim;

public class InputVar extends DataVar {
	
	public InputVar(int value, String info) {
		super(value, info);
		setFinished(true);
	}
}
