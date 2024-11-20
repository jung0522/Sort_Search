import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// Huffman Tree Node
class Node {
    char ch;
    int frequency;
    Node left;
    Node right;

    Node(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }

    Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}

// Huffman Coding Class
public class HuffmanCoding {

    // Huffman Tree 생성
    public static Node buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        // 각 문자와 빈도수를 기반으로 초기 노드를 생성
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Huffman Tree 구성
        while (pq.size() > 1) {
            Node left = pq.poll();  // 최소 빈도수 노드
            Node right = pq.poll(); // 두 번째 최소 빈도수 노드

            // 새로운 내부 노드 생성
            Node newNode = new Node(left.frequency + right.frequency, left, right);
            pq.add(newNode);
        }

        return pq.poll(); // 루트 노드 반환
    }

    // Huffman Code 생성
    public static void generateHuffmanCode(Node root, String code, Map<Character, String> huffmanCodeMap) {
        if (root == null) {
            return;
        }

        // 리프 노드인 경우 코드 저장
        if (root.left == null && root.right == null) {
            huffmanCodeMap.put(root.ch, code);
        }

        // 왼쪽과 오른쪽 하위 트리 탐색
        generateHuffmanCode(root.left, code + "0", huffmanCodeMap);
        generateHuffmanCode(root.right, code + "1", huffmanCodeMap);
    }

    public static void main(String[] args) {
        // 입력 문자열
        String text = "huffman coding example";

        // 빈도수 계산
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Huffman Tree 생성
        Node root = buildHuffmanTree(freqMap);

        // Huffman Code 생성
        Map<Character, String> huffmanCodeMap = new HashMap<>();
        generateHuffmanCode(root, "", huffmanCodeMap);

        // 결과 출력
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 입력 문자열 인코딩
        StringBuilder encodedString = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedString.append(huffmanCodeMap.get(ch));
        }
        System.out.println("\nEncoded String:");
        System.out.println(encodedString.toString());
    }
}
