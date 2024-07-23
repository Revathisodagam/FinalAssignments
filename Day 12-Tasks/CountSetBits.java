package bitwiseTasks;

public class CountSetBits {
	public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1; 
            num >>= 1;       
        }
        return count;
    }

    public static int countTotalSetBits(int n) {
        int total_count = 0;
        for (int i = 1; i <= n; i++) {
            total_count += countSetBits(i);
        }
        return total_count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Total set bits from 1 to " + n + ": " + countTotalSetBits(n));
    }
}
