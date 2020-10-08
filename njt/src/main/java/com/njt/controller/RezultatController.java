/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.domain.Prijava;
import com.njt.domain.Rezultat;
import com.njt.domain.Takmicenje;
import com.njt.domain.User;
import com.njt.repository.PrijavaRepository;
import com.njt.repository.TakmicenjeRepository;
import com.njt.repository.UserRepository;
import com.njt.service.RezultatService;
import com.njt.service.TakmicenjeService;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jovan Petrovic
 */
@Controller
@RequestMapping(value = "/rezultati/*")
public class RezultatController {

    @Autowired
    private RezultatService rezultatService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PrijavaRepository prijavaRepository;
    
    @Autowired
    private TakmicenjeService takmicenjeService;

    @GetMapping("/all")
    public ModelAndView allRezultati() {
         List<Takmicenje> takmicenja = takmicenjeService.getAll();
        List<Takmicenje> takm = new LinkedList<>();
        Date date = new Date();
        for (Takmicenje takmicenje : takmicenja) {
            if (date.after(takmicenje.getDatumOdrzavanja())) {
                takm.add(takmicenje);
            }
        }

        ModelAndView modelAndView = new ModelAndView("rezultati/all");
        modelAndView.addObject("takmicenja", takm);

        return modelAndView;
    }
    
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public ModelAndView detailsPrijave(@PathVariable Long id) {
        Takmicenje ts = takmicenjeService.findbyId(id);
        List<Rezultat> rez = rezultatService.getAll();
        List<Rezultat> rezultati = new LinkedList<>();
        for (Rezultat r : rez) {
            if (r.getTakmicenje().equals(ts)) {
                rezultati.add(r);
            }
        }

        ModelAndView modelAndView = new ModelAndView("rezultati/view");
        modelAndView.addObject("rezultati", rezultati);
        return modelAndView;
    }

    @GetMapping("/mojiRezultati")
    public ModelAndView mojiRezultati() {

      List<Takmicenje> takmicenja = new LinkedList<>();
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User u = userRepository.findByUsername(user.getUsername());

        List<Rezultat> rezultati = rezultatService.getAll();
        List<Rezultat> rez = new LinkedList<>();

        for (Rezultat r : rezultati) {
            if (r.getPlivac().getPlivacId() == u.getPlivacId()) {
                rez.add(r);
            }
        }

        ModelAndView modelAndView = new ModelAndView("rezultati/mojiRezultati");
        modelAndView.addObject("rezultati", rez);
        return modelAndView;
    }

}
