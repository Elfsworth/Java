package com.mycompany.practicaltask_8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DoctorManagement {
    public static void main(String[] args) {
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(new Doctor("Anton Antonovich Antonov", "therapist", 345, 15, true));
        doctorList.add(new Doctor("Ivanov Ivan Ivanovich", "surgeon", 5, 20, true));
        doctorList.add(new Doctor("Yuriev Yuri Aristarchovich", "ophthalmologist", 65, 10, false));

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Select an action:");
            System.out.println("1. Add a doctor");
            System.out.println("2. Change the mark of passing the certification");
            System.out.println("3. Display a list of doctors");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addDoctor(scanner, doctorList);
                case 2 -> updateAccreditation(scanner, doctorList);
                case 3 -> displayDoctors(doctorList);
                default -> System.out.println("The wrong choice. Try again.");
            }
        }
    }

    private static void addDoctor(Scanner scanner, List<Doctor> doctorList) {
        System.out.println("Enter the doctor's full name:");
        String fullName = scanner.next();

        System.out.println("Enter the doctor's specialty:");
        String specialty = scanner.next();

        System.out.println("Enter the doctor's serial number:");
        int staffNumber = scanner.nextInt();

        boolean exist = doctorList.stream().anyMatch(doctor -> doctor.staffNumber == staffNumber);
        if (exist) {
            System.out.println("The doctor with the specified serial number already exists.");
            return;
        }

        System.out.println("Enter the number of work shifts per month:");
        int shiftsPerMonth = scanner.nextInt();

        System.out.println("Enter the mark of passing the certification (true/false):");
        boolean accreditation = scanner.nextBoolean();

        doctorList.add(new Doctor(fullName, specialty, staffNumber, shiftsPerMonth, accreditation));
        Collections.sort(doctorList, Comparator.comparing(doctor -> doctor.fullName));
    }

    private static void updateAccreditation(Scanner scanner, List<Doctor> doctorList) {
        System.out.println("Enter the doctor's serial number to change the certification mark:");
        int staffNumber = scanner.nextInt();

        Doctor doctor = doctorList.stream().filter(d -> d.staffNumber == staffNumber).findFirst().orElse(null);
        if (doctor == null) {
            System.out.println("The doctor with the specified serial number has not been found.");
            return;
        }

        System.out.println("The current mark of passing the certification: " + doctor.accreditation);
        System.out.println("Enter a new mark about passing the certification (true/false):");
        boolean newAccreditation = scanner.nextBoolean();

        doctor.accreditation = newAccreditation;
        Collections.sort(doctorList, Comparator.comparing(d -> d.fullName));
    }

    private static void displayDoctors(List<Doctor> doctorList) {
        System.out.println("List of doctors:");
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }
    }
}
    