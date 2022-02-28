package sentences;

public class SentenceTransformer {

    private static final String SEPARATOR = " " ;

    public String shortenSentence(String sentence) {
        isValidSentence(sentence);
        String[] parts = sentence.split(SEPARATOR);
        if (parts.length >= 5) {
            return parts[0] + " ... " + parts[parts.length - 1];
        }
        return sentence;
    }

    private void isValidSentence(String sentence) {
        if (sentence.charAt(0) != sentence.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        if (!sentence.endsWith(".") && !sentence.endsWith("!") && !sentence.endsWith("?")) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }
}
