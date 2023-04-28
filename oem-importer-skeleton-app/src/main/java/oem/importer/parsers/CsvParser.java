package oem.importer.parsers;

public class CsvParser implements Parser {
    public CsvParser() {

    }

    @Override
    public String parse() {
        return "CSV|FORD|FIESTA|RED|123";
    }
}
