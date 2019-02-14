package Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class AddressDeserializer extends StdDeserializer<Address> {
    protected AddressDeserializer(Class<?> vc) {
        super(vc);
    }

    protected AddressDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected AddressDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Address deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Address address = new Address();
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        JsonNode countryNode = node.get("country1");
        String country = countryNode.asText();
        Country countryEnum = Country.valueOf(country);
        address.setCountry(countryEnum);
        return address;
    }
}
