package com.ccit.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println(content);

        super.characters(ch, start, length);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("文档解析结束");
        super.endDocument();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</");
        System.out.print(qName);
        System.out.print(">");
        super.endElement(uri, localName, qName);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析文档");
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        System.out.println(s);
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<");
        System.out.print(qName);

        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print("" + attributes.getQName(i) + "=" + attributes.getValue(i) + "");
            }
        }
        System.out.print(">");

        super.startElement(uri, localName, qName, attributes);
    }
}
