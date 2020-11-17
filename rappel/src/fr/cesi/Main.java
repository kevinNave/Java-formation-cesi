package fr.cesi;

public class Main {
    public static void main(String[] args) {
        System.out.println("unTest");
        Voiture clio = new Voiture("Renault", "Clio", 5);
        System.out.println(clio);

        try {
            System.out.println(3 / 0);
        }
        catch(ArithmeticException e) {
            System.out.println("3/0 n'est pas une opération valide");
        }
    }
}
