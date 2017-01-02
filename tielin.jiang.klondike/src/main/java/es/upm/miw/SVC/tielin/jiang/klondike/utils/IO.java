package es.upm.miw.SVC.tielin.jiang.klondike.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IO {

    private static IO io;

    public static IO instance() {
        if (io == null) {
            io = new IO();
        }
        return io;
    }

    private IO() {

    }

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            this.write(title);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                this.writeError("de cadena de caracteres");
            }
        } while (!ok);
        return input;
    }

    public int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readString(title));
                ok = true;
            } catch (Exception ex) {
                this.writeError("entero");
            }
        } while (!ok);
        return input;
    }

    public void writeln() {
        System.out.println();
    }

    public void write(String string) {
        System.out.print(string);
    }

    public void writeln(String string) {
        System.out.println(string);
    }

    private void writeError(String formato) {
        System.out.println("ERROR DE FORMATO! " + "Introduzca un valor con formato " + formato + ".");
    }
}
