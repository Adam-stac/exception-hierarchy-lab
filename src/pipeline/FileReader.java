package pipeline;

import exceptions.FileReadException;
import java.io.IOException;

public class FileReader implements AutoCloseable {

    public FileReader() {
        System.out.println("[FileReader] Opened");
    }

    public String read(boolean simulateFailure) throws FileReadException {
        if (simulateFailure) {
            throw new FileReadException(
                    "Could not read file",
                    new IOException("No such file: data.csv")
            );
        }
        return "record_id=1,value=42";
    }

    @Override
    public void close() {
        System.out.println("[FileReader] Closed");
    }
}