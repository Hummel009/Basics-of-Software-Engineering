package app.entities;

import java.util.List;

public interface ApplicationUser {

	void addPaymentMethod(String paymentMethod, String... args);

	List<String> usePaymentMethod(String paymentMethod);
}
