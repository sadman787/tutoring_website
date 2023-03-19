package com.sadman.School_management.service;

import com.sadman.School_management.constants.AllConstants;
import com.sadman.School_management.model.Contact;
import com.sadman.School_management.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        Contact savedContact = contactRepository.save(contact);
        if (savedContact != null && savedContact.getContactId() > 0){
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(AllConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int id, String name){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(AllConstants.CLOSE);
            contact1.setUpdatedBy(name);
            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if (updatedContact != null && updatedContact.getUpdatedBy() != null){
            isUpdated = true;
        }
        return isUpdated;
    }
}
