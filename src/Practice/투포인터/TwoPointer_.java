package Practice.투포인터;

public class TwoPointer_ {
    /**
     * 연속된 값의 합이 target 인 경우를 찾는다.
     */
    public static int[] twoPointers(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int[] result = {-1, -1};

        while(true){

            if(sum > target){ // sum이 큰 경우 왼쪽 포인터가 가리키는 값을 빼주고, ++
                sum -= arr[left++];
            }else if(right == arr.length){
                break;
            }else { //sum이 작은 경우 오른쪽 포인터를 더해주고 ++
                sum += arr[right++];
            }
            if(sum == target){
                result[0] = left;
                result[1] = right - 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        //부분 합이 target 인 경우를 찾는다.
        System.out.println(twoPointers(arr, 9));
        System.out.println(twoPointers(arr, 14));
    }
}
