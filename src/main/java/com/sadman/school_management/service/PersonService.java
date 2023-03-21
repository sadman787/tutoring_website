package com.sadman.school_management.service;

import com.sadman.school_management.constants.AllConstants;
import com.sadman.school_management.model.Person;
import com.sadman.school_management.model.Roles;
import com.sadman.school_management.repository.PersonRepository;
import com.sadman.school_management.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(AllConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (person != null && person.getPersonId() > 0){
            isSaved = true;
        }
        return isSaved;
    }
}
