package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String sede;
    private String tiu;

    @OneToMany(mappedBy = "participante")
    private List<Resultado> resultados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getTiu() {
        return tiu;
    }

    public void setTiu(String tiu) {
        this.tiu = tiu;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}
