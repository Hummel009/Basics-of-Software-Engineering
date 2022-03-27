package main.java.hummel;

import java.util.Arrays;

public class IterationsMethod {
	public static final int MAX_ITERATIONS = 10000;
	public double[][] M;
	public boolean isJacobi;
	public IterationsMethod(double[][] matrix, boolean jacobi) {
		M = matrix;
		isJacobi = jacobi;
	}

	public static void main(String[] args) {
		double[][] M;
		IterationsMethod jacobi;
		System.out.println("JACOBI");
		System.out.println();
		M = new double[10][11];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == j) {
					M[i][j] = 20;
				} else {
					M[i][j] = 1;
				}
			}
			M[i][10] = 19 * i + 142.0;
		}
		jacobi = new IterationsMethod(M, true);
		jacobi.print();
		System.out.println();
		jacobi.solve();
		System.out.println();
		System.out.println("SEIDEL-HAUSS");
		System.out.println();
		jacobi = new IterationsMethod(M, false);
		jacobi.print();
		System.out.println();
		jacobi.solve();
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
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solve() {
		int iterations = 0;
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
			System.out.print("X_" + iterations + " = {");
			for (int i = 0; i < n; i++) {
				System.out.print(X[i] + " ");
			}
			System.out.println("}");
			if (iterations != 0) {
				System.out.println("||X(" + iterations + ")-X(" + (iterations-1) + ")|| = " + Math.abs(X[0] - P[0]));
			}
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