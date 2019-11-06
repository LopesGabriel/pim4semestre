package com.virtualcondo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtualcondo.models.VagaEstacionamento;
import com.virtualcondo.repository.VagaEstacionamentoRepository;

@SpringBootApplication
public class VirtualCondoApplication implements CommandLineRunner {

	@Autowired
	private VagaEstacionamentoRepository vagaRepo;

	public static void main(String[] args) {
		SpringApplication.run(VirtualCondoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		VagaEstacionamento v1 = new VagaEstacionamento(1, "01A", false);
		VagaEstacionamento v2 = new VagaEstacionamento(2, "02A", false);
		VagaEstacionamento v3 = new VagaEstacionamento(3, "03A", false);
		VagaEstacionamento v4 = new VagaEstacionamento(4, "04A", false);
		VagaEstacionamento v5 = new VagaEstacionamento(5, "05A", false);
		VagaEstacionamento v6 = new VagaEstacionamento(6, "06A", false);
		VagaEstacionamento v7 = new VagaEstacionamento(7, "07A", false);
		VagaEstacionamento v8 = new VagaEstacionamento(8, "08A", false);
		VagaEstacionamento v9 = new VagaEstacionamento(9, "09A", false);
		VagaEstacionamento v10 = new VagaEstacionamento(10, "10A", false);

		vagaRepo.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10));
		
	}

}
