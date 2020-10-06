import java.util.ArrayList;

public class Stack<Integer> extends ArrayList<Integer> {
    //This push method, will take in an integer, and add that integer to the stack. Remember stacks work, Last in First Out.
    public void push(Integer number)
    {
        add(number);
    }
    //This pop method will take the topmost element in the stack and remove it. That element will then be returned.
    public int pop()
    {
        Integer popDigit = get(size() - 1);
        remove(size() - 1);
        return (int)popDigit;
    }
}
