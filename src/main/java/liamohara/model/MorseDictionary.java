package liamohara.model;

import java.util.HashMap;

public record MorseDictionary() {
    private final static HashMap<String, String> morseLatin = new HashMap<>();
    static {
        morseLatin.put(".-", "A");
        morseLatin.put("-...", "B");
        morseLatin.put("-.-.", "C");
        morseLatin.put("-..", "D");
        morseLatin.put(".", "E");
        morseLatin.put("..-.", "F");
        morseLatin.put("--.", "G");
        morseLatin.put("....","H");
        morseLatin.put("..", "I");
        morseLatin.put(".---", "J");
        morseLatin.put("-.-", "K");
        morseLatin.put(".-..", "L");
        morseLatin.put("--", "M");
        morseLatin.put("-.", "N");
        morseLatin.put("---", "O");
        morseLatin.put(".--.", "P");
        morseLatin.put("--.-", "Q");
        morseLatin.put(".-.", "R");
        morseLatin.put("...", "S");
        morseLatin.put("-", "T");
        morseLatin.put("..-", "U");
        morseLatin.put("...-", "V");
        morseLatin.put(".--", "W");
        morseLatin.put("-..-", "X");
        morseLatin.put("-.--", "Y");
        morseLatin.put("--..", "Z");
        morseLatin.put(".----", "1");
        morseLatin.put("..---", "2");
        morseLatin.put("...--", "3");
        morseLatin.put("....-", "4");
        morseLatin.put(".....", "5");
        morseLatin.put("-....", "6");
        morseLatin.put("--...", "7");
        morseLatin.put("---..", "8");
        morseLatin.put("----.", "9");
        morseLatin.put("-----", "0");
        morseLatin.put("--..--", ", ");
        morseLatin.put(".-.-.-", ".");
        morseLatin.put("..--..", "?");
        morseLatin.put("-..-.", "/");
        morseLatin.put("-....-", "-");
        morseLatin.put("-.--.", "(");
        morseLatin.put("-.--.-", ")");
    }

    public static String getLatin (String morseCharacter) {
        return morseLatin.get(morseCharacter);
    }
}
