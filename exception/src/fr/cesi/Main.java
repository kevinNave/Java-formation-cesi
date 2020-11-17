package fr.cesi;

public class Main {
    public static void main(String[] args) throws MonException {
        throw new MonException("Exception Personnalisée");
    }
}
