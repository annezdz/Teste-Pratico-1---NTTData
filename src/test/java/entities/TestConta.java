package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestConta {

    private Conta conta;

    @BeforeEach
    public void init() {

        conta = new Conta(10);
    }

    @DisplayName("Não deveria permitir alterar saldo da conta (Set)")
    @Test
    public void naoDeveriaAlterarSaldoDaConta() {

        int saldoAntigo = conta.getSaldo();
        this.conta.setSaldo(1000);
        int saldoNovo = conta.getSaldo();
        assertNotEquals(saldoNovo,saldoAntigo);
    }
}
