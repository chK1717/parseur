package parseur;
import java.util.Arrays;
import java.util.List;

public class RecursiveDescentParser {
    private String input;
    private int position;

    public RecursiveDescentParser(String input) {
        this.input = input;
        this.position = 0;
    }

    private char currentChar() {
        if (position < input.length()) {
            return input.charAt(position);
        }
        return '\0'; // Fin de la chaîne
    }

    private void consume(char expected) {
        if (currentChar() == expected) {
            position++;
        } else {
            throw new RuntimeException("Erreur de parsing à la position " + position);
        }
    }

    public boolean parse() {
        try {
            S();
            return position == input.length(); 
        } catch (RuntimeException e) {
            return false;
        }
    }

    private void S() {
        if (currentChar() == 'b') {
            consume('b');
            S();
            consume('b');
        } else if (currentChar() == 'c') {
            consume('c');
            A();
            consume('c');
        } else {
            throw new RuntimeException("Erreur dans S");
        }
    }

    private void A() {
        if (currentChar() == 'b') {
            consume('b');
            A();
            A();
        } else if (currentChar() == 'c') {
            consume('c');
            A();
            consume('b');
        } else if (currentChar() == 'd') {
            consume('d');
            consume('c');
            consume('b');
        } else {
            throw new RuntimeException("Erreur dans A");
        }
    }

  
}