import java.util.ArrayList;


public class SentenceExtractor {
    WordsExtractor wordsExtractor = new WordsExtractor();

    public ArrayList<Sentence> extractSentences(String textInput) {
        ArrayList<Sentence> sortedSentencesList = new ArrayList<>();
        String[] sentences = textInput.split("\\.");

        for(String sentence : sentences){
            if (!sentence.equals("") && !sentence.equals(" ")) {
                String rightSentence = sentence.trim();
                Sentence sortedSentence = wordsExtractor.extractWords(rightSentence);
                sortedSentencesList.add(sortedSentence);
            }
        }
        return sortedSentencesList;
    }
}
