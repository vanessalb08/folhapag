package FolhaPag.controllers;

import FolhaPag.dtos.colaborador.CadastroColaboradorDTO;
import FolhaPag.dtos.colaborador.RetornoColaboradorDTO;
import FolhaPag.models.Colaborador;
import FolhaPag.services.ColaboradorService;
import FolhaPag.services.DepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornoColaboradorDTO cadastrarColaborador(@RequestBody CadastroColaboradorDTO cadastroColaboradorDTO){
        Colaborador colaborador = modelMapper.map(cadastroColaboradorDTO, Colaborador.class);
        Colaborador colaboradorSalvo = colaboradorService.salvarColaborador(colaborador);

        colaboradorSalvo.setDepartamento(
                departamentoService.buscarDepartamentoPorId(
                        cadastroColaboradorDTO.getDepartamento().getId()
                ));

        RetornoColaboradorDTO retornoColaboradorDTO = modelMapper.map(colaboradorSalvo, RetornoColaboradorDTO.class);
        return retornoColaboradorDTO;
    }

    @GetMapping
    public List<RetornoColaboradorDTO> exibirColaboradores(){
        List<RetornoColaboradorDTO> retornoColaboradorDTOS = new ArrayList<>();

        for (Colaborador colaboradorReferencia : colaboradorService.listarColaboradoresCadastrados()){
            RetornoColaboradorDTO retorno = modelMapper.map(colaboradorReferencia, RetornoColaboradorDTO.class);
            retornoColaboradorDTOS.add(retorno);
        }

        return retornoColaboradorDTOS;
    }
}
