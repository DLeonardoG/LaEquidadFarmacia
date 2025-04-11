package com.somic.demo.nit.dominio;

import java.util.List;
import java.util.Optional;

public interface NitRepositorio {

    List<Nit> findAll();

    Nit save(Nit nit);

    Optional<Nit> findById(Long id);

    void deleteById(Long id);

}
