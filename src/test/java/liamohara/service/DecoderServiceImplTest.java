package liamohara.service;

import liamohara.model.MorseDictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
//        mockMorseDictionary = new MorseDictionary();
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
}