package code.service;

import code.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStaffService {

//    public List<Staff> findAll();
    public Page<Staff> findAllByNameStaffContaining(String nameStaff,Pageable pageable);

    Page<Staff> findAll(Pageable pageable);

    public void save(Staff staff);

    public void delete(int id);

    public Staff findById(int id);

    public boolean countImg(String img);


}
