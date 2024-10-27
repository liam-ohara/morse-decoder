package liamohara.controller;

import liamohara.exception.GlobalExceptionHandler;
import liamohara.exception.InvalidMorseException;
import liamohara.service.DecoderService;
import liamohara.service.DecoderServiceImpl;

public class DecoderController {

    DecoderService decoderService = new DecoderServiceImpl();

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
