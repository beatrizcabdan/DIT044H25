package W46ErrorHandling;

class BeaComplaint extends Exception {
    public BeaComplaint() {
        super("Ai ai ai ai nooooooooooo!");
    }
}

class Class7 {
    int num;

    public Class7(int n1, int n2) {
        try {
            this.num = this.divide(n1, n2);
        }
        catch (BeaComplaint e) {
            System.out.println(e.getMessage());
            this.num = 0;
        }
    }

    private int divide(int n1, int n2) throws BeaComplaint {
        if (n2 < 1) throw new BeaComplaint();
        return n1 / n2;
    }

    public int getNum() {
        return this.num;
    }
}

public class Error3 {
    public static void main(String[] args) {
        Class7 c1 = new Class7(5,3);
        System.out.println(c1.getNum());

        Class7 c2 = new Class7(5,0);
        System.out.println(c2.getNum());
    }
}
