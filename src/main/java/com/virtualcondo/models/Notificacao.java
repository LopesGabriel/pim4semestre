package com.virtualcondo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String assunto;
	private String txtConteudo;

	@OneToOne
	@JoinColumn(name = "destinatario", referencedColumnName = "id")
	private Morador destinatario;
	@OneToOne
	@JoinColumn(name = "remetente", referencedColumnName = "id")
	private Morador remetente;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtEnvio;

	@OneToMany(mappedBy = "id", targetEntity = Anexo.class, fetch = FetchType.LAZY)
	private List<Anexo> anexos;

	public Notificacao() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTxtConteudo() {
		return txtConteudo;
	}

	public void setTxtConteudo(String txtConteudo) {
		this.txtConteudo = txtConteudo;
	}

	public Morador getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Morador destinatario) {
		this.destinatario = destinatario;
	}

	public Morador getRemetente() {
		return remetente;
	}

	public void setRemetente(Morador remetente) {
		this.remetente = remetente;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	public Date getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(Date dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

}
