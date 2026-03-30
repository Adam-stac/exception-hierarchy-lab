package pipeline;

import exceptions.FileParseException;

public class FileParser implements AutoCloseable {

    public FileParser() {
        System.out.println("[FileParser] Opened");
    }

    public int parse(String rawContent, boolean simulateFailure) throws FileParseException {
        try {
            if (simulateFailure) {
                Integer.parseInt("N/A");
            }
            String valuePart = rawContent.split(",")[1].replace("value=", "");
            return Integer.parseInt(valuePart);

        } catch (NumberFormatException e) {
            throw new FileParseException(
                    "Could not parse file content — bad format",
                    e
            );
        }
    }

    @Override
    public void close() {
        System.out.println("[FileParser] Closed");
    }
}