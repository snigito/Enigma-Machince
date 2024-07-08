/*
 * File: EnigmaModel.java
 * ----------------------
 * This class defines the starter version of the EnigmaModel class,
 * which doesn't implement any of the methods.
 */



import java.util.ArrayList;

public class EnigmaModel{
    EnigmaKey enigmaKey;
    EnigmaLamp enigmaLamp;

    static EnigmaRotor[] rotors;
    static EnigmaRotor reflector;

    public EnigmaModel() {
        views = new ArrayList<EnigmaView>();
        enigmaKey = new EnigmaKey();
        enigmaLamp = new EnigmaLamp();
        rotors = new EnigmaRotor[3];
        EnigmaRotor fastRotor = new EnigmaRotor("BDFHJLCPRTXVZNYEIWGAKMUSQO");
        EnigmaRotor mediumRotor = new EnigmaRotor("AJDKSIRUXBLHWTMCQGZNPYFVOE");
        EnigmaRotor slowRotor = new EnigmaRotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        rotors[2] = fastRotor;
        rotors[1] = mediumRotor;
        rotors[0] = slowRotor;
        reflector = new EnigmaRotor("IXUHFEZDAOMTKQJWNSRLCYPBVG");
    }

    /**
     * Adds a view to this model.
     *
     * @param view The view being added
     */

    public void addView(EnigmaView view) {
        views.add(view);
    }

    /**
     * Sends an update request to all the views.
     */

    public void update() {
        for (EnigmaView view : views) {
            view.update();
        }
    }

    public static int applyPermutation(int index, EnigmaRotor rotor){
        int tempIndex = (index + rotor.getOffset()) % 26;
        int letterIndex = getIndexFromLetter(rotor.getPermutationLetter(tempIndex));
        int temp = letterIndex - rotor.getOffset();
        if(temp < 0) return (temp + 26);
        return temp % 26;
    }

    public static int applyPermutationInverse(int index, EnigmaRotor rotor){
        int tempIndex = (index + rotor.getOffset()) % 26;
        int letterIndex = getIndexFromLetter(rotor.getInvertedPermutationLetter(tempIndex));
        int temp = letterIndex - rotor.getOffset();
        if(temp < 0) return (temp + 26);
        return temp % 26;
    }

    public static int encrypt(int index){
        int encryptedIndex = index;
        for(int i = 2; i >= 0; i--){
            encryptedIndex = applyPermutation(encryptedIndex, rotors[i]);
        }
        encryptedIndex = applyPermutation(encryptedIndex, reflector);
        for(int i = 0; i < 3; i++){
            encryptedIndex = applyPermutationInverse(encryptedIndex, rotors[i]);
        }
        return encryptedIndex;
    }


    /**
     * Returns true if the specified letter key is pressed.
     *
     * @param letter The letter key being tested as a one-character string.
     */

    public boolean isKeyDown(String letter) {
        return enigmaKey.keys[enigmaKey.keyInds.get(letter) - 1];
    }

    /**
     * Returns true if the specified lamp is lit.
     *
     * @param letter The lamp being tested as a one-character string.
     */

    public boolean isLampOn(String letter) {
        return enigmaLamp.lamps[enigmaLamp.lampInds.get(letter) - 1];
    }

    /**
     * Returns the letter visible through the rotor at the specified inded.
     *
     * @param index The index of the rotor (0-2)
     * @return The letter visible in the indicated rotor
     */

    public static String getLetterAtIndex(int index) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.substring(index, index + 1);
    }

    public static int getIndexFromLetter(String letter){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.indexOf(letter);
    }

    /**
     * Called automatically by the view when the specified key is pressed.
     *
     * @param key The key the user pressed as a one-character string
     */

    public void keyPressed(String key) {
        // Write the code to handle a key press
        if(rotors[2].advance()){
            if(rotors[1].advance()) rotors[0].advance();
        }
        int index = encrypt(getIndexFromLetter(key));
        enigmaLamp.lamps[index] = true;
        enigmaKey.keys[getIndexFromLetter(key)] = true;
        this.update();
    }

    /**
     * Called automatically by the view when the specified key is released.
     *
     * @param key The key the user released as a one-character string
     */

    public void keyReleased(String key) {
        // Write the code to handle a key release
        int index = encrypt(getIndexFromLetter(key));
        enigmaLamp.lamps[index] = false;
        enigmaKey.keys[getIndexFromLetter(key)] = false;
        this.update();
    }

    public String getRotorLetter(int index){
        return getLetterAtIndex(rotors[index].getOffset());
    }

    /**
     * Called automatically by the view when the rotor at the specified
     * index (0-2) is clicked.
     *
     * @param index The index of the rotor that was clicked
     */

    public void rotorClicked(int index) {
        // Write the code to run when the specified rotor is clicked
        rotors[index].setOffset(rotors[index].getOffset() + 1);
    }

    /* Main program */

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.dir"));
        EnigmaModel model = new EnigmaModel();
        EnigmaView view = new EnigmaView(model);
        model.addView(view);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String inverted = "";
        for(int i = 0; i < alphabet.length(); i++){
            inverted += getLetterAtIndex(model.rotors[0].getPermutationLetterIndex(alphabet.substring(i, i + 1)));
        }
        //System.out.println(inverted);

        //System.out.println(model.rotors[0].getInvertedPermutationLetter(0));

    }

    /* Private instance variables */

    private ArrayList<EnigmaView> views;

}