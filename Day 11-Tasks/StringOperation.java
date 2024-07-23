package Tasks;

public class StringOperation {
	public static String middleSubstringAfterConcatenateAndReverse(String s1, String s2, int length) {
        String concatenated = s1.concat(s2);

        String reversed = new StringBuilder(concatenated).reverse().toString();

        int middleIndex = reversed.length() / 2;

        int startIndex = middleIndex - length / 2;
        
        int endIndex = startIndex + length;

        if (endIndex > reversed.length()) {
            endIndex = reversed.length();
        }

        String middleSubstring = reversed.substring(startIndex, endIndex);

        return middleSubstring;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "Hello";
        String s2 = "World";
        int length = 7;

        String result = middleSubstringAfterConcatenateAndReverse(s1, s2, length);
        System.out.println("Middle substring: " + result); // Expected output: "roWol"
    }
}
