package app.entities;

import java.util.*;

public class EripImpl implements ApplicationPaymentMethod {

	private static final String ERIP_CODE = "Erip code;";

	public String name = "Erip";

	@Override
	public List<String> getMethodAttributes() {
		ArrayList<String> list = new ArrayList<>();
		list.add(ERIP_CODE);
		return list;
	}

	public void setEripCode(String eripCode) {
	}
}
