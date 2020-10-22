package com.fouad.training.scolarite;

import com.fouad.training.scolarite.dao.EtudiantRepository;
import com.fouad.training.scolarite.entities.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ScolariteApplication {

	public static void main(String[] args) throws ParseException {

		ApplicationContext ctx = SpringApplication.run(ScolariteApplication.class, args);
		/*
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant("Fouad", df.parse("1988-11-10"), "fou@fouadserradj.tech", "fouad.jpg"));
		etudiantRepository.save(new Etudiant("mohamed", df.parse("1999-01-10"), "mohamed@fouadserradj.tech", "mohamed.jpg"));
		etudiantRepository.save(new Etudiant("Ibrahim", df.parse("1993-11-10"), "ibrahim@fouadserradj.tech", "ibrahim.jpg"));
		etudiantRepository.save(new Etudiant("naima", df.parse("1980-11-10"), "naima@fouadserradj.tech", "fouad.jpg"));
		etudiantRepository.save(new Etudiant("sofiane", df.parse("1979-01-10"), "sofiane@fouadserradj.tech", "mohamed.jpg"));
		etudiantRepository.save(new Etudiant("jean", df.parse("1998-11-10"), "jean@fouadserradj.tech", "ibrahim.jpg"));
		*/
	}
}
