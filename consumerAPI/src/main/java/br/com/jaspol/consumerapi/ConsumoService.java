package br.com.jaspol.consumerapi;

import br.com.jaspol.dao.GenericDao;
import br.com.jaspol.domain.Eletronico;
import br.com.jaspol.domain.Pessoa;
import br.com.jaspol.fromto.FromTo;
import br.com.jaspol.model.ChangePass;
import br.com.jaspol.model.Eletro;
import br.com.jaspol.model.User;
import br.com.jaspol.valida.ValidationShield;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/consumer")
public class ConsumoService {
    
    private GenericDao dao;
    private FromTo dePara;
    private ValidationShield valida;
    
    public ConsumoService(){
        this.dao = new GenericDao();
        this.dePara = new FromTo();
        this.valida = new ValidationShield();
    }
    
   @Path("/cadastrareletro")
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public String cadastraEletro(String eletro){
        Eletro eletr = new Gson().fromJson(eletro, Eletro.class);
        Eletronico eletronico = null;
        if (this.valida.validaEletronico(eletr)) {
            this.dao.openConnec();
            eletronico = this.dao.buscaEletro(eletr);
            if (eletronico == null) {
                this.dePara.newEletro(eletr, this.dao);
                this.dao.fechaConnec();
                return "Eletronico cadastrado com sucesso!";
            } else {
                this.dao.fechaConnec();
                return "Eletronico ja existe!"; 
            }
        } else {
            return "Complete todos os campos!";
        }
    }
    
   @Path("/cadastrar")
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public String cadastraUser(String pessoa){
        Pessoa p = null;
        User user = new Gson().fromJson(pessoa, User.class);
        if (this.valida.validaPessoa(user)) { 
            this.dao.openConnec();
            p = this.dao.buscaPessoa(user);
            if (p == null) {
                this.dePara.newUser(user, this.dao);
                this.dao.fechaConnec();
                return"Usuario cadastrado com sucesso!";
            } else {
                this.dao.fechaConnec();
                return "Usuario ja existe!"; 
            }
        } else {
            return "Complete todos os campos!";
        }
    }
   
    
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String logar(String pessoa){
        Pessoa p = null;
        User user = new Gson().fromJson(pessoa, User.class);
        if(this.valida.validaLogin(user)){
            this.dao.openConnec();
            p = dao.buscaPessoaLoga(user);
            this.dao.fechaConnec();
            if(p != null){
                p.setPassword("");
                return new Gson().toJson(p);
            }else{
                return "Usuario nao cadastrado!";
            }    
        }else{
            return "Complete todos os campos";
        }    
    }
    
    @Path("/buscaeletro/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEletro(@PathParam("id")int id){
        List<Eletronico> eletronico = null; 
        this.dao.openConnec();
        eletronico = dao.buscaEletroPessoaId(id);
        this.dao.fechaConnec();
        if(eletronico == null || eletronico.isEmpty()){
            return new Gson().toJson("Nenhum equipamento cadastrado para o usuario!");
        }else{            
            return new Gson().toJson(this.dePara.retEletro(eletronico));
        }
    }
   
    @Path("/deletaeletro/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deletaEletro(@PathParam("id")int id){
        Eletronico eletr = null;
        this.dao.openConnec();
        String msg = null;
        eletr =  this.dao.buscaEletroId(id);
        if(eletr != null){
            this.dao.remove(eletr);
            msg = "Eletronico deletado!";
        }else{
            msg = "Eletronico nao Existe!";
        }
        this.dao.fechaConnec();
        return msg;
       
    }
    
    
    @Path("/deletauser/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deletaUser(@PathParam("id")int id){
        Pessoa pes = null;  
        this.dao.openConnec();
        pes = this.dao.buscaPessoaId(id);
        String msg = null;
        if(pes.getName() != null) {
            this.dao.remove(pes);
            msg = "Usuario deletado!"; 
        }else{
            msg = "Usuario nao Existe!";  
        }
        this.dao.fechaConnec();
        return msg;
    }
  
    @Path("/editaeletro")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String atualizar(String eletro) {
        Eletronico eletronico = null;
        String msg = null;
        Eletro eletr = new Gson().fromJson(eletro, Eletro.class);
        if (this.valida.validaEletronicoEdicao(eletr)) {
            this.dao.openConnec();
            eletronico = this.dao.buscaEletroId(eletr.getId());
            if (eletronico != null) {
                this.dePara.newEletroEdit(eletronico, eletr, dao);
                dao.fechaConnec();
                msg = "Operacao Realizada!";
            } else {
                msg = "Eletronico nao existe na base de dados!";
            }
        } else {
            msg = "Preencha todos os campos!";
        }

        return msg;
    }
    
    @Path("/trocasenha")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String trocaSenha(String userChange) {
        Pessoa pessoa = null;
        String msg = null;
        ChangePass pass = new Gson().fromJson(userChange,ChangePass.class);
        if (this.valida.validaPass(pass)) {
            this.dao.openConnec();
            pessoa = this.dao.buscaPessoaPass(pass);
            if (pessoa != null) {
                this.dePara.newPass(pessoa, pass, dao);
                dao.fechaConnec();
                msg = "Operacao Realizada!";
            } else {
                msg = "Usuario nao existe na base de dados!";
            }
        } else {
            msg = "Preencha todos os campos!";
        }

        return msg;
    }
}
