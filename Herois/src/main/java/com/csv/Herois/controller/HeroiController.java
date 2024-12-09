package com.csv.Herois.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csv.Herois.model.Heroi;
import com.csv.Herois.repository.IHeroiRepository;

@Controller
public class HeroiController {

	@Autowired
	private IHeroiRepository hRep;
	
	@RequestMapping(name="heroi", value = "/heroi", method = RequestMethod.GET)
	public ModelAndView heroiGet(ModelMap model) {
		return new ModelAndView("heroi");
	}
	
	@RequestMapping(name="heroi", value = "/heroi", method = RequestMethod.POST)
	public ModelAndView heroiPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		String id = params.get("id");
		String name = params.get("name");
		String gender = params.get("gender");
		String eyeColor = params.get("eyeColor");
		String race = params.get("race");
		String hairColor = params.get("hairColor");
		String height = params.get("height");
		String publish = params.get("publish");
		String skinColor = params.get("skinColor");
		String alignment = params.get("alignment");
		String weight = params.get("weight");
		String botao = params.get("botao");

		Heroi heroi = new Heroi();
		if (!botao.equals("Listar") || !botao.equals("listarPorPeso") || !botao.equals("listarPorPublisher")) {
			heroi.setId(Integer.parseInt(id));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			heroi.setName(name);
			heroi.setGender(gender);
			heroi.setEyeColor(eyeColor);
			heroi.setRace(race);
			heroi.setHairColor(hairColor);
			heroi.setHeight(Double.parseDouble(height));
			heroi.setPublish(publish);
			heroi.setSkinColor(skinColor);
			heroi.setAlignment(alignment);
			heroi.setWeight(Double.parseDouble(weight));
		}
		
		String saida = "";
		String erro = "";
		List<Heroi> herois = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				hRep.save(heroi);
				saida = "Log inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				hRep.save(heroi);
				saida = "Log atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				hRep.delete(heroi);
				saida = "Log excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				heroi = hRep.findById(heroi.getId()).get();
			}
			if (botao.equals("Listar")) {
				herois = hRep.findAll();
			}
			if(botao.equals("<")) {
				herois = hRep.findWeightLTOrderByNomeASC(Double.parseDouble(weight));
			}
			if(botao.equals("=")) {
				herois = hRep.findWeightEQOrderByNomeASC(Double.parseDouble(weight));
			}
			if(botao.equals(">")) {
				herois = hRep.findWeightGTOrderByNomeASC(Double.parseDouble(weight));
			}
			
			if (botao.equals("BuscarPorNome")) {
				heroi = hRep.findHeroiNome(name);						
			}
			if(botao.equals("listarPorPublisher")) {
				herois = hRep.findPublishOrderByNomeASC(publish);
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("heroi", heroi);
			model.addAttribute("herois", herois);
		}
		return new ModelAndView("heroi");
	}
}
