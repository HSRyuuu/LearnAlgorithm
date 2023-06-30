package Practice.이진탐색;

public class BinarySearch_upperBound {
    /**
     * upperbound : 원하는 값중 가장 큰수
     * arr[mid] > target인 경우 right = mid
     * arr[mid] <= target인 경우 left = mid + 1 , 즉, arr[mid] = target인 경우에도 mid+1 하기때문에
     * left에 원하는 값보다 큰 수중에 가장 작은 수가 도출되서, 답은 left - 1이다.
     */
    public static int binarySearch_upperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] > target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        //upperbound -> left-1이 답
        return left - 1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 10};
        int target = 6;
        //upper bound : 가장 인덱스가 큰 6 찾기 (left - 1)
        System.out.println("=== upper bound ==");
        System.out.println(binarySearch_upperBound(arr, target));
    }
}
