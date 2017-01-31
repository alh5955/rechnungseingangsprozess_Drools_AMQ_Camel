package edu.thi.test;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author Alexander Hauke
 */

public class CreateInvoiceXml{
    
    public void InvoiceToXml(String tmp){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("invoice");
            doc.appendChild(rootElement);

            Element invoiceElements = doc.createElement("invoiceElements");
            rootElement.appendChild(invoiceElements);

            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            invoiceElements.setAttributeNode(attr);

            Element invoiceValue = doc.createElement("invoiveValue");
            invoiceValue.appendChild(doc.createTextNode(tmp));
            invoiceElements.appendChild(invoiceValue);

            TransformerFactory trnsformerFactory = TransformerFactory.newInstance();
            Transformer transformer = trnsformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            String xmlPath = "data/in";
            StreamResult result = new StreamResult(new File(xmlPath, "invoiceValues.xml").getPath());

            transformer.transform(source, result);

            // System.out.println("File saved");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
