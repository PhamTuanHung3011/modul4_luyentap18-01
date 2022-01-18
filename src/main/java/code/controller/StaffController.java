package code.controller;


import code.model.Branch;
import code.model.Staff;
import code.service.IBranchService;
import code.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffController {
    @Autowired
    IStaffService staffService;

    @Autowired
    IBranchService branchService;

    @GetMapping("/show")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("staffs", staffService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("staff", new Staff());
        modelAndView.addObject("branch", branchService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createStaff(@ModelAttribute Staff staff, @RequestParam int idBranch) {
        Branch branch = new Branch();
        branch.setIdBranch(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        return "redirect:/show";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        staffService.delete(id);
        return "redirect:/show";
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("staff", staffService.findById(id));
        modelAndView.addObject("branch", branchService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editStaff(@ModelAttribute(value = "staff") Staff staff, @RequestParam int idBranch) {
        Branch branch = new Branch();
        branch.setIdBranch(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        return "redirect:/show";
    }

   @GetMapping("/detail")
   public ModelAndView showDetail(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("staff", staffService.findById(id));
        modelAndView.addObject("branch", branchService.findAll());
        return modelAndView;
   }


}
