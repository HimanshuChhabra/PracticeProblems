package mac.interfaces.practice;
import java.util.regex.*;

public class javaRegex {

	public static void main(String[] args) {
		boolean val = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)\\.([org||com]{3})$").
				matcher("himan12_@syr.org").matches();
		
		System.out.println(val);

	}

	//^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-]+)\.([a-zA-Z]{2,5})$
}
