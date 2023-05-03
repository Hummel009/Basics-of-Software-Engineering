package app.entities;

import java.util.*;

public class CardImpl implements ApplicationPaymentMethod {

	private static final String CARD_NUMBER = "Card number;";

	public String name = "Card";

	@Override
	public List<String> getMethodAttributes() {
		ArrayList<String> list = new ArrayList<>();
		list.add(CARD_NUMBER);
		return list;
	}

	public void setCardNumber(String number) {
	}
}
