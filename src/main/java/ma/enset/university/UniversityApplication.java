package ma.enset.university;

import ma.enset.university.entities.Patient;
import ma.enset.university.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
@Autowired
private PatientRepository patientRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientRepository.save(new Patient(1L, "ahmed", "07-03-2001", true, 1));
        patientRepository.save(new Patient(2L, "amine", "07-03-2002", false, 2));
        patientRepository.save(new Patient(3L, "amina", "07-03-2003", true, 3));
        patientRepository.save(new Patient(4L, "omar", "07-03-2004", false, 4));
        List<Patient> patiens = patientRepository.findAll();
        patiens.forEach(patient -> {
            System.out.println(patient.toString());
        });
        Patient patient = patientRepository.findById(Long.valueOf(1)).get();
        System.out.println("************************");
        System.out.println(patient.getId());
        System.out.println(patient.getNom());
        System.out.println(patient.getScore());
        System.out.println(patient.getDateNaissance());
        System.out.println("*********************************");
        System.out.println("--------------------------------------------");
        List<Patient> patients = patientRepository.findByNomContaining("o");
        patients.forEach(patient1 -> {
            System.out.println(patient1);
        });
        System.out.println("*************-------------------------****************");

        List<Patient> p = patientRepository.searchByName("%o%");
        p.forEach(pa -> {
            System.out.println(pa);
        });
        System.out.println("*********------------------------------------------------");

        // Supprimer un patient par son ID
        Long patientIdToDelete = 2L; // ID du patient à supprimer
        patientRepository.deleteById(patientIdToDelete);
        System.out.println("Patient avec l'ID " + patientIdToDelete + " a été supprimé.");

        // Afficher la liste mise à jour des patients après la suppression
        System.out.println("Liste mise à jour des patients après la suppression :");
        List<Patient> patientsAfterDeletion = patientRepository.findAll();
        patientsAfterDeletion.forEach(System.out::println);
        System.out.println("_______________________________________________");

        Long patientIdToDelete1 = 3L; // ID du patient à supprimer
        patientRepository.deletePatientByIdSQL(patientIdToDelete1);
        System.out.println("Patient avec l'ID " + patientIdToDelete1 + " a été supprimé.");

        // Afficher la liste mise à jour des patients après la suppression
        System.out.println("Liste mise à jour des patients après la suppression :");
        List<Patient> patientsAfterDeletion1 = patientRepository.findAll();
        patientsAfterDeletion1.forEach(System.out::println);

    }
    }
