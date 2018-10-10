package mac.interfaces.practice;

public class Aclass implements functionPointer {

	
	public static void main(String args[]) {
		functionPointer a = new Aclass();
		//a.print();
		testIt(a);
		
		functionPointer b = new Bclass();
		//b.print();
		testIt(b);
	}
	
	@Override
	public void print() {
		System.out.println("Aclass");
	}
	
	public static void testIt(functionPointer obj){
		obj.print();
	}
}

class Bclass implements functionPointer{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Bclass");
	}
	
}
