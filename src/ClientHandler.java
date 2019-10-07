import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SocketHandler;

public class ClientHandler extends Thread {
    protected Socket incoming;
    protected String name = null;
    BufferedReader in;
    PrintWriter out;
    Chat chat;

    public ClientHandler(Socket socket, Chat c) throws IOException {
        chat = c;
        incoming = socket;
        in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(incoming.getOutputStream()));
        chat.addClientHandler(this);
    }

    public boolean isUserLogin() {
        return (name != null);
    }

    public synchronized void broadcast(String msg) {

        for (ClientHandler c: chat.getClientHandler()) {
            if (c.isUserLogin()){
                if (c.name == name){
                    c.out.println("Sua mensagem:  " + msg);
                    c.out.flush();
                }else{
                    c.out.println("Mensagem enviada por " + name + " "+ msg);
                    c.out.flush();
                    System.out.println("Mensagem recebida por " + c.name);
                }
            }
        }

    }

    public void run() {
        try {
            out.println("Bem-vindo a matrix!");
            out.println("Digite SAIR para encerrar a conexão");
            out.println("");
            out.flush();
            name = in.readLine();
            while (true) {
                String str = in.readLine();
                System.out.println("Menssagem recebida por " + name);
                if (str == null) break;
                broadcast(str);
                if (str.trim().toUpperCase().equals("SAIR")) break;
            }
            in.close();
            out.close();
            incoming.close();
        } catch (Exception e) {}
        finally {

        }

    }

}
