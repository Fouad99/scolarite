package com.fouad.training.scolarite.web;

import com.fouad.training.scolarite.dao.EtudiantRepository;
import com.fouad.training.scolarite.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
    /**
     * cherche moi un objet qui implemente (auto injection)
     */
    @Autowired
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value = "/index",  method = RequestMethod.GET)
    public String index(Model model, @RequestParam(name="nbrPage", defaultValue = "0") int nbrPage, @RequestParam(name = "nameSearch", defaultValue="") String nomMc){
        Page<Etudiant> etudiantsParNomMc = etudiantRepository.chercherEtudiantsParMc("%"+nomMc+"%", PageRequest.of(nbrPage, 6));
        int pagesCount = etudiantsParNomMc.getTotalPages();
        long elements = etudiantsParNomMc.getTotalElements();
        int[] pages = new int[pagesCount];
        for (int i = 0; i < pagesCount; ++i){
            pages[i] = i;
        }
        model.addAttribute("pageEtudiants", etudiantsParNomMc);
        model.addAttribute("numberOfelements", elements);
        model.addAttribute("totalPages", pages);
        model.addAttribute("pageCourante", nbrPage);
        model.addAttribute("nameSearch", nomMc);
        return "etudiants";
    }

    // fonction qui renvoie au formulaire d enregistrement
    @RequestMapping(value = "/ajouterEtudiantForm", method = RequestMethod.GET)
    public String addEtudiantForm(Model model){
        Etudiant e = new Etudiant();
        String pageTitle = "Ajout etudiant";
        model.addAttribute("Etudiant", e);
        model.addAttribute("pageTitle", pageTitle);
        return "ajouterEtudiant";
    }

    // fonction qui valide les et enregistre l etudiant ajoute
    @RequestMapping(value = "/saveEtudiant", method = RequestMethod.POST)
    public String saveEtudiant(Etudiant e){
        etudiantRepository.save(e);

        return "redirect:index";
    }


}