package serializationanddeserialization;

public class Test {
	
	int i;
	
	
	public int getI()
	{
		return i;
	}
	
	public void setI(int a)
	{
		i = a;
	}
	
	public static void main(String[] args) {
		
		Test t = new Test();
		
		t.setI(20);
		
		System.out.println(t.getI());
		
	}

}
