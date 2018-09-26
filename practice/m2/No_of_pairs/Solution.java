import java.util.*;

class NumOfPairs {
	/**
	 * Constructs the object.
	 */
	NumOfPairs() {

	}
	public int numOfPairs(int[] intArray) {
		int j;
		int count = 0;
		int total = 0;
		for (int i = 0; i < intArray.length - 1; i++) {
			j = i + 1;
			if (intArray[i] == intArray[j]) {
				count++;
			}
			if (i == intArray.length - 2 || intArray[i] != intArray[j]) {
				total += (count + 1) * (count) / 2;
			}
		}
		return total;
	}

}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int  size = scan.nextInt();
		int[] intArr = new int[size];
		for (int i = 0; i < size; i++) {
			intArr[i] = scan.nextInt();
		}
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		NumOfPairs obj = new NumOfPairs();
		System.out.println(obj.numOfPairs(intArr));
	}
}



// 4th october - interview 1
// 15th november - interview 2
// 7th feb - interview 3
// 28th march - interview 4
// 14th june - interview 5 