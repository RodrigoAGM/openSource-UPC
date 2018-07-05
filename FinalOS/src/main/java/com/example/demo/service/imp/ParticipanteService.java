package com.example.demo.service.imp;

import com.example.demo.entity.Participante;
import com.example.demo.repository.iParticipanteRepository;
import com.example.demo.service.iParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService implements iParticipanteService {

    @Autowired
    iParticipanteRepository repository;

    @Override
    public List<Participante> listado() {
        return repository.findTop2ByOrderByPuntajeAsc();
    }

    @Override
    public boolean agregar(Participante obj) {

        Participante p = repository.save(obj);
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
