package org.lessons.springilmiofotoalbum.service;

import org.lessons.springilmiofotoalbum.model.Message;
import org.lessons.springilmiofotoalbum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

      @Autowired
      private MessageRepository messageRepository;

      // metodo che crea nuovo messaggio
      public Message create(Message formMessage) {
            Message newMessage = new Message();
            newMessage.setCreatedAt(LocalDateTime.now());
            newMessage.setEmail(formMessage.getEmail());
            newMessage.setText(formMessage.getText());
            return messageRepository.save(newMessage);
      }
}
