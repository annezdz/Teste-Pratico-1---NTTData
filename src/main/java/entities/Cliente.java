package entities;

import exceptions.ContaException;
import exceptions.RecargaException;

import java.util.Objects;

public class Cliente {

    private String nome_cliente;
    private Telefone telefone;
    private Conta conta;

    public Cliente(String nome_cliente, Telefone telefone, Conta conta){
        this.nome_cliente=nome_cliente;
        this.telefone=telefone;
        this.conta=conta;
    }
    public void setNome(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }
    public String getNome() {
        return this.nome_cliente;
    }
    public void setLinha(Telefone telefone) {
        this.telefone = telefone;
    }
    public Telefone getTelefone() {
        return this.telefone;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public Conta getConta() {
        return this.conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome_cliente, cliente.nome_cliente) && Objects.equals(telefone, cliente.telefone) && Objects.equals(conta, cliente.conta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome_cliente, telefone, conta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome_cliente='" + nome_cliente + '\'' +
                ", telefone=" + telefone +
                ", conta=" + conta +
                '}';
    }

    public void efetuandoRecarga(int valorRecarga) {
            debitarRecargaDaConta(valorRecarga);
            realizarRecarga(valorRecarga);
    }


    private void debitarRecargaDaConta(int valorRecarga) {
        int saldo = conta.getSaldo();
        if(valorRecarga > 0) {
            if (valorRecarga <= conta.getSaldo()) {
                this.conta.setSaldo(saldo - valorRecarga);
            }
            else {
                throw new ContaException("Saldo Insuficiente!");
            }
        }
    }


    private void realizarRecarga(int valorRecarga) {
        int saldoTelefone = telefone.getSaldo();
        if(valorRecarga > 0) {
            this.telefone.setSaldo(saldoTelefone + valorRecarga);
        } else {
            throw new RecargaException("Valor da Recarga Inválido!");
        }
    }
}
