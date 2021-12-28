package FolhaPag.services;

import FolhaPag.models.Departamento;
import FolhaPag.repositories.DepartamentoReposoiitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoReposoiitory departamentoReposoiitory;

    public void salvarDepartamento(Departamento novoDepartamento){
        departamentoReposoiitory.save(novoDepartamento);
    }

    public Departamento buscarDepartamentoPorId(int id){
        Optional<Departamento> departamento = departamentoReposoiitory.findById(id);
        if (departamento.isEmpty()){
            throw new RuntimeException("Id não encontrado");
        }

        return departamento.get();
    }

    public List<Departamento> listarDepartamentosCadastrados(){
        Iterable<Departamento> departamentos = departamentoReposoiitory.findAll();
        return (List<Departamento>) departamentos;
    }
}
