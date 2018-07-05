package com.example.demo.service;

import com.example.demo.entity.Participante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface iParticipanteService {

    public List<Participante> listado();
    public boolean agregar(Participante obj);
    public boolean eliminar(int id);
}
