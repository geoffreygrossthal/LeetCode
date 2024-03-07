import java.util.PriorityQueue;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] array1 = {1,2,4,5,6,0};
        int num1 = 5;
        int[] array2 = {3};
        int num2 = 1;

        merge(array1, num1, array2, num2);

        for (int i = 0; i < array1.length; ++i) {
            System.out.print(array1[i] + " ");
        }
    }
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //Indexes of nums1 and nums2
        int i = 0;
        //To store elements that need to be isnerted
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        //Continue while either array has elements to merger
        while (i < m + n) {
            //Both arrays have elements to merge
            if (i < m && i < n) {
                //Merge nums1[i], add nums2[i] to the queue
                if (nums1[i] < nums2[i] && (priorityQueue.isEmpty() || nums1[i] <= priorityQueue.peek())) {
                    priorityQueue.add(nums2[i]);
                }
                //Merge nums[2], add nums[i] to queue
                else if (priorityQueue.isEmpty() || nums2[i] <= priorityQueue.peek()) {
                    priorityQueue.add(nums1[i]);
                    nums1[i] = nums2[i];
                }
                //Priorty queue has the lowest merge it, and insert num1[i]/num[i] into queue
                else {
                    priorityQueue.add(nums1[i]);
                    nums1[i] = priorityQueue.poll();
                    priorityQueue.add(nums2[i]);
                }
            }
            //nums1 has elements left to merge 
            else if (i < m) {
                //No more elements to merge return
                if (priorityQueue.isEmpty())
                    return;
                //Merge queue
                if (!priorityQueue.isEmpty() && priorityQueue.peek() < nums1[i]) {
                    priorityQueue.add(nums1[i]);
                    nums1[i] = priorityQueue.poll();
                }
            }
            //nums2 has elements left to merge
            else if (i < n) {
                //Merge nums2
                if (priorityQueue.isEmpty() || priorityQueue.peek() > nums2[i]) {
                    nums1[i] = nums2[i];
                }
                //Merge queue
                else {
                    nums1[i] = priorityQueue.poll();
                    priorityQueue.add(nums2[i]);
                }
            }
            //Queue has elements left to merge
            else {
                nums1[i] = priorityQueue.poll();
            }
            ++i;
        }
    }
}
