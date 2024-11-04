import java.util.HashMap;

public class HashSearchExample {
    public static void main(String[] args) {
        // HashMap 객체를 생성합니다.
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 데이터를 HashMap에 추가합니다.
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Cathy", 35);
        hashMap.put("David", 40);

         // HashMap에서 key를 검색합니다.
        String searchKey = "Cathy";

        if (hashMap.containsKey(searchKey)) {
            int value = hashMap.get(searchKey); // key에 해당하는 값을 가져옵니다.
            System.out.println("The value for the key '" + searchKey + "' is: " + value);
        } else {
            System.out.println("The key '" + searchKey + "' is not in the HashMap.");
        }
    }
}