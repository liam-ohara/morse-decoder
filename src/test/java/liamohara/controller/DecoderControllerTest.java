package liamohara.controller;

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
}