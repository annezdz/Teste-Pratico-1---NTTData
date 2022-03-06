package entities;

import exceptions.ContaException;
import exceptions.RecargaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRecarga {

    private Cliente cliente;
    private int valorRecarga;

    @BeforeEach
    public void init() {

        cliente = new Cliente("Clara Emanuelly Pereira",
                new Telefone("(66) 97553-3613",10),new Conta(20));
        valorRecarga = 10;
    }

    @DisplayName("Valor da recarga debitado da Conta com sucesso")
    @Test
    public void deveriaDebitarRecargaDaConta() {

        int saldoAnterior = cliente.getConta().getSaldo();
        cliente.recarregarCelular(valorRecarga);
        int saldoAtual = cliente.getConta().getSaldo();
        assertEquals(saldoAnterior - valorRecarga ,saldoAtual);
    }

    @DisplayName("Valor da recarga acrescido no saldo atual do telefone com sucesso")
    @Test
    public void deveriaCreditarValorRecargaNoTelefone() {

        int saldoTelefoneAnteriorRecarga = cliente.getTelefone().getSaldo();
        cliente.recarregarCelular(valorRecarga);
        int saldoTelefonePosteriorRecarga = cliente.getTelefone().getSaldo();
        assertEquals(saldoTelefoneAnteriorRecarga + valorRecarga, saldoTelefonePosteriorRecarga);
    }

    @DisplayName("Valor da recarga não debitado da Conta")
    @Test
    public void naoDeveriaDebitarRecargaDaConta() {

        this.cliente.getConta().setSaldo(1);
        int saldoAtualConta = cliente.getConta().getSaldo();

        ContaException thrown = assertThrows(ContaException.class, () ->
                cliente.recarregarCelular(valorRecarga));
        int saldoAposTentativaRecarga = cliente.getConta().getSaldo();
        assertEquals("Saldo Insuficiente!",thrown.getMessage());
        assertEquals(saldoAtualConta, saldoAposTentativaRecarga);
    }

    @DisplayName("Valor da recarga não acrescido no saldo do telefone")
    @Test
    public void nãoDeveriaCreditarValorRecargaNoTelefone() {

        int saldoTelefoneAnteriorRecarga = cliente.getTelefone().getSaldo();
        valorRecarga = -1;
        RecargaException thrown = assertThrows(RecargaException.class, () ->
                cliente.recarregarCelular(valorRecarga));
        assertEquals("Valor da Recarga Inválido!",thrown.getMessage());
        assertEquals(saldoTelefoneAnteriorRecarga,cliente.getTelefone().getSaldo());
    }

    @DisplayName("Testando RecargaException")
    @Test
    public void testRecargaException() {

        valorRecarga = -1;
        assertThrows(RecargaException.class, () -> cliente.recarregarCelular(valorRecarga));
    }

    @DisplayName("Testando ContaException")
    @Test
    public void testContaException() {

        this.cliente.getConta().setSaldo(1);
        assertThrows(ContaException.class, () -> cliente.recarregarCelular(valorRecarga));
    }
}
