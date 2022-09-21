package main.java.hummel;

import java.util.*;

public class Content {
	public String name;
	public ArrayList<Integer> ids = new ArrayList<>();

	public Content(String fname, ArrayList<Integer> fids) {
		name = fname;
		ids = fids;
	}

	@Override
	public String toString() {
		return name + ": " + ids.toString();
	}
}