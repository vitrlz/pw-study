package br.com.etechoracio.pw_study.controller;

import br.com.etechoracio.pw_study.entity.Disciplina;
import br.com.etechoracio.pw_study.entity.Monitor;
import br.com.etechoracio.pw_study.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitores")
public class MonitorController {

    @Autowired
    private MonitorService service;
    @GetMapping
    public List<Monitor> listar(){ return service.listar();}
    @PostMapping
    public Monitor cadastrar(@RequestBody Monitor monitor) {return service.cadastrar(monitor);}

    @DeleteMapping("/{id}")
    public ResponseEntity<Disciplina> excluir(@PathVariable Long id) {
        var existe = service.buscarPorId(id);
        if (existe.isPresent()){
            service.excluir(existe.get().getDisciplina());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
