package com.somic.demo.nit.infrastructura;


import com.somic.demo.nit.dominio.Nit;
import com.somic.demo.nit.dominio.NitRepositorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNitRepositorio extends JpaRepository<Nit, Long>, NitRepositorio {

}
