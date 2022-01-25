package code.controller;


import code.model.Branch;
import code.model.Staff;
import code.service.IBranchService;
import code.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class StaffController {
    @Autowired
    IStaffService staffService;

    @Autowired
    IBranchService branchService;

    @ModelAttribute("staff")
    public Staff staff(){
        return new Staff();
    }

    @ModelAttribute("branch")
    public List<Branch> branch() {
        return branchService.findAll();
    }

    @GetMapping("/show")
    public Page<Staff> showAll(@RequestParam(defaultValue = "0") int page) {
        return staffService.findAll(PageRequest.of(page, 3));
    }

    @PostMapping("/create")
    public Staff create(@RequestBody Staff staff) {
        staffService.save(staff);
        return staff;
    }
//    public String createStaff(@Validated @ModelAttribute (value = "staff") Staff staff, BindingResult bindingResult, @RequestParam MultipartFile upImg) {
//        if(bindingResult.hasFieldErrors()) {
//            return "/create";
//        }
//            String fileName = upImg.getOriginalFilename();
//            try {
//                FileCopyUtils.copy(upImg.getBytes(), new File("E:\\Tu\\modul4\\luyentap1\\src\\main\\webapp\\WEB-INF\\img\\" +fileName));
//                staff.setImgStaff("/img/"+fileName);
//            } catch (IOException e) {
//                staff.setImgStaff("/img/1.jpg");
//                e.printStackTrace();
//            }
//
//        staffService.save(staff);
//        return "redirect:/show";
//    }

    @GetMapping("/delete/{idStaff}")
    public Staff showDelete(@PathVariable int idStaff) {
        Staff staff= staffService.findById(idStaff);
        return staff;
    }
    @DeleteMapping("/delete/{idStaff}")
    public void delete(@PathVariable int idStaff) {
        staffService.delete(idStaff);

    }

    @GetMapping("/edit/{idStaff}")
    public Staff showEdit(@PathVariable int idStaff) {
        Staff staff= staffService.findById(idStaff);
        return staff;
    }

    @PutMapping("/edit")
    public Staff edit(@RequestBody Staff staff) {
        staffService.save(staff);
        return staff;
    }


//    public String editStaff(@Validated @RequestBody Staff staff, BindingResult bindingResult, @RequestParam MultipartFile upImg) {
//        if(bindingResult.hasFieldErrors()) {
//            return "/edit";
//        }
//        if (upImg.getSize() !=0) {
//            String fileName = upImg.getOriginalFilename();
//            if(!staff.getImgStaff().equals("/img/1.jpg") && staffService.countImg(staff.getImgStaff())){
//                String deleteFile = "E:\\Tu\\modul4\\luyentap1\\src\\main\\webapp\\WEB-INF/"+ staff.getImgStaff();
//                File file = new File(deleteFile);
//                file.delete();
//            }
//            try {
//                FileCopyUtils.copy(upImg.getBytes(), new File("E:\\Tu\\modul4\\luyentap1\\src\\main\\webapp\\WEB-INF\\img\\" +fileName));
//                staff.setImgStaff("/img/"+fileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        staffService.save(staff);
//        return "redirect:/show";
//    }

   @GetMapping("/detail")
   public ModelAndView showDetail(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        return modelAndView;
   }

    @GetMapping("/find/{name}")
    public ResponseEntity <Page<Staff>> findAllByName (@PathVariable String name, @RequestParam(defaultValue = "0") int page){
        return new ResponseEntity( staffService.findAllByNameStaffContaining(name,PageRequest.of(page, 2)), HttpStatus.OK);
    }
}
