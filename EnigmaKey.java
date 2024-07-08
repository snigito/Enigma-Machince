import java.util.Hashtable;

public class EnigmaKey {
    public static final Hashtable<String, Integer> keyInds = new Hashtable<>();
    public static boolean[] keys;

    // Adding elements to the hashtable
    public EnigmaKey() {
        keyInds.put("A", 1);
        keyInds.put("B", 2);
        keyInds.put("C", 3);
        keyInds.put("D", 4);
        keyInds.put("E", 5);
        keyInds.put("F", 6);
        keyInds.put("G", 7);
        keyInds.put("H", 8);
        keyInds.put("I", 9);
        keyInds.put("J", 10);
        keyInds.put("K", 11);
        keyInds.put("L", 12);
        keyInds.put("M", 13);
        keyInds.put("N", 14);
        keyInds.put("O", 15);
        keyInds.put("P", 16);
        keyInds.put("Q", 17);
        keyInds.put("R", 18);
        keyInds.put("S", 19);
        keyInds.put("T", 20);
        keyInds.put("U", 21);
        keyInds.put("V", 22);
        keyInds.put("W", 23);
        keyInds.put("X", 24);
        keyInds.put("Y", 25);
        keyInds.put("Z", 26);
        keys = new boolean[26];
    }
}
