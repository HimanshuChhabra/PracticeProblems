package mac.himanshu.practice;

import java.util.*;

public class TestIt {

	public static void main(String[] args) {
			List l = new ArrayList();
			l.add(1);
			l.add(5);
			l.add(4);
			l.add(0, 0);
			Collections.sort(l);
			System.out.println(l);
			Iterator i = l.iterator();
			while(i.hasNext())
			{  
				String x = i.next().toString();
				if(x != "7")
				{
					System.out.println(x);
					i.remove();
					
				}
			}
System.out.println(l.size());
l.clear();
Scanner s = new Scanner(System.in);
String se = "sd,ddf,fff,ff,f";
String d[]=se.split(",");
System.out.println(d[1]+"  "+d[2]);
int val = 4;
while(val>0)
{
	val --;
	
	l.add(s.nextInt());
}
	System.out.println(l);
	}

}
