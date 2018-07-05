package com.example.demo.controller;

import com.example.demo.entity.Participante;
import com.example.demo.entity.Resultado;
import com.example.demo.service.iParticipanteService;
import com.example.demo.service.iResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    iResultadoService resultadoService;

    @Autowired
    iParticipanteService participanteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String Home(){
        List<Participante> lista = participanteService.listado();
        for(int i = 0; i<lista.size(); ++i){
            System.out.println(lista.get(i).getNombre() + "  " + lista.get(i).getPuntaje());
        }

        return "admin/dashboard";
    }

    @RequestMapping(value = "/participante/ranking", method = RequestMethod.GET)
    private String Ranking(Model model){
        List<Participante> list = new ArrayList<Participante>();
        model.addAttribute("participantes",participanteService.listado());
        return "participante_listar";
    }


    @RequestMapping(value = "/participante/agregar", method = RequestMethod.GET)
    private String agregar(Model model){
        Participante participante = new Participante();
        model.addAttribute("resultado",participante);
        return "participante_registrar";
    }

    @RequestMapping(value = "/participante/guardar", method = RequestMethod.POST)
    private String guardar(@ModelAttribute Participante obj){
        boolean flag = false;
        flag = participanteService.agregar(obj);
        if(flag){
            System.out.println("Creado");
        }else{
            System.out.println("Salio mal");
        }
        return "redirect:/participante/listado";
    }


    @RequestMapping(value = "/participante/listado", method = RequestMethod.GET)
    private String listado(Model model){
        model.addAttribute("participantes",participanteService.listado());
        return "participante_listar";
    }

    @RequestMapping(value = "/participante/eliminar/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable int id, RedirectAttributes redirAtt) {
        boolean flag = participanteService.eliminar(id);
        return "redirect:/participante/listado";
    }

    @RequestMapping(value = "/resultado/agregar", method = RequestMethod.GET)
    private String agregarResultado(Model model){
        Resultado resultado = new Resultado();
        model.addAttribute("resultado",resultado);
        return "resultado_registrar";
    }

    @RequestMapping(value = "/resultado/agregar", method = RequestMethod.POST)
    private String guardarResultado(@ModelAttribute Resultado obj){
        boolean flag = false;
        flag = resultadoService.agregar(obj);
        if(flag){
            System.out.println("Creado");
        }else{
            System.out.println("Salio mal");
        }
        return "redirect:/resultado/listado";
    }


    @RequestMapping(value = "/resultado/listado", method = RequestMethod.GET)
    private String listResultado(Model model){
        model.addAttribute("resultados",resultadoService.listado());
        return "resultado_listar";
    }

    @RequestMapping(value = "/resultado/eliminar/{id}", method = RequestMethod.GET)
    public String eliminarResultado(@PathVariable int id, RedirectAttributes redirAtt) {
        boolean flag = resultadoService.eliminar(id);
        return "redirect:/resultado/listado";
    }
}
