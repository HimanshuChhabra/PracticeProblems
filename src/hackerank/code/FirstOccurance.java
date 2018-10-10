package hackerank.code;


public class FirstOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2, 3,3};
		System.out.println(firstOccurance(a));
	}
	
	public static int firstOccurance(int[] a){
		int index = 0;
		int result = -1;
		int ans = -1;
		int length = a.length;
		boolean flag = false;
		while(index < length-1){
			int pivot = a[index];
			for(int i=index+1;i< length;i++){
				
				if(a[i] == pivot){
					
					if(!flag){
						result = i;
						flag = true;
					}else if(i < result){
							result = i;
					}
					ans = a[result];
					break;
				}
			}
			if(result == ++index || (result < index && result!= -1 )){
				break;
			}
			//index++;
			
		}
			return ans;
			
	}
	
}
