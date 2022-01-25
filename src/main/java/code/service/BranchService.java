package code.service;


import code.model.Branch;
import code.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BranchService implements IBranchService{
    @Autowired
    BranchRepo branchRepo;

    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepo.findAll();
    }

    @Override
    public Branch findById(int id) {
        return branchRepo.findById(id).get();
    }

    @Override
    public void save(Branch branch) {
        branchRepo.save(branch);
    }

    @Override
    public void delete(int id) {
        branchRepo.deleteById(id);
    }


}
