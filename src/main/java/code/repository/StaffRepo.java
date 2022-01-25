package code.repository;

import code.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface StaffRepo extends PagingAndSortingRepository<Staff, Integer> {

//    @Query(value = "select s from Staff s where s.nameStaff like concat('%', :name, '%') ")
//    ArrayList<Staff> findAllByName(@Param("name") String name);

    Page<Staff> findAllByNameStaffContaining(String nameStaff, Pageable pageable);

}
