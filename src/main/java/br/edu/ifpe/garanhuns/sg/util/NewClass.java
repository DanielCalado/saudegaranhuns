/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.util;

import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.PerfilUsuario;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Prioridade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Status;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author nosso
 */

public class NewClass {

    public static void main(String[] args) {
        ConsultaHibernate cH = new ConsultaHibernate();
        Paciente p = new Paciente("lala", "123", LocalDate.of(1955, 6, 1), new PostoSaude("casa", new Endereco("omi", "654", new Bairro("HGGFD"))), new Usuario("lala", "00000", PerfilUsuario.PACIENTE));
        cH.inserir(new Consulta(Especialidade.GERAL, Prioridade.IDOSO, Status.FILA, LocalDate.now(), LocalDate.now(), p));
        cH.inserir(new Consulta(Especialidade.DENTISTA, Prioridade.BEBEDECOLO, Status.AGENDADO, LocalDate.now(), LocalDate.now().plusDays(1), p));
        cH.inserir(new Consulta(Especialidade.GERAL, Prioridade.DEFICIENTEFISICO, Status.CANCELADO, LocalDate.now(), LocalDate.now(), p));
        cH.inserir(new Consulta(Especialidade.GERAL, Prioridade.NENHUMA, Status.AGENDADO, LocalDate.now(), LocalDate.now(), p));
        cH.inserir(new Consulta(Especialidade.DENTISTA, Prioridade.DEFICIENTEFISICO, Status.FILA, LocalDate.now(), LocalDate.now(), p));
        cH.inserir(new Consulta(Especialidade.GERAL, Prioridade.IDOSO, Status.AGENDADO, LocalDate.now(), LocalDate.now(), p));
        
        List<Consulta> c = cH.recuperarConsultasDoDia(LocalDate.now());
        for( Consulta c1 : c){
            System.out.println(c1);
        }
    }
}