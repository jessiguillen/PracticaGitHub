package practicagithub;

public class PracticaGitHub {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        System.out.println("Base de datos original");
        con.mostrar();
        con.insertar("Juana", 23, "DSM-104");
        con.insertar("Pablo", 19, "DSM-104");
        System.out.println("Base de datos con inserciones");
        con.mostrar();
        con.actualizar("Juana", "Juana", 23, 24, "DSM-104", "DSM-204");
        System.out.println("Base de datos con actualizacion");
        con.mostrar();
        con.eliminar("Pablo");
        System.out.println("Base de datod con eliminacion");
        con.mostrar();
    }
    
}
