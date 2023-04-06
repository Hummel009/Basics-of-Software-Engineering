import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Integer> c1 = new ArrayList<>();
		List<Integer> c2 = new ArrayList<>();
		boolean isC1 = true;

		try (Scanner scanner = new Scanner(new File("input.txt"))) {
			while (scanner.hasNext()) {
				int num = scanner.nextInt();
				if (num < 0) {
					isC1 = false;
					continue;
				}
				if (isC1) {
					c1.add(num);
				} else {
					c2.add(num);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Collections.sort(c1);
		Collections.sort(c2);

		List<Integer> result = new ArrayList<>();
		result.addAll(c1);
		result.addAll(c2);

		System.out.println(result);
	}
}