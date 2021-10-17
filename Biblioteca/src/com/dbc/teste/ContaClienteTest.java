package com.dbc.teste;

import com.dbc.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContaClienteTest {
    private ContaClienteComum joaoVitor = new ContaClienteComum(5, "joao vitor", "5555", "555", StatusCliente.OK);
    private ContaClienteComum joaoPedro = new ContaClienteComum(65, "joao pedro", "5555", "555", StatusCliente.OK);
    private ContaCLientePremium luizFelipe = new ContaCLientePremium(9, "aaa", "5555", "555", StatusCliente.OK);
    private ContaCLientePremium luizGuilherme = new ContaCLientePremium(53, "aaa", "5555", "555", StatusCliente.OK);
    private Contas contas = new Contas();



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
        //joaoVitor.setNome("a");
        assertTrue(listaClientesComum.contains(joaoVitor));
        joaoVitor.imprimirContaComum();
        System.out.println(listaClientesComum);
        System.out.println(joaoVitor.getNome());
    }

    @Test
    public void editarTelefoneDeveriaFuncionarERetornarTelefoneCorreto() {
        luizFelipe.setTelefone("132");
        luizFelipe.editarTelefone(luizFelipe,"9990");
        assertEquals(luizFelipe.getTelefone(), "9990");
    }

    @Test
    public void deveriaListarContasComunsCorretamente() {
        contas.adicionarContaComum(joaoPedro);
        var retornoConta = contas.listarContasComum().get(0);
        assertEquals(joaoPedro, retornoConta);
    }

    @Test
    public void deveriaListarContasPremiumCorretamente() {
        contas.adicionarContaNaListaPremium(luizFelipe);
        assertEquals(luizFelipe, contas.listarContasPremium().get(0));
    }

    @Test
    public void deveriaRemoverContaComum() {
        contas.adicionarContaComum(joaoPedro);
        assertTrue(contas.removerContaComum(0));
    }

    @Test
    public void deveriaRemoverContaPremium() {
        contas.adicionarContaNaListaPremium(luizFelipe);
        assertTrue(contas.removerContaPremium(0));
    }

    @Test
    public void deveriaEditarContaComum() {
        contas.adicionarContaComum(joaoPedro);
        joaoPedro.setEmail("correio.com");
        var contaEditada = contas.editarContaComum(0, joaoPedro);
        var emailEditado = contaEditada.getEmail();
        assertEquals("correio.com", emailEditado);
    }

    @Test
    public void deveriaEditarContaPremium() {
        contas.adicionarContaNaListaPremium(luizFelipe);
        Integer novoId = 6;
        luizFelipe.setIdCliente(novoId);
        var contaEditada = contas.editarContaPremium(0, luizFelipe);
        var idEditado = contaEditada.getIdCliente();
        assertEquals(novoId, idEditado);
    }
}
