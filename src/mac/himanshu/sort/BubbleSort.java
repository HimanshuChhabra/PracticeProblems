package mac.himanshu.sort;

public class BubbleSort implements SortIntegers{

	public  void sort(int input[]){
		try{
			for(int i= 0 ; i < input.length ; i ++){
				for(int j = 0 ; j < input.length - 1 ; j ++){
					if(input[j] > input[j+1]){
						int temp = input[j];
						input[j] = input[j+1];
						input[j+1] = temp;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
