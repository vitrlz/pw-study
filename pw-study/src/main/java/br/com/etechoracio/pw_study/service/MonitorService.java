package br.com.etechoracio.pw_study.service;

import br.com.etechoracio.pw_study.entity.Disciplina;
import br.com.etechoracio.pw_study.entity.Monitor;
import br.com.etechoracio.pw_study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {
    @Autowired
    private MonitorRepository repository;

    public List<Monitor> listar(){
        return repository.findAll();
    }

    public Monitor cadastrar(Monitor monitor){
        var existeEmail = repository.findByEmail(monitor.getEmail());
        if (!existeEmail.isEmpty()){
            throw new RuntimeException("Email já cadastrado");
        }
        var existeWhatsapp = repository.findByWhatsapp(monitor.getWhatsapp());
        if (!existeWhatsapp.isEmpty()){
            throw new RuntimeException("Telefone(Whatsapp) já cadastrado");
        }
        return repository.save(monitor);
    }

    public Optional<Monitor> buscarPorId(Long id){
        return repository.findById(id);
    }

    public void excluir(Disciplina disciplina){
        if(repository.findByDisciplina(disciplina).isPresent())
            throw new RuntimeException("Monitor não pode ser excluída");
        else{
            repository.deleteById(disciplina.getDisciplina());
        }
    }


}
