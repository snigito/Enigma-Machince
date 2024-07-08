public class EnigmaRotor {
    private String permutation;
    private int offset;

    public EnigmaRotor(String permutation){
        this.setPermutation(permutation);
        setOffset(0);
    }

    public String getPermutationLetter(int index){
        return permutation.substring(index, index + 1);
    }

    public int getPermutationLetterIndex(String letter){
        return permutation.indexOf(letter);
    }

    public String getInvertedPermutationLetter(int i){
        return getLetterAtIndex(getPermutationLetterIndex(getLetterAtIndex(i)));
    }

    public int getInvertedPermutationLetterIndex(String letter){
        return getIndexFromLetter(getInvertedPermutationLetter(getPermutationLetterIndex(letter)));
    }

    public boolean advance(){
        setOffset(getOffset() + 1);
        if(getOffset() == 26){
            setOffset(0);
            return true;
        }
        return false;
    }


    public String getPermutation() {
        return permutation;
    }

    public void setPermutation(String permutation) {
        this.permutation = permutation;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public static String getLetterAtIndex(int index) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.substring(index, index + 1);
    }

    public static int getIndexFromLetter(String letter){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.indexOf(letter);
    }
}
