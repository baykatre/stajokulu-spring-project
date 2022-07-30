package com.stajokulu.message;

import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/hello")
    public String getMessage(){
        return messageService.getMessage();
    }

    @PostMapping("/save")
    public Integer saveMessage(@RequestBody Message message){
        return messageService.save(message);
    }

    @GetMapping("/get-message/{id}")
    public Message getMessageById(@PathVariable Integer id) throws Exception {
        return messageService.getMessageById(id);
    }

    @PutMapping("/update")
    public Integer updateMessage(@RequestBody Message message){
        return messageService.save(message);
    }
}


