import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestDecoder {
	String raw;
	String operation;
	ResponseEncoder enc;
	int num1, num2;
	
	public RequestDecoder(String raw) {
		this.raw = raw;
		enc = new ResponseEncoder();
	}
	
	public ResponseEncoder decode() {
		//regular expression pattern
		Pattern pattern = Pattern.compile("HMDP/1.0 (\\w+)\\n.*\\n.*\\n(\\d+) (\\d+)");
		
		//pattern matching
		Matcher matcher = pattern.matcher(raw);
		
		if (matcher.find()) {
            operation = matcher.group(1);  // "ADD"
            num1 = Integer.parseInt(matcher.group(2));    // "1"
            num2 = Integer.parseInt(matcher.group(3));    // "2"
//            System.out.println("Operation: " + operation);
//            System.out.println("Number 1: " + num1);
//            System.out.println("Number 2: " + num2);
        } else {
        	enc.setResponseCode(400);
            System.out.println("No match found.");
        }
		
		return enc;
	}
}
