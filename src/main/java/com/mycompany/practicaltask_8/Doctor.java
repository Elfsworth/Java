package com.mycompany.practicaltask_8;
public class Doctor {
    String fullName;
    String specialty;
    int staffNumber;
    int shiftsPerMonth;
    boolean accreditation;

    public Doctor(String fullName, String specialty, int staffNumber, int shiftsPerMonth, boolean accreditation) {
        this.fullName = fullName;
        this.specialty = specialty;
        this.staffNumber = staffNumber;
        this.shiftsPerMonth = shiftsPerMonth;
        this.accreditation = accreditation;
    }

    @Override
    public String toString() {
        return fullName + ", " + specialty + ", " + staffNumber + ", " + shiftsPerMonth + ", " + accreditation;
    }
}