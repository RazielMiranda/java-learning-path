import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {

    public static void main(String[] args) {
        Chat chat = new Chat();
        try {
            ServerSocket s = new ServerSocket(8902);
            while (true) {
                Socket incoming = s.accept();
                new ClientHandler(incoming, chat).start();
            }
        } catch (IOException e) { }
    }
}