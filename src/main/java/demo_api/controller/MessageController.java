package demo_api.controller;
import demo_api.exception.EntityNotFoundException;
import demo_api.models.Category;
import demo_api.models.Message;
import demo_api.models.Region;
import demo_api.services.CategoryService;
import demo_api.services.MessageService;
import demo_api.services.RegionService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import demo_api.models.dto.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;
    private final CategoryService categoryService;
    private final RegionService regionService;
    private final ModelMapper modelMapper;

    public MessageController(MessageService messageService,
                             CategoryService categoryService,
                             RegionService regionService,
                             ModelMapper modelMapper){
        this.messageService = messageService;
        this.categoryService = categoryService;
        this.regionService = regionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}")
    public GetMessageDTO getMessageDetails(@PathVariable("id")Long id){
        Message message = this.messageService.getMessage(id);
        if(message == null){
            throw new EntityNotFoundException("Message does not exist in the database!");
        }

        return this.modelMapper
                .map(message,GetMessageDTO.class);
    }

    @PostMapping
    public String createMessage(@RequestBody MessageDTO message){
        Category category = this.categoryService.getCategory(message.getCategoryId());
        if(category == null){
            throw new EntityNotFoundException("Category does not exist in the database!");
        }

        Region region = this.regionService.getRegion(message.getRegionId());
        if(region == null){
            throw new EntityNotFoundException("Region does not exist in the database!");
        }

        Message createdMessage = new Message(category,region,message.getLocation(),message.getDescription());
        this.messageService.createMessage(createdMessage);

        return "Message created successfully!";
    }

    @PutMapping("{id}")
    public String updateMessage(@PathVariable("id")Long id
            ,@RequestBody MessageDTO message){
        Message messageToUpdate = this.messageService.getMessage(id);
        if(messageToUpdate == null){
            throw new EntityNotFoundException("Message does not exist in the database!");
        }

        Category category = this.categoryService.getCategory(message.getCategoryId());
        if(category == null){
            throw new EntityNotFoundException("Category does not exist in the database!");
        }

        Region region = this.regionService.getRegion(message.getRegionId());
        if(region == null){
            throw new EntityNotFoundException("Region does not exist in the database!");
        }

        messageToUpdate.setLocation(message.getLocation());
        messageToUpdate.setDescription(message.getDescription());
        messageToUpdate.setRegion(region);
        messageToUpdate.setCategory(category);

        this.messageService.updateMessage(messageToUpdate);
        return "Message updated successfully!";
    }

    @DeleteMapping("{id}")
    public String deleteMessage(@PathVariable("id")Long id){
        Message message = this.messageService.getMessage(id);
        if(message == null){
            throw new EntityNotFoundException("Message does not exist in the database!");
        }

        this.messageService.deleteMessage(id);
        return "Message deleted successfully!";
    }

    @GetMapping
    public List<GetMessageDTO> getAllMessages(){
        List<Message> messages = this.messageService.getAllMessages();
        if(messages == null){
            throw new EntityNotFoundException("Message does not exist in the database!");
        }

        return messages
                .stream()
                .map(m -> modelMapper.map(m,GetMessageDTO.class))
                .toList();
    }
}
