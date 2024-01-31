package com.desafio.alura.desafioalurascreensound;

import com.desafio.alura.desafioalurascreensound.main.Main;
import com.desafio.alura.desafioalurascreensound.service.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioAluraScreensoundApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioAluraScreensoundApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.showMenu();
	}
}
