import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest implements Runnable {
    final static String CRLF = "\r\n";
    final Socket socket;

    // Constructor
    public HttpRequest(final Socket socket) throws Exception {
        this.socket = socket;
    }

    // Implement the run() method of the Runnable interface.
    public void run() {
        try {
            processRequest();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void processRequest() throws Exception {
        // Get a reference to the socket's input and output streams.

        final InputStream inputStream = this.socket.getInputStream();
         final DataOutputStream outputStream = (DataOutputStream) this.socket.getOutputStream();

        // Set up input stream filters.
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // Get the request line of the HTTP request message.
        final String requestLine = bufferedReader.readLine();

        // Display the request line.
        System.out.println();
        System.out.println(requestLine);

        // Get and display the header lines.
        String headerLine = null;
        while ((headerLine = bufferedReader.readLine()).length() != 0) {
            System.out.println(headerLine);
        }

        // Close streams and socket.
        outputStream.close();
        bufferedReader.close();
        socket.close();

    }

}
