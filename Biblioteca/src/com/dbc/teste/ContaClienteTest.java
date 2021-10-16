package com.dbc.teste;

import com.dbc.ContaCLientePremium;
import com.dbc.ContaCliente;
import com.dbc.ContaClienteComum;
import com.dbc.StatusCliente;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContaClienteTest {
    ContaClienteComum joaoVitor = new ContaClienteComum();
    ContaClienteComum joaoPedro = new ContaClienteComum();
    ContaCLientePremium luizFelipe = new ContaCLientePremium();
    ContaCLientePremium luizGuilherme = new ContaCLientePremium();


    @Test
    public void editarIdContaClienteDeveriaFuncionarERetornarIdCorreto() {
        joaoVitor.setIdCliente(1);

        boolean editar = joaoVitor.editarId(33);

        assertTrue(editar);
        assertEquals(joaoVitor.getIdCliente(),33,0);
    }

    @Test
    public void deveriaPoderAlugarCasoStatusSejaOK() {
        joaoVitor.setStatus(StatusCliente.OK);

        boolean verifica = joaoVitor.podeAlugar(joaoVitor.getStatus());

        assertTrue(verifica);
    }

    @Test
    public void deveriaConseguirAdicionarContaComum() {
        List<ContaClienteComum> listaClientesComum = new ArrayList<>();
        listaClientesComum.add(joaoVitor);
        assertTrue(listaClientesComum.contains(joaoVitor));
    }

    @Test
    public void editarTelefoneDeveriaFuncionarERetornarTelefoneCorreto() {
        luizFelipe.setTelefone("132");

        luizFelipe.editarTelefone(luizFelipe,"9990");

        assertEquals(luizFelipe.getTelefone(), "9990");
    }



}
