package com.ccit.utils;

import com.ccit.handler.SaxHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XmlDocumentUtil {

    private static final String FILE_PATH = "src/main/resources/applicationContext.xml";

    public static void main(String[] args) {
        parseFromSAX();
    }

    //通过dom解析
    public static void parseFromDOM() {
        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = docBuilder.parse(new File(FILE_PATH));

            NodeList nodeList = document.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.hasChildNodes()) {
                    NodeList childNodeList = node.getChildNodes();

                    for (int j = 0; j < childNodeList.getLength(); j++) {
                        Node childNode = childNodeList.item(j);

                        System.out.println(childNode.getNodeName() + ":" + childNode.getTextContent());
                    }
                } else {
                    System.out.println(node.getNodeName() + ":" + node.getTextContent());
                }
            }
        } catch (Exception e) {
            System.out.println("xml文件解析有误!");
        }
    }

    //通过SAX解析

    public static void parseFromSAX() {
        SAXParserFactory saxfac = SAXParserFactory.newInstance();
        try {
            SAXParser saxparser = saxfac.newSAXParser();
            saxparser.parse(new File(FILE_PATH), new SaxHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}