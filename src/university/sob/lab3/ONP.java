package university.sob.lab3;

public class ONP {
    static Stack stack;

    public static void main(String[] args) throws Exception {
        stack = new Stack(100);
        ONP onp = new ONP();
        String chain = "( ( 2 + 7 ) / 3 + ( 14 - 3 ) * 4 ) / 2";

        String[] inputData = chain.split(" ");

        for (int i = 0; i < inputData.length; i++) {
            onp.count(inputData[i]);
        }

        System.out.println();
    }

    public void count(String element) throws Exception {
        try {
            if (element.equals("=")) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        }


        switch (element) {
            case " ":
                break;
            case "(":
                stack.push(element);
                break;
            case ")":
                while (!stack.top().equals("(")) {
                    System.out.print(stack.pop() + " ");
                }
                stack.pop(); //usuń nawias zamykający
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                while (!stack.isEmpty()) {
                    if (priority(element) == 3 || (priority(element)) > priority(stack.top()))
                        break;
                    System.out.print(stack.pop() + " ");
                }
                stack.push(element);
                break;
            default:
                System.out.print(element + " ");
                break;
        }
    }

    public int priority(String element) {
        switch (element) {
            case "+":
                ;
            case "-":
                return 1;
            case "*":
                ;
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return 0;
    }

}
