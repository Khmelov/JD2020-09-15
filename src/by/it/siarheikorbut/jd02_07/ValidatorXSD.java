package by.it.siarheikorbut.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXSD {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/by/it/siarheikorbut/jd02_07/Persons+xsd.xml";
        String schemaName = "src/by/it/siarheikorbut/jd02_07/Person.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " валиден");
        } catch (SAXException e) {
            System.err.println("Валидация " + fileName + " не выполнена " + e.getMessage());
        } catch (IOException e) {
            System.err.println(fileName + " не валиден " + e.getMessage());
        }
    }
}