
public class HeapSort {
    // 힙 정렬 알고리즘을 수행하는 함수
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 배열에서 부모 노드부터 루트 노드까지 반복하여 최대 힙을 만듦
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 배열의 끝부터 시작하여 원소를 정렬
        for (int i = n - 1; i >= 0; i--) {
            // 현재 루트 노드와 마지막 노드를 교환
            swap(arr, 0, i);
            // 남은 원소들을 대상으로 최대 힙을 유지
            heapify(arr, i, 0);
        }
    }

    // 힙 구조를 유지하는 메서드
    private static void heapify(int[] array, int n, int rootIndex) {
        int largest = rootIndex; // 루트를 가장 큰 값으로 가정
        int leftChild = 2 * rootIndex + 1; // 왼쪽 자식
        int rightChild = 2 * rootIndex + 2; // 오른쪽 자식

        // 왼쪽 자식이 루트보다 크면 largest 업데이트
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // 오른쪽 자식이 largest보다 크면 largest 업데이트
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // largest가 루트가 아니면 교환하고 재귀적으로 힙 구조 유지
        if (largest != rootIndex) {
            swap(array, rootIndex, largest);
            heapify(array, n, largest);
        }
    }

    // 두 배열 원소를 서로 교환하는 함수
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}