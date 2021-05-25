package com.artkoto.portfoli.backend.service;

import com.artkoto.portfoli.backend.model.Personne;
import com.artkoto.portfoli.backend.model.Formation;
import com.artkoto.portfoli.backend.repository.FormationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private PersonneService personneService;

    /**
     * recup une formation avec id
     * @param id2
     * @param id
     * @return
     */
    public Optional<Formation> getformation(final Long id2,final Long id){
        Formation formation = formationRepository.findById(id).stream().iterator().next();
        Personne personne =personneService.getPersonne(id2).stream().iterator().next();
        if (personne != null && personne.getFormations().contains(formation)){
            return formationRepository.findById(id);
        }
        return Optional.empty();
    }

    /**
     * obtenir tous les formations
     * @param id
     * @return
     */
    public Iterable<Formation> getformations(final Long id){
        Optional<Personne> personne =personneService.getPersonne(id);
        if (personne.isPresent()){
            return personne.stream().iterator().next().getFormations();
        }
        return null;
    }

    /**
     * delete
     * @param id
     * @param id2
     */
    public void  deleteformation(final Long id, final Long id2){
        Formation formation = formationRepository.findById(id).stream().iterator().next();
        Personne personne =personneService.getPersonne(id2).stream().iterator().next();
        if (personne != null && personne.getFormations().contains(formation)){
            Set<Formation> formations = new HashSet<>(personne.getFormations());
            formations.remove(formation);
            personne.setFormations(formations);
            personneService.modifyPersonne(id,personne);
            formationRepository.delete(formation);
        }

    }

    /**
     * @description  ajout de formation à la liste
     * @param formation
     * @param id
     * @return formation
     */
    public Formation saveFormation(Formation formation,final Long id ){
        if (personneService.getPersonne(id).isPresent()){
            Personne personne = personneService.getPersonne(id).stream().iterator().next();
            Set<Formation> formations = new HashSet<>(personne.getFormations());
            formations.add(formation);
            personne.setFormations(formations);
            personneService.modifyPersonne(id,personne);
            return formation;
        }
        return formation;
    }

    /**
     * Modification d'un formation existant
     * @param id
     * @param formation
     * @return
     */
    public Formation modifyformation(final Long id, Formation formation){
        if (formationRepository.existsById(id)) {
            // formation formation1 = formationRepository.findById(id).stream().iterator().next();
            return formationRepository.save(formation);
        }
        return null;
    }

}
