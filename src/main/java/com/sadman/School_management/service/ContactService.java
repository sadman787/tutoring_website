package com.sadman.School_management.service;

import com.sadman.School_management.constants.AllConstants;
import com.sadman.School_management.controller.ContactController;
import com.sadman.School_management.model.Contact;
import com.sadman.School_management.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(AllConstants.OPEN);
        contact.setCreatedBy(contact.getName());
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if (result > 0){
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(AllConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int id, String name){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(id, AllConstants.CLOSE, name);
        if (result > 0){
            isUpdated = true;
        }
        return isUpdated;
    }
}
