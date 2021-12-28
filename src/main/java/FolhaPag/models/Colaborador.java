package FolhaPag.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "colaboradores")
public class Colaborador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nomeColaborador;
    @Column(nullable = false)
    private String CPF;
    @Column(nullable = false)
    private double salarioBase;
    @ManyToOne
    private Departamento departamento;
}
