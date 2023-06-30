package Practice.이진탐색;

public class BinarySearch_lowerBound {

    /**
     * lower : 원하는 값중 가장 작은 수
     * arr[mid] < target인 경우 left = mid + 1 ,
     * arr[mid] >= target인 경우 right = mid 즉, arr[mid] = target인 경우에도 right = mid 이기때문에
     * 원하는 값이 처음 나오는 인덱스를 탐색하기 때문에 left를 그대로 반환한다.
     */
    public static int binarySearch_lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] < target){
                left = mid + 1;

            }else{
                right = mid;
            }
        }
        //lower bound -> left
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 10};
        int target = 6;
        //lower bound : 가장 인덱스가 작은 6 찾기 (right + 1)
        System.out.println("=== lower bound ==");
        System.out.println(binarySearch_lowerBound(arr, target));
    }
}
