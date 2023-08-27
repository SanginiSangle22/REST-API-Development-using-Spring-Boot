package com.example.student.serviceimpl;

import com.example.student.entity.stud;
import com.example.student.exception.resourcenotfound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.repository.studrepo;
import com.example.student.service.studservice;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class studserviceimpl implements studservice {
    @Autowired
    studrepo srrepository;

    @Override
    public stud create(stud sr) {
        return srrepository.save(sr);
    }

    @Override
    public List<stud> getAll() {
        return srrepository.findAll();
    }

    @Override
    public List<stud> getsome() {
        List<stud> productList = srrepository.findAll  ();
        List<stud> collect = productList.stream().filter(i -> i.getId() > 100).collect(Collectors.toList());
        return collect;
    }

    @Override
    public String deleteall() {
        srrepository.deleteAll();
        return "Delete data";
    }

    @Override
    public String deletebyid(long id) {
        Optional<stud> byId = srrepository.findById(id);
        if (byId.isEmpty()) {
            return "student not exits with id " + id;
        }
        srrepository.deleteById(id);
        return "student delelted with id" + id;
    }

    @Override
    public String update(long id, stud pro) {
        Optional<stud> Existingemp = srrepository.findById(id);
        if (Existingemp.isPresent()) {
            if (Existingemp.get().getId() == pro.getId()) {
                srrepository.save(pro);
                return "Updated";
            }
            return "Id not matched";
        }
        return "Id not found";
    }

}