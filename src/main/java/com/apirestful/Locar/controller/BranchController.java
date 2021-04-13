package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.BranchService;
import com.apirestful.Locar.model.Branch;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @DeleteMapping("/branch/{id}")
    public <Any> Any deleteBranch(@PathVariable(value = "id")int id){
        Response response = new Response();
        try {
            branchService.deleteById(id);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/branch")
    public <Any> Any refreshBranch(@RequestBody Branch branch){
        Response response = new Response();
        try {
            Branch updateBranch = branchService.findById(branch.getId());
            if (branch.getCnpj() != 0)
                updateBranch.setCnpj(branch.getCnpj());
            if (branch.getNome() != null)
                updateBranch.setNome(branch.getNome());

            branchService.save(updateBranch);
            return (Any) new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
