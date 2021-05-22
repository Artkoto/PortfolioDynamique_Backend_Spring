package com.artkoto.portfoli.backend;

import com.artkoto.portfoli.backend.model.*;
import com.artkoto.portfoli.backend.service.PersonneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.logging.Logger;

@SpringBootTest
@AutoConfigureMockMvc
class PersonneControllerTests {

	@Autowired
	public MockMvc mockMvc;
	@Autowired
	PersonneService personneService ;

	Personne personne1 = new Personne();

	@BeforeEach
	void init() throws Exception {


	//	Personne personne2= null;

		//Creéation de la personne 1
		personne1.setNom("Akoto");
		personne1.setPrenom("Arnaud");
		personne1.setPoste("Dev");
		//personne1.setId();
		personne1.setPhoto("jhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhfdicg.png");
		personne1.setCv("dsfdhkgvhsdfhevkdvnjs;bvhjfksdkhfbvskdnfl");
		personne1.setAPropos("je suis");
		personne1.setNumero("076798256254");
		personne1.setEmail("knkluhsb@uhyuest");

		personne1.setLoisirs(new HashSet<>(){{
			add(new Hobie() {{ setName("Game");}});
			add(new Hobie() {{ setName("Natation");}});
			add(new Hobie() {{ setName("bla bla bla");}});

		}});

		personne1.setFormations(new HashSet<>(){{
			//1
			add(new Formation(){{
				setName("M1 IL");
				setDate("26/08/1996");
				setLieux("IStic");
				setMontrer(false);
				setDetail("bla bla bla bla bla bla");
			}});
			//2
			add(new Formation(){{
				setName("L3 INFO");
				setDate("26/08/1996");
				setLieux("UVCI");
				setMontrer(true);
				setDetail("bla bla bla bla bla bla");
			}});
		}});
		personne1.setExperiences(new HashSet<>(){{
			add(new Experience(){{
				setName("Equipier à BK");
				setDate("26/08/1996");
				setLieux("BK");
				setMontrer(true);
				setDetail("bla bla bla bla bla bla");
				setOutils("rien");
			}});
		}});

		personne1.setProjets(new HashSet<>(){{
			add(new Projet(){{
				setOutils("Vs Code");
				setAfficherProjet(false);
				setDescriptionProjet("blablavbla");
				setNomProjet("Xproject");
				setGitLink("fsgjkbhljsbvgjdbgfskjbgljsfb");
				setUrlProject("bkjvhnbkjbhjbljbvfds");
				setPhoto("kjghjgvkghvjhgv.png");
			}});
		}});

		personne1.setCompetences(new HashSet<>(){{
			add(new Competence(){{
				setName("Spring");
				setAfficherCompetence(true);
				setCompetenceType(new CompetenceType(){{
					setAfficher(true);
					setName("Dev");
				}});
				setEvolution("50");
			}});

			add(new Competence(){{
				setName("Français");
				setAfficherCompetence(true);
				setCompetenceType(new CompetenceType(){{
					setAfficher(true);
					setName("Langue");
				}});
				setEvolution("95");
			}});
		}});

		//ajout à la bdd

		personneService.savePersonne(personne1);

	}

	@Test
	void contextLoads()  throws Exception{
		mockMvc.perform(get("/personnes"))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].nom", is("Akoto")));
	}

}
