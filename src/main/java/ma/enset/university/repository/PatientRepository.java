package ma.enset.university.repository;

import jakarta.transaction.Transactional;
import ma.enset.university.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    // La premiere methode pour chercher un patient :
    List<Patient> findByNomContaining(String m);

    // La deuxieme methode pour chercher un patient :
    @Query("select p from Patient p where p.nom like :x")
    List<Patient> searchByName(@Param("x") String g);



    // supperimer un patient par son id
    void deleteById(Long id );


    // Supprimer un patient par son ID en utilisant une requête SQL

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Patient WHERE id = :id", nativeQuery = false)
    void deletePatientByIdSQL(@Param("id") Long id);



}
