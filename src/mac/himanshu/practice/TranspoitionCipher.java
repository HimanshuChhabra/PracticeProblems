package mac.himanshu.practice;
import java.util.*;

public class TranspoitionCipher {

	public static void main(String[] args) {
		try{
			Scanner s = new Scanner(System.in);
			int testcases = Integer.parseInt(s.nextLine());
			List<String> subsList = null;
			List<String> answer = new ArrayList<String>();
			char alpha = 'A';
			while(testcases > 0){
				String keyword = s.nextLine();
				String cipher = s.nextLine();
				subsList = new ArrayList<String>();
				int i =0;
				while(i < keyword.length()){
					if(!subsList.contains(keyword.charAt(i)+"")){
						subsList.add(keyword.charAt(i)+"");
					}
					i++;
				}
				i = 0;
				while (alpha != '['){
					if(i==subsList.size()){
						i=0;
					}
					if(!keyword.contains(alpha+"")){
					subsList.set(i, subsList.get(i)+alpha+"");
					i++;
					alpha++;
					}
					else
					{
						alpha++;
					}
				}
				Collections.sort(subsList);
				alpha = 'A';
				HashMap<String,String> relation = new HashMap<String,String>();
				Iterator<String> it = subsList.iterator();
				while(it.hasNext()){
					String str = it.next();
					int counter = 0;
					while(counter < str.length()){
						relation.put(str.charAt(counter)+"", alpha+"");
						counter++;
						alpha++;
					}
			
				}
				String ans = "";
				int counter = 0;
				while(counter < cipher.length()){
					String space = cipher.charAt(counter)+"";
					if(space.equals(" ")){
						ans+=" ";
					}
					else{
						ans+=relation.get(cipher.charAt(counter)+"");
					}
					counter++;
				}
				alpha='A';
				answer.add(ans);
				subsList.clear();
				relation.clear();
				testcases--;
			}
			Iterator<String> i = answer.iterator();
			while(i.hasNext())
			{
				System.out.println(i.next());
			}
			s.close();
		}
		catch(Exception e){
			
		}
	}

}
