package code.model;


import javax.persistence.*;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idStaff;
    private String CodeStaff;
    private String nameStaff;
    private int ageStaff;
    private double salaryStaff;

    @ManyToOne
    private Branch branch;

    public Staff() {

    }

    public Staff(int idStaff, String codeStaff, String nameStaff, int ageStaff, double salaryStaff, Branch branch) {
        this.idStaff = idStaff;
        CodeStaff = codeStaff;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.salaryStaff = salaryStaff;
        this.branch = branch;
    }

    public Staff(String codeStaff, String nameStaff, int ageStaff, double salaryStaff, Branch branch) {
        CodeStaff = codeStaff;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.salaryStaff = salaryStaff;
        this.branch = branch;
    }


    public String getCodeStaff() {
        return CodeStaff;
    }

    public void setCodeStaff(String codeStaff) {
        CodeStaff = codeStaff;
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
