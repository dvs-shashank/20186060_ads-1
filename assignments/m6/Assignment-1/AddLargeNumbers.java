/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    static int a = 0;
    /**
     * converting numbers to digits.
     *
     * @param      number  The number
     *
     * @return     numbers to digit.
     */
    public static LinkedList numberToDigits(String number) {
        LinkedList list = new LinkedList();
        int count = 0;
        while (count < number.length()) {
            int j = count;
            String s = number.substring(j, j + 1);
            int k = Integer.parseInt(s);
            list.add(k);
            count++;
        }
        a = list.getSize();
        return list;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        System.out.println("hi");
        String str = "";
        int count = 0;
        while (count < a) {
            count++;
        }
        return "hiii";
    }

    /**
     * digits to number.
     *
     * @param      list  The list
     *
     * @return     digits to number as string.
     */
    public static String digitsToNumber(LinkedList list) {
        return null;

    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     list after adding.
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return null;
    }

}