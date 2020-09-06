package DataStructure.LinkedStack;

public class Test {
    public static void main(String[] args) {
        LinkedStack ls=new LinkedStack();
        ls.push(3);
        ls.push(6);
        ls.push(9);
        System.out.println(ls.isEmpty()); //false
        System.out.println(ls.size()); //3
        System.out.println(ls.peek()); //9
        while(!ls.isEmpty())
            System.out.println(ls.pop()); //顺序输出9,6,3
        System.out.println(ls.isEmpty()); //true
    }
}
