package controleatleta;

import java.util.ArrayList;

public class ControleArqueiro {

    private ArrayList<Arqueiro> listaArqueiros;

    public ControleArqueiro() {
        this.listaArqueiros = new ArrayList<Arqueiro>();
    }
    
    public ArrayList<Arqueiro> getListaArqueiroes() {
        return listaArqueiros;
    }
    
    public void adicionar(Arqueiro umArqueiro) {
        listaArqueiros.add(umArqueiro);
    }
    
    public void remover(Arqueiro umArqueiro) {
        listaArqueiros.remove(umArqueiro);
    }
    
    public Arqueiro pesquisar(String nome) {
        for (Arqueiro b: listaArqueiros) {
            if (b.getNome().equalsIgnoreCase(nome)) {
                return b;
            }
        }
        return null;
    }

    ArrayList<Arqueiro> getListaArqueiros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
