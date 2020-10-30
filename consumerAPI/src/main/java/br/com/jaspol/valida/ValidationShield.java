/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jaspol.valida;

import br.com.jaspol.model.ChangePass;
import br.com.jaspol.model.Eletro;
import br.com.jaspol.model.User;

/**
 *
 * @author antonio
 */
public class ValidationShield {
    
    public Boolean validaPessoa(User pessoa){
        Boolean name  = pessoa.getName() != null;
        Boolean email = pessoa.getEmail() != null;
        Boolean password = pessoa.getPassword() != null; 
        return name && email && password;
    }
    
    public Boolean validaLogin(User pessoa){
        Boolean email = pessoa.getEmail() != null;
        Boolean password = pessoa.getPassword() != null; 
        return email && password;          
    }
    
    public Boolean validaPass(ChangePass pessoa){
        Boolean email = pessoa.getEmail() != null;
        Boolean password = pessoa.getPassword() != null; 
        Boolean passwordTwo = pessoa.getPasswordtwo() != null;
        
        return email && password && passwordTwo;          
    }
    
    
    public Boolean validaEletronico(Eletro eletronico){
        Boolean name = eletronico.getName() != null;
        Boolean marca = eletronico.getMarca() != null;
        Boolean potencia = eletronico.getPotencia() != null;
        Boolean tempo = eletronico.getTempoUso() != null;
        Boolean pessoaId = eletronico.getPessoaIdFk() != null;
        
        return name && marca && potencia && tempo && pessoaId;    
    }
    
     public Boolean validaEletronicoEdicao(Eletro eletronico){
        Boolean id = eletronico.getId() != null;
        Boolean name = eletronico.getName() != null;
        Boolean marca = eletronico.getMarca() != null;
        Boolean potencia = eletronico.getPotencia() != null;
        Boolean tempo = eletronico.getTempoUso() != null;
        Boolean pessoaId = eletronico.getPessoaIdFk() != null;
        
        return name && marca && potencia && tempo && pessoaId && id;    
    }
    
    
}
