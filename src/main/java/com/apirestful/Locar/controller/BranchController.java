package com.apirestful.Locar.controller;

import com.apirestful.Locar.Services.BranchService;
import com.apirestful.Locar.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BranchController {

    @Autowired
    BranchService branchService;
    private Branch branch;

    @GetMapping("/branch")
    public List<Branch> listaFiliais(){
        return branchService.findAll();
    }

    @GetMapping("/branch/{id}")
    public Branch idBranch(@PathVariable(value = "id")int id){
        return branchService.findById(id);
    }

    @PostMapping("/branch")
    public Branch saveBranch(@RequestBody Branch branch){
        return branchService.save(branch);
    }

    @DeleteMapping("/branch")
    public void deleteBranch(@RequestBody Branch branch){
        branchService.delete(branch);
    }

    @PutMapping("/branch")
    public Branch refreshBranch(@RequestBody Branch branch){
        return branchService.save(branch);
    }

}
