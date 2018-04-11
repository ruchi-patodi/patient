/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Patient;

/**
 * @author rpatodi
 *
 */
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
