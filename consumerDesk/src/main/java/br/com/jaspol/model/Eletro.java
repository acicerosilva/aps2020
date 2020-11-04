package br.com.jaspol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Eletro {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("marca")
    @Expose
    private String marca;
    @SerializedName("potencia")
    @Expose
    private Integer potencia;
    @SerializedName("tempoUso")
    @Expose
    private Double tempoUso;
    @SerializedName("gastoDiaWatts")
    @Expose
    private Double gastoDiaWatts;
    @SerializedName("gastoMesWatts")
    @Expose
    private Double gastoMesWatts;
    @SerializedName("gastoDiaReais")
    @Expose
    private Double gastoDiaReais;
    @SerializedName("gastoMesReais")
    @Expose
    private Double gastoMesReais;
    @SerializedName("pessoaIdFk")
    @Expose
    private Integer pessoaIdFk;

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

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Double getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(Double tempoUso) {
        this.tempoUso = tempoUso;
    }

    public Double getGastoDiaWatts() {
        return gastoDiaWatts;
    }

    public void setGastoDiaWatts(Double gastoDiaWatts) {
        this.gastoDiaWatts = gastoDiaWatts;
    }

    public Double getGastoMesWatts() {
        return gastoMesWatts;
    }

    public void setGastoMesWatts(Double gastoMesWatts) {
        this.gastoMesWatts = gastoMesWatts;
    }

    public Double getGastoDiaReais() {
        return gastoDiaReais;
    }

    public void setGastoDiaReais(Double gastoDiaReais) {
        this.gastoDiaReais = gastoDiaReais;
    }

    public Double getGastoMesReais() {
        return gastoMesReais;
    }

    public void setGastoMesReais(Double gastoMesReais) {
        this.gastoMesReais = gastoMesReais;
    }

    public Integer getPessoaIdFk() {
        return pessoaIdFk;
    }

    public void setPessoaIdFk(Integer pessoaIdFk) {
        this.pessoaIdFk = pessoaIdFk;
    }

}
