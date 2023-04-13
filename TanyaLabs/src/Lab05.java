import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Lab05 {
    public static void main(String[] args) throws Exception {
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
        
        List<Integer> result = Stream.concat(c1.stream(), c2.stream()).collect(Collectors.toList());
        
        System.out.println(result);
    }
}