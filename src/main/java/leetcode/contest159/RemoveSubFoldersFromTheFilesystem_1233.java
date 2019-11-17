package leetcode.contest159;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveSubFoldersFromTheFilesystem_1233 {

    public static void main(String[] args) {
        String[] folders = {"/a","/a/b","/c/d","/c/d/e","/c/f"};

        List<String> result = removeSubfolders(folders);
        for(String r : result) {
            System.out.println(r);
        }
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparing(s -> s.length()));
        Set<String> group = new HashSet<>();

        outer:
        for(String s : folder) {
            for(int i = 2; i < s.length(); i++) {
                if(s.charAt(i) == '/' && group.contains(s.substring(0, i))) {
                    continue outer;
                }
            }
            group.add(s);
        }
        return group.stream().collect(Collectors.toList());
    }
}
