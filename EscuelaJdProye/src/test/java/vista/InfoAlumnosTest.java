package vista;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InfoAlumnosTest {

    InfoAlumnos info = new InfoAlumnos();

    @Test
    public void testCalcularPromedio() {
        info.ejecutarInfoAlumno(14);
        double resultadoEsperado, resultadoObtenido;
        resultadoEsperado = 4.9;
        resultadoObtenido = info.calcularPromedio();
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void testEstadoNotas() {
        info.ejecutarInfoAlumno(14);
        info.estadoNota();
        String resultadoObtenido = info.getLblAprobado().getText();
        String resultadoEsperado = "Reprobado";
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }
}
