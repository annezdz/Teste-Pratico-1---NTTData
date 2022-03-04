package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTelefone {

    private Telefone telefone;

    @BeforeEach
    public void init() {

        telefone = new Telefone("(66) 97553-3613",10);

    }

    @DisplayName("Não deveria permitir alterar o saldo disponível no telefone. (Set)")
    @Test
    public void naoDeveriaAlterarSaldoDoTelefone() {
        int saldoAntigoTelefone = telefone.getSaldo();
        this.telefone.setSaldo(1000);
        int saldoAtualTelefone = telefone.getSaldo();
        assertNotEquals(saldoAtualTelefone,saldoAntigoTelefone);
    }
}
