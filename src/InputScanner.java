import java.util.Scanner;

public class InputScanner {
    public String scanInput() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputTextBuilder = new StringBuilder();
        System.out.print("Enter your text: ");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            line += " ";
            inputTextBuilder.append(line);
        }

        return inputTextBuilder.toString();
    }
}
