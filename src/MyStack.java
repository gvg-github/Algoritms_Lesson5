//Реализация стека.
public class MyStack {

    int[] arr;
    int index;

    MyStack(){
        arr = new int[16];
        index = 0;
    }

    public void clear(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public boolean find(int x){
        if (index == 0) return false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return true;
        }
        return false;
    }

    public int pop(){
        int x = arr[index];
        if (index > 0){
            index--;
        }
        return x;
    }

    public void push(int x){
        if (index < arr.length){
            arr[index] = x;
            index++;
        }else{
            increaseStackCapacity();
            push(x);
        }
    }

    private void increaseStackCapacity() {
        int[] arrNew = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                arrNew[i] = arr[i];
            }
        }
        arr = arrNew;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("");
        for (int i = arr.length - 1; i >= 0; i--) {
            stb.append(arr[i]);
        }
        return stb.toString();
    }
}
