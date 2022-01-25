package code.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idStaff;

    @Size(min = 4, max = 8, message = "CodeStaff min la 4, max la 8")
    private String codeStaff;

    @NotEmpty(message = "Ten khong duoc de trong")
    private String nameStaff;

    @Min(value = 18, message = "Tuoi tu 20 den 60")
    @Max(value = 60 , message = "Tuoi tu 20 den 60")
    private int ageStaff;

    private double salaryStaff;
    private String imgStaff;

    @ManyToOne
    private Branch branch;

    public Staff() {
    }

    public Staff(String codeStaff, String nameStaff, int ageStaff, double salaryStaff, String imgStaff, Branch branch) {
        this.codeStaff = codeStaff;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.salaryStaff = salaryStaff;
        this.imgStaff = imgStaff;
        this.branch = branch;
    }

    public String getImgStaff() {
        return imgStaff;
    }

    public void setImgStaff(String imgStaff) {
        this.imgStaff = imgStaff;
    }

    public String getCodeStaff() {
        return codeStaff;
    }

    public void setCodeStaff(String codeStaff) {
        this.codeStaff = codeStaff;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public int getAgeStaff() {
        return ageStaff;
    }

    public void setAgeStaff(int ageStaff) {
        this.ageStaff = ageStaff;
    }

    public double getSalaryStaff() {
        return salaryStaff;
    }

    public void setSalaryStaff(double salaryStaff) {
        this.salaryStaff = salaryStaff;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
