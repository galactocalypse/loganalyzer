import java.util.*;

public class SampleParser implements Parser {
	
	public ArrayList<Object> parse (String s) {
		ArrayList<Object> arr = new ArrayList<Object>();
		if (s == null || s.trim().length() == 0) return arr;
		String components[] = s.split(" ");
		if (components.length != 4) return arr;

		return processFields (components);
	}
	private ArrayList<Object> processFields (String[] fields) {

		ArrayList<Object> arr = new ArrayList<Object>();
		arr.add(fields[0]);
		arr.add(new Date(Long.valueOf(fields[1])));
		arr.add(fields[2]);
		arr.add(fields[3]);


		return arr;
	}
}
