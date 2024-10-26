package liamohara.controller;

import liamohara.service.DecoderService;

public class DecoderController {

    DecoderService decoderService;

    public String decode(String morseCode) {

        return decoderService.decode(morseCode);
    }
}
