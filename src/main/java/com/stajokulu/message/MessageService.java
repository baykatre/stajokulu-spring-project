package com.stajokulu.message;

import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@Service //@Component
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    public String getMessage(){
        return "Hello Servis!";
    }

    public Integer save(Message message) {

        Message message1 = repository.save(message);
        return message1.getId();
    }

    public Message getMessageById(Integer id) throws Exception {

        return repository.findById(id).orElseThrow(() -> new Exception("Kayıt Bulunamadı!"));
    }
}
