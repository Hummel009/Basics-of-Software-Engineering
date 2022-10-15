package main.java.hummel;

import java.util.*;

public class Content {
	public Content sub;
	public String name;
	public ArrayList<Integer> ids = new ArrayList<>();

	public Content(String fname, ArrayList<Integer> fids, Content fsub) {
		name = fname;
		ids = fids;
		sub = fsub;
	}

	public Content(String fname, ArrayList<Integer> fids) {
		name = fname;
		ids = fids;
		sub = null;
	}

	@Override
	public String toString() {
		if (sub == null) {
			return name + ": " + ids.toString() + ", sub does not exist.";
		} else {
			return name + ": " + ids.toString() + ", sub: " + sub.toString();
		}
	}
}