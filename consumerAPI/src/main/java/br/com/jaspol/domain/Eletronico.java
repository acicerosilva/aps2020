/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jaspol.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "eletronico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eletronico.findAll", query = "SELECT e FROM Eletronico e")
    , @NamedQuery(name = "Eletronico.findById", query = "SELECT e FROM Eletronico e WHERE e.id = :id")
    , @NamedQuery(name = "Eletronico.findByName", query = "SELECT e FROM Eletronico e WHERE e.name = :name")
    , @NamedQuery(name = "Eletronico.findByMarca", query = "SELECT e FROM Eletronico e WHERE e.marca = :marca")
    , @NamedQuery(name = "Eletronico.findByPotencia", query = "SELECT e FROM Eletronico e WHERE e.potencia = :potencia")
    , @NamedQuery(name = "Eletronico.findByTempoUso", query = "SELECT e FROM Eletronico e WHERE e.tempoUso = :tempoUso")
    , @NamedQuery(name = "Eletronico.findByGastoDiaWatts", query = "SELECT e FROM Eletronico e WHERE e.gastoDiaWatts = :gastoDiaWatts")
    , @NamedQuery(name = "Eletronico.findByGastoMesWatts", query = "SELECT e FROM Eletronico e WHERE e.gastoMesWatts = :gastoMesWatts")
    , @NamedQuery(name = "Eletronico.findByGastoDiaReais", query = "SELECT e FROM Eletronico e WHERE e.gastoDiaReais = :gastoDiaReais")
    , @NamedQuery(name = "Eletronico.findByGastoMesReais", query = "SELECT e FROM Eletronico e WHERE e.gastoMesReais = :gastoMesReais")
    , @NamedQuery(name = "Eletronico.findByPessoaId", query = "SELECT e FROM Eletronico e WHERE e.pessoaIdFk.id = :id")})
public class Eletronico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "marca")
    private String marca;
    @Column(name = "potencia")
    private BigInteger potencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tempo_uso")
    private BigDecimal tempoUso;
    @Column(name = "gasto_dia_watts")
    private BigDecimal gastoDiaWatts;
    @Column(name = "gasto_mes_watts")
    private BigDecimal gastoMesWatts;
    @Column(name = "gasto_dia_reais")
    private BigDecimal gastoDiaReais;
    @Column(name = "gasto_mes_reais")
    private BigDecimal gastoMesReais;
    @JoinColumn(name = "pessoa_id_fk", referencedColumnName = "id")
    @ManyToOne
    private Pessoa pessoaIdFk;

    public Eletronico() {
    }

    public Eletronico(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigInteger getPotencia() {
        return potencia;
    }

    public void setPotencia(BigInteger potencia) {
        this.potencia = potencia;
    }

    public BigDecimal getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(BigDecimal tempoUso) {
        this.tempoUso = tempoUso;
    }

    public BigDecimal getGastoDiaWatts() {
        return gastoDiaWatts;
    }

    public void setGastoDiaWatts(BigDecimal gastoDiaWatts) {
        this.gastoDiaWatts = gastoDiaWatts;
    }

    public BigDecimal getGastoMesWatts() {
        return gastoMesWatts;
    }

    public void setGastoMesWatts(BigDecimal gastoMesWatts) {
        this.gastoMesWatts = gastoMesWatts;
    }

    public BigDecimal getGastoDiaReais() {
        return gastoDiaReais;
    }

    public void setGastoDiaReais(BigDecimal gastoDiaReais) {
        this.gastoDiaReais = gastoDiaReais;
    }

    public BigDecimal getGastoMesReais() {
        return gastoMesReais;
    }

    public void setGastoMesReais(BigDecimal gastoMesReais) {
        this.gastoMesReais = gastoMesReais;
    }

    public Pessoa getPessoaIdFk() {
        return pessoaIdFk;
    }

    public void setPessoaIdFk(Pessoa pessoaIdFk) {
        this.pessoaIdFk = pessoaIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eletronico)) {
            return false;
        }
        Eletronico other = (Eletronico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id = " + id + " name = "+ name + " marca = " + marca +" potencia = " + potencia 
              +" " ;
    }
    
}
