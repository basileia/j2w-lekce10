package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.service.TridaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TridaController {

    private final TridaService service;

    public TridaController(TridaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznamTrid")
                .addObject("seznam", service.seznamTrid());
    }

    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable int id) {
        Optional<Trida> hledanaTrida = service.tridaDleId(id);

        if (!hledanaTrida.isEmpty()) {
            return new ModelAndView("detail")
                    .addObject("trida", service.tridaDleId(id).get());
        }
        return ResponseEntity.notFound().build();
    }


}
