package org.example;

public class CuentaBancaria {

    private String titular;
    private int saldo = 0;
    private String numeroCuenta;

    public CuentaBancaria(){
    }

    public CuentaBancaria(String titular, int saldo, String numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void depositar(int cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito de " + cantidad + " realizado con éxito.");
        } else {
            System.out.println("El monto del depósito debe ser positivo.");
        }
    }

    public void retirar(int cantidad) {
        if (cantidad > 0) {
            if (saldo >= cantidad) {
                saldo -= cantidad;
                System.out.println("Retiro de " + cantidad + " realizado con éxito.");
            } else {
                System.out.println("Saldo insuficiente para realizar el retiro.");
            }
        } else {
            System.out.println("El monto del retiro debe ser positivo.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta Bancaria{" +
                "Titular='" + titular + '\'' +
                ", Número de Cuenta='" + numeroCuenta + '\'' +
                ", Saldo=" + saldo +
                '}';
    }
}