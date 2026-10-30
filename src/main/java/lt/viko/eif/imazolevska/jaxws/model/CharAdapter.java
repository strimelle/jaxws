package lt.viko.eif.imazolevska.jaxws.model;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Converts a {@code char} value to text in XML and back.
 */
public class CharAdapter extends XmlAdapter<String, Character> {

    @Override
    public Character unmarshal(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return value.charAt(0);
    }

    @Override
    public String marshal(Character value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
}