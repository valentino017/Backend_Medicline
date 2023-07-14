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

import com.medicline.spring.models.Paciente;
import com.medicline.spring.models.exceptions.ResorceNotFoundException;
import com.medicline.spring.repositorio.PacienteRepositorio;

@CrossOrigin(origins = "http://localhost:3002/")
@RestController
@RequestMapping("/api/pacientes")
public class PacienteRestController {

    @Autowired
    private PacienteRepositorio pacienteRepository;

    @GetMapping()
    public List<Paciente> getAllpacientes() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteId(@PathVariable(value = "id") Integer pacienteId)
            throws ResorceNotFoundException {

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new ResorceNotFoundException("Paciente no encontrado por Id: " + pacienteId));
        return ResponseEntity.ok(paciente);

    }

    @PostMapping()
    public Paciente createPaciente(@Validated @RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable(value = "id") Integer pacienteId,
            @Validated @RequestBody Paciente pacienteDetails) throws ResorceNotFoundException {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new ResorceNotFoundException("Paciente no encontrado por Id : " + pacienteId));

        // cliente.setId_cliente(clienteDetails.getId_cliente());
        paciente.setDni(pacienteDetails.getDni());
        paciente.setFechaEmision(pacienteDetails.getFechaEmision());
        paciente.setNombres(pacienteDetails.getNombres());
        paciente.setApellidoPaterno(pacienteDetails.getApellidoPaterno());
        paciente.setApellidoMaterno(pacienteDetails.getApellidoMaterno());
        paciente.setEstado_civil(pacienteDetails.getEstado_civil());
        paciente.setTelefono(pacienteDetails.getTelefono());
        paciente.setCorreoElectronico(pacienteDetails.getCorreoElectronico());
        paciente.setHora(pacienteDetails.getHora());
        paciente.setDia(pacienteDetails.getDia());
        paciente.setEspecialidad(pacienteDetails.getEspecialidad());
        paciente.setSede(pacienteDetails.getSede());

        final Paciente updatePaciente = pacienteRepository.save(paciente);
        return ResponseEntity.ok(updatePaciente);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePaciente(@PathVariable(value = "id") Integer pacienteId)
            throws ResorceNotFoundException {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new ResorceNotFoundException("Paciente no encontrado por Id : " + pacienteId));
        pacienteRepository.delete(paciente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

}
