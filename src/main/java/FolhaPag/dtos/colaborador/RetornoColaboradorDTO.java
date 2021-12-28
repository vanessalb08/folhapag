package FolhaPag.dtos.colaborador;

import FolhaPag.models.Departamento;
import lombok.Data;

@Data
public class RetornoColaboradorDTO {
    private int id;
    private String nomeColaborador;
    private String cpf;
    private double salarioBase;
    private Departamento departamento;
}
