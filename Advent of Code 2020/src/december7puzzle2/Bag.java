package december7puzzle2;

import java.util.ArrayList;

public class Bag {
	public String name = "invalid";
	public ArrayList<Pair> children = new ArrayList<Pair>();
	
	Bag(String name, ArrayList<Pair> children) {
		this.name = name;
		this.children = children;
	}
	
	Bag() {
		
	}
	
	public int getCount() {
		int total = 0;
		for (Pair p : children) {
			total += p.count;
		}
		return total;
	}
}
