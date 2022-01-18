package code.repository;

import code.model.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepo extends CrudRepository<Staff, Integer> {
}
