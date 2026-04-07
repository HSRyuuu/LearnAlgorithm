package problem_solving.stack_and_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import static common.Grader.grade;

/**
 * @문제명: 다리를 지나는 트럭
 * @Tear: Lv2
 * @Algorithm: Queue
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class LV2_다리를_지나는_트럭 {

    public static void main(String[] args) {

        // situation1: 일반 케이스 - 트럭 4대, 다리 길이 2
        int bridgeLength1 = 2;
        int weight1 = 10;
        int[] truckWeights1 = {7, 4, 5, 6};
        int expected1 = 8;
        int result1 = solution(bridgeLength1, weight1, truckWeights1);
        grade(1, "트럭 4대, 다리 길이 2, 최대 무게 10", expected1, result1);

        // situation2: 엣지 케이스 - 트럭 1대
        int bridgeLength2 = 100;
        int weight2 = 100;
        int[] truckWeights2 = {10};
        int expected2 = 101;
        int result2 = solution(bridgeLength2, weight2, truckWeights2);
        grade(2, "트럭 1대, 다리 길이 100", expected2, result2);

        // situation3: 엣지 케이스 - 동일 무게 트럭 다수
        int bridgeLength3 = 100;
        int weight3 = 100;
        int[] truckWeights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int expected3 = 110;
        int result3 = solution(bridgeLength3, weight3, truckWeights3);
        grade(3, "동일 무게 트럭 10대, 다리 길이 100", expected3, result3);

        // situation4: 엣지 케이스 - 다리 길이 1, 무거운 트럭
        int bridgeLength4 = 1;
        int weight4 = 5;
        int[] truckWeights4 = {5, 5, 5};
        int expected4 = 4;
        int result4 = solution(bridgeLength4, weight4, truckWeights4);
        grade(4, "다리 길이 1, 트럭 3대 모두 최대 무게", expected4, result4);
    }

    /**
     * TODO: 이 메서드를 구현하세요!
     *
     * @param bridge_length 다리에 올라갈 수 있는 트럭 수
     * @param weight        다리가 견딜 수 있는 최대 무게
     * @param truck_weights 트럭별 무게 배열 (건너는 순서대로)
     * @return 모든 트럭이 다리를 건너는 최소 시간(초)
     */
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 여기에 풀이를 작성하세요
        // 1. 순서대로
        // 2. weight "이하"까지 가능
        // 3. bridge_length = 다리에 올라갈 수 있는 트럭 수 / weight = 견딜 수 있는 무게
        Queue<Integer> waitingQueue = new LinkedList<>();
        Arrays.stream(truck_weights).forEach(waitingQueue::add);

        Queue<Integer> bridgeQueue = new LinkedList<>();


        int time = 0;
        int arrivedTruck = 0;
        int bridgeWeight = 0;

        while (arrivedTruck < truck_weights.length) {
            time++;
            int next = Optional.ofNullable(waitingQueue.peek()).orElse(0);

            // 다리가 가득 차있는 경우 = 하나 빠지면 올라갈 수 있는지 확인
            if (bridgeQueue.size() == bridge_length) {
                next -= Optional.ofNullable(bridgeQueue.peek()).orElse(0);
            }
            //트럭이 올라갈 수 있는 경우
            if (bridgeQueue.size() <= bridge_length && next + bridgeWeight <= weight) {
                Integer truck = Optional.ofNullable(waitingQueue.poll()).orElse(0);
                bridgeWeight += truck;
                bridgeQueue.add(truck);
            } else {
                // 올라갈 수 없으면 빈칸
                bridgeQueue.add(0);
            }

            if (bridgeQueue.size() > bridge_length) {
                int out = bridgeQueue.poll();
                if (out != 0) {
                    bridgeWeight -= out;
                    arrivedTruck++;
                }
            }


        }

        return time;
    }
}
