package app.entities;

import java.util.*;

public class PayPalImpl implements ApplicationPaymentMethod {

	private static final String OWNER_ID = "Owner id;";

	private static final String RECEIVER_ID = "Receiver id";
	public String name = "Paypal";

	@Override
	public List<String> getMethodAttributes() {
		ArrayList<String> list = new ArrayList<>();
		list.add(OWNER_ID);
		list.add(RECEIVER_ID);
		return list;
	}

	public void setOwnerId(String ownerId) {
	}

	public void setReceiverId(String receiverId) {
	}
}
