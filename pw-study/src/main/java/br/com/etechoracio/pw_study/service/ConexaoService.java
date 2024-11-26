package br.com.etechoracio.pw_study.service;

import br.com.etechoracio.pw_study.entity.Conexao;
import br.com.etechoracio.pw_study.repository.ConexaoRepository;
import br.com.etechoracio.pw_study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConexaoService {
    @Autowired
    private ConexaoRepository repository;

    @Autowired
    private MonitorRepository monitorRepository;

    public long contaMonitores(){
        long quantidade = monitorRepository.count();
        return quantidade;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Conexao cadastraConexao(Conexao conexao){
        repository.save(conexao);
        return conexao;
    }

}
