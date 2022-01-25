package code.service;

import code.model.Branch;

import java.util.List;
import java.util.Optional;

public interface IBranchService {

    public List<Branch> findAll();

    public Branch findById(int id);

    public void save(Branch branch);

    public void delete(int id);
}
