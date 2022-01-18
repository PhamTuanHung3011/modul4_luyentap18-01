package code.service;

import code.model.Staff;

import java.util.List;

public interface IStaffService {
    public List<Staff> findAll();

    public void save(Staff staff);

    public void delete(int id);

    public Staff findById(int id);
}
