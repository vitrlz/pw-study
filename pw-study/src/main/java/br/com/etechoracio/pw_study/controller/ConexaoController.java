package br.com.etechoracio.pw_study.controller;

import br.com.etechoracio.pw_study.entity.Conexao;
import br.com.etechoracio.pw_study.repository.ConexaoRepository;
import br.com.etechoracio.pw_study.service.ConexaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conexoes")
public class ConexaoController {
    @Autowired
    private ConexaoService conexaoService;

    @GetMapping
    public long contar(){return conexaoService.contaMonitores();}

    @PostMapping
    public Conexao cadastrar(@RequestBody Conexao conexao){
        return conexaoService.cadastraConexao(conexao);
    }
}
