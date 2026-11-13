package Tema5;

import java.util.Scanner;

public class GeneradorDeCURP {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        String nombre, paterno, materno, fecha, estado, curp;
        char sexo;

        System.out.println("-------- GENERADOR DE CURP --------");
        System.out.println("Escribe todo en MAYUSCULAS y sin acentos");

        System.out.print("Nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Apellido paterno: ");
        paterno = scanner.nextLine();

        System.out.print("Apellido materno: ");
        materno = scanner.nextLine();

        do {
            System.out.print("Fecha de nacimiento (dd/mm/aaaa, ejemplo 01/02/1999): ");
            fecha = scanner.nextLine();
            if (fecha.length() != 10) {
                System.out.println("Fecha incorrecta, usa el formato dd/mm/aaaa");
            }
        } while (fecha.length() != 10);

        do {
            System.out.print("Sexo (H/M): ");
            sexo = scanner.nextLine().charAt(0);
            if (sexo != 'H' && sexo != 'M') {
                System.out.println("Opcion invalida, escribe H o M");
            }
        } while (sexo != 'H' && sexo != 'M');

        System.out.print("Entidad federativa de nacimiento: ");
        estado = scanner.nextLine();

        curp = generarCURP(nombre, paterno, materno, fecha, sexo, estado);

        System.out.println("Tu CURP es: " + curp);
    }

    public static boolean esVocal(char letra) {
        if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public static char obtenerPrimeraLetra(String palabra) {
        return palabra.charAt(0);
    }

    public static char obtenerPrimeraVocal(String palabra) {
        int i;
        char letra;

        for (i = 1; i < palabra.length(); i++) {
            letra = palabra.charAt(i);
            if (esVocal(letra)) {
                return letra;
            }
        }
        return 'X';
    }

    public static char obtenerPrimeraConsonante(String palabra) {
        int i;
        char letra;

        for (i = 1; i < palabra.length(); i++) {
            letra = palabra.charAt(i);
            if (!esVocal(letra) && letra != ' ') {
                return letra;
            }
        }
        return 'X';
    }

    public static String obtenerFecha(String fecha) {
        String dia, mes, anio;

        dia = fecha.substring(0, 2);
        mes = fecha.substring(3, 5);
        anio = fecha.substring(8, 10);

        return anio + mes + dia;
    }

    public static String obtenerClaveEstado(String estado) {
        String clave;

        switch (estado) {
            case "AGUASCALIENTES":
                clave = "AS";
                break;
            case "BAJA CALIFORNIA":
                clave = "BC";
                break;
            case "BAJA CALIFORNIA SUR":
                clave = "BS";
                break;
            case "CAMPECHE":
                clave = "CC";
                break;
            case "CHIAPAS":
                clave = "CS";
                break;
            case "CHIHUAHUA":
                clave = "CH";
                break;
            case "CIUDAD DE MEXICO":
                clave = "DF";
                break;
            case "COAHUILA":
                clave = "CL";
                break;
            case "COLIMA":
                clave = "CM";
                break;
            case "DURANGO":
                clave = "DG";
                break;
            case "GUANAJUATO":
                clave = "GT";
                break;
            case "GUERRERO":
                clave = "GR";
                break;
            case "HIDALGO":
                clave = "HG";
                break;
            case "JALISCO":
                clave = "JC";
                break;
            case "MEXICO":
                clave = "MC";
                break;
            case "MICHOACAN":
                clave = "MN";
                break;
            case "MORELOS":
                clave = "MS";
                break;
            case "NAYARIT":
                clave = "NT";
                break;
            case "NUEVO LEON":
                clave = "NL";
                break;
            case "OAXACA":
                clave = "OC";
                break;
            case "PUEBLA":
                clave = "PL";
                break;
            case "QUERETARO":
                clave = "QT";
                break;
            case "QUINTANA ROO":
                clave = "QR";
                break;
            case "SAN LUIS POTOSI":
                clave = "SP";
                break;
            case "SINALOA":
                clave = "SL";
                break;
            case "SONORA":
                clave = "SR";
                break;
            case "TABASCO":
                clave = "TC";
                break;
            case "TAMAULIPAS":
                clave = "TS";
                break;
            case "TLAXCALA":
                clave = "TL";
                break;
            case "VERACRUZ":
                clave = "VZ";
                break;
            case "YUCATAN":
                clave = "YN";
                break;
            case "ZACATECAS":
                clave = "ZS";
                break;
            default:
                clave = "NE";
        }
        return clave;
    }

    public static String generarCURP(String nombre, String paterno, String materno,
                                     String fecha, char sexo, String estado) {
        String curp;
        int campo1, campo2;

        campo1 = (paterno.length() + materno.length()) % 10;
        campo2 = (nombre.length() + materno.length()) % 10;

        curp = "";
        curp = curp + obtenerPrimeraLetra(paterno);
        curp = curp + obtenerPrimeraVocal(paterno);
        curp = curp + obtenerPrimeraLetra(materno);
        curp = curp + obtenerPrimeraLetra(nombre);
        curp = curp + obtenerFecha(fecha);
        curp = curp + sexo;
        curp = curp + obtenerClaveEstado(estado);
        curp = curp + obtenerPrimeraConsonante(paterno);
        curp = curp + obtenerPrimeraConsonante(materno);
        curp = curp + obtenerPrimeraConsonante(nombre);
        curp = curp + campo1 + campo2;

        return curp;

    }
}
