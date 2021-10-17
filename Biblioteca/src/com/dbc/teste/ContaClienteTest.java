package com.dbc.teste;

import com.dbc.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContaClienteTest {
    private ContaClienteComum joaoVitor = new ContaClienteComum(5, "Joao Vitor", "5555", "555", StatusCliente.OK);
    private ContaClienteComum joaoPedro = new ContaClienteComum(65, "Joao Pedro", "5555", "555", StatusCliente.OK);
    private ContaClientePremium luizFelipe = new ContaClientePremium(9, "Luiz Felipe", "5555", "555", StatusCliente.OK);
    private ContaClientePremium luizGuilherme = new ContaClientePremium(53, "Luiz Guilherme", "5555", "555", StatusCliente.OK);
    private ContaClienteComum contaComum = new ContaClienteComum();
    private ContaClientePremium contaPremium = new ContaClientePremium();



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

    @Test
    public void deveriaListarContasComunsCorretamente() {
        contaComum.adicionarContaComum(joaoPedro);
        var retornoConta = contaComum.listarContasComum().get(0);
        assertEquals(joaoPedro, retornoConta);
    }

    @Test
    public void deveriaListarContasPremiumCorretamente() {
        contaPremium.adicionarContaNaListaPremium(luizFelipe);
        assertEquals(luizFelipe, contaPremium.listarContasPremium().get(0));
    }

    @Test
    public void deveriaRemoverContaComum() {
        contaComum.adicionarContaComum(joaoPedro);
        assertTrue(contaComum.removerContaComum(0));
    }

    @Test
    public void deveriaRemoverContaPremium() {
        contaPremium.adicionarContaNaListaPremium(luizFelipe);
        assertTrue(contaPremium.removerContaPremium(0));
    }

    @Test
    public void deveriaEditarContaComum() {
        contaComum.adicionarContaComum(joaoPedro);
        joaoPedro.setEmail("correio.com");
        var contaEditada = contaComum.editarContaComum(0, joaoPedro);
        var emailEditado = contaEditada.getEmail();
        assertEquals("correio.com", emailEditado);
    }

    @Test
    public void deveriaEditarContaPremium() {
        contaPremium.adicionarContaNaListaPremium(luizFelipe);
        Integer novoId = 6;
        luizFelipe.setIdCliente(novoId);
        var contaEditada = contaPremium.editarContaPremium(0, luizFelipe);
        var idEditado = contaEditada.getIdCliente();
        assertEquals(novoId, idEditado);
    }
}
