package hackerrank;

import java.util.*;

public class JourneytotheMoon {

    public static void main(String[] args) {
        int N = 4;
        /*int[][] astronaut = new int[3][3];
        astronaut[0][0] = 0;
        astronaut[0][1] = 1;
        astronaut[1][0] = 2;
        astronaut[1][1] = 3;
        astronaut[2][0] = 0;
        astronaut[2][1] = 4;*/

        int[][] astronaut = new int[1][2];
        astronaut[0][0] = 0;
        astronaut[0][1] = 2;

        System.out.println(journeyToMoon(N, astronaut));
    }

    static int journeyToMoon(int n, int[][] astronaut) {

        Map<Integer, NODE> nodeMap = new HashMap<>();
        for(int i = 0 ; i < n; i++) {
            nodeMap.put(i, new NODE(i));
        }

        for(int i = 0 ; i < astronaut.length; i++) {
            int first = astronaut[i][0];
            int second = astronaut[i][1];
            nodeMap.putIfAbsent(first, new NODE(first));
            nodeMap.putIfAbsent(second, new NODE(second));

            nodeMap.get(first).set(nodeMap.get(second));
        }
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            Stack<NODE> stack = new Stack<>();
            if(visited[i] == false) {
                stack.add(nodeMap.get(i));
                int count = 1;

                while(!stack.isEmpty()) {
                    NODE node = stack.pop();
                    Map<Integer, NODE> children = node.children;
                    for(Integer key : children.keySet()) {
                        if(visited[key] == false) {
                            stack.add(nodeMap.get(key));
                            visited[key] = true;
                            ++count;
                        }
                    }
                }
                result.add(count);
            }
        }
        int answer = 0;
        for(int i = 0; i < result.size() - 1; i++) {
            for(int j = i + 1; j < result.size(); j++) {
               answer += result.get(i) * result.get(j);
            }
        }

        return answer;

    }
}
class NODE {
    int num;
    NODE root;
    Map<Integer, NODE> children;

    public NODE(int num) {
        this.num = num;
        this.root = this;
        children = new HashMap<>();
    }
    public void set(NODE node) {
        if(this.root.num != node.root.num) {
            NODE otherRoot = node.root;
            Map<Integer, NODE> child = otherRoot.children;
            NODE otherRootChild;
            for(Integer key : child.keySet()) {
                otherRootChild = child.get(key);
                otherRootChild.root = this.root;
                this.children.put(otherRootChild.num, otherRootChild);
            }

            otherRoot.root = this.root;
            this.children.put(otherRoot.num, otherRoot);
        }
    }
}
