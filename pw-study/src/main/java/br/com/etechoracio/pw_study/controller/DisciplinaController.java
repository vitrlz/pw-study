package br.com.etechoracio.pw_study.controller;

import br.com.etechoracio.pw_study.entity.Disciplina;
import br.com.etechoracio.pw_study.service.DisciplinaService;
import br.com.etechoracio.pw_study.service.MonitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(description = "Endpoints para gerenciar as disciplinas da aplicação", name = "Disciplina")
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService service;
    @Autowired
    private MonitorService monitorService;

    @Operation(summary = "Lista todas as disciplinas")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "ok")})
    @GetMapping
    public List<Disciplina> listar(){
        return service.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Long id){
        var existe = service.buscarPorId(id);
        if(existe.isPresent()){ //if(!existe.isEmpty())
            return ResponseEntity.ok(existe.get());
        }else{
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }
        //return service.buscarPorId(id).map((e-> ResponseEntity.ok(e))
        //                              .orElse(ResponseEntity.notFound().build());
    }


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

    @PostMapping
    public Disciplina cadastrar(@RequestBody Disciplina disciplina){
        return service.cadastrar(disciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina){
        var existe = service.buscarPorId(id);
        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var atualizado = service.alterar(disciplina);
        return ResponseEntity.ok(atualizado);

    }
}
