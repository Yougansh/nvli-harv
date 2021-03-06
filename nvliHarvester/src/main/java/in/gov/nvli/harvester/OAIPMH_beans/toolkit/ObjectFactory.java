//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.29 at 10:02:32 AM IST 
//


package in.gov.nvli.harvester.OAIPMH_beans.toolkit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.vt.dlib.oai.oai.metadata.toolkit package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Toolkit_QNAME = new QName("http://oai.dlib.vt.edu/OAI/metadata/toolkit", "toolkit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.vt.dlib.oai.oai.metadata.toolkit
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ToolkitType }
     * 
     */
    public ToolkitType createToolkitType() {
        return new ToolkitType();
    }

    /**
     * Create an instance of {@link AuthorType }
     * 
     */
    public AuthorType createAuthorType() {
        return new AuthorType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToolkitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://oai.dlib.vt.edu/OAI/metadata/toolkit", name = "toolkit")
    public JAXBElement<ToolkitType> createToolkit(ToolkitType value) {
        return new JAXBElement<ToolkitType>(_Toolkit_QNAME, ToolkitType.class, null, value);
    }

}
