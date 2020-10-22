/**
 * au demarrage, spring va detecter une interface qui instancie et cree un objet utilise dans l'application
 * cette classe est la representation de la couche DAO pour Etudiant
 */

package com.fouad.training.scolarite.dao;

import com.fouad.training.scolarite.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Long type is for the etudiant ID
 */

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByNom(String n);
    Page<Etudiant> findByNom(String n, Pageable pageable);
    @Query(value = "select * from etudiant where nom like :x", nativeQuery = true)
    Page<Etudiant> chercherEtudiantsParMc(@Param("x")String mc, Pageable pageable);
    //@Query(value = "select u from etudiant from u.dateNaissance >= :x AND u.dateNaissance <= :y", nativeQuery = true)
    //List<Etudiant> chercherEtudiants2(@Param("x")Date d1, @Param("y")Date d2);
}