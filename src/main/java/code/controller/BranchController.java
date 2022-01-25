package code.controller;


import code.model.Branch;
import code.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BranchController {
    @Autowired
    IBranchService iBranchService;

    @GetMapping("/home/branch")
    public List<Branch> show() {
        return iBranchService.findAll();
    }

    @PostMapping("/home/branch")
    public Branch create(@RequestBody Branch branch) {
        iBranchService.save(branch);
        return branch;
    }

    @DeleteMapping("/home/branch/{id}")
    public void delete(@PathVariable int id) {
        iBranchService.delete(id);
    }

    @PutMapping("/home/branch/{id}")
    public void update(@RequestBody Branch branch) {
        iBranchService.save(branch);
    }
}
