package mac.himanshu.practice;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 public class Demo {

    public static void main(String[] args) {
        	Scanner s = new Scanner(System.in);
	    NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(3);
		int n =s.nextInt();
		int b = s.nextInt();
		int k;
		double x,y,z;
		String x1,y1,z1;
		HashMap<Integer,String> kmap = new HashMap<Integer,String>();
		HashMap<Double, Integer> zmap = new HashMap<Double,Integer>();
		List<Double> zvalue=new ArrayList<Double>();
		HashMap<Integer,String> bucket = new HashMap<Integer,String>();
		List<String> query=new ArrayList<String>();
		for(int i =0;i< n ;i++){
			 k = s.nextInt();
			 x=s.nextDouble();
			 x=new BigDecimal(x).setScale(3,RoundingMode.HALF_UP).doubleValue();
			 y=s.nextDouble();
			 y=new BigDecimal(y).setScale(3,RoundingMode.HALF_UP).doubleValue();
			 z=s.nextDouble();
			 z=new BigDecimal(z).setScale(3,RoundingMode.HALF_UP).doubleValue();
			 x1=nf.format(x);
			 y1=nf.format(y);
			 z1=nf.format(z);
			 String value = "("+x1+","+y1+","+z1+")";
			 kmap.put(k, value);
			 zmap.put(z, k);
			 zvalue.add(z);
		}
		
		while(s.hasNext()){
            query.add(s.nextLine());
        }
		query.remove(0);
		Collections.sort(zvalue);
		Collections.reverse(zvalue);
		int i=0;
		while(i<b){
			bucket.put(zmap.get(zvalue.get(i)),kmap.get(zmap.get(zvalue.get(i))));
			i++;
		}
		int index =0;
		int len = query.size();
       while(index < len){
    	   String ch = query.get(index).charAt(0)+"";
    	   if(ch.equalsIgnoreCase("F")){
    		   int fetch = Integer.parseInt(query.get(index).charAt(2)+"");
    		   if(bucket.containsKey(fetch)){
    			   System.out.println(fetch+" = "+bucket.get(fetch));
    		   }
    		   else{
    			   System.out.println("Point doesn’t exist in the bucket.");
    		   }
    	   }
    	   else{
    		   if(i< kmap.size()){
    		   int remove = Integer.parseInt(query.get(index).charAt(2)+"");
    		   if(bucket.containsKey(remove)){
    			   bucket.remove(remove);
    			   System.out.println("Point id "+remove+" removed.");
    				   bucket.put(zmap.get(zvalue.get(i)),kmap.get(zmap.get(zvalue.get(i))));
    				   i++;
    		   }
    		   else{
    			   System.out.println("Point doesn't exist in the bucket.");
    		   }
    		  }
    		   else{
    			   System.out.println("No more points can be deleted.");
    		   }
    	   }
    	   index++;
     }
    }
}