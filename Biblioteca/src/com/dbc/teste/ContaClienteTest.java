package com.dbc.teste;

import com.dbc.*;
import com.dbc.model.ContaCliente;
import com.dbc.model.StatusCliente;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContaClienteTest {
    private ContaCliente joaoVitor = new ContaCliente(5, "Joao Vitor", "5555", "555", StatusCliente.OK);

    @Test
    public void deveriaConseguirAdicionarConta() {
        List<ContaCliente> listaClientes = new ArrayList<>();
        listaClientes.add(joaoVitor);
        assertTrue(listaClientes.contains(joaoVitor));
    }

    @Test
    public void deveriaConseguirEditarNome(){
        joaoVitor.setNome("João");
        assertEquals(joaoVitor.getNome(), "João");
    }

}
