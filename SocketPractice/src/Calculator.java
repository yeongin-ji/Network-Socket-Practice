
public class Calculator {
	private String operation;
	private int num1, num2;
	
	//migration dec data to calculator
	public Calculator(RequestDecoder dec) {
		operation = dec.operation;
		num1 = dec.num1;
		num2 = dec.num2;
	}
	
	public String getOperation() {
		return operation;
	}
	
	//return add result
	public int getAddResult() {
		return num1 + num2;
	}
	
	//return subtract result
	public int getSubResult() {
		return num1 - num2;
	}
	
	//return multiplication result
	public int getMulResult() {
		return num1 * num2;
	}
	
	//return division result
	public float getDivResult() {
		return (float)num1 / num2;
	}
	
	//check divide by zero state
	public boolean checkDivideByZero() {
		if(num2 == 0) return true;
		else return false;
	}
}
