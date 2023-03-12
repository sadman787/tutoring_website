package com.sadman.School_management.service;

import com.sadman.School_management.controller.ContactController;
import com.sadman.School_management.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {
    public boolean saveMessageDetails(Contact contact){
        log.info(contact.toString());
        return true;
    }
}
