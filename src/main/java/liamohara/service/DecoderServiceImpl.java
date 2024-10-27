package liamohara.service;

import liamohara.model.MorseDictionary;

public class DecoderServiceImpl implements DecoderService {

    MorseDictionary morseDictionary;

    @Override
    public String decode(String morseCode) {
        String decodedMorse;

        if (!(morseCode.isEmpty())) {
            decodedMorse = morseDictionary.getLatin(morseCode);
            return decodedMorse;
        }
        return "";
    }
}
