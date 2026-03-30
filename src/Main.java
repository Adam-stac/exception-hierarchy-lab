import exceptions.FileReadException;
import exceptions.FileParseException;
import exceptions.FileWriteException;
import pipeline.FileReader;
import pipeline.FileParser;
import pipeline.FileWriter;

public class Main {

    public static void main(String[] args) {
        runPipeline(false, false, true);
    }

    private static void runPipeline(
            boolean failRead,
            boolean failParse,
            boolean failWrite) {

        FileWriter writer = new FileWriter();

        try (FileReader reader = new FileReader();
             FileParser parser = new FileParser()) {

            String rawContent = reader.read(failRead);
            int result        = parser.parse(rawContent, failParse);
            writer.write(result, failWrite);

            System.out.println("Pipeline completed. Result: " + result);

        } catch (FileReadException e) {
            System.out.println("FAIL FAST — aborting pipeline");
            System.out.println("  " + e.getMessage());
            System.out.println("  Caused by: " + e.getCause().getMessage());

        } catch (FileParseException e) {
            System.out.println("RECOVER — skipping bad record");
            System.out.println("  " + e.getMessage());
            System.out.println("  Caused by: " + e.getCause().getMessage());

        } catch (FileWriteException e) {
            System.out.println("PROPAGATE — rethrowing");
            throw new RuntimeException("Pipeline write failure", e);
        }
    }
}