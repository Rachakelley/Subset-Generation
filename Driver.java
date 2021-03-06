import java.util.*;

public class Driver {
	
	public static void main(String[] args) {
		int n = 0;
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("To generate subsets of the set {0, 1, 2,..., n},\n"
					+ "Enter a positive integer n: ");
			n = input.nextInt();

			int set[] = new int[n];
			for(int i = 1 ; i < n; i++)
				set[i] = i;	
			displaySubsets(set);

		} catch (InputMismatchException e) {
			System.out.println("Invalid input.");
		} finally {
			input.close();
		}
	}

	/**
	 *  Method to print all subsets of the given set[].
	 * @param set[], an array representing the power set
	 */
	static void displaySubsets(int set[]) {
		// subsets of a power set = 2^n - 1
		// 1 << set.length = number of subsets in the set
		for (int i = 0; i < (1 << set.length); i++) {
			StringBuilder sb = new StringBuilder();
			System.out.print("{");
			for (int j = 0; j < set.length; j++) {
				// if result of ith AND jth bit is not 0, add to the subset.
				if ((i & (1 << j)) != 0) {
					sb.append(set[j]);
					sb.append(", ");
				}
			}
			//  if for every set including not the empty set
			if(sb.lastIndexOf(", ") != -1)
				System.out.println(sb.substring(0, sb.lastIndexOf(", ")) + "}");
			else {	// closing bracket for empty set
				System.out.println("}");
			}
		}
	}
}
