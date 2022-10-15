package main.java.hummel;

import java.util.*;

public class Content {
	public ArrayList<Content> sub = new ArrayList<>();
	public ArrayList<Integer> ids = new ArrayList<>();
	public String name;

	public Content(String fname, ArrayList<Integer> fids,  ArrayList<Content> fsub) {
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
			String s = name + ": " + ids.toString() + ", subs:\n";
			for (Content c: sub) {
				s+= c.toString() + "\n";
			}
			return s;
		}
	}
}