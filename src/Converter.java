import java.util.ArrayList;
import java.util.Scanner;


public class Converter {
    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner();
        SentenceExtractor sentenceExtractor = new SentenceExtractor();
        ToXMLConverter toXMLConverter = new ToXMLConverter();
        ToCSVConverter toCSVConverter = new ToCSVConverter();


        String textInput = inputScanner.scanInput();

/*
        Mary had a little lamb . Peter called for the wolf , and Aesop came .
        Cinderella likes shoes..
*/
        ArrayList<Sentence> sortedSentencesList = sentenceExtractor.extractSentences(textInput);
        toXMLConverter.saveToXML(sortedSentencesList);
        toCSVConverter.saveToCSV(sortedSentencesList);
    }
}
