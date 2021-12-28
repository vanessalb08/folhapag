package FolhaPag.dtos.colaborador;

import FolhaPag.models.Departamento;
import lombok.Data;

@Data
public class CadastroColaboradorDTO {

    private String nomeColaborador;
    private String cpf;
    private double salarioBase;
    private Departamento departamento;
}
