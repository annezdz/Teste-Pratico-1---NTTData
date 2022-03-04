package entities;

import java.util.Objects;

public class Telefone {

    private String numero_linha;
    private int saldo;

    public Telefone(String numero_linha, int saldo){
        this.numero_linha = numero_linha;
        this.saldo=saldo;
    }
    public void setNumeroLinha(String numero_linha) {
        this.numero_linha = numero_linha;
    }
    public String getNumeroLinha() {
        return this.numero_linha;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public int getSaldo() {
        return this.saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return saldo == telefone.saldo && Objects.equals(numero_linha, telefone.numero_linha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero_linha, saldo);
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "numero_linha='" + numero_linha + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
