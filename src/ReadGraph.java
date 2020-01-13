import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Locale;

public class ReadGraph {
    private Scanner scanner;
    ReadGraph(Graph graph,String filename){
        readFile(filename);
        try{
            int V=scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            assert V == graph.V();

            int E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");

            for(int i=0;i<E;i++){
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                assert v >= 0 && v < V;
                assert w >= 0 && w < V;
                graph.addEdge(v, w);
            }
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
    }
    private void readFile(String filename){
        try{
            File file=new File(filename);
            if(file.exists()){
                FileInputStream fileInputStream=new FileInputStream(file);
                scanner=new Scanner(new BufferedInputStream(fileInputStream), StandardCharsets.UTF_8);
                scanner.useLocale(Locale.ENGLISH);
            }
            else
                throw new IllegalArgumentException(filename+"doesn't exists.");
        }catch (IOException ioe){
            throw new IllegalArgumentException("Couldn't open"+filename,ioe);
        }
    }
}
