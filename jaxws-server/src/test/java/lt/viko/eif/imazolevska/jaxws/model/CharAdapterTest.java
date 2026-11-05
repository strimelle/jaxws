package lt.viko.eif.imazolevska.jaxws.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link CharAdapter}.
 */
class CharAdapterTest {

    @Test
    void unmarshalReturnsFirstCharacter() {

        CharAdapter adapter = new CharAdapter();
        Character result = adapter.unmarshal("S");
        assertEquals('S', result);
    }

}