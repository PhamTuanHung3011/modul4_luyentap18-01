package code.service;


import code.model.Staff;
import code.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository

public class StaffService implements IStaffService {
    @Autowired
    StaffRepo staffRepo;



//    @Override
//    public List<Staff> findAll() {
//        return (List<Staff>) staffRepo.findAll();
//    }


    @Override
    public Page<Staff> findAllByNameStaffContaining(String nameStaff, Pageable pageable) {
        return staffRepo.findAllByNameStaffContaining(nameStaff, pageable);
    }

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepo.findAll(pageable);
    }


    @Override
    public void save(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void delete(int id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Staff findById(int idStaff) {
        return staffRepo.findById(idStaff).get();
    }

    @Override
    public boolean countImg(String img) {
        int count =0;
        for (Staff s:staffRepo.findAll()) {
            if(img.equals(s.getImgStaff())){
                count++;
        }
    }
        if(count > 1){
            return false;
        }
        return true;
    }


}
