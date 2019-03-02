package leetcode.contest122;

import leetcode.domain.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversalofaBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalTraversal(root);

        for(int i = 0; i < result.size(); i++) {
            List<Integer> enjoy = result.get(i);
            Collections.sort(enjoy);
            for(int j = 0; j < enjoy.size(); j++) {
                System.out.println(enjoy.get(j));
            }
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<TreeNode>> listMap = new TreeMap<>();
        root.x = 0;
        root.y = 0;
        listMap.computeIfAbsent(0, k -> new ArrayList<>())
                .add(root);

        if(root.left != null) {
            setListCoord(root.left, 0, 0, true, listMap);
        }

        if(root.right != null) {
            setListCoord(root.right, 0, 0, false, listMap);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> temp;
        for(Integer key : listMap.keySet()) {
            temp = listMap.get(key);
            Collections.sort(temp, new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2) {
                    int temp = Integer.compare(o2.y, o1.y);
                    if(temp == 0) {
                        return Integer.compare(o2.val, o1.val);
                    }
                    return temp;
                }
            });

            result.add(temp.stream()
                    .map(i -> i.val)
                    .collect(Collectors.toList()));
        }

        return result;
    }

    private static void setListCoord(TreeNode node, int x, int y, boolean isLeft, Map<Integer, List<TreeNode>> listMap) {
        if (node == null) return;
        int currentX;
        int currentY;

        if (isLeft) {
            currentX = x - 1;
            currentY = y - 1;
            node.x = currentX;
            node.y = currentY;

            listMap.computeIfAbsent(currentX, k -> new ArrayList<>())
                    .add(node);
        } else {
            currentX = x + 1;
            currentY = y - 1;
            node.x = currentX;
            node.y = currentY;

            listMap.computeIfAbsent(currentX, k -> new ArrayList<>())
                    .add(node);
        }

        if (node.left != null) {
            setListCoord(node.left, currentX, currentY, true, listMap);
        }

        if (node.right != null) {
            setListCoord(node.right, currentX, currentY, false, listMap);
        }
    }
}
