package com.medicline.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicline.spring.models.Doctor;
import com.medicline.spring.models.exceptions.ResorceNotFoundException;
import com.medicline.spring.repositorio.DoctorRepositorio;

@CrossOrigin(origins = "http://localhost:3002/")
@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
    @Autowired
    private DoctorRepositorio doctorRepository;

    @GetMapping()
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorId(@PathVariable(value = "id") Integer doctorId)
            throws ResorceNotFoundException {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResorceNotFoundException("Doctor no encontrado por Id: " + doctorId));
        return ResponseEntity.ok(doctor);

    }

    
    @PostMapping()
    public Doctor createDoctor(@Validated @RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "id") Integer doctorId,
            @Validated @RequestBody Doctor doctorDetails) throws ResorceNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResorceNotFoundException("Doctor no encontrado por Id : " + doctorId));
        
        doctor.setCodigo(doctorDetails.getCodigo());
        doctor.setNombres(doctorDetails.getNombres());
        doctor.setApellidoPaterno(doctorDetails.getApellidoPaterno());
        doctor.setApellidoMaterno(doctorDetails.getApellidoMaterno());
        doctor.setEspecialidad(doctorDetails.getEspecialidad());
        doctor.setFecha(doctorDetails.getFecha());
        doctor.setHoraInicio(doctorDetails.getHoraInicio());
        doctor.setHoraFin(doctorDetails.getHoraFin());


        final Doctor updateDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(updateDoctor);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteDoctor(@PathVariable(value = "id") Integer doctorId)
            throws ResorceNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResorceNotFoundException("Doctor no encontrado por Id : " + doctorId));
        doctorRepository.delete(doctor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }
}
