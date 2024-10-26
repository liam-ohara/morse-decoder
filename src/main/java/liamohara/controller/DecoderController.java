package liamohara.controller;

import liamohara.exception.GlobalExceptionHandler;
import liamohara.exception.InvalidMorseException;
import liamohara.service.DecoderService;

public class DecoderController {

    DecoderService decoderService;

    GlobalExceptionHandler globalExceptionHandler;

    public String decode(String morseCode) {

        String errorMessage;

        try {
            return decoderService.decode(morseCode);
        } catch (InvalidMorseException ie) {
            globalExceptionHandler = new GlobalExceptionHandler();
            errorMessage = globalExceptionHandler.handleInvalidMorseException(ie);
        }
        return errorMessage;
    }
}
