package controleatleta;

import java.util.ArrayList;

public class Arqueiro extends Atleta {

    
    private String alvo;
    private Double tamanhoArco;	
    private int distancia; //Masculino: 90, 70, 50 e  30 metros; Feminino: 70, 60, 50,30 metros.
    private String tipoFlecha;  //(M) Madeira, (A) Alumínio, (C)  Carbono
    private char tipoArco;// (T) Arco tradicional,  (R) Arco recurvo (olímpico), (C) Arco composto.
    private char modalidade;// (O) Outdoor,(I) Indoor, (F) Field, (S) Ski-archery (esqui), (C) Clout, (E) Flight.
    private ArrayList<Premiacao> premiacoes;
    private int totalAcertosNaMosca;
    private int totalDesistencias;
    private int totalMedalhas;

   public Arqueiro (String nome){
   super(nome);   
   }

    public String getAlvo() {
        return alvo;
    }

    public void setAlvo(String alvo) {
        this.alvo = alvo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public char getModalidade() {
        return modalidade;
    }

    public void setModalidade(char modalidade) {
        this.modalidade = modalidade;
    }

    public ArrayList<Premiacao> getPremiacoes() {
        return premiacoes;
    }

    public void setPremiacoes(ArrayList<Premiacao> premiacoes) {
        this.premiacoes = premiacoes;
    }

    public Double getTamanhoArco() {
        return tamanhoArco;
    }

    public void setTamanhoArco(Double tamanhoArco) {
        this.tamanhoArco = tamanhoArco;
    }

    public char getTipoArco() {
        return tipoArco;
    }

    public void setTipoArco(char tipoArco) {
        this.tipoArco = tipoArco;
    }

    public String getTipoFlecha() {
        return tipoFlecha;
    }

    public void setTipoFlecha(String tipoFlecha) {
        this.tipoFlecha = tipoFlecha;
    }

    public int getTotalAcertosNaMosca() {
        return totalAcertosNaMosca;
    }

    public void setTotalAcertosNaMosca(int totalAcertosNaMosca) {
        this.totalAcertosNaMosca = totalAcertosNaMosca;
    }

    public int getTotalDesistencias() {
        return totalDesistencias;
    }

    public void setTotalDesistencias(int totalDesistencias) {
        this.totalDesistencias = totalDesistencias;
    }

    public int getTotalMedalhas() {
        return totalMedalhas;
    }

    public void setTotalMedalhas(int totalMedalhas) {
        this.totalMedalhas = totalMedalhas;
    }


    public String obterCategoriaPorIdadeEsexo() {
        return obterCategoriaPorIdadeEsexo(this.getSexo(), this.getIdade());
    }

   public static String obterCategoriaPorIdadeEsexo(char sexo, Double idade) {
        if (sexo == 'F') {
            return obterCategoriaPorIdadeEsexoFeminino(idade);
        } else if (sexo == 'M') {
            return obterCategoriaPorIdadeEsexoMasculino(idade);
        } else {
            return "";
        }
    }

    private static String obterCategoriaPorIdadeEsexoFeminino(Double idade) {
        if (idade <= 16) {
            return "Cadete Feminino";
        } else if (idade <= 18) {
            return "Juvenil Feminino";
        } else if (idade >= 19 && idade <=50) {
            return "Adulto Feminino";
        } else {
            return "Master Feminino";
        }
    }

    private static String obterCategoriaPorIdadeEsexoMasculino(Double idade) {
        if (idade <= 16) {
            return "Cadete Masculino";
        } else if (idade <= 18) {
            return "Juvenil Masculino";
        } else if (idade >= 19 && idade <=50) {
            return "Adulto Masculino";
        }   
         else {
            return "Master Masculino";
        } 
    }

    
}