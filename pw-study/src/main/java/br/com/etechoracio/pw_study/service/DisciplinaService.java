package br.com.etechoracio.pw_study.service;

import br.com.etechoracio.pw_study.entity.Disciplina;
import br.com.etechoracio.pw_study.entity.Monitor;
import br.com.etechoracio.pw_study.repository.DisciplinaRepository;
import br.com.etechoracio.pw_study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository repository;
    @Autowired
    private MonitorRepository monitorRepository;

    public List<Disciplina> listar() {
        return repository.findAll();
    }

    public Disciplina cadastrar(Disciplina disciplina) {
        var existe = repository.findByNome(disciplina.getNome());
        if (!existe.isEmpty()) {
            throw new RuntimeException("Nome da disciplina já cadastrado");
        }
        repository.save(disciplina);
        return disciplina;
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        if (monitorRepository.findById(id).isPresent())
            throw new RuntimeException("Disciplina não pode ser excluída");
        else {
            repository.deleteById(id);
        }
    }

    public Disciplina alterar(Disciplina disciplina) {
        return repository.save(disciplina);
    }
}