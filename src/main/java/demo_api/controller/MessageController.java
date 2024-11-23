package demo_api.controller;
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
    private final ModelMapper modelMapper = new ModelMapper();

    public MessageController(MessageService messageService,
                             CategoryService categoryService,
                             RegionService regionService){
        this.messageService = messageService;
        this.categoryService = categoryService;
        this.regionService = regionService;
    }

    @GetMapping("{id}")
    public GetMessageDTO getMessageDetails(@PathVariable("id")Long id){
        return this.modelMapper
                .map(this.messageService.getMessage(id),GetMessageDTO.class);
    }

    @PostMapping
    public String createMessage(@RequestBody CreateMessageDTO message){
        Category category = this.categoryService.getCategory(message.getCategoryId());
        Region region = this.regionService.getRegion(message.getRegionId());

        Message createdMessage = new Message(category,region,message.getLocation(),message.getDescription());
        this.messageService.createMessage(createdMessage);

        return "Message created successfully!";
    }

    @PutMapping("{id}")
    public String updateMessage(@PathVariable("id")Long id
            ,@RequestBody CreateMessageDTO message){
        Message messageToUpdate = this.messageService.getMessage(id);
        Category category = this.categoryService.getCategory(message.getCategoryId());
        Region region = this.regionService.getRegion(message.getRegionId());

        messageToUpdate.setLocation(message.getLocation());
        messageToUpdate.setDescription(message.getDescription());
        messageToUpdate.setRegion(region);
        messageToUpdate.setCategory(category);

        this.messageService.updateMessage(messageToUpdate);
        return "Message updated successfully!";
    }

    @DeleteMapping("{id}")
    public String deleteMessage(@PathVariable("id")Long id){
        this.messageService.deleteMessage(id);
        return "Message deleted successfully!";
    }

    @GetMapping
    public List<GetMessageDTO> getAllMessages(){
        return this.messageService.getAllMessages()
                .stream()
                .map(m -> modelMapper.map(m,GetMessageDTO.class))
                .toList();
    }
}
