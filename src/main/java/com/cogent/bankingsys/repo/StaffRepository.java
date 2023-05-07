package com.cogent.bankingsys.repo;

import com.cogent.bankingsys.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    Optional<Staff> findBystaffUserName(String staffUserName);
    List<staffFullNameAndstaffUserNameAndStatusProjection> findAllBy();
    interface staffFullNameAndstaffUserNameAndStatusProjection {
        Long getStaffId();
        String getStaffFullName();
        String getStaffUserName();
        Enum getStatus();

    }

}
