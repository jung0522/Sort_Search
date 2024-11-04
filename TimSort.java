import java.util.Arrays;

class TimSort {
    private static final int RUN = 32; // 작은 구간의 크기를 정의

    // 삽입 정렬 함수
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // 두 정렬된 배열을 병합하는 함수
    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        System.arraycopy(arr, l, left, 0, len1);
        System.arraycopy(arr, m + 1, right, 0, len2);

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    // TimSort 알고리즘을 수행하는 함수
    public static void timSort(int[] arr, int n) {
        // 배열을 RUN 크기의 작은 구간으로 나누어 삽입 정렬 수행
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min(i + RUN - 1, n - 1));
        }

        // 작은 구간을 병합해가며 전체 배열 정렬 수행
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);

                merge(arr, left, mid, right);
            }
        }
    }

/*
    // 메인 함수
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, 50, 29, 14, 1, 31};
        int n = arr.length;
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        timSort(arr, n);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}
 */