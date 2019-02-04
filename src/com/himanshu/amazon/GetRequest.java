package com.himanshu.amazon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GetRequest {

	public static void main(String[] args) {

		getRequest("filename");
	}

	// 5 Get, 6 , Path, 8th 200;
	public static void getRequest(String filename) {
		// to maintain unique results
		HashSet<String> gifFiles = new HashSet<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"/Users/himanshuchhabra/Documents/workspace1/Personal/src/com/himanshu/amazon/input.txt"));

			PrintWriter pWriter = null;
			String outputFileName = "/Users/himanshuchhabra/Documents/workspace1/Personal/src/com/himanshu/amazon/gifs_input.txt";
			File file = new File(outputFileName);
			// if file already exists over-write it or create a new file
			if (file.exists() || file.createNewFile()) {
				FileWriter fWriter = new FileWriter(outputFileName);
				pWriter = new PrintWriter(fWriter);

			}
			String inputLine = br.readLine();
			// read next line by line
			while (inputLine != null) {
				String line[] = inputLine.split(" ");
				if (line.length >= 10) {
					String requestType = line[5].substring(1);
					String path = line[6];
					String statusCode = line[8];

					if (requestType.equals("GET") && statusCode.equals("200")) {
						String[] patharr = path.split("/");
						String fileName = "";//patharr[patharr.length - 1];
						String[] extractExtension = fileName.split("\\.");

						if (extractExtension.length > 0
								&& extractExtension[extractExtension.length - 1].equalsIgnoreCase("gif")) {
							if (gifFiles.add(fileName) && pWriter != null) {
								pWriter.print(fileName + "\n");
							}
						}
					}
				}

					inputLine = br.readLine();
			}
			br.close();
			pWriter.close();
		} catch (IOException e) {
		}

		/*
		 * try { String outputFileName =
		 * "/Users/himanshuchhabra/Documents/workspace1/Personal/src/com/himanshu/amazon/gifs_input.txt";
		 * File file = new File(outputFileName); // if file already exists over-write it
		 * or create a new file if (file.exists() || file.createNewFile()) { FileWriter
		 * fWriter = new FileWriter(outputFileName); PrintWriter pWriter = new
		 * PrintWriter(fWriter); for (String str : gifFiles) pWriter.print(str + "\n");
		 * pWriter.close();
		 * 
		 * }
		 * 
		 * } catch (IOException e) {
		 * 
		 * }
		 */

	}

}
