package br.unipar.bancopoo;

import br.unipar.bancopoo.Enums.OperadoraEnum;
import br.unipar.bancopoo.Enums.TipoContaEnum;
import br.unipar.bancopoo.Enums.TipoTransacaoEnum;
import br.unipar.bancopoo.models.Agencia;
import br.unipar.bancopoo.models.Banco;
import br.unipar.bancopoo.models.Cidade;
import br.unipar.bancopoo.models.Conta;
import br.unipar.bancopoo.models.Endereco;
import br.unipar.bancopoo.models.Estado;
import br.unipar.bancopoo.models.Pais;
import br.unipar.bancopoo.models.PessoaFisica;
import br.unipar.bancopoo.models.Telefone;
import br.unipar.bancopoo.models.Transacao;
import br.unipar.bancopoo.repositories.EnderecoDAO;
import br.unipar.bancopoo.repositories.PaisDAO;
import br.unipar.bancopoo.services.AgenciaService;
import br.unipar.bancopoo.services.BancoService;
import br.unipar.bancopoo.services.CidadeService;
import br.unipar.bancopoo.services.ContaService;
import br.unipar.bancopoo.services.EnderecoService;
import br.unipar.bancopoo.services.EstadoService;
import br.unipar.bancopoo.services.PaisService;
import br.unipar.bancopoo.services.PessoaFisicaService;
import br.unipar.bancopoo.services.PessoaJuridicaService;
import br.unipar.bancopoo.services.PessoaService;
import br.unipar.bancopoo.services.TelefoneService;
import br.unipar.bancopoo.services.TransacaoService;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BancoPoo {

    public static void main(String[] args) {
        
        try{
            
//INSERT DE PAIS
//            PaisService ps = new PaisService();
//            Pais pais = new Pais();
//            pais.setId(826);
//            pais.setNmPais("País de Gales");
//            pais.setSgPais("WL");
//            pais.setRa("00230380");
//            ps.insert(pais);

//INSERT DE ESTADO
//            EstadoService es = new EstadoService();
//            PaisService ps = new PaisService();
//            Estado estado = new Estado();
//            estado.setId(10011);
//            estado.setNmEstado("Cardiff");
//            estado.setPais(ps.findById(826));
//            estado.setRa("00230380");
//            estado.setSgEstado("CF");
//            es.insert(estado);

//INSERT DE CIDADE
//            CidadeService cs = new CidadeService();
//            EstadoService es = new EstadoService();
//            Cidade cidade = new Cidade();
//            cidade.setId(3112901);
//            cidade.setNmCidade("Carmo do Paranaíba");
//            cidade.setEstado(es.findById(31));
//            cidade.setRa("00230380");
//            cs.insert(cidade);
            

//INSERT DE PESSOA
//            PessoaFisicaService pfs = new PessoaFisicaService();
//            PessoaFisica pessoaFisica = new PessoaFisica();
//            pessoaFisica.setCpf("20569902029");
//            pessoaFisica.setEmail("victorwazlawick@gmail.com");
//            pessoaFisica.setNmPessoa("Victor Wazowski");
//            pessoaFisica.setRg("10.248.971-3");
//            pessoaFisica.setRa("00230380");
//            Date data = Date.valueOf("2003-10-30");
//            pessoaFisica.setDtnasc(data);
//            pfs.insert(pessoaFisica);

//INSERT DE ENDERECO
//            EnderecoService es = new EnderecoService();
//            PessoaService ps = new PessoaService();
//            CidadeService cs = new CidadeService();
//            Endereco endereco = new Endereco();
//            endereco.setCep("78085-516");
//            endereco.setCidade(cs.findById(3112901));
//            endereco.setNmBairro("Parque Georgia");
//            endereco.setNmRua("Avenida Caravela");
//            endereco.setNrCasa("231");
//            endereco.setPessoa(ps.findById(1));
//            endereco.setRa("00230380");
//            es.insert(endereco);

//INSERT DE TELEFONE
//            TelefoneService ts = new TelefoneService();
//            PessoaService ps = new PessoaService();
//            Telefone telefone = new Telefone();
//            telefone.setNrTelefone("45988083059");
//            telefone.setOperadora(OperadoraEnum.TIM);
//            telefone.setPessoa(ps.findById(1));
//            telefone.setRa("00230380");
//            ts.insert(telefone);
     
//INSERT DE BANCO
//            BancoService bs = new BancoService();
//            Banco banco = new Banco();
//            banco.setId(2313);
//            banco.setNmBanco("Banco de trabalho completo");
//            banco.setRa("00230380");
//            bs.insert(banco);

//INSERT DE AGENCIA            
//            AgenciaService as = new AgenciaService();
//            BancoService bs = new BancoService();
//            Agencia agencia = new Agencia();
//            agencia.setId(213);
//            agencia.setBanco(bs.findById(112));
//            agencia.setCnpj("77520932000190");
//            agencia.setCodigo("4788");
//            agencia.setDigito("02");
//            agencia.setRa("00230380");
//            agencia.setRazaoSocial("Agencia de Testes");
//            as.insert(agencia);

//INSERT DE TELEFONE
//            TelefoneService ts = new TelefoneService();
//            PessoaService ps = new PessoaService();
//            Telefone telefone = new Telefone();
//            telefone.setNrTelefone("45998618406");
//            telefone.setOperadora(OperadoraEnum.CLARO);
//            telefone.setPessoa(ps.findById(1));
//            telefone.setRa("00230380");
//            ts.insert(telefone);

//INSERT DE CONTA
//            ContaService cs = new ContaService();
//            AgenciaService as = new AgenciaService();
//            PessoaService ps = new PessoaService();
//            Conta conta = new Conta();
//            conta.setAgencia(as.findById(55));
//            conta.setNrConta("1718561");
//            conta.setDigito("6");
//            conta.setPessoa(ps.findById(1));
//            conta.setRa("00230380");
//            conta.setSaldo(350);
//            conta.setTipo(TipoContaEnum.CONTA_CORRENTE);
//            cs.insert(conta);
            
//INSERT DE TRANSAÇÃO
//            TransacaoService ts = new TransacaoService();
//            ContaService cs = new ContaService();
//            Transacao transacao = new Transacao();
//            transacao.setContaOrigem(cs.findById(47));
//            transacao.setContaDestino(cs.findById(31));
//            LocalDateTime now = LocalDateTime.now();
//            Date data = Date.valueOf(now.toLocalDate());
//            transacao.setDhTransacao(data);
//            transacao.setRa("00230380");
//            transacao.setTipo(TipoTransacaoEnum.PIX);
//            transacao.setValor(400);
//            ts.insert(transacao);

//SELECT DE PAIS
//            PaisService ps = new PaisService();
//            System.out.println(ps.findById(2));

//SELECT DE ESTADO
//            EstadoService es = new EstadoService();
//            System.out.println(es.findById(2));

//SELECT DE CIDADE
//            CidadeService cs = new CidadeService();
//            System.out.println(cs.findById(1));

//SELECT DE ENDERECO
//            EnderecoService es = new EnderecoService();
//            System.out.println(es.findById(1));

//SELECT DE PESSOA
//            PessoaService ps = new PessoaService();
//            System.out.println(ps.findById(1));

//SELECT DE PESSOA FISICA
//            PessoaFisicaService pfs = new PessoaFisicaService();
//            System.out.println(pfs.findById(1));

//SELECT DE PESSOA JURIDICA
//            PessoaJuridicaService pjs = new PessoaJuridicaService();
//            System.out.println(pjs.findById(1));

//SELECT DE TELEFONE
//            TelefoneService ts = new TelefoneService();
//            System.out.println(ts.findById(1));

//SELECT DE BANCO
//            BancoService bs = new BancoService();
//            System.out.println(bs.findById(1));

//SELECT DE AGENCIA
//            AgenciaService as = new AgenciaService();
//            System.out.println(as.findById(1));

//SELECT DE CONTA
//            ContaService cs = new ContaService();
//            System.out.println(cs.findById(1));

//SELECT DE TRANSACAO
//            TransacaoService ts = new TransacaoService();
//            System.out.println(ts.findById(1));

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
    }
}
