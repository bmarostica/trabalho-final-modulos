package com.dbc.teste;

import com.dbc.ContaCLientePremium;
import com.dbc.ContaCliente;
import com.dbc.ContaClienteComum;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContaClienteTest {
    ContaClienteComum joaoVitor = new ContaClienteComum();
    ContaCLientePremium luizFelipe = new ContaCLientePremium();


    @Test
    public void editarIdContaClienteDeveriaFuncionarERetornarIdCorreto() {
        joaoVitor.setIdCliente(1);

        boolean editar = joaoVitor.editarId(33);

        assertTrue(editar);
        assertEquals(joaoVitor.getIdCliente(),33,0);
    }



}
