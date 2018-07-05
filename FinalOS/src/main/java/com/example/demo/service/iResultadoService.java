package com.example.demo.service;

import com.example.demo.entity.Resultado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface iResultadoService {

    public List<Resultado> listado();
    public boolean agregar(Resultado obj);
    public boolean eliminar(int id);
}
