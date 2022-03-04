package entities;

import java.util.Objects;

public class Conta {

    private int saldo;
    private int vl_recarga;

    public Conta(int saldo){
        this.saldo = saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public int getSaldo() {
        return this.saldo;
    }
    public void setRecarga(int vl_recarga) {
        this.vl_recarga = vl_recarga;
    }
    public int getRecarga() {
        return this.vl_recarga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return saldo == conta.saldo && vl_recarga == conta.vl_recarga;
    }

    @Override
    public int hashCode() {
        return Objects.hash(saldo, vl_recarga);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", vl_recarga=" + vl_recarga +
                '}';
    }
}
