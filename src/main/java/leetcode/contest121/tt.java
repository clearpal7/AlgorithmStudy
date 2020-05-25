package leetcode.contest121;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class tt {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String line;
        int command;
        CustomQueue customQueue = new CustomQueue();

        for(int i = 0; i < N; i++) {
            line = bufferedReader.readLine();
            String[] values = line.split("\\s+");
            command = Integer.parseInt(values[0]);

            if(command == 1) {
                customQueue.add(Integer.parseInt(values[1]));
            } else if(command == 2) {
                customQueue.dequeue();
            } else if(command ==3) {
                System.out.println(customQueue.get());
            }
        }

    }

}
class CustomQueue {
    Stack<Integer> insertStack;
    Stack<Integer> popStack;

    CustomQueue() {
        this.insertStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(Integer x) {
        insertStack.push(x);
    }

    public Integer get() {
        if(!popStack.isEmpty()) {
            return popStack.peek();
        } else {
            while(!insertStack.isEmpty()) {
                popStack.push(insertStack.pop());
            }
            return popStack.peek();
        }
    }

    public void dequeue() {
        if(!popStack.isEmpty()) {
            popStack.pop();
        } else {
            while(!insertStack.isEmpty()) {
                popStack.push(insertStack.pop());
            }
            popStack.pop();
        }
    }
}

