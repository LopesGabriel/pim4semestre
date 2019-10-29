package com.virtualcondo.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FotoService {

	@Value("${virtualcondo.raiz}")
	private String raiz;

	@Value("${virtualcondo.diretorio-fotos}")
	private String fotos;

	public FotoService() {}

	public File salvarFoto(MultipartFile foto, String nome) {

		Path diretorioPath = Paths.get(raiz, fotos);
		Path arquivoPath = diretorioPath.resolve(nome + "_" + new Date().getTime() + "_" + foto.getOriginalFilename());

		try {

			File path = new File(raiz + File.separator + fotos);
			if(!path.exists())
				path.mkdirs();

			foto.transferTo(arquivoPath.toFile());

		}catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao gravar o arquivo em disco. " + e.getMessage());
		}

		return arquivoPath.toFile();
	}

}
