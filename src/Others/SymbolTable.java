package Others;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import Others.ThrowingErrorListener;

import java.util.LinkedList;

public class SymbolTable {
        private LinkedList<Ident> tabla;
        private int nivelActual;

        public class Ident{
            int nivel;
            Token tok;
            int type; //forma simple de identificar un tipo del lenguaje [0--> Entero] NO ES TAN CECESARIO EN ESTE LENGUAJE ALPHA PUESTO QUE SOLO ACEPTA NUMEROS
            ParserRuleContext decl; //por si fuera necesario saber más acerca del contexto del identificador en el árbol
            String value;

            public Ident(int n, Token t, int ty, ParserRuleContext d,String v) {
                nivel = n;
                tok = t;
                type = ty;
                decl = d;
                value = v;
            }

            public int getNivel() {
                return nivel;
            }

            public Token getTok() {
                return tok;
            }

            public int getType() {
                return type;
            }

            public ParserRuleContext getDecl() {
                return decl;
            }

            public String toString(){
                return this.tok.getText() + "," + this.nivel;
            }
        }

        public SymbolTable()
        {
            this.nivelActual = -1;
            this.tabla = new LinkedList<Ident>();
        }

        public Ident insertar(String nombre, int tipo, ParserRuleContext declaracion, String v)
        {
            Token token = new CommonToken(0,nombre);
            Ident i = new Ident(nivelActual,token,tipo,declaracion,v);
            int j = 0;
            while (j < this.tabla.size() && this.tabla.get(j).nivel == nivelActual) {
                if (this.tabla.get(j).tok.getText().equals(nombre)) {
                    String error = "El identificador \"" + nombre + "\" ya ha sido declarado.";
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    //System.out.println("El identificador \"" + nombre + "\" ya ha sido declarado.");
                    return null;
                }
                j++;
            }
            this.tabla.push(i); //deben ser una tabla estilo pila
            return this.tabla.get(0);
        }

        public Ident insertar(Token token, int tipo, ParserRuleContext declaracion, String v)
        {
            Ident i = new Ident(nivelActual,token,tipo,declaracion, v);
            int j = 0;
            while (j < this.tabla.size() && this.tabla.get(j).nivel == nivelActual) {
                if (this.tabla.get(j).tok.getText().equals(token.getText())) {
                    //System.out.println("El identificador \"" + token.getText() + "\" ya ha sido declarado. Line " + token.getLine() + ":" + token.getCharPositionInLine());
                    String error = "El identificador \"" + token.getText() + "\" ya ha sido declarado.";
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    return null;
                }
                j++;
            }
            tabla.push(i); //deben ser una tabla estilo pila
            return this.tabla.get(0);

        }

        public void openScope(){
            this.nivelActual++;
        }

        public void closeScope(){
            Ident element = this.tabla.get(0);
            while (element != null && element.nivel == nivelActual){
                tabla.pop();
                if(!this.tabla.isEmpty())
                    element = this.tabla.get(0);
                else
                    element= null;
            }
            this.nivelActual--;
        }

        public int buscar(String nombre)
        {
            for(Ident id : this.tabla)
            {
                if (id.tok.getText().equals(nombre)) {
                    return id.getType();
                }
            }
            return -1;
        }

        public void imprimir() {
            System.out.println("****** ESTADO DE TABLA DE SÍMBOLOS ******");
            if (!this.tabla.isEmpty()) {
                for (Ident i : this.tabla) {
                    /*String nivel = "";
                    for (int j = 0; j < i.nivel; j++) {
                        nivel += "\t";
                    }*/
                    System.out.println(/*nivel + */"Nombre: " + i.tok.getText() + " -> Nivel: " + i.nivel + " -> Tipo: " +i.type + " -> Valor: "+ i.value);
                }
                System.out.println("------------------------------------------");
            }
            else
                System.out.println("Tabla vacía");
        }

        public LinkedList<Ident> getTabla() {
            return this.tabla;
        }

}
