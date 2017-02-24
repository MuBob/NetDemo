package test;

public class Test {
	public static void main(String args[]) {
		int i = 0;
		MyMath mymath = new MyMath();
		for (i = 2; i <= 200; i++)
			if (mymath.iszhishu(i) == true)
				System.out.println(i);
		
		
		
		
		
		
//		MyMath mymath = new MyMath();
	
		
		
	}

		
		
		
}

class MyMath {
	public int f(int x) {
		if (x == 1 || x == 2)
			return 1;
		else
			return f(x - 1) + f(x - 2);
	}

	public boolean iszhishu(int x) {
		for (int i = 2; i <= x / 2; i++)
			if (x % 2 == 0)
				return false;
		return true;
	}

}
