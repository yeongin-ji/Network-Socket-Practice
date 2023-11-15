
public class Calculator {
	private String operation;
	private int num1, num2;
	
	
	public Calculator(RequestDecoder dec) {
		operation = dec.operation;
		num1 = dec.num1;
		num2 = dec.num2;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public int getAddResult() {
		return num1 + num2;
	}
	
	public int getSubResult() {
		return num1 - num2;
	}
	
	public int getMulResult() {
		return num1 * num2;
	}
	
	public float getDivResult() {
		return (float)num1 / num2;
	}
	
	public boolean checkDivideByZero() {
		if(num2 == 0) return true;
		else return false;
	}
}
