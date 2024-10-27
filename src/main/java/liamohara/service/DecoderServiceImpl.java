package liamohara.service;

import liamohara.model.MorseDictionary;

public class DecoderServiceImpl implements DecoderService {

    MorseDictionary morseDictionary;

    @Override
    public String decode(String morseCode) {
        StringBuilder decodedMorse = new StringBuilder();

        if (!(morseCode.isEmpty())) {

            String[] morseArray = morseCode.split("\\s");

            for (int i = 0; i < morseArray.length; i++) {
                decodedMorse.append(morseDictionary.getLatin(morseArray[i]));
            }

            return decodedMorse.toString();
        }
        return "";
    }
}
