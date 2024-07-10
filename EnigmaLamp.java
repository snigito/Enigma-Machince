import java.util.Hashtable;

public class EnigmaLamp {
    public static final Hashtable<String, Integer> lampInds = new Hashtable<>();
    public static boolean[] lamps = new boolean[26];

    // Adding elements to the hashtable
    static {
        // Adding elements to the hashtable
        String alphabet = EnigmaConstants.ALPHABET;
        for (int i=0; i<alphabet.length(); i++) {
            lampInds.put(alphabet.substring(i, i+1), i+1);
        }
    }
}
