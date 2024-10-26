package liamohara.controller;

import liamohara.exception.InvalidMorseException;
import liamohara.service.DecoderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DecoderControllerTest {

    @Mock
    private DecoderServiceImpl mockDecoderServiceImpl;

    @InjectMocks
    private DecoderController decoderController;

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Returns empty string when provided with an empty string")
    void testDecode_WhenProvidedWithEmptyString() {

        String morseCode = "";

        when(mockDecoderServiceImpl.decode(morseCode)).thenReturn("");

        String result = decoderController.decode(morseCode);

        verify(mockDecoderServiceImpl, times(1)).decode(morseCode);

        assertEquals("", result);
    }

    @Test
    @DisplayName("Returns S when provided with morse code string ...")
    void testDecode_WhenProvidedWithMorseCodeForCharacterS() {

        String morseCode = "...";

        when(mockDecoderServiceImpl.decode(morseCode)).thenReturn("S");

        String result = decoderController.decode(morseCode);

        verify(mockDecoderServiceImpl, times(1)).decode(morseCode);

        assertEquals("S", result);
    }

    @Test
    @DisplayName("Returns invalid morse code error message when provided with invalid morse code string")
    void testDecode_WhenProvidedWithInvalidMorseCodeString() {

        String invalidMorseCode = "12 drummers drumming";

        when(mockDecoderServiceImpl.decode(invalidMorseCode)).thenThrow(new InvalidMorseException(invalidMorseCode));

        String result = decoderController.decode(invalidMorseCode);

        verify(mockDecoderServiceImpl, times(1)).decode(invalidMorseCode);

        assertEquals("\"12 drummers drumming\" is invalid morse code.", result);

    }
}