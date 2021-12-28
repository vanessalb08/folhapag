package FolhaPag.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String nomeDepartamento;
    @OneToMany
    private List<Colaborador> colaboradores;
}
