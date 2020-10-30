/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jaspol.calc;

import br.com.jaspol.domain.Eletronico;
import java.math.BigDecimal;

/**
 *
 * @author antonio
 */
public class Calculadora {
    
    public Eletronico calculaWatts(Eletronico eletronico){
        
        eletronico.setGastoDiaWatts(
                eletronico.getTempoUso().multiply(
                        new BigDecimal(eletronico.getPotencia().intValue())
                ).divide(new BigDecimal(1000))
        );
        
        eletronico.setGastoMesWatts(
                eletronico.getGastoDiaWatts().multiply(
                        new BigDecimal(30)
                )
        );
        
        eletronico.setGastoDiaReais(
                eletronico.getGastoDiaWatts().multiply( new BigDecimal(0.68))
        );
        
        eletronico.setGastoMesReais(
                eletronico.getGastoDiaReais().multiply( new BigDecimal(30))
        );
        
        
        return eletronico;
    }
    
}
