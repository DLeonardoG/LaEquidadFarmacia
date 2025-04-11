package com.somic.demo.nit.aplicacion;

import com.somic.demo.nit.dominio.Nit;
import com.somic.demo.nit.dominio.NitDTO;
import com.somic.demo.nit.dominio.NitRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NitServicio {
    private final NitRepositorio nitRepositorio;

    public NitServicio(NitRepositorio nitRepositorio) {
        this.nitRepositorio = nitRepositorio;
    }

    public List<NitDTO> verTodos() {
        return nitRepositorio.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        NitRepositorio.deleteById(id);
    }


    private NitDTO convertirADTO(Nit nit) {
        NitDTO nitDTO = new NitDTO();
        nitDTO.setCartera(nit.getCartera());
        nitDTO.setCupo(nit.getCupo());
        nitDTO.setId(nit.getId());
        nitDTO.setDocumento(nit.getDocumento());
        nitDTO.setNombre(nit.getNombre());
        nitDTO.setPlazo(nit.getPlazo());

        return nitDTO;
    }
    private Nit convertirAEntidad(NitDTO nitDTO) {
        Nit nit = new Nit();
        nit.setCartera(nitDTO.getCartera());
        nit.setCupo(nitDTO.getCupo());
        nit.setDocumento(nitDTO.getDocumento());
        nit.setNombre(nitDTO.getNombre());
        nit.setPlazo(nitDTO.getPlazo());

        return nit;
    }

}
