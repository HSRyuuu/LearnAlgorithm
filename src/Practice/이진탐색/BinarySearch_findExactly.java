package Practice.이진탐색;

public class BinarySearch_findExactly {
    /**
     * 정확한 값 찾기
     * arr[mid] < target인 경우 left = mid + 1 ,
     * arr[mid] > target인 경우 right = mid - 1
     * arr[mid] == target인 경우 return mid;
     * 즉, arr[mid] == target일 때 바로 해당 mid 값을 반환한다.
     */
    public static int binarySearch_exactly(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                //정확한 값을 찾을 때는 mid에 정확한 값이 들어왔을 때 return
                return mid;
            }
        }
        //원하는 값이 없으면 -1 반환
        return -1;
    }

    public static void main(String[] args) {
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        int target = 6;
        //중복이 없을 때 정확한 값찾기 (mid)
        System.out.println("=== exactly ==");
        System.out.println(binarySearch_exactly(arr2, target));
    }
}
