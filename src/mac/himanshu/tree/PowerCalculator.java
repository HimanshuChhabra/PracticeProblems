package mac.himanshu.tree;

public class PowerCalculator {
	static int base = 2;
	public static void main(String args[]){
	
		int power = 4;
		int result = powerCal(power);
		System.out.println(result);
	}
	
	public static int powerCal(int power){
		if(power == 0){
			return 1;
		}
		else{
			return base*powerCal(power-1);
		}
	}
}
