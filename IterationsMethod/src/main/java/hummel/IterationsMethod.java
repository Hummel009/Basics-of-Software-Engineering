package main.java.hummel;

import java.text.DecimalFormat;
import java.util.Arrays;

public class IterationsMethod {
	public static final int MAX_ITERATIONS = 10000;

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
			M[i][10] = 19*(i+1) + 171;
		}
		method = new IterationsMethod(M, true);
		System.out.println(
				"\u0421\u0440\u0430\u0432\u043D\u0435\u043D\u0438\u0435 \u043C\u0435\u0442\u043E\u0434\u043E\u0432 \u044F\u043A\u043E\u0431\u0438 \u0438 \u0413\u0430\u0443\u0441\u0441\u0430-\u0417\u0435\u0439\u0434\u0435\u043B\u044F \u0434\u043B\u044F \u0440\u0435\u0448\u0435\u043D\u0438\u044F \u0421\u041B\u0410\u0423");
		System.out.println();
		System.out.println(
				"\u0418\u0441\u0445\u043E\u0434\u043D\u0430\u044F \u043C\u0430\u0442\u0440\u0438\u0446\u0430:");
		System.out.println();
		method.print();
		System.out.println();
		System.out.println(
				"\u0418\u0442\u0435\u0440\u0430\u0446\u0438\u0438 \u043F\u0440\u0438 \u043C\u0435\u0442\u043E\u0434\u0435 \u042F\u043A\u043E\u0431\u0438:");
		System.out.println();
		method.solve();
		System.out.println();
		System.out.println(
				"\u0418\u0442\u0435\u0440\u0430\u0446\u0438\u0438 \u043F\u0440\u0438 \u043C\u0435\u0442\u043E\u0434\u0435 \u0417\u0435\u0439\u0434\u0435\u043B\u044F-\u0413\u0430\u0443\u0441\u0441\u0430:");
		System.out.println();
		method = new IterationsMethod(M, false);
		method.solve();
	}

	public double[][] M;
	public boolean isJacobi;

	public IterationsMethod(double[][] matrix, boolean jacobi) {
		M = matrix;
		isJacobi = jacobi;
	}

	public boolean makeDominant() {
		boolean[] visited = new boolean[M.length];
		int[] rows = new int[M.length];
		Arrays.fill(visited, false);
		return transformToDominant(0, visited, rows);
	}

	public void print() {
		int n = M.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				final String result = new DecimalFormat("#.#####").format(M[i][j]);
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
			for (int i = 0; i < n && stop; i++) {
				if (Math.abs(X[i] - P[i]) > epsilon) {
					stop = false;
				}
			}
			if (stop || iterations == MAX_ITERATIONS) {
				break;
			}
			P = X.clone();
		}
	}

	public boolean transformToDominant(int r, boolean[] V, int[] R) {
		int n = M.length;
		if (r == M.length) {
			double[][] T = new double[n][n + 1];
			for (int i = 0; i < R.length; i++) {
				for (int j = 0; j < n + 1; j++) {
					T[i][j] = M[R[i]][j];
				}
			}
			M = T;
			return true;
		}
		for (int i = 0; i < n; i++) {
			if (V[i]) {
				continue;
			}
			double sum = 0;
			for (int j = 0; j < n; j++) {
				sum += Math.abs(M[i][j]);
			}
			if (2 * Math.abs(M[i][r]) > sum) {
				V[i] = true;
				R[r] = i;
				if (transformToDominant(r + 1, V, R)) {
					return true;
				}
				V[i] = false;
			}
		}
		return false;
	}
}