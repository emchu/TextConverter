public class ExtractWords {
    public void extractWords(String sentence) {
        String[] words = sentence.split("\\s+|,\\s*|\\.\\s*");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("</Sentence>");
    }
}
