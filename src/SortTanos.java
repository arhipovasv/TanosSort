public class SortTanos {

    static int[] tanosSort(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums;
        int head = 0;
        int tail = nums.length - 1;
        int [] sortAvg = new int[nums.length];
        int avg = average(nums);
        for (int j : nums) {
            if (avg >= j) {
                sortAvg[head] = j;
                head = head + 1;
            }
            else {
                sortAvg[tail] = j;
                tail = tail - 1;
            }
        }
        if (head == n) {
            head = head - 1;
        }
        int[] l = new int[head];
        int[] r = new int[nums.length - head];
        for (int i = 0; i < nums.length; i++) {
            if (i < head) l[i] = sortAvg[i];
            else r[i - head] = sortAvg[i];
        }
        int[] sortR = tanosSort(r);
        int[] sortL = tanosSort(l);
        return union(sortR, sortL);
    }

    static int[] union(int[] r, int[] l) {
        int size = r.length + l.length;
        int[] union = new int[size];
        for (int i = 0; i < size; i++) {
            if (i < l.length) union[i] = l[i];
            else  union[i] = r[i - l.length];
        }
        return union;
    }
    static int average(int[] nums) {
        int sum = sum(nums);
        return sum / nums.length;
    }

    static int sum (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        return sum;
    }
}
