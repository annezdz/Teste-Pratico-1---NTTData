# Engenheiro de Qualidade de Software - Teste Prático


## Teste Prático 1

 •  Dado que um cliente deseja realizar uma recarga de celular pela a sua instituição financeira. Implemente
uma função que permita que o cliente realize uma recarga em sua linha onde o débito ocorrerá de sua conta
corrente. Considerando testes negativos e positivos, implemente um teste unitário para as funções de
recarga de saldo e para o saldo atual da linha. Utilize as classes abaixo para o desenvolvimento do
programa.

## Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando-se as seguintes tecnologias:

- Java 11
- Maven 4.0.0
- Junit 5


## Classes:

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
}

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
}

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
}

