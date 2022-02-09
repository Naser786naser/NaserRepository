package java_basics;

public class Arrays_practice {

	public static void main(String[] args) {
		int[] myInt = new int[4];
		
		myInt[0] = 1;
		myInt[1] = 10;
		myInt[2] = 13;
		myInt[3] = 18;
		
		System.out.println(myInt [2]);
		for (int i=0; i<myInt.length; i++)
		{
			System.out.println(myInt[i]);
		}
		
		int[] myInt2 = {23,13,6};
		/*
		 * System.out.println(myInt2[2]);
		 * 
		 * for(int x=0; x<myInt2.length; x++) { System.out.println(myInt2[x]); }
		 */
		for( int j :myInt2)
		{
			System.out.println(j);
		}
		
		String[] names = new String[4];
		names[0] = "John";
		names[1] = "Naser";
		names[2] = "Mike";
		names[3] = "Sam";
		//System.out.println(names[2]);
		for(String s :names)
		{
			System.out.println(s);
		}
		
		/*
		 * for(int y=0; y<names.length; y++) { System.out.println(names[y]); }
		 */
		String[] names2= {"Ryan", "Keyan", "Romaisa"};
		/*
		 * for(int i=0; i<names2.length; i++) { System.out.println(names2[i]); }
		 * 
		 * String myString = "Naser is a good guy";
		 */
		
		//System.out.println(myString.toUpperCase());
		/*
		 * String[] parts = myString.split(""); String part1 = parts[0]; // 004 String
		 * part2 = parts[1]; // 034556 System.out.println(part1);
		 * System.out.println(part2);
		 */
		
		
	
		
		

	}

}
