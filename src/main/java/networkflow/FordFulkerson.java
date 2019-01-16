package networkflow;


import com.sun.corba.se.spi.servicecontext.MaxStreamFormatVersionServiceContext;

import java.util.*;

public class FordFulkerson {

    public static int MAX_V = 10;

    public static int[][] capacity = new int[MAX_V][MAX_V];
    public static int[][] flow = new int[MAX_V][MAX_V];
    static int V;

    public static void main(String[] args) {

    }

    public static Integer networkFlow(int source, int sink) {
        int totalFlow = 0;

        while(true) {
            Map<Integer, Integer> parent = new HashMap<>();
            init(parent);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);

            parent.put(source, source);

            while(!queue.isEmpty() && parent.get(sink) == -1) {
                int here = queue.poll().intValue();
                for(int there = 0; there <  V; there++) {
                    if(capacity[here][there] - flow[here][there] > 0 && parent.get(there) == -1) {
                        queue.add(there);
                        parent.put(there, here);
                    }
                }

                //증가 경로가 없으면 종료
                if(parent.get(sink) == -1) break;

                int amount = Integer.MAX_VALUE;

                for(int p = sink; p != source; p = parent.get(p)) {
                    amount = Math.min(capacity[parent.get(p)][p] - flow[parent.get(p)][p], amount);
                }

                for(int p = sink; p != source; p = parent.get(p)) {
                    flow[parent.get(p)][p] += amount;
                    flow[p][parent.get(p)] -= amount;
                }
                totalFlow += amount;
            }
        }
    }

    public static void init(Map<Integer, Integer> parent) {
        for(int i = 0; i < MAX_V; i ++) {
            parent.put(i, -1);
        }
    }
}
