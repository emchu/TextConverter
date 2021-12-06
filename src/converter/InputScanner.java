package converter;

import java.util.Scanner;

public class InputScanner {
    public String scanInput() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputTextBuilder = new StringBuilder();
        System.out.println("To confirm the input press \"Enter\" key twice");
        System.out.println("Enter your text:");

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
