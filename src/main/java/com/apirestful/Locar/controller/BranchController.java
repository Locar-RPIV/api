package com.apirestful.Locar.controller;

import com.apirestful.Locar.Services.BranchService;
import com.apirestful.Locar.model.Branch;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BranchController {

    @Autowired
    BranchService branchService;

    @GetMapping("/branch")
    public List<Branch> listaFiliais(){
        return branchService.findAll();
    }

    @GetMapping("/branch/{id}")
    public <Any> Any idBranch(@PathVariable(value = "id")int id){
        Branch branch = branchService.findById(id);
        Response response = new Response();
        if (branch != null) {
            return (Any) branch;
        }
        response.setMessage("Erro interno.");
        return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/branch")
    public Branch saveBranch(@RequestBody Branch branch){
        return branchService.save(branch);
    }

    @DeleteMapping("/branch")
    public <Any> Any deleteBranch(@RequestBody Branch branch){
        Response response = new Response();
        try {
            branchService.delete(branch);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/branch")
    public Branch refreshBranch(@RequestBody Branch branch){
        return branchService.save(branch);
    }

}
