package com.sadman.school_management.repository;

import com.sadman.school_management.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer>, CrudRepository<Contact, Integer>  {
    List<Contact> findByStatus(String status);

    Page<Contact> findByStatus(String status, Pageable pageable);
}
