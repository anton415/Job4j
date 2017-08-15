package ru.aserdyuchenko.JDBC;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * TODO add absolut path to xml file.
 * TODO make class loke beautiful.
 * TODO convert 1.xml to 2.xml with XSLT
 * TODO get sum from 2.xml
 */
public class XmlStorage {

    /**
     * Save to 1.xml
     * @param list
     * @throws ParserConfigurationException
     * @throws TransformerConfigurationException
     */
    public void saveToXML(List<Integer> list) throws ParserConfigurationException, TransformerConfigurationException {
        Iterator<Integer> iterator = list.iterator();
        Document dom;
        Element e = null;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.newDocument();

            // create the root element
            Element rootEle = dom.createElement("entries");

            // create data elements and place them under root
            while (iterator.hasNext()) {
                e = dom.createElement("entry");
                Element child = dom.createElement("field");
                child.setTextContent(iterator.next().toString());
                e.appendChild(child);
                //e.setAttribute("field", iterator.next().toString());

                //e.appendChild(dom.createTextNode(iterator.next().toString()));
                rootEle.appendChild(e);
            }

            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                // send DOM to file
                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream("src/main/java/ru.aserdyuchenko/JDBC/1.xml")));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    /**
     * Read from 1.xml
     * @return
     */
    public List<String> readXML() {
        List<String> list = new ArrayList<>();
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the
            // XML file
            dom = db.parse("src/main/java/ru.aserdyuchenko/JDBC/1.xml");

            NodeList doc = dom.getElementsByTagName("field");
            for (int i = 0; i < doc.getLength(); i++){
                String number = doc.item(i).getTextContent();
                list.add(number);
            }

            return list;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return null;
    }

    public void XsltTransformation() throws TransformerException {
        String xmlFile = "src/main/java/ru.aserdyuchenko/JDBC/1.xml";
        String xslFile = "src/main/java/ru.aserdyuchenko/JDBC/file.xml";

        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(xslFile));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new File(xmlFile));
        transformer.transform(text, new StreamResult(new File("src/main/java/ru.aserdyuchenko/JDBC/2.xml")));
    }
}
