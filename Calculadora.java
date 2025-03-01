import java.awt.BorderLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import javax.swing.JOptionPane;

/**
 * La Clase Calculadora simula una calculadora básica con interfaz gráfica.
 * Permite realizar operaciones aritméticas como suma, resta, multiplicación y división.
 *
 * @author Rafael Segura Orta
 * @version 1.0
 */

public class Calculadora {

    // Constantes
    final int MAX_DIGITS = 5; // Número máximo de dígitos permitidos en la pantalla.
    final int MODE_ENTRADA = 0; // Modo de entrada de dígitos.
    final int MODE_RESULTADO = 1; // Modo de visualización de resultados.

    // Variables
    int modo; // Modo actual de la calculadora (entrada o resultado).
    int digito; // Dígito actual.
    int valor1; // Primer valor para las operaciones.
    int valor2; // Segundo valor para las operaciones.
    String operacion; // Operación actual (+, -, *, /).
    boolean inicializa_resultado; // Indica si se debe inicializar el resultado.

    private static Text texto_resultado; // Campo de texto para mostrar el resultado.

    /**
     * Constructor de la clase Calculadora.
     *
     * @param gui Indica si se debe mostrar la interfaz gráfica (true) o no (false).
     */

    public Calculadora(boolean gui) {

        //Inicialización de las variables.
        inicializa();

        if (gui==true) dibujaCalculadora();// Dibuja la interfaz gráfica si gui es true.

    }
    /**
     * Dibuja la interfaz gráfica de la calculadora.
     */
    private void dibujaCalculadora() {

        Display display = Display.getDefault();
        Shell shlCalculadora = new Shell();
        shlCalculadora.setSize(259, 250);
        shlCalculadora.setText("Calculadora");

        //------------------------------------------------ -
        //Números
        //------------------------------------------------ -

        //botón con el número 0
        Button button_0 = new Button(shlCalculadora, SWT.NONE);
        button_0.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(0);
            }
        });
        button_0.setText("0");
        button_0.setBounds(23, 163, 40, 33);

        //botón con el número 1
        Button button_1 = new Button(shlCalculadora, SWT.NONE);
        button_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(1);
            }
        });
        button_1.setText("1");
        button_1.setBounds(23, 124, 40, 33);

        //botón con el número 2
        Button button_2 = new Button(shlCalculadora, SWT.NONE);
        button_2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(2);
            }
        });
        button_2.setText("2");
        button_2.setBounds(69, 124, 40, 33);

        //botón con el número 3
        Button button_3 = new Button(shlCalculadora, SWT.NONE);
        button_3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(3);
            }
        });
        button_3.setText("3");
        button_3.setBounds(115, 124, 40, 33);

        //botón con el número 4
        Button button_4 = new Button(shlCalculadora, SWT.NONE);
        button_4.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(4);
            }
        });
        button_4.setText("4");
        button_4.setBounds(23, 85, 40, 33);

        //botón con el número 5
        Button button_5 = new Button(shlCalculadora, SWT.NONE);
        button_5.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(5);
            }
        });
        button_5.setText("5");
        button_5.setBounds(69, 85, 40, 33);

        //botón con el número 6
        Button button_6 = new Button(shlCalculadora, SWT.NONE);
        button_6.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(6);
            }
        });
        button_6.setText("6");
        button_6.setBounds(115, 85, 40, 33);

        //botón con el número 7
        Button button_7 = new Button(shlCalculadora, SWT.NONE);
        button_7.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(7);
            }
        });
        button_7.setText("7");
        button_7.setBounds(23, 46, 40, 33);

        //botón con el número 8
        Button button_8 = new Button(shlCalculadora, SWT.NONE);
        button_8.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(8);
            }
        });
        button_8.setBounds(69, 46, 40, 33);
        button_8.setText("8");

        //botón con el número 9
        Button button_9 = new Button(shlCalculadora, SWT.NONE);
        button_9.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(9);
            }
        });
        button_9.setText("9");
        button_9.setBounds(115, 46, 40, 33);

        //------------------------------------------------ -
        //Operaciones
        //------------------------------------------------ -

        //botón con la operacion de división
        Button button_12 = new Button(shlCalculadora, SWT.NONE);
        button_12.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("/");
            }
        });
        button_12.setText("/");
        button_12.setBounds(178, 46, 40, 33);

        //botón con la operacion de multiplicación
        Button button_13 = new Button(shlCalculadora, SWT.NONE);
        button_13.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("*");
            }
        });
        button_13.setText("*");
        button_13.setBounds(178, 85, 40, 33);

        //botón con la operacion de suma
        Button button_14 = new Button(shlCalculadora, SWT.NONE);
        button_14.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("+");
            }
        });
        button_14.setText("+");
        button_14.setBounds(178, 124, 40, 33);

        //botón con la operacion de resto
        Button button_15 = new Button(shlCalculadora, SWT.NONE);
        button_15.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("-");
            }
        });
        button_15.setText("-");
        button_15.setBounds(178, 163, 40, 33);

        //botón con la operacion de igual
        Button button_11 = new Button(shlCalculadora, SWT.NONE);
        button_11.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarIgual();
            }
        });
        button_11.setText("=");
        button_11.setBounds(69, 163, 86, 33);

        //Texto donde se visualiza el resultado
        texto_resultado = new Text(shlCalculadora, SWT.BORDER);
        texto_resultado.setText("0");
        texto_resultado.setBounds(22, 19, 196, 21);

        shlCalculadora.open();
        shlCalculadora.layout();
        while (!shlCalculadora.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
    /**
     * Inicializa las variables de la calculadora.
     */
    public void inicializa() {
        operacion = "null";
        valor1 = 0;
        valor2 = 0;
        modo = MODE_ENTRADA;
        inicializa_resultado = true;
    }
    /**
     * Obtiene el resultado actual como una cadena de texto.
     *
     * @return El resultado actual en formato String.
     */
    public String getResultadoString (){
        return texto_resultado.getText();
    }
    /**
     * Establece el resultado actual como una cadena de texto.
     *
     * @param s La cadena de texto que se mostrará como resultado.
     */
    public void setResultadoString(String s){
        texto_resultado.setText(s);
    }
    /**
     * Obtiene el resultado actual como un entero.
     *
     * @return El resultado actual en formato int.
     */
    public int getResultadoInt() {
        String resultado = texto_resultado.getText();
        return Integer.parseInt(resultado);
    }
    /**
     * Añade un nuevo dígito al resultado actual.
     *
     * @param digito El dígito que se añadirá (0-9).
     */
    public void anadeNuevoDigito(int digito){
        if (inicializa_resultado)
            setResultadoString("");

        String inputString = getResultadoString();

        if (inputString.indexOf("0") == 0){
            inputString = inputString.substring(1);
        }

        if ((!inputString.equals("0") || digito > 0) && inputString.length() < MAX_DIGITS){
            setResultadoString(inputString + digito);
        }

        modo = MODE_ENTRADA;
        inicializa_resultado = false;
    }
    /**
     * Ejecuta una operación aritmética (+, -, *, /).
     *
     * @param new_operacion La operación a ejecutar.
     */
    public void ejecutarOperador(String new_operacion) {

        int resultado;

        if (operacion.equals("null"))
        {
            resultado = getResultadoInt();
            valor1 = resultado;
        }

        else
        {
            valor2 = getResultadoInt();
            resultado = ejecutarOperacion();
            muestraResultado(resultado);
            valor1 = resultado;
        }

        inicializa_resultado = true;
        operacion = new_operacion;
    }
    /**
     * Ejecuta la operación de igual (=).
     */
    public void ejecutarIgual(){
        int resultado = 0;

        valor2 = getResultadoInt();
        resultado = ejecutarOperacion();
        muestraResultado(resultado);

        operacion = "null";
    }
    /**
     * Ejecuta la operación aritmética actual.
     *
     * @return El resultado de la operación.
     */
    public int ejecutarOperacion() {
        int resultado = 0;

        if (operacion.equals("/"))
        {

            if (valor2 == 0)
            {
                JOptionPane.showMessageDialog(null, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                operacion = "null";
                valor1 = 0;
                modo = MODE_ENTRADA;
                inicializa_resultado = true;
            }
            else
                resultado = valor1 / valor2;
        }

        if (operacion.equals("*"))
            resultado = valor1 * valor2;

        if (operacion.equals("-"))
            resultado = valor1 - valor2;

        if (operacion.equals("+"))
            resultado = valor1 + valor2;

        return resultado;
    }
    /**
     * Muestra el resultado en la pantalla de la calculadora.
     *
     * @param resultado El resultado a mostrar.
     */
    public void muestraResultado(int resultado){
        setResultadoString(Integer.toString(resultado));
        valor1 = resultado;
        modo = MODE_RESULTADO;
        inicializa_resultado = true;
    }
    /**
     * Método principal para ejecutar la calculadora.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Calculadora calculadora = new Calculadora(true);
    }

}
