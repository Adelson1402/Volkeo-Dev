package br.com.volkeo.basicaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volkeo.basicaccess.dao.entities.DocumentosEntity;
import br.com.volkeo.basicaccess.dao.entities.PessoaEntity;
import br.com.volkeo.basicaccess.dao.entities.PessoaFisicaEntity;
import br.com.volkeo.basicaccess.dao.entities.PessoaJuridicaEntity;
import br.com.volkeo.basicaccess.services.exception.InvalidDocumentException;
import br.com.volkeo.basicaccess.util.Mensagens;
import br.com.volkeo.basicaccess.util.UtilVolkeo;

@Service
public class PessoasService {

	@Autowired
	private PessoaFisicaService pessoaFisica;

	@Autowired
	private PessoaJuridicaService pessoaJuridica;

	@Autowired
	private EnderecosService enderecos;

	@Autowired
	private DocumentosService documentos;

	@Autowired
	private EmailsService emails;

	@Autowired
	private TelefonesService telefones;

	private void completePerson(PessoaEntity pessoaGeral) {
		pessoaGeral.setLstDocumentos(documentos.findByPerson(pessoaGeral.getId()));
		pessoaGeral.setLstEmails(emails.findByPerson(pessoaGeral.getId()));
		pessoaGeral.setLstEnderecos(enderecos.findByPerson(pessoaGeral.getId()));
		pessoaGeral.setLstTelefones(telefones.findByPerson(pessoaGeral.getId()));
	}

	public PessoaEntity buscarCpfouCnpj(String nrDocumento) {
		PessoaEntity pessoaGeral = buscarDocumento(nrDocumento);
		completePerson(pessoaGeral);
		return pessoaGeral;
	}

	private PessoaEntity buscarDocumento(String nrDocumento) {
		PessoaEntity pessoa = null;
		int valor = UtilVolkeo.verificaTipoDocumento(nrDocumento);
		if (valor == UtilVolkeo.NENHUM) {
			throw new InvalidDocumentException(Mensagens.MSG001);
		} else if (valor == UtilVolkeo.CPF) {
			if (UtilVolkeo.isCPF(nrDocumento)) {
				throw new InvalidDocumentException(Mensagens.MSG002);
			}
			try {
				DocumentosEntity doc = (DocumentosEntity) documentos
						.findByNumber(UtilVolkeo.removeCaracteresEspeciais(nrDocumento));
				pessoa = pessoaFisica.findById(doc.getPessoa().getId());
			} catch (Exception e) {
				throw new InvalidDocumentException(Mensagens.MSG005);
			}

		} else if (valor == UtilVolkeo.CNPJ) {
			if (UtilVolkeo.isCPF(nrDocumento)) {
				throw new InvalidDocumentException(Mensagens.MSG003);
			}
			try {
				DocumentosEntity doc = (DocumentosEntity) documentos
						.findByNumber(UtilVolkeo.removeCaracteresEspeciais(nrDocumento));
				pessoa = pessoaJuridica.findById(doc.getPessoa().getId());
			} catch (Exception e) {
				throw new InvalidDocumentException(Mensagens.MSG005);
			}
		}

		return pessoa;
	}

}
