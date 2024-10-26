package liamohara.exception;

public class GlobalExceptionHandler {

    public String handleInvalidMorseException (InvalidMorseException ie) {

        return "\"" + ie.getMessage() + "\" is invalid morse code.";
    }
}
