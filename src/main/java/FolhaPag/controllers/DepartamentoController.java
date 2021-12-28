package FolhaPag.controllers;

import FolhaPag.dtos.departamento.DepartamentoEntradaDTO;
import FolhaPag.dtos.departamento.RetornoDepartamentoDTO;
import FolhaPag.models.Departamento;
import FolhaPag.services.DepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<RetornoDepartamentoDTO> exibirDepartamentos(){
        List<RetornoDepartamentoDTO> retornoDepartamentoDTOS = new ArrayList<>();
        for (Departamento departamentoReferencia : departamentoService.listarDepartamentosCadastrados()){
            RetornoDepartamentoDTO retorno = modelMapper.map(departamentoReferencia, RetornoDepartamentoDTO.class);
            retornoDepartamentoDTOS.add(retorno);
        }

        return retornoDepartamentoDTOS;
    }
}
