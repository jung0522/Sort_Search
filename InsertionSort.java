

// InsertionSort 클래스 선언
public class InsertionSort {
    // 삽입 정렬 알고리즘을 수행하는 함수
    public static void insertionSort(int[] arr) {
        // 바깥 루프: 배열의 두 번째 원소부터 마지막 원소까지 반복
        for (int i = 1; i < arr.length; i++) {
            // 현재 인덱스의 값을 key 변수에 저장
            int key = arr[i];
            int j = i - 1;

            // 안쪽 루프: key 값보다 큰 원소들을 오른쪽으로 이동
            while( j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // key 값을 적절한 위치에 삽입
            arr[j + 1] = key;
        }
    }

/*
    // 메인 함수
    public static void main(String[] args) {
        // 정렬할 배열
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        // 정렬 전 배열 출력
        System.out.println("Unsorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        // 삽입 정렬 실행
        insertionSort(arr);

        // 정렬 후 배열 출력
        System.out.println("\nSorted array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
*/