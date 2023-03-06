package hummel;

public class Lab0101 {
	public static void launch() {
		double x = 0.6;
		while (x <= 1.1) {
			for (int n = 10; n <= 15; n++) {
				double sum = 0;
				for (int k = 1; k <= n; k++) {
					double termR1 = Math.exp(1.2 * k);
					double termR2 = (k - 10) / (k + 30);
					double termR3 = Math.sqrt(k * Math.exp(Math.log(n + 5) / 3));
					double termR4 = Math.log(Math.sqrt(n * x));
					double numerator = Math.exp(Math.log(termR1 + termR2) / k);
					double denominator = termR3 + termR4;
					sum += numerator / denominator;
				}
				double termL1 = Math.exp(n * x) / 2;
				double termL2 = Math.exp(Math.log(n * x) / 3);
				double f = sum + Math.exp(Math.log(termL1 + termL2) / 3);
				System.out.println("X = " + x + ", N = " + n + ", F = " + f);
			}
			x += 0.1;
		}
	}
}