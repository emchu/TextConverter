import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ToCSVConverter {
    public void saveToCSV(ArrayList<Sentence> sortedSentencesList) {

        try (PrintWriter writer = new PrintWriter("CSV file.csv")) {
            StringBuilder firstLine = new StringBuilder();

            StringBuilder CSVStringBuilder = new StringBuilder();
            int numberOfSentences = 1;
            int maxNumberOfWords = 1;

            for (Sentence sentence : sortedSentencesList) {
                CSVStringBuilder.append("Sentence ").append(numberOfSentences).append(",");
                numberOfSentences++;

                ArrayList<String> sortedWords = sentence.getWords();
                int numberOfWords = 0;

                for (String word : sortedWords) {
                    CSVStringBuilder.append(" ").append(word).append(",");
                    numberOfWords++;
                }

                if (numberOfWords > maxNumberOfWords) {
                    maxNumberOfWords = numberOfWords;
                }
                CSVStringBuilder.append('\n');
            }
            firstLine.append(" ");

            for (int i = 1; i <= maxNumberOfWords; i++) {
                firstLine.append(",").append(" Word ").append(i);
            }
            firstLine.append('\n');
            CSVStringBuilder.insert(0, firstLine);

            writer.write(CSVStringBuilder.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

