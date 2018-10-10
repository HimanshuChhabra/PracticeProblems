package com.himanshu.ibm;
import java.io.*;
import java.util.*;

public class ibm2 {

	public static void main(String[] args) throws IOException {
		List<String> drugList = new ArrayList<String>();

		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		boolean found = false;

		String partialSeq = "";
		String line;
		while ((line = in.readLine()) != null) {
			if(line.equals("")) {
				found = true;
				continue;
			}
			if(found) {
				partialSeq = line;
				break;
			}
			drugList.add(line);
			
		}

		search(drugList , partialSeq);
	}

	private static void search(List<String> drugList, String partialSeq) {
		boolean found = false;
		for(String str : drugList) {
			str = str.toUpperCase();
			partialSeq = partialSeq.toUpperCase();
			if(str.startsWith(partialSeq)) {
				System.out.println(str);
				found = true;
			}
		}
		if(!found)
			System.out.println("<NONE>");

	}
}
