package oem.importer.services;

import oem.importer.parsers.CsvParser;
import oem.importer.parsers.Parser;
import oem.importer.parsers.XmlParser;

public class ParsingFactory {
    private ParsingFactory(){}
    public static Parser getParser(String fileType) {
        if (fileType == null) {
            return null;
        }
        switch (fileType.toUpperCase()) {
            case "CSV":
                return new CsvParser();
            case "XML":
                return new XmlParser();
            default:
                return null;
        }
    }
}
