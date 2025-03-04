package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cuentas predefinidas
        cuentas.add(new CuentaBancaria("Juan Pérez", 1000, "123456"));
        cuentas.add(new CuentaBancaria("María García", 500, "789012"));
        cuentas.add(new CuentaBancaria("Carlos Rodríguez", 2000, "456789"));

        while (true) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    buscarYGestionarCuenta();
                    break;
                case 3:
                    listarCuentas();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Sistema de Gestión de Cuentas Bancarias");
        System.out.println("1. Crear nueva cuenta");
        System.out.println("2. Buscar y gestionar cuenta");
        System.out.println("3. Listar todas las cuentas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearCuenta() {
        System.out.print("Ingrese el nombre del titular: ");
        String titular = scanner.nextLine();

        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        int saldoInicial = scanner.nextInt();
        scanner.nextLine();

        CuentaBancaria nuevaCuenta = new CuentaBancaria(titular, saldoInicial, numeroCuenta);
        cuentas.add(nuevaCuenta);
        System.out.println("Cuenta creada exitosamente.");
    }

    private static void buscarYGestionarCuenta() {
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        CuentaBancaria cuenta = buscarCuentaPorNumero(numeroCuenta);

        if (cuenta != null) {
            while (true) {
                mostrarMenuCuenta(cuenta);
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        realizarDeposito(cuenta);
                        break;
                    case 2:
                        realizarRetiro(cuenta);
                        break;
                    case 3:
                        consultarSaldo(cuenta);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    private static CuentaBancaria buscarCuentaPorNumero(String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    private static void mostrarMenuCuenta(CuentaBancaria cuenta) {
        System.out.println("Gestión de Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void realizarDeposito(CuentaBancaria cuenta) {
        System.out.print("Ingrese el monto a depositar: ");
        int monto = scanner.nextInt();
        scanner.nextLine();
        cuenta.depositar(monto);
    }

    private static void realizarRetiro(CuentaBancaria cuenta) {
        System.out.print("Ingrese el monto a retirar: ");
        int monto = scanner.nextInt();
        scanner.nextLine();
        cuenta.retirar(monto);
    }

    private static void consultarSaldo(CuentaBancaria cuenta) {
        System.out.println("Saldo actual: " + cuenta.getSaldo());
    }

    private static void listarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
            return;
        }

        System.out.println("Cuentas Registradas");
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println(cuenta);

        }
    }
}
