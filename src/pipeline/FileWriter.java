package pipeline;

import exceptions.FileWriteException;
import java.io.IOException;

public class FileWriter {

    public void write(int result, boolean simulateFailure) throws FileWriteException {
        if (simulateFailure) {
            throw new FileWriteException(
                    "Could not write result to file",
                    new IOException("Permission denied: output.txt")
            );
        }
        System.out.println("[FileWriter] Wrote result → " + result);
    }
}