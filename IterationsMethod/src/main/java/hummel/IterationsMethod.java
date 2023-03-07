package hummel;

import java.text.DecimalFormat;
import java.util.Arrays;

public class IterationsMethod {
	public static final int MAX_ITERATIONS = 10000;
	public double[][] M;
	public boolean isJacobi;

	public IterationsMethod(double[][] matrix, boolean jacobi) {
		M = matrix;
		isJacobi = jacobi;
	}

	public void print() {
		int n = M.length;
		for (double[] doubles : M) {
			for (int j = 0; j < n + 1; j++) {
				final String result = new DecimalFormat("#.#####").format(doubles[j]);
				System.out.print(result + " ");
			}
			System.out.println();
		}
	}

	public void solve() {
		int iterations;
		if (isJacobi) {
			iterations = 1;
		} else {
			iterations = 0;
		}
		int n = M.length;
		double epsilon = 1e-4;
		double[] X = new double[n];
		double[] P = new double[n];
		Arrays.fill(X, 0);
		if (isJacobi) {
			Arrays.fill(P, 0);
		}
		while (true) {
			for (int i = 0; i < n; i++) {
				double sum = M[i][n];
				for (int j = 0; j < n; j++) {
					if (j != i) {
						if (isJacobi) {
							sum -= M[i][j] * P[j];
						} else {
							sum -= M[i][j] * X[j];
						}
					}
				}
				X[i] = 1 / M[i][i] * sum;
			}
			System.out.print("K = " + iterations + "; X: ");
			for (int i = 0; i < n; i++) {
				final String result = new DecimalFormat("#.#####").format(X[i]);
				System.out.print(result + "; ");
			}
			System.out.println();
			if (iterations != 0) {
				final String result = new DecimalFormat("#.#####").format(Math.abs(X[0] - P[0]));
				System.out.println("||X(" + iterations + ")-X(" + (iterations - 1) + ")|| = " + result);
			}
			System.out.println();
			iterations++;
			if (iterations == 1) {
				continue;
			}
			boolean stop = true;
			for (int i = 0; i < n; i++) {
				if (Math.abs(X[i] - P[i]) > epsilon) {
					stop = false;
					break;
				}
			}
			if (stop || iterations == MAX_ITERATIONS) {
				break;
			}
			P = X.clone();
		}
	}

	public static void main(String[] args) {
		double[][] M;
		IterationsMethod method;
		M = new double[10][11];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == j) {
					M[i][j] = 20;
				} else {
					M[i][j] = 1;
				}
			}
			M[i][10] = 19 * (i + 1) + 171;
		}
		method = new IterationsMethod(M, true);
		System.out.println("Comparison of Jacobi and Gauss-Seidel methods for System of linear equations");
		System.out.println();
		System.out.println("Source matrix:");
		System.out.println();
		method.print();
		System.out.println();
		System.out.println("Jacobi Iterations:");
		System.out.println();
		method.solve();
		System.out.println();
		System.out.println("Seidel-Gauss Iterations:");
		System.out.println();
		method = new IterationsMethod(M, false);
		method.solve();
	}
}