package hackerank.code;
import java.util.*;

public class LuckyPurchase {
	static Map<String,Integer> brands = new HashMap<String,Integer>();
	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String name = in.next();
            int value = in.nextInt();
            boolean flag = check(value);
            if(flag)
            	brands.put(name, value);
        }
        in.close();
        System.out.println(getPurchase(brands));
    }
	private static String getPurchase(Map<String, Integer> brands) {
		int max = Integer.MAX_VALUE;
		String brandName = "-1";
		if(brands.isEmpty())
			return brandName;
		for(Map.Entry<String, Integer> entry : brands.entrySet()){
			if(entry.getValue() < max){
				brandName = entry.getKey();
				max = entry.getValue();
			}
		}
		
		return brandName;
	}
	private static boolean check(int value) {
		int count1 = 0;
		int count2 = 0;
		String val = Integer.toString(value);
		for(int i = 0 ; i < val.length() ; i++){
			if(val.charAt(i) == '4'){
				count1++;
			}else if(val.charAt(i) == '7'){
				count2++;
			}
			else{
				return false;
			}
		}
		
		if(count1 == count2){
			return true;
		}
		
		return false;
	}
}
