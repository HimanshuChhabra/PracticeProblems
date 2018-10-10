package mac.interfaces.practice;

import java.util.*;
public class ComprablePrac implements Comparable<ComprablePrac>{

	private int val;
	
	public ComprablePrac(int val) {
		this.val = val;
	}
	public static void main(String[] args) {
		
		List<ComprablePrac> list = Arrays.asList(new ComprablePrac(1),new ComprablePrac(5),new ComprablePrac(2));
		
		Collections.sort(list);

	}

	@Override
	public int compareTo(ComprablePrac o) {

		return this.val - o.val;
	}
	
}
