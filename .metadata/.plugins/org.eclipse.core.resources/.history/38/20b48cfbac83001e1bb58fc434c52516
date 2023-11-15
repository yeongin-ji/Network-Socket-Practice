
public class requestEncoder {
	final private String protocolVersion = "HMDP/1.0";
	private String request;
	private String encodedRequest;
	private String method;
	private String argu[] = new String[3];
	private String num1, num2;
	
	public requestEncoder(String request) { //ADD 1 2
		// TODO Auto-generated constructor stub
		this.request = request;
	}
	
	public void encode(String IP, int port) {
		String portStr = Integer.toString(port);
		argu = request.split(" ");
		method = argu[0];
		num1 = argu[1];
		num2 = argu[2];
		
		encodedRequest = 
				protocolVersion + " " + method + "\n" +
				"Host: " + IP + ":" + portStr + "\n\n" +
				num1 + " " + num2;
	}
	
	public String getEncodedRequest() {
		return encodedRequest;
	}
}
