import java.util.ArrayList;
import java.util.List;

public class Chat
{
    private List<ClientHandler> clients= new ArrayList<ClientHandler>();

    public Chat() {}

    public void addClientHandler(ClientHandler c) {
        clients.add(c);
    }

    public List<ClientHandler> getClientHandler() {
        return clients;
    }

}
