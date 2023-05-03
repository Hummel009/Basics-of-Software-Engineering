package app.entities;

import java.util.*;

public class ApplicationUserImpl implements ApplicationUser {

	public String name = "";

	public Map<String, List<String>> paymentMethods = new HashMap<>();

	public ApplicationUserImpl(String name) {
		this.name = name;
	}

	@Override
	public void addPaymentMethod(String paymentMethod, String... args) {
		paymentMethods.put(paymentMethod, Arrays.asList(args));
	}

	@Override
	public List<String> usePaymentMethod(String paymentMethod) {
		return paymentMethods.get(paymentMethod);
	}
}
