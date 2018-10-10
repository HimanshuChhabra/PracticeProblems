package mac.himanshu.practice;

import java.util.LinkedList;


public class Profiler {
	
	public static class StrackTrace{
		String methodName;
		Long startTime;
	}

	private static double endTime;
	private static LinkedList<String> display = new LinkedList<String>();
	private static LinkedList<StrackTrace> stackTrace = new LinkedList<StrackTrace>();
	
	public static void startProfililng() {
		StrackTrace trace = new StrackTrace();
		trace.methodName = Thread.currentThread().getStackTrace()[2].toString();
		trace.startTime = System.currentTimeMillis();
		stackTrace.push(trace);
	}

	public static void stopProfiling() {
		endTime = System.currentTimeMillis();
		StrackTrace trace = stackTrace.pop();
		double result = endTime - trace.startTime;
		display.add(trace.methodName + " -> " + result + " milliseconds");
		if(stackTrace.isEmpty())
			display.add("-------------------------------------------------------------------\n");
	}

	public static void displayProfilingReport() {		
		System.out.println("*********************** Profiler Report *********************** \n");
		display.forEach( value -> System.out.println(value));
	}
	
	/**
	 * Test Cases.
	 */
	
	public static void method1() {
		startProfililng();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		method2();
		stopProfiling();
	}
	
	private static void method2() {
		startProfililng();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		method3();
		stopProfiling();	
	}

	private static void method3() {
		startProfililng();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopProfiling();	
	}

	
	private static void method4() {
		startProfililng();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopProfiling();	
	}

	public static void main(String args[]) {
		method1();
		method4();
		method1();
		method4();
		displayProfilingReport();
	}

}
