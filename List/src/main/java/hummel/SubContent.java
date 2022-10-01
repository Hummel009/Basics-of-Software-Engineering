package main.java.hummel;

import java.util.*;

public class SubContent {
	public String name;
	public ArrayList<Integer> ids = new ArrayList<>();

	public SubContent(String fname, ArrayList<Integer> fids) {
		name = fname;
		ids = fids;
	}

	@Override
	public String toString() {
		return name + ": " + ids.toString();
	}
}