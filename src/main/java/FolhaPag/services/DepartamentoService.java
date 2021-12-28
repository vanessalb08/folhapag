package FolhaPag.services;

import FolhaPag.models.Departamento;
import FolhaPag.repositories.DepartamentoReposoiitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoReposoiitory departamentoReposoiitory;

    public void salvarDepartamento(Departamento novoDepartamento){
        departamentoReposoiitory.save(novoDepartamento);
    }
}
