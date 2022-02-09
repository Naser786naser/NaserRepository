package java_basics;

import java.util.ArrayList;

public class ArrayLists {

	public static void main(String[] args) {
	
		ArrayList<String> a = new ArrayList<String>();
		a.add("Naser");
		a.add("Ahmad");
		a.add("John");
		a.add("Malcomb");
		a.add("Rishi");
		a.add("Mike");
		System.out.println(a.get(3));
		
		for (int i = 0; i<a.size(); i++)
		{
		System.out.println(a.get(i));	
		}
		
		String s = "My name is Naser";
		for(int i=s.length() -1; i>=0; i--)
		{
			System.out.println(s.charAt(i));
		}
		
	
		
		

	}

}
