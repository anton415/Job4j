package ru.aserdyuchenko.JDBC;

import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * TODO add assert in all test.
 */
public class XmlStorageTest {
    private XmlStorage xmlStorage = new XmlStorage();
    private JdbcStorage jdbcStorage = new JdbcStorage();

    @Test
    public void whenSaveNumberInXml() throws ParserConfigurationException, TransformerConfigurationException {
        xmlStorage.saveToXML(jdbcStorage.get());
    }

    @Test
    public void whenReadNumbersFromXml() {
        assertThat(xmlStorage.readXML(), is(Arrays.asList("1", "2", "3")));
    }

    @Test
    public void  whenTransformatXML() throws TransformerException {
        xmlStorage.XsltTransformation();
    }

    @Test
    public void whenGetSum() {
        assertThat(xmlStorage.getSum(), is(6));
    }
}