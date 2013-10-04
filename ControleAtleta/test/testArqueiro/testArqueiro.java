/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testArqueiro;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import controleatleta.Arqueiro;

/**
 *
 * @author marcella
 */
public class testArqueiro {
  
    public testArqueiro() {
    }
    
    public static void setUpClass() throws Exception{
    }
    
     @After
    public void tearDownClass() throws Exception{
    }  
    
    @Test
	public void testObterCategoriaPorIdadeEsexo0(){
         assertEquals("Master Masculino", Arqueiro.obterCategoriaPorIdadeEsexo('M', 51));
	}
    
    
    
    @Test
	public void testObterCategoriaPorIdadeEsexo1() {
        assertEquals("Juvenil Feminino", Arqueiro.obterCategoriaPorIdadeEsexo('F', 18));
	}
   
    @Test
	public void testObterCategoriaPorIdadeEsexo2(){
		assertEquals("Juvenil Masculino", Arqueiro.obterCategoriaPorIdadeEsexo('M', 18));
	}
    @Test
	public void testObterCategoriaPorIdadeEsexo3(){
		assertEquals("Master Feminino", Arqueiro.obterCategoriaPorIdadeEsexo('F', 51));
	}
    
    @Test
	public void testObterCategoriaPorIdadeEsexo4(){
		assertEquals("Master Masculino", Arqueiro.obterCategoriaPorIdadeEsexo('M', 51));
	}
    @Test
	public void testObterCategoriaPorIdadeEsexo5(){
		assertEquals("Cadete Masculino", Arqueiro.obterCategoriaPorIdadeEsexo('M', 16));
	}
    @Test
	public void testObterCategoriaPorIdadeEsexo6(){
		assertEquals("Cadete Feminino", Arqueiro.obterCategoriaPorIdadeEsexo('F', 16));
	}
         public void testObterCategoriaPorIdadeEsexo7(){
		assertEquals("Adulto Masculino", Arqueiro.obterCategoriaPorIdadeEsexo('M', 19));
	}
    @Test
	public void testObterCategoriaPorIdadeEsexo8(){
		assertEquals("Adulto Feminino", Arqueiro.obterCategoriaPorIdadeEsexo('F', 19));
	}
    
}