package leetcode.contest158;

import java.util.*;

public class RemoveSubFoldersFromTheFilesystem_1233 {

    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> ans = removeSubfolders(folder);

        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static List<String> removeSubfolders(String[] folder) {
        Try root = new Try();
        for(int i = 0; i < folder.length; i++) {
            Try t = root;
            for(char ch : folder[i].toCharArray()) {
                int idx = ch == '/' ? 26 : ch - 'a';
                if(t.child[idx] == null)
                    t.child[idx] = new Try();
                t = t.child[idx];
            }
            t.index = i;
        }
        return bfs(root, folder);
    }

    public static List<String> bfs(Try root, String[] folder) {
        List<String> ans = new ArrayList<>();
        Queue<Try> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Try t = queue.poll();
            if(t.index >= 0) {
                ans.add(folder[t.index]);
                if(t.child[26] != null)
                    continue;
            }
            for(int i = 0; i < 27; i++) {
                if(t.child[i] != null)
                    queue.offer(t.child[i]);
            }

        }
        return ans;
    }
}

class Try {
    int index = -1;
    Try[] child = new Try[27];
}
