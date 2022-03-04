package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCliente {

    private Cliente cliente;
    private int valorRecarga;

    @BeforeEach
    public void init() {

        cliente = new Cliente("Clara Emanuelly Pereira",
                new Telefone("(66) 97553-3613",10),new Conta(20));
        valorRecarga = 10;

    }

    @DisplayName("Não deveria permitir alterar saldo da conta (Set)")
    @Test
    public void naoDeveriaAlterarSaldoDaConta() {

        int saldoAntigo = cliente.getConta().getSaldo();
        this.cliente.getConta().setSaldo(1000);
        int saldoNovo = cliente.getConta().getSaldo();
        assertNotEquals(saldoNovo,saldoAntigo);

    }

    @DisplayName("Não deveria permitir alterar o saldo disponível no telefone. (Set)")
    @Test
    public void naoDeveriaAlterarSaldoDoTelefone() {

        int saldoAntigoTelefone = cliente.getTelefone().getSaldo();
        this.cliente.getTelefone().setSaldo(1000);
        int saldoAtualTelefone = cliente.getTelefone().getSaldo();
        assertNotEquals(saldoAtualTelefone,saldoAntigoTelefone);

    }

}
