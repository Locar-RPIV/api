package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.BranchService;
import com.apirestful.Locar.model.Branch;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
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

    Response responseErro = new Response("Erro interno.");

    @GetMapping("/branch")
    public List<Branch> listaFiliais(){
        return branchService.findAll();
    }

    @GetMapping("/branch/{id}")
    public <Any> Any idBranch(@PathVariable(value = "id")int id){
        
        Branch branch = branchService.findById(id);
        if (branch != null) {
            return (Any) branch;
        }
        return (Any) new Response("Erro interno.");
    }

    @PostMapping("/branch")
    public Branch saveBranch(@RequestBody Branch branch){
        return branchService.save(branch);
    }

    @DeleteMapping("/branch/{id}")
    public <Any> Any deleteBranch(@PathVariable(value = "id")int id) {
        try {
            branchService.deleteById(id);
            return (Any) new Response("Filial removida.");
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

    @PutMapping("/branch")
    public <Any> Any editBranch(@RequestBody Branch branch) {
        try {
            Branch updateBranch = branchService.findById(branch.getId());
            if (branch.getCnpj() != 0)
                updateBranch.setCnpj(branch.getCnpj());
            if (branch.getNome() != null)
                updateBranch.setNome(branch.getNome());

            return (Any) branchService.save(updateBranch);
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

}
