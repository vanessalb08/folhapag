package FolhaPag.services;

import FolhaPag.models.Colaborador;
import FolhaPag.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Colaborador salvarColaborador (Colaborador novoColaborador){
        return colaboradorRepository.save(novoColaborador);
    }
}
