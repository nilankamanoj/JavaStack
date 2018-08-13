import java.util.Arrays;

public class Stack<T extends Object> {

    private int stackSize;
    private T[] stackArr;
    private int top;
    private int initial;


    public Stack(int size) {
        this.stackSize = size;
        this.initial = size;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
    }
    public Stack() {
        this.stackSize = 10;
        this.initial = 10;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
    }

    public void push(T entry){
        if(this.isStackFull()){
            this.increaseStackCapacity();
        }
            this.stackArr[++top] = entry;
    }


    public T pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        T entry = this.stackArr[top--];
        return entry;
    }


    public T peek() {
        return stackArr[top];
    }

    private void increaseStackCapacity(){

        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }


    public boolean isStackEmpty() {
        return (top == -1);
    }


    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    public void reset(){
        this.stackSize = initial;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;

    }


    public String toString(){
        try {
            return Arrays.toString(Arrays.copyOfRange(stackArr,0,top+1)).replaceAll(",|\\]|\\[", "").replaceAll("null","");
        }
        catch (Exception e){
            return "[]";
        }


    }

}