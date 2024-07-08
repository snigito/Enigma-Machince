/*
 * File: EnigmaConstants.java
 * --------------------------
 * This module contains the constants used in the Enigma simulator.  The
 * easiest way to incorporate them into your program is to use the line
 *
 *     import static edu.willamette.cs1.enigma.EnigmaConstants.*;
 *
 * which imports all the top-level definitions.
 */


/*
 * Notes on the Enigma constants
 * -----------------------------
 * The early German Enigma machines include three rotors, which advance
 * at different speeds.  The rotor on the right is the "fast" rotor,
 * which advances on every keystroke.  The rotor in the middle is the
 * "medium" rotor, which advances when the fast rotor has made a
 * complete revolution.  The rotor at the left is the "slow" rotor,
 * which advances when the medium rotor has made a complete cycle.
 * The ROTOR_PERMUTATIONS array lists the three rotors from left to
 * right: the slow rotor, the medium rotor, and the fast rotor.
 *
 * Each rotor implements a letter-substitution cipher, which is
 * represented by a string of 26 uppercase letters that shows how
 * the letters in the alphabet are mapped to new letters as the
 * internal signal flows across the rotor from right to left.  For
 * example, the slow rotor corresponds to the following mapping
 * when it is in its initial position:
 *
 *    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *    | | | | | | | | | | | | | | | | | | | | | | | | | |
 *    E K M F L G D Q V Z N T O W Y H X U S P A I B R C J
 *
 * At the left end of the rotors, the signal passed through a
 * reflector, which implemented the following fixed permutation:
 *
 *    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *    | | | | | | | | | | | | | | | | | | | | | | | | | |
 *    I X U H F E Z D A O M T K Q J W N S R L C Y P B V G
 *
 * Note that the reflector is symmetric.  If A is transformed to I,
 * then I is transformed to A.
 */

public class EnigmaConstants {

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final int N_ROTORS = 3;

    public static final String[] ROTOR_PERMUTATIONS = {
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ",  /* Permutation for slow rotor      */
            "AJDKSIRUXBLHWTMCQGZNPYFVOE",  /* Permutation for medium rotor    */
            "BDFHJLCPRTXVZNYEIWGAKMUSQO"   /* Permutation for fast rotor      */
    };

    public static final String REFLECTOR_PERMUTATION =
            "IXUHFEZDAOMTKQJWNSRLCYPBVG";

}
