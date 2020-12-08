package december8puzzle1;

public class Instruction {
	public String instruction;
	public int arg;
	
	Instruction(String s, int t) {
		instruction = s;
		arg = t;
	}
	
	@Override 
	public String toString() {
		return instruction + " " + arg;
	}
}
