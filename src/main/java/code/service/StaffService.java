package code.service;


import code.model.Staff;
import code.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public class StaffService implements IStaffService {
    @Autowired
    StaffRepo staffRepo;



    @Override
    public List<Staff> findAll() {
        return (List<Staff>) staffRepo.findAll();
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
    public Staff findById(int id) {
        return staffRepo.findById(id).get();
    }
}
