
public class QuickSort {
    // 퀵 정렬 알고리즘을 수행하는 함수
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗을 기준으로 배열을 분할하고 피벗 인덱스를 반환
            int pivotIndex = partition(arr, low, high);
            // 피벗을 기준으로 왼쪽 부분 배열을 정렬
            quickSort(arr, low, pivotIndex - 1);
            // 피벗을 기준으로 오른쪽 부분 배열을 정렬
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 배열을 피벗 기준으로 나누는 메서드
    private static int partition(int[] array, int left, int right) {
        int pivot = array[right]; // 오른쪽 끝 요소를 피벗으로 선택
        int i = left - 1; // i는 피벗보다 작은 값이 쌓일 마지막 위치를 가리킴

        // left부터 right - 1까지 반복하며 피벗보다 작은 요소들을 피벗의 왼쪽으로 이동
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) { // 피벗보다 작은 요소를 발견하면
                i++; // i를 증가시키고
                swap(array, i, j); // 현재 요소와 i 위치 요소를 교환하여 작은 값을 앞으로 이동
            }
        }

        // 최종적으로 피벗을 i+1 위치로 이동하여 피벗을 기준으로 배열을 나눔
        swap(array, i + 1, right); // 피벗을 정확한 위치로 이동
        return i + 1; // 피벗 인덱스 반환 (피벗 기준으로 왼쪽은 작고, 오른쪽은 큼)
    }


    // 두 배열 원소를 서로 교환하는 함수
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}