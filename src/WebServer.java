import javax.naming.ldap.SortKey;
import java.net.ServerSocket;
import java.net.Socket;

public final class WebServer
{
    public static void main(String argv[]) throws Exception
    {
		// Set the port number .
        final int port = 6789;

        final Socket socket = new Socket("host.someschool.edu", port);

        // Process HTTP service requests in an infinite loop.
        while(true) {
            // Listen for a TCP connection request.

            // Construct an object to process the HTTP request message.
            final HttpRequest request = new HttpRequest(socket);

            // Create a new thread to process the request.
            final Thread thread = new Thread(request);

            // Start the thread.
            thread.start();

        }
    }
}