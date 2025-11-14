package W46ErrorHandling;

class Class6 {
    int num;
    public Class6(int n1, int n2) {
        try {
            this.num = n1/n2;
        }
        catch (ArithmeticException e) {
            this.num = 0;
        }
    }

    public int getNum() {
        return this.num;
    }
}

public class Error2 {
    public static void main(String[] args) {
        Class6 c1 = new Class6(5,3);
        System.out.println(c1.getNum());

        Class6 c2 = new Class6(5,0);
        System.out.println(c2.getNum());
    }
}
