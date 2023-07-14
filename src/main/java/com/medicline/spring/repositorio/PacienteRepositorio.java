package com.medicline.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicline.spring.models.Paciente;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
    // @Query(value = "SELECT a FROM Cliente a WHERE a.nombre=?1")
    // public List<Cliente> buscarClientesPorNombre(String nombre);

    // @Query(value = "SELECT a FROM Cliente a WHERE a.nombre like CONCAT(?1,'%')")
    // public List<Cliente> buscarClienteLikeNombre(String nombre);
}