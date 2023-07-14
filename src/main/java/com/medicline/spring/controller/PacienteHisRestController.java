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

import com.medicline.spring.models.PacienteHis;
import com.medicline.spring.models.exceptions.ResorceNotFoundException;
import com.medicline.spring.repositorio.PacienteHisRepositorio;


@CrossOrigin(origins = "http://localhost:3002/")
@RestController
@RequestMapping("/api/pacientesHis")
public class PacienteHisRestController {

    @Autowired
    private PacienteHisRepositorio pacienteHisRepository;

    public List<PacienteHis> getAllpacienteHis(){
         return pacienteHisRepository.findAll();
    }



    //@GetMapping()
    //public List<PacienteHis> getAllpacientesHis() {
     //// }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteHis> getPacientHiseId(@PathVariable(value = "id") Integer pacienteHisId)
            throws ResorceNotFoundException {

        PacienteHis pacienteHis = pacienteHisRepository.findById(pacienteHisId)
                .orElseThrow(() -> new ResorceNotFoundException("Paciente no encontrado por Id: " + pacienteHisId));
        return ResponseEntity.ok(pacienteHis);

    }

    @PostMapping()
    public PacienteHis createPacienteHis(@Validated @RequestBody PacienteHis pacienteHis) {
        return pacienteHisRepository.save(pacienteHis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteHis> updatePacienteHis(@PathVariable(value = "id") Integer pacienteHisId,
            @Validated @RequestBody PacienteHis pacienteDetails) throws ResorceNotFoundException {
        PacienteHis pacienteHis = pacienteHisRepository.findById(pacienteHisId)
                .orElseThrow(() -> new ResorceNotFoundException("Paciente no encontrado por Id : " + pacienteHisId));

        // cliente.setId_cliente(clienteDetails.getId_cliente());
        pacienteHis.setDni(pacienteDetails.getDni());
        pacienteHis.setFechaEmision(pacienteDetails.getFechaEmision());
        pacienteHis.setNombres(pacienteDetails.getNombres());
        pacienteHis.setApellidoPaterno(pacienteDetails.getApellidoPaterno());
        pacienteHis.setApellidoMaterno(pacienteDetails.getApellidoMaterno());
        pacienteHis.setEstado_civil(pacienteDetails.getEstado_civil());
        pacienteHis.setTelefono(pacienteDetails.getTelefono());
        pacienteHis.setCorreoElectronico(pacienteDetails.getCorreoElectronico());
        pacienteHis.setHora(pacienteDetails.getHora());
        pacienteHis.setDia(pacienteDetails.getDia());
        pacienteHis.setEspecialidad(pacienteDetails.getEspecialidad());
        pacienteHis.setSede(pacienteDetails.getSede());

        final PacienteHis updatePacienteHis = pacienteHisRepository.save(pacienteHis);
        return ResponseEntity.ok(updatePacienteHis);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePacienteHis(@PathVariable(value = "id") Integer pacienteHisId)
            throws ResorceNotFoundException {
        PacienteHis pacienteHis = pacienteHisRepository.findById(pacienteHisId)
                .orElseThrow(() -> new ResorceNotFoundException("Paciente no encontrado por Id : " + pacienteHisId));
        pacienteHisRepository.delete(pacienteHis);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

}

