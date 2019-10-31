package com.virtualcondo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtualcondo.models.Apartamento;
import com.virtualcondo.models.VagaEstacionamento;
import com.virtualcondo.repository.ApartamentoRepository;
import com.virtualcondo.repository.VagaEstacionamentoRepository;

@SpringBootApplication
public class VirtualCondoApplication implements CommandLineRunner {

	@Autowired
	private VagaEstacionamentoRepository vagaRepo;

	@Autowired
	private ApartamentoRepository apartamentoRepo;

	public static void main(String[] args) {
		SpringApplication.run(VirtualCondoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		VagaEstacionamento v1 = new VagaEstacionamento(1, "01A", false, null);
		VagaEstacionamento v2 = new VagaEstacionamento(2, "02A", false, null);
		VagaEstacionamento v3 = new VagaEstacionamento(3, "03A", false, null);
		VagaEstacionamento v4 = new VagaEstacionamento(4, "04A", false, null);
		VagaEstacionamento v5 = new VagaEstacionamento(5, "05A", false, null);
		VagaEstacionamento v6 = new VagaEstacionamento(6, "06A", false, null);
		VagaEstacionamento v7 = new VagaEstacionamento(7, "07A", false, null);
		VagaEstacionamento v8 = new VagaEstacionamento(8, "08A", false, null);
		VagaEstacionamento v9 = new VagaEstacionamento(9, "09A", false, null);
		VagaEstacionamento v10 = new VagaEstacionamento(10, "10A", false, null);

		vagaRepo.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10));

		Apartamento a1 = new Apartamento(1, "A", "0001", "0001", null);
		Apartamento a2 = new Apartamento(2, "A", "0002", "0002", null);
		Apartamento a3 = new Apartamento(3, "A", "0003", "0003", null);
		Apartamento a4 = new Apartamento(4, "A", "0004", "0004", null);
		Apartamento a5 = new Apartamento(5, "A", "0005", "0005", null);

		apartamentoRepo.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
		
	}

}
