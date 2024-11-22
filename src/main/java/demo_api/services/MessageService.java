package demo_api.services;
import demo_api.models.Message;
import java.util.List;

public interface MessageService {

    public void createMessage(Message message);
    public void updateMessage(Message message);
    public void deleteMessage(Long id);
    public Message getMessage(Long id);
    public List<Message> getAllMessages();
}
