package FolhaPag.controllers;

import FolhaPag.dtos.DepartamentoEntradaDTO;
import FolhaPag.models.Departamento;
import FolhaPag.services.DepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDepartamento(@RequestBody DepartamentoEntradaDTO departamentoEntradaDTO){

        Departamento departamento = modelMapper.map(departamentoEntradaDTO, Departamento.class);
        departamentoService.salvarDepartamento(departamento);
    }
}
