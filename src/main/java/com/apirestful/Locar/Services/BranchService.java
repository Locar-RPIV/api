package com.apirestful.Locar.Services;

import com.apirestful.Locar.model.Branch;
import com.apirestful.Locar.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    public Branch findById(int id){
        return branchRepository.findById(id);
    }

    public List<Branch> findAll(){
        return branchRepository.findAll();
    }

    public Branch save(Branch branch){
        return branchRepository.save(branch);
    }

    public void delete(Branch branch){
        branchRepository.delete(branch);
    }

    public void deleteById(int id) {
        branchRepository.deleteById(id);
    }

}
