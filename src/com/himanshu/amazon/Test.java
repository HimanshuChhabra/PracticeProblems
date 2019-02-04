package com.himanshu.amazon;

import java.io.*;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) throws IOException {
		HashSet<String> res = new HashSet();
		res.add("hello");
		res.add("hello1");
		String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";
	     
	    FileWriter fileWriter = new FileWriter("/Users/himanshuchhabra/Documents/workspace1/Personal/src/com/himanshu/amazon/gif_input.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    for(String str : res)
	    printWriter.print(str + "\n");
	    printWriter.close();
	}

}
