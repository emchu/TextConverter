public class ExtractSentences {
    ExtractWords extractWords = new ExtractWords();
    public void extractSentences(String textInput) {
        String[] sentences = textInput.split("\\.");
        for(String sentence : sentences){
            System.out.println("<Sentence>" + sentence);
            extractWords.extractWords(sentence);
        }
    }
}
