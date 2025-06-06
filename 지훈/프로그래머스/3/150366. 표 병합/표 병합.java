import java.util.*;

public class Solution {

    private static final int SIZE = 50 * 50;

    private final int[] parent = new int[SIZE];
    private final Map<Integer, String> valueMap = new HashMap<>();
    private final Map<Integer, Set<Integer>> members = new HashMap<>();

    public String[] solution(String[] commands) {
        for (int i = 0; i < SIZE; i++) {
            parent[i] = i;
            valueMap.put(i, "EMPTY");
            members.put(i, new HashSet<>(Collections.singleton(i)));
        }

        List<String> output = new ArrayList<>();

        for (String cmd : commands) {
            String[] tokens = cmd.split(" ");
            String command = tokens[0];

            switch (command) {
                case "UPDATE":
                    if (tokens.length == 4) {
                        updateCell(
                            Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]),
                            tokens[3]
                        );
                    } else {
                        updateValue(tokens[1], tokens[2]);
                    }
                    break;

                case "MERGE":
                    mergeCells(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]),
                        Integer.parseInt(tokens[4])
                    );
                    break;

                case "UNMERGE":
                    unmergeCell(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2])
                    );
                    break;

                case "PRINT":
                    printCell(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]),
                        output
                    );
                    break;

                default:
            }
        }

        return output.toArray(new String[0]);
    }

    private int toId(int row, int col) {
        return (row - 1) * 50 + (col - 1);
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void updateCell(int row, int col, String value) {
        int id = toId(row, col);
        int root = find(id);
        valueMap.put(root, value);
    }

    private void updateValue(String oldValue, String newValue) {
        for (Map.Entry<Integer, String> entry : valueMap.entrySet()) {
            if (entry.getValue().equals(oldValue)) {
                entry.setValue(newValue);
            }
        }
    }

    private void mergeCells(int r1, int c1, int r2, int c2) {
        int id1 = toId(r1, c1);
        int id2 = toId(r2, c2);
        int root1 = find(id1);
        int root2 = find(id2);

        if (root1 == root2) {
            return;
        }

        String value1 = valueMap.getOrDefault(root1, "EMPTY");
        String value2 = valueMap.getOrDefault(root2, "EMPTY");

        for (int cellId : members.get(root2)) {
            parent[cellId] = root1;
            members.get(root1).add(cellId);
        }
        members.remove(root2);

        if (!value1.equals("EMPTY")) {
            valueMap.put(root1, value1);
        } else {
            valueMap.put(root1, value2);
        }
        valueMap.remove(root2);
    }

    private void unmergeCell(int row, int col) {
        int id = toId(row, col);
        int root = find(id);

        String originalValue = valueMap.getOrDefault(root, "EMPTY");
        Set<Integer> group = new HashSet<>(members.get(root));

        members.remove(root);
        valueMap.remove(root);

        for (int cellId : group) {
            parent[cellId] = cellId;
            members.put(cellId, new HashSet<>(Collections.singleton(cellId)));
            valueMap.put(cellId, "EMPTY");
        }

        valueMap.put(id, originalValue);
    }

    private void printCell(int row, int col, List<String> output) {
        int id = toId(row, col);
        int root = find(id);
        output.add(valueMap.getOrDefault(root, "EMPTY"));
    }
}
