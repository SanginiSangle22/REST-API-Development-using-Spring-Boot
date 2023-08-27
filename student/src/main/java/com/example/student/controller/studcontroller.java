package com.example.student.controller;

import com.example.student.entity.stud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.student.service.studservice;
import java.util.List;

@RestController
public class studcontroller {

    @Autowired
    studservice srService;

    @PostMapping("/stud")
    public ResponseEntity<stud> create(@RequestBody stud sr) {
        return ResponseEntity.ok().body(this.srService.create(sr));
    }

    @GetMapping("/Get")
    public ResponseEntity<List<stud>> getAll() {
        return ResponseEntity.ok().body(this.srService.getAll());
    }

    @GetMapping("/find")
    public ResponseEntity<List<stud>> findsome() {
        return ResponseEntity.ok().body(this.srService.getsome());
    }

    @DeleteMapping("/stud/{id}")
    public ResponseEntity<String> deletesrbyid(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(this.srService.deletebyid(id));
    }

    @PutMapping("/update/{prid}")
    public String update(@PathVariable("prid") long id, @RequestBody stud sr) {
        return this.srService.update(id, sr);
    }

    @PatchMapping("/updateone/{prid}")
    public String updateone(@PathVariable("prid") long id, @RequestBody stud sr) {
        return this.srService.update(id, sr);
    }
}