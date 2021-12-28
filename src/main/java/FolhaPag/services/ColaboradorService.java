package FolhaPag.services;

import FolhaPag.models.Colaborador;
import FolhaPag.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Colaborador salvarColaborador (Colaborador novoColaborador){
        return colaboradorRepository.save(novoColaborador);
    }

    public List<Colaborador> listarColaboradoresCadastrados(){
        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();
        return (List<Colaborador>) colaboradores;
    }
}
