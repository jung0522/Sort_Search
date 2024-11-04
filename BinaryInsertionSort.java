// BinaryInsertionSort 클래스 선언
public class BinaryInsertionSort {
    // 이진 삽입 정렬 알고리즘을 수행하는 함수
    public static void sort(int[] array) {
        // 바깥 루프: 배열의 두 번째 원소부터 마지막 원소까지 반복
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            // 이진 검색을 사용하여 key 값을 삽입할 위치를 찾음
            int index = binarySearch(array, key, 0, i - 1);

            // 원소를 오른쪽으로 이동하여 key 값을 적절한 위치에 삽입할 공간을 만듦
            System.arraycopy(array, index, array, index + 1, i - index);
            // key 값을 적절한 위치에 삽입
            array[index] = key;
        }
    }

    // 이진 검색을 수행하는 함수
    private static int binarySearch(int[] array, int key, int low, int high) {
        // 이진 검색을 통해 key 값이 삽입될 위치를 찾음
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}