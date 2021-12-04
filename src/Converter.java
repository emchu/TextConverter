import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        ExtractSentences extractSentences = new ExtractSentences();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your text: ");
        String textInput = scanner.nextLine(); //"b a, e, l.d u, n.. g"
        extractSentences.extractSentences(textInput);

    }
}
