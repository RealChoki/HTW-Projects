public class SumCalculator {
    public static int computeSum(int n) {
        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Summe für n = " + n + ": " + computeSum(n));

        n = 10;
        System.out.println("Summe für n = " + n + ": " + computeSum(n));
    }
}
