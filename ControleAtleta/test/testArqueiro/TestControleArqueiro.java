/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testArqueiro;

import controleatleta.Arqueiro;
import controleatleta.ControleArqueiro;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestControleArqueiro {

    ControleArqueiro controleArqueiro;
    Arqueiro arqueiro;

    @Before
    public void setUp() {
        arqueiro = new Arqueiro("Robin Hood");
        controleArqueiro = new ControleArqueiro();
    }

    @Test
    public void testaGetListArqueiros() {
        assertNotNull(controleArqueiro.getListaArqueiros());
    }

    @Test
    public void testaPesquisaArqueiros() {
        controleArqueiro.adicionar(arqueiro);

        assertEquals(arqueiro, controleArqueiro.pesquisar("Robin Hood"));

        assertNull(controleArqueiro.pesquisar("Oliver Queen"));


    }

    @Test
    public void testaPesquisaArqueiros2() {
        controleArqueiro.remover(arqueiro);

        assertNull(controleArqueiro.pesquisar("Robin Hood"));


    }
}
