/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jaspol.dao;

import br.com.jaspol.model.EditaEletro;
import br.com.jaspol.model.Eletro;
import br.com.jaspol.model.Login;
import br.com.jaspol.model.NewPass;
import br.com.jaspol.model.NewUser;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author antonio
 */
public class CalculadoraDao {
    
     private final HttpClient http;
    
    public CalculadoraDao(){
        this.http = HttpClientBuilder.create().build();
    }
    
    //
    // POST
    //
    public String CadastraUser(NewUser u){
        try {
            HttpPost requisicao = new HttpPost("https://wsrestrletricocossumer.herokuapp.com/webresources/consumer/cadastrar");
            requisicao.addHeader("Content-Type", "application/json");
            
            //Converter o objeto em JSON
            StringEntity se = new StringEntity(new Gson().toJson(u),"UTF-8");
            requisicao.setEntity((HttpEntity) se);
            
            HttpResponse resposta = http.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return "Erro";
        }
    }
    
    //
    // POST
    //
    public String login(Login u){
        try {
            HttpPost requisicao = new HttpPost("https://wsrestrletricocossumer.herokuapp.com/webresources/consumer/login");
            requisicao.addHeader("Content-Type", "application/json");
            
            //Converter o objeto em JSON
            StringEntity se = new StringEntity(new Gson().toJson(u),"UTF-8");
            requisicao.setEntity((HttpEntity) se);
            
            HttpResponse resposta = http.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }   
    
    //
    // POST
    //
    public String newEletro(Eletro e){
        try {
            HttpPost requisicao = new HttpPost("https://wsrestrletricocossumer.herokuapp.com/webresources/consumer/cadastrareletro");
            requisicao.addHeader("Content-Type", "application/json");
            
            //Converter o objeto em JSON
            StringEntity se = new StringEntity(new Gson().toJson(e),"UTF-8");
            requisicao.setEntity((HttpEntity) se);
            
            HttpResponse resposta = http.execute(requisicao);
            return  EntityUtils.toString(resposta.getEntity()); 
        } catch (Exception ex) {
            System.err.println("ERRO: " + ex.getMessage());
            return "Erro";
        }
    }       
    
    //
    // GET
    //
    public String getEletro(final String RECURSO){
        try {
            HttpGet requisicao = new HttpGet("https://wsrestrletricocossumer.herokuapp.com/webresources/consumer/buscaeletro/"+RECURSO);
            requisicao.addHeader("Content-Type", "application/json");
           
            HttpResponse resposta = http.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }   

    //
    // PUT
    //
    public String editaEletro(EditaEletro el){
        try {
            HttpPut requisicao = new HttpPut("https://wsrestrletricocossumer.herokuapp.com/webresources/consumer/editaeletro");
            requisicao.addHeader("Content-Type", "application/json");
            
            //Converter o objeto Aluno em JSON
            StringEntity se = new StringEntity(new Gson().toJson(el),"UTF-8");
            requisicao.setEntity((HttpEntity) se);
            
            HttpResponse resposta = http.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return "Erro";
        }
    }   

    //
    // PUT
    //
    public String editaUser(NewPass p){
        try {
            HttpPut requisicao = new HttpPut("https://wsrestrletricocossumer.herokuapp.com/webresources/consumer/trocasenha");
            requisicao.addHeader("Content-Type", "application/json");
            
            //Converter o objeto Aluno em JSON
            StringEntity se = new StringEntity(new Gson().toJson(p),"UTF-8");
            requisicao.setEntity((HttpEntity) se);
            
            HttpResponse resposta = http.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return "Erro";
        }
    }       

    //
    // DELETE
    //
    public String deleteEletro(final String RECURSO){
        try {
            HttpDelete requisicao = new HttpDelete("https://wsrestrletricocossumer.herokuapp.com/webresources/consumer/deletaeletro/"+RECURSO);
            requisicao.addHeader("Content-Type", "application/json");
            
            HttpResponse resposta = http.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return "Erro";
        }
    }       

    //
    // DELETE
    //
    public String deleteUser(final String RECURSO){
        try {
            HttpDelete requisicao = new HttpDelete("https://wsrestrletricocossumer.herokuapp.com/webresources/consumer/deletauser/"+RECURSO);
            requisicao.addHeader("Content-Type", "application/json");
            
            HttpResponse resposta = http.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return "Erro";
        }
    }       

     public String getCep(final String RECURSO){
        try {
            HttpGet requisicao = new HttpGet("https://viacep.com.br/ws/"+RECURSO+"/json/");
            requisicao.addHeader("Content-Type", "application/json");
           
            HttpResponse resposta = http.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }   
}
