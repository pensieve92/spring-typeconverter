package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringToIntegerConverterTest {

    @Test
    void stingToInteger() {
        StringToIntegerConverter convert = new StringToIntegerConverter();
        Integer result = convert.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString(){
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort(){
        IpPortToStringConvert converter = new IpPortToStringConvert();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortToString(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);

        //@EqualsAndHashCode
        // ip와 port만 같으면 true가 나온다.
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }


}