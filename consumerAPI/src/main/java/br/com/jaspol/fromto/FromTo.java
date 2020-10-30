/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jaspol.fromto;

import br.com.jaspol.calc.Calculadora;
import br.com.jaspol.dao.GenericDao;
import br.com.jaspol.domain.Eletronico;
import br.com.jaspol.domain.Pessoa;
import br.com.jaspol.model.ChangePass;
import br.com.jaspol.model.Eletro;
import br.com.jaspol.model.User;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antonio
 */
public class FromTo {
    
    
    
    public List<User> retUser(List<Pessoa> pessoa) {
        List<User> listUser = new ArrayList<User>();
        pessoa.forEach(pes -> {
            User user = new User();
            user.setId(pes.getId());
            user.setName(pes.getName());
            user.setEmail(pes.getEmail());
            listUser.add(user);
        });
        return listUser;
    }

    public List<Eletro> retEletro(List<Eletronico> eletronico){
        List<Eletro> listEletro = new ArrayList<Eletro>();
        eletronico.forEach(elet->{
            Eletro eletro = new Eletro();
            eletro.setId(elet.getId());
            eletro.setName(elet.getName());
            eletro.setPotencia(elet.getPotencia().intValue());
            eletro.setTempoUso(new Double(elet.getTempoUso().toString()));
            eletro.setGastoDiaWatts(new Double(elet.getGastoDiaWatts().toString()));
            eletro.setGastoMesWatts(new Double(elet.getGastoMesWatts().toString()));
            eletro.setGastoDiaReais(new Double(elet.getGastoDiaReais().toString()));
            eletro.setGastoMesReais(new Double(elet.getGastoMesReais().toString()));
            eletro.setPessoaIdFk(elet.getPessoaIdFk().getId());
            listEletro.add(eletro);
        });
        return listEletro;
    }
    
    public Pessoa newUser(User user, GenericDao dao){
        Pessoa pessoa = new Pessoa();
        pessoa.setName(user.getName());
        pessoa.setEmail(user.getEmail());
        pessoa.setPassword(user.getPassword().toLowerCase());
        return (Pessoa) dao.merge(pessoa);
    }
    
    public Pessoa newPass(Pessoa pessoa, ChangePass user, GenericDao dao){
        pessoa.setName(user.getName());
        pessoa.setEmail(user.getEmail());
        pessoa.setPassword(user.getPasswordtwo().toLowerCase());
        return (Pessoa) dao.merge(pessoa);
    }
    
    public Eletronico newEletro(Eletro elet, GenericDao dao){
            Eletronico eletro = new Eletronico();
            eletro.setName(elet.getName().toLowerCase());
            eletro.setMarca(elet.getMarca().toLowerCase());
            eletro.setPotencia(new BigInteger(elet.getPotencia().toString()));
            eletro.setTempoUso(new BigDecimal(elet.getTempoUso()));
            eletro.setPessoaIdFk(dao.buscaPessoaId(elet.getPessoaIdFk()));
            
            Calculadora calc = new Calculadora();
            
        return (Eletronico) dao.merge(calc.calculaWatts(eletro));
    }
    
     public Eletronico newEletroEdit(Eletronico eletro, Eletro elet, GenericDao dao){
            eletro.setName(elet.getName().toLowerCase());
            eletro.setMarca(elet.getMarca().toLowerCase());
            eletro.setPotencia(new BigInteger(elet.getPotencia().toString()));
            eletro.setTempoUso(new BigDecimal(elet.getTempoUso()));
            eletro.setPessoaIdFk(dao.buscaPessoaId(elet.getPessoaIdFk()));
            
            Calculadora calc = new Calculadora();
            
        return (Eletronico) dao.merge(calc.calculaWatts(eletro));
    }
    
}
