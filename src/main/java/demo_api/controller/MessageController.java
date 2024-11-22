package demo_api.controller;
import demo_api.models.Category;
import demo_api.models.Message;
import demo_api.models.Region;
import demo_api.services.CategoryService;
import demo_api.services.MessageService;
import demo_api.services.RegionService;
import org.springframework.web.bind.annotation.*;
import demo_api.models.dto.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;
    private final CategoryService categoryService;
    private final RegionService regionService;

    public MessageController(MessageService messageService,
                             CategoryService categoryService,
                             RegionService regionService){
        this.messageService = messageService;
        this.categoryService = categoryService;
        this.regionService = regionService;
    }

    @GetMapping("{Id}")
    public Message getMessageDetails(@PathVariable("id")Long id){
        return this.messageService.getMessage(id) ;
    }

    @PostMapping
    public String createMessage(@RequestBody createMessageDTO message){
        Category category = this.categoryService.getCategory(message.getCategoryId());
        Region region = this.regionService.getRegion(message.getRegionId());

        Message createdMessage = new Message(category,region,message.getLocation(),message.getDescription());
        this.messageService.createMessage(createdMessage);

        return "Message created successfully!";
    }

    @PutMapping
    public String updateMessage(@RequestBody Message message){
        this.messageService.updateMessage(message);
        return "Message created successfully!";
    }

    @DeleteMapping("{id}")
    public String deleteMessage(@PathVariable("id")Long id){
        this.messageService.deleteMessage(id);
        return "Message deleted successfully!";
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return this.messageService.getAllMessages();
    }
}
