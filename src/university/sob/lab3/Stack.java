package university.sob.lab3;

public class Stack {
    private String[] list;
    private int index = -1;

    public Stack(int size) {
        list = new String[size];
    }

    public boolean isEmpty() {
        return index < 0;
    }

    public String top() throws Exception {
        if (!isEmpty())
            return list[index];
        else
            throw new Exception("Stack is empty!");
    }

    public void push(String objectToPush) throws Exception {
        if (index < (list.length - 1))
            list[++index] = objectToPush;
        else
            throw new Exception("Stack is full!");
    }

    public String pop() throws Exception {
        if (!isEmpty())
            return list[index--];
        else
            throw new Exception("Stack is empty!");
    }

    public int size() {
        return index;
    }

}
