package main.java.hummel;

import java.util.*;

public class Content {
	public SubContent sub;
	public String name;
	public ArrayList<Integer> ids = new ArrayList<>();

	public Content(String fname, ArrayList<Integer> fids, SubContent fsub) {
		name = fname;
		ids = fids;
		sub = fsub;
	}

	@Override
	public String toString() {
		return name + ": " + ids.toString() + ", sub: " + sub.toString();
	}
}