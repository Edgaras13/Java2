package Test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class AddressSerializer extends StdSerializer<Address> {
    protected AddressSerializer(Class<Address> t) {
        super(t);
    }

    public AddressSerializer(){
        this(null);
    }

    @Override
    public void serialize(Address address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("street1", address.getStreet());
        jsonGenerator.writeStringField("city1", address.getCity());
        jsonGenerator.writeStringField("number1", address.getNumber());
        jsonGenerator.writeStringField("country1", String.valueOf(address.getCountry()));

        jsonGenerator.writeEndObject();
    }
}
