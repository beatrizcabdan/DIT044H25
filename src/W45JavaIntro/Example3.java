package W45JavaIntro;

// the class is called Example3
class Example3 {

    // this is a method of the class Example3
    public void doSomething() {
        System.out.println("Doing something");
    }

    // this method is static! it can be used without instantiating the class!
    public static void doSomethingElse() {
        System.out.println("Doing something else");
    }

    // remember: main is what is going to run in the beginning
    public static void main(String[] args) {
        // create object
        Example3 obj = new Example3();

        // use methods from object's class
        obj.doSomething();
        obj.doSomethingElse();

        // static methods could be used without creating an object from that class
        Example3.doSomethingElse();
    }
}