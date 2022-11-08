package LULA_Sistema;

public class Main {
    public static void main(String[] args) {
        LULASistema sistema = new LULASistema();
        sistema.cadastraLocal("CAA", "Central de Aulas", "1122");
        System.out.println(sistema.testaGetIdent());
        System.out.println(sistema.exibeLocal("CAA"));
    }
}
