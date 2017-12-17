
//Реализация oчереди.
public class MyQueue {

    int[] arr;
    int indexStart;
    int indexEnd;


    MyQueue() {
        arr = new int[16];
        indexStart = 0;
        indexEnd = 0;
    }

    public boolean find(int x) {
        if (indexEnd <= indexStart) return false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return true;
        }
        return false;
    }

    public int pop() {
        int x = arr[indexStart];
        if (indexStart < indexEnd) {
            if (indexStart < arr.length - 1) {
                indexStart++;
            } else {
                indexStart = 0;
            }
        }
        return x;
    }

    public void push(int x) {
        if (indexEnd < arr.length) {
            arr[indexEnd] = x;
            indexEnd++;
        } else {
            increaseQueueCapacity();
            push(x);
        }
    }

    private void increaseQueueCapacity() {
        int[] arrNew = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arrNew[i] = arr[i];
            }
        }
        arr = arrNew;
    }

    public void clear(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
