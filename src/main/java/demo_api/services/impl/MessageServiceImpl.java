package demo_api.services.impl;
import demo_api.models.Message;
import demo_api.repositories.MessageRepository;
import demo_api.services.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public void createMessage(Message message) {
        this.messageRepository.save(message);
    }

    @Override
    public void updateMessage(Message message) {
        this.messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long id) {
        this.messageRepository
                .deleteById(id);
    }

    @Override
    public Message getMessage(Long id) {
        return this.messageRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<Message> getAllMessages() {
        return this.messageRepository.findAll();
    }
}
