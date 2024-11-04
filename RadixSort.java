
public class RadixSort {
    // 기수 정렬 알고리즘을 수행하는 함수
    public static void radixSort(int[] arr) {
        int max = getMax(arr); // 배열의 최대값을 찾음
        // 1의 자리부터 최대 자릿수까지 반복하여 계수 정렬 수행
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // 배열에서 최대값을 찾는 함수
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 기수 정렬에서 각 자릿수에 대해 계수 정렬을 수행하는 함수
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // 정렬된 결과를 저장할 배열
        int[] count = new int[10]; // 각 자릿수의 빈도를 저장할 배열
        Arrays.fill(count, 0); // count 배열을 0으로 초기화

        // 각 원소의 해당 자릿수를 기준으로 빈도를 셈
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10;
            count[index]++;
        }

        // 누적 합을 계산하여 count 배열을 업데이트
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // output 배열에 원소를 올바른 위치에 넣음
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        // 정렬된 결과를 원래 배열에 복사
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}