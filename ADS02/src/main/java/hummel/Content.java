package main.java.hummel;

import java.util.*;

public class Content {
	public List<Content> cSub = new ArrayList<>();
	public List<Integer> cIds = new ArrayList<>();
	public String cName;

	public Content(String fName, List<Integer> fIds,  List<Content> fSub) {
		cName = fName;
		cIds = fIds;
		cSub = fSub;
	}

	public Content(String fname, List<Integer> fids) {
		cName = fname;
		cIds = fids;
		cSub = null;
	}

	@Override
	public String toString() {
		if (cSub == null) {
			return cName + ": " + cIds.toString() + ", sub does not exist.";
		} else {
			String s = cName + ": " + cIds.toString() + ", subs:\n";
			for (Content c: cSub) {
				s+= c.toString() + "\n";
			}
			return s;
		}
	}
}