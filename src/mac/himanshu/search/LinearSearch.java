package mac.himanshu.search;

public class LinearSearch implements SearchElement {

	@Override
	public int search(int input[],int element) {
		
		for(int i = 0 ; i < input.length ; i++ ){
			if(input[i] == element){
				return i;
			}
		}
		return -1;
	}
}
