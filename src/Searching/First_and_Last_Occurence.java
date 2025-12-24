package Searching;
import java.util.*;
public class First_and_Last_Occurence {
        public static int[] searchRange(int[] nums, int target) {
            int first = findFirst(nums, target);
            int last = findLast(nums, target);
            return new int[]{first, last};
        }

        static int findFirst(int[] arr, int x) {
            int low = 0, high = arr.length - 1, first = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == x) {
                    first = mid;
                    high = mid - 1; // Move left
                } else if (arr[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return first;
        }

        static int findLast(int[] arr, int x) {
            int low = 0, high = arr.length - 1, last = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == x) {
                    last = mid;
                    low = mid + 1; // Move right
                } else if (arr[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return last;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the number of elements:");
            int n = sc.nextInt();

            System.out.println("Enter sorted elements:");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println("Enter target:");
            int target = sc.nextInt();

            int[] result = searchRange(nums, target);
            System.out.println(Arrays.toString(result)); // Output format: [firstIndex, lastIndex]
        }
    }
