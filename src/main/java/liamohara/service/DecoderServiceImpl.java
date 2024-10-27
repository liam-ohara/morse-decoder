package liamohara.service;

import liamohara.exception.InvalidMorseException;
import liamohara.model.MorseDictionary;

public class DecoderServiceImpl implements DecoderService {

    MorseDictionary morseDictionary;

    @Override
    public String decode(String morseCode) {
        StringBuilder decodedMorse = new StringBuilder();

        if (!(morseCode.isEmpty())) {

            if (morseCode.matches("[^.\\-\\s]*")) {
                throw new InvalidMorseException(morseCode);

            } else {

                String[] morseArray = morseCode.split("\\s{1,2}");

                for (int i = 0; i < morseArray.length; i++) {
                    if (!(morseArray[i].isEmpty())) {
                        decodedMorse.append(morseDictionary.getLatin(morseArray[i]));

                    } else {
                        decodedMorse.append(" ");
                    }
                }

                return decodedMorse.toString();
            }
        }

        return "";
    }
}
