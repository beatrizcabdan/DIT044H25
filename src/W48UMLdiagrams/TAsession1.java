package W48UMLdiagrams;

class HandbagDecoration {
    private String name;

    public HandbagDecoration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Keyring extends HandbagDecoration {
    public Keyring(String name) {
        super(name);
    }
}


public class TAsession1 {
    public static void main(String[] args) {
        HandbagDecoration decoration = new Keyring("Keyring");
    }
}
