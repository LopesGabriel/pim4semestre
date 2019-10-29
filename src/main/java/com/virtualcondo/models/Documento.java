package com.virtualcondo.models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nomeDocumento;
	private String nomeArquivo;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date dtUpload;
	private Morador responsavel;
	private Apartamento apVinculado;

	public Documento() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Morador getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Morador responsavel) {
		this.responsavel = responsavel;
	}

	public Apartamento getApVinculado() {
		return apVinculado;
	}

	public void setApVinculado(Apartamento apVinculado) {
		this.apVinculado = apVinculado;
	}

	public Date getDtUpload() {
		return dtUpload;
	}

	public void setDtUpload(Date dtUpload) {
		this.dtUpload = dtUpload;
	}

}
