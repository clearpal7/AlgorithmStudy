package leetcode.contest142;

import java.util.*;

public class FindinMountainArray_1095 {

    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray();
        System.out.println(findInMountainArray(3, mountainArray));
    }

    public static int getMax(int left, int right, MountainArray mountainArray) {
        int mid = (left + right) / 2;
        int t = -1;
        while(t == -1) {
            if((mountainArray.get(mid - 1) < mountainArray.get(mid)) && (mountainArray.get(mid + 1) < mountainArray.get(mid))) {
                t = mid;
                return t;
            } else if((mountainArray.get(mid - 1) < mountainArray.get(mid)) && (mountainArray.get(mid) < mountainArray.get(mid + 1))) {
                mid = (mid + right) / 2;
            } else if((mountainArray.get(mid - 1) > mountainArray.get(mid)) && (mountainArray.get(mid) > mountainArray.get(mid + 1))) {
                mid = (left + right) / 2;
            }
        }
        return t;
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        List<Integer> index = new ArrayList<>();
        int left = 0;
        int right = length - 1;

        int max = getMax(left, right, mountainArr);

        getLeftIndexInc(left, max, target, index, mountainArr);
        getLeftIndexDec(max, right, target, index, mountainArr);

        return index.stream().min(Comparator.comparingInt(Integer::intValue)).get();
    }

    private static void getLeftIndexDec(int left, int right, int target, List<Integer> index, MountainArray mountainArray) {
        if(left > right)
            return;

        int mid = (left + right) / 2;

        if(mountainArray.get(mid) == target) {
            index.add(mid);
        } else if(mountainArray.get(mid) < target) {
            getLeftIndexDec(left, mid, target, index, mountainArray);
        } else if(mountainArray.get(mid) > target) {
            getRightIndexDec(mid, right, target, index, mountainArray);
        }

    }

    private static void getRightIndexDec(int left, int right, int target, List<Integer> index, MountainArray mountainArray) {
        if(left > right)
            return;

        int mid = (left + right) / 2;

        if(mountainArray.get(mid) == target) {
            index.add(mid);
        } else if(mountainArray.get(mid) < target) {
            getLeftIndexDec(left, mid, target, index, mountainArray);
        } else if(mountainArray.get(mid) > target) {
            getRightIndexDec(mid, right, target, index, mountainArray);
        }

    }

    private static void getLeftIndexInc(int left, int right, int target, List<Integer> index, MountainArray mountainArray) {
        if(left > right)
            return;

        int mid = (left + right) / 2;

        if(mountainArray.get(mid) == target) {
            index.add(mid);
        } else if(mountainArray.get(mid) > target) {
            getLeftIndexInc(left, mid, target, index, mountainArray);
        } else if(mountainArray.get(mid) < target) {
            getRightIndexInc(mid, right, target, index, mountainArray);
        }

    }

    private static void getRightIndexInc(int left, int right, int target, List<Integer> index, MountainArray mountainArray) {
        if(left > right)
            return;

        int mid = (left + right) / 2;

        if(mountainArray.get(mid) == target) {
            index.add(mid);
        } else if(mountainArray.get(mid) > target) {
            getLeftIndexInc(left, mid, target, index, mountainArray);
        } else if(mountainArray.get(mid) < target) {
            getRightIndexInc(mid, right, target, index, mountainArray);
        }
    }

}

class MountainArray {
    int[] arr;

    public MountainArray() {
        arr = new int[]{0,1,2,4,2,1};
    }

     public int get(int index) {
        return arr[index];
     }
     public int length() {
         return arr.length;
     }
 }
