package com.example.demo.service.imp;

import com.example.demo.entity.Resultado;
import com.example.demo.repository.iResultadoRepository;
import com.example.demo.service.iResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoService implements iResultadoService {

    @Autowired
    iResultadoRepository repository;

    @Override
    public List<Resultado> listado() {
        return repository.findAll();
    }

    @Override
    public boolean agregar(Resultado obj) {

        Resultado p = repository.save(obj);
        if(p == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        boolean flag = false;

        try {
            repository.deleteById(id);
            flag = true;
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return flag;
    }
}
