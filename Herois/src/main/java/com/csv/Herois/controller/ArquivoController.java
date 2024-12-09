package com.csv.Herois.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csv.Herois.repository.IHeroiRepository;
import com.csv.Herois.model.Heroi;

@Controller
public class ArquivoController {

	@Autowired
	private IHeroiRepository hRep;
	
	@RequestMapping(name="arquivo", value = "/arquivo", method = RequestMethod.GET)
	public ModelAndView arquivoGet(ModelMap model) {
		return new ModelAndView("arquivo");
	}
	
	@RequestMapping(name="arquivo", value = "/arquivo", method = RequestMethod.POST)
	public ModelAndView arquivoPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		String pathArquivo = params.get("arquivo");
		String botao = params.get("botao");

		
		File arquivo = new File(pathArquivo);
		
		
		String saida = "";
		String erro = "";
		
		try {
			if (botao.equals("enviarArquivo")) {
				String linha;
				
				Scanner leitor = new Scanner(arquivo);
				leitor.nextLine();
				while(leitor.hasNext()) {
					Heroi heroi = new Heroi();
					linha = leitor.nextLine();
					String[] splitVirgula = linha.split(",");
					
					for(int i=0; i<11;i++) {
						if(splitVirgula[i].equals("-")) {
							splitVirgula[i]=null;
						}
					}
					
					heroi.setId(Integer.parseInt(splitVirgula[0]));
					heroi.setName(splitVirgula[1]);
					heroi.setGender(splitVirgula[2]);
					heroi.setEyeColor(splitVirgula[3]);
					heroi.setRace(splitVirgula[4]);
					heroi.setHairColor(splitVirgula[5]);
					heroi.setHeight(Double.parseDouble(splitVirgula[6]));
					heroi.setPublish(splitVirgula[7]);
					heroi.setSkinColor(splitVirgula[8]);
					heroi.setAlignment(splitVirgula[9]);
					heroi.setWeight(Double.parseDouble(splitVirgula[10]));
					hRep.save(heroi);
				}
				saida = "Herois inseridos com sucesso";
			}

		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
		}
		return new ModelAndView("arquivo");
	}
}
