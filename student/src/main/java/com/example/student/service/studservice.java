package com.example.student.service;
import com.example.student.entity.stud ;
        import java.util.List;
public interface studservice {
    stud  create(stud sr);
    List<stud> getAll();
    List<stud> getsome();

    String deleteall();
    String deletebyid(long id);

    public String  update (long id,stud  sr);

}