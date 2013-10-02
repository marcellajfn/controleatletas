package controleatleta;

import java.util.ArrayList;

public class Arqueiro extends Atleta {

    
    private char alvo;
    private Double tamanhoArco;	
    private int distancia; //Masculino: 90, 70, 50 e  30 metros; Feminino: 70, 60, 50,30 metros.
    private char tipoFlecha;  //(M) Madeira, (A) Alumínio, (C)  Carbono
    private char tipoArco;// (T) Arco tradicional,  (R) Arco recurvo (olímpico), (C) Arco composto.
    private char modalidade;// (O) Outdoor,(I) Indoor, (F) Field, (S) Ski-archery (esqui), (C) Clout, (E) Flight.
    private ArrayList<Premiacao> premiacoes;
    private int totalVitorias;
    private int totalAcertosNaMosca;
    private int totalDesistencias;
    private int totalMedalhas;

   public Arqueiro (String nome){
   super(nome);   
   }

    public char getAlvo() {
        return alvo;
    }

    public void setAlvo(char alvo) {
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

    public char getTipoFlecha() {
        return tipoFlecha;
    }

    public void setTipoFlecha(char tipoFlecha) {
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

    public int getTotalVitorias() {
        return totalVitorias;
    }

    public void setTotalVitorias(int totalVitorias) {
        this.totalVitorias = totalVitorias;
    }
          

    public String obterCategoriaPorIdadeEsexo() {
        return obterCategoriaPorIdadeEsexo(this.getSexo(), this.getIdade());
    }

   public static String obterCategoriaPorIdadeEsexo(char sexo, int idade) {
        if (sexo == 'F') {
            return obterCategoriaPorIdadeEsexoFeminino(idade);
        } else if (sexo == 'M') {
            return obterCategoriaPorIdadeEsexoMasculino(idade);
        } else {
            return "";
        }
    }

    private static String obterCategoriaPorIdadeEsexoFeminino(int idade) {
        if (idade <= 16) {
            return "Cadete Feminino";
        } else if (idade <= 18) {
            return "Juvenil Feminino";
        } else if (idade >= 19) {
            return "Adulto Feminino";
        } else if (idade >= 50) {
            return "Master Feminino";
        } else {
            return "Invalido";
        }
    }

    private static String obterCategoriaPorIdadeEsexoMasculino(int idade) {
        if (idade <= 16) {
            return "Cadete Masculino";
        } else if (idade <= 18) {
            return "Juvenil Masculino";
        } else if (idade >= 19) {
            return "Adulto Masculino";
        } else if (idade >= 50) {
            return "Master Masculino";
        } else {
            return "Invalido";
        }
        
    }
    
    
}