package com.cogent.bankingsys.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    public enum Status {
        ENABLED,
        DISABLED
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    @Column(name = "staffFullName")
    private String staffFullName;
    @Column(name = "staffUserName")
    private String staffUserName;
    @Column(name = "staffPassword")
    private String staffPassword;
    @Column(name = "stuffAddedDate")
    private LocalDate stuffAddedDate;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStaffFullName() {
        return staffFullName;
    }

    public void setStaffFullName(String staffFullName) {
        this.staffFullName = staffFullName;
    }

    public String getStaffUserName() {
        return staffUserName;
    }

    public void setStaffUserName(String staffUserName) {
        this.staffUserName = staffUserName;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public LocalDate getStuffAddedDate() {
        return stuffAddedDate;
    }

    public void setStuffAddedDate(LocalDate stuffAddedDate) {
        this.stuffAddedDate = stuffAddedDate;
    }

}
