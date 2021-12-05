import java.util.Arrays;


public class WordsExtractor {

    public Sentence extractWords(String sentence) {
        String[] words = sentence.split("\\s+|,\\s*|\\.\\s*");
        String[] sortedWords = sortWords(words);

        return new Sentence(sortedWords);
    }

    private String[] sortWords(String[] words) {
        return Arrays.stream(words)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toArray(String[]::new);
    }
}
