package liamohara.service;

import liamohara.exception.InvalidMorseException;
import liamohara.model.MorseDictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DecoderServiceImplTest {

    @Mock
    private MorseDictionary mockMorseDictionary;

    @InjectMocks
    private DecoderServiceImpl decoderServiceImpl;

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Returns empty string when provided with an empty string")
    void testDecode_WhenProvidedWithEmptyString() {

        String morseCode = "";

        when(mockMorseDictionary.getLatin(morseCode)).thenReturn("");

        String result = decoderServiceImpl.decode(morseCode);

        verify(mockMorseDictionary, times(0)).getLatin(morseCode);

        assertEquals("", result);
    }

    @Test
    @DisplayName("Returns S when provided with morse code string ...")
    void testDecode_WhenProvidedWithMorseCodeForCharacterS() {

        String morseCode = "...";

        when(mockMorseDictionary.getLatin(morseCode)).thenReturn("S");

        String result = decoderServiceImpl.decode(morseCode);

        verify(mockMorseDictionary, times(1)).getLatin(morseCode);

        assertEquals("S", result);
    }

    @Test
    @DisplayName("Returns SOS when provided with morse code string ... --- ...")
    void testDecode_WhenProvidedWithMorseCodeForWordSOS() {

        String morseCode = "... --- ...";
        String morseCodeS = "...";
        String morseCodeO = "---";
        String decoded = "SOS";

        when(mockMorseDictionary.getLatin(morseCodeS)).thenReturn("S");
        when(mockMorseDictionary.getLatin(morseCodeO)).thenReturn("O");

        String result = decoderServiceImpl.decode(morseCode);

        verify(mockMorseDictionary, times(2)).getLatin(morseCodeS);
        verify(mockMorseDictionary, times(1)).getLatin(morseCodeO);

        assertEquals(decoded, result);

    }

    @Test
    @DisplayName("Returns 'SOS NOW PLEASE.' when provided with morse code string ... --- ...")
    void testDecode_WhenProvidedWithMorseCodeForSentenceSOSNOWPLEASE() {

        String morseCode = "... --- ...   -. --- .--   .--. .-.. . .- ... . .-.-.-";
        String morseCodeS = "...";
        String morseCodeO = "---";
        String morseCodeN = "-.";
        String morseCodeW = ".--";
        String morseCodeP = ".--.";
        String morseCodeL = ".-..";
        String morseCodeE = ".";
        String morseCodeA = ".-";
        String morseCodeStop = ".-.-.-";

        String decoded = "SOS NOW PLEASE.";

        when(mockMorseDictionary.getLatin(morseCodeS)).thenReturn("S");
        when(mockMorseDictionary.getLatin(morseCodeO)).thenReturn("O");
        when(mockMorseDictionary.getLatin(morseCodeN)).thenReturn("N");
        when(mockMorseDictionary.getLatin(morseCodeW)).thenReturn("W");
        when(mockMorseDictionary.getLatin(morseCodeP)).thenReturn("P");
        when(mockMorseDictionary.getLatin(morseCodeL)).thenReturn("L");
        when(mockMorseDictionary.getLatin(morseCodeE)).thenReturn("E");
        when(mockMorseDictionary.getLatin(morseCodeA)).thenReturn("A");
        when(mockMorseDictionary.getLatin(morseCodeStop)).thenReturn(".");

        String result = decoderServiceImpl.decode(morseCode);

        verify(mockMorseDictionary, times(3)).getLatin(morseCodeS);
        verify(mockMorseDictionary, times(2)).getLatin(morseCodeO);
        verify(mockMorseDictionary, times(1)).getLatin(morseCodeN);
        verify(mockMorseDictionary, times(1)).getLatin(morseCodeW);
        verify(mockMorseDictionary, times(1)).getLatin(morseCodeP);
        verify(mockMorseDictionary, times(1)).getLatin(morseCodeL);
        verify(mockMorseDictionary, times(2)).getLatin(morseCodeE);
        verify(mockMorseDictionary, times(1)).getLatin(morseCodeA);
        verify(mockMorseDictionary, times(1)).getLatin(morseCodeStop);

        assertEquals(decoded, result);

    }

    @Test
    @DisplayName("Throws InvalidMorseException when provided with string that is invalid morse")
    void testDecode_WhenProvidedWithStringOfInvalidMorse() {

        String invalidMorse = "SOS";

        assertThrowsExactly(InvalidMorseException.class, () -> decoderServiceImpl.decode(invalidMorse));
    }

}