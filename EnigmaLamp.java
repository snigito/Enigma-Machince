import java.util.Hashtable;

public class EnigmaLamp {
    public static final Hashtable<String, Integer> lampInds = new Hashtable<>();
    public static boolean[] lamps;

    // Adding elements to the hashtable
    public EnigmaLamp() {
        lampInds.put("A", 1);
        lampInds.put("B", 2);
        lampInds.put("C", 3);
        lampInds.put("D", 4);
        lampInds.put("E", 5);
        lampInds.put("F", 6);
        lampInds.put("G", 7);
        lampInds.put("H", 8);
        lampInds.put("I", 9);
        lampInds.put("J", 10);
        lampInds.put("K", 11);
        lampInds.put("L", 12);
        lampInds.put("M", 13);
        lampInds.put("N", 14);
        lampInds.put("O", 15);
        lampInds.put("P", 16);
        lampInds.put("Q", 17);
        lampInds.put("R", 18);
        lampInds.put("S", 19);
        lampInds.put("T", 20);
        lampInds.put("U", 21);
        lampInds.put("V", 22);
        lampInds.put("W", 23);
        lampInds.put("X", 24);
        lampInds.put("Y", 25);
        lampInds.put("Z", 26);
        lamps = new boolean[26];
    }
}
