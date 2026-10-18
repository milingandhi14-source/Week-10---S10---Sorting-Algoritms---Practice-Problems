
public class p4 {

    static int lowerBound(int[] prices, int target) {
        int left = 0, right = prices.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prices[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int upperBound(int[] prices, int target) {
        int left = 0, right = prices.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prices[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int countInRange(int[] prices, int low, int high) {
        if (low > high) return 0;
        return upperBound(prices, high) - lowerBound(prices, low);
    }

    public static void main(String[] args) {
        int[] prices = {100, 150, 150, 200, 300, 450};
        int low = 150;
        int high = 300;

        int lower = lowerBound(prices, low);
        int upper = upperBound(prices, high);

        System.out.println("Lower bound index: " + lower);
        System.out.println("Upper bound index: " + upper);
        System.out.println("Count: " + (upper - lower));
    }
}
