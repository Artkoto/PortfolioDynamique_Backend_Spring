package com.artkoto.portfoli.backend;

import com.artkoto.portfoli.backend.model.*;
import com.artkoto.portfoli.backend.repository.ApiUserRepository;
import com.artkoto.portfoli.backend.repository.UserRepository;
import com.artkoto.portfoli.backend.service.PersonneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

@SpringBootTest
@AutoConfigureMockMvc
class PersonneControllerTests {

	@Autowired
	public MockMvc mockMvc;
	@Autowired
	PersonneService personneService ;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ApiUserRepository apiUserRepository;


	Personne personne1 = new Personne();
	User user = new User();
	ApiUser apiUser = new ApiUser();

	@BeforeEach
	void init() throws Exception {


	//	Personne personne2= null;

		//Creéation de la personne 1
		personne1.setNom("votre Nom");
		personne1.setPrenom("votre Prenom");
		personne1.setPoste("le poste");
		personne1.setPhoto("url de laPhoto");
		personne1.setCv("url du cv");
		personne1.setApropos("a propos de vous");
		personne1.setNumero("+33076797...");
		personne1.setEmail("votre@email.com");

		personne1.setLoisirs("vos loisirs");

		personne1.setFormations(new HashSet<>(){{
			//1
			add(new Formation(){{
				setName("vos formations");
				setDate_debut(new Date());
				setDate_fin(new Date());
				setLieux("lieux de la formation");
				setDetail("description de la formation");
			}});
			//2
			add(new Formation(){{
				setName("M2 INFO");
				setDate_debut(new Date());
				setDate_fin(new Date());
				setLieux("istic");
				setDetail("Je suis une formation à l'istic en IL ....");
			}});
		}});
		personne1.setExperiences(new HashSet<>(){{
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
			add(new Experience(){{
				setName("vos expé pro");
				setDate_debut(formater.parse("26-08-96"));
				setDate_fin(new Date());
				setLieux("liex de expé");
				setDetail("description expé");
				setOutils("outils utilisés");
			}});

			add(new Experience(){{
				setName("Equipier à BK");
				setDate_debut(new Date());
				setDate_fin(new Date());
				setLieux("BK St Grerégoire");
				setDetail("bla bla bla bla bla bla");
			}});
		}});

		personne1.setProjets(new HashSet<>(){{
			add(new Projet(){{
				setOutils("outils utilisés pour le projet");
				setDescriptionProjet("description projet");
				setNomProjet("nom projet");
				setGitLink("depot git du projet");
				setUrlProject("url du projet");
				setPhoto("image du projet");
			}});
			add(new Projet(){{
				setOutils("IntelliJ");
				//setAfficherProjet(false);
				setDescriptionProjet("Creation de cette API avec Spring");
				setNomProjet("Spring_project");
				setGitLink("https://github.com/Artkoto/PortfolioDynamique_Backend_Spring");
				setPhoto("https://avatars.githubusercontent.com/u/35773837?v=4");
			}});
		}});

		personne1.setCompetences(new HashSet<>(){{
			add(new Competence(){{
				setName("Spring");
				setCategorie("PROGRAMMATION");
				setEvolution(50);
			}});

			add(new Competence(){{
				setName("Français");
				setCategorie("LINGUISTIQUE");
				setEvolution(95);
			}});
		}});

		personne1.setDerniereMiseAJour(new Date());

		//ajout à la bdd
		//personneService.savePersonne(personne1);
		user.setUser_name("aaaaa");
		user.setEmail("hjdfgfh@hfg");
		user.setPassword(Crypter.encrypt("motdepasse"));
		user.setPortfolios(new HashSet<>(){{
			add(personne1);
		}});

		//

		apiUser.setUser_name("aaaaa");
		apiUser.setEmail("hjdfgfh@hfg");
		apiUser.setPassword(Crypter.encrypt("motdepasse"));
//		apiUser.setApi_key(Crypter.encrypt("aaa"));
		apiUser.setApi_key("aaa");

		apiUserRepository.save(apiUser);
		userRepository.save(user);


	}

	@Test
	void contextLoads()  throws Exception{
		mockMvc.perform(get("/personnes/api_key=aaa"))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].nom", is("votre Nom")));
	}

}
