import java.util.Hashtable;

public class EnigmaKey {
    public static final Hashtable<String, Integer> keyInds = new Hashtable<>();
    public static boolean[] keys = new boolean[26];

    static {
        // Adding elements to the hashtable
        String alphabet = EnigmaConstants.ALPHABET;
        for (int i=0; i<alphabet.length(); i++) {
            keyInds.put(alphabet.substring(i, i+1), i+1);
        }
    }
}
