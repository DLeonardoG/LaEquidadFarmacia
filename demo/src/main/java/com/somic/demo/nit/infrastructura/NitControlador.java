package com.somic.demo.nit.infrastructura;


import com.somic.demo.nit.aplicacion.NitServicio;
import com.somic.demo.nit.dominio.Nit;
import com.somic.demo.nit.dominio.NitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nit")
public class NitControlador {

    @Autowired
    private NitServicio nitServicio;

    @PutMapping("/edit/{nitId}")
    public NitDTO editNit(@PathVariable long nitId, @RequestBody NitDTO nitDTO) {
        Nit updatedNit = nitServicio.editar(nitId, nitDTO);
        NitDTO response = new NitDTO();
        response.setId(updatedNit.getId());
        response.setNombre(updatedNit.getNombre());
        response.setPlazo(updatedNit.getPlazo());
        response.setCupo(updatedNit.getCupo());
        response.setDocumento(updatedNit.getDocumento());
        return response;
    }

    @GetMapping("/{nitId}")
    public Optional<NitDTO> buscarPorId(@PathVariable long nitId) {
        Optional<NitDTO> encontrada = nitServicio.findById(nitId);
        return encontrada;
    }

    @GetMapping("/todos")
    public List<NitDTO> getNitById() {
        return nitServicio.verTodos();
    }

    @PostMapping
    public ResponseEntity<NitDTO> createNit(@RequestBody NitDTO dto) {
        NitDTO createdNit = nitServicio.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNit(@PathVariable Long id) {
        nitServicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
