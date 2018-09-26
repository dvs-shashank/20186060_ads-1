import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int count = 0;
		int[] threesome = new int[size];
		for (int i = 0; i < size; i++) {
			threesome[i] = scan.nextInt();
		}
		Arrays.sort(threesome);
		for (int i = 0; i < size - 2; i++) {
			int j = i + 1;
			int k = size - 1;
			while (j < k) {
				if (threesome[i] + threesome[j] + threesome[k] == 0) {
					count++;
					j++;
					k--;
				} else if (threesome[i] + threesome[j] + threesome[k] < 0) {
					j++;
				} else {
					k--;
				}

			}
		}
		System.out.println(count);
	}
}