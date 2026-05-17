public class BST {
    private Nodo raiz;

    public BST() {
        this.raiz = null;
    }

    // --- INSERCIÓN ---
    public void insert(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izq = insertarRec(actual.izq, valor);
        } else if (valor > actual.valor) {
            actual.der = insertarRec(actual.der, valor);
        }
        return actual;
    }

    // --- BÚSQUEDA ---
    public boolean search(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo actual, int valor) {
        if (actual == null) return false;
        if (actual.valor == valor) return true;
        
        return valor < actual.valor 
            ? buscarRec(actual.izq, valor) 
            : buscarRec(actual.der, valor);
    }

    // --- ELIMINACIÓN (Los 3 Casos Críticos) ---
    public void delete(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo actual, int valor) {
        if (actual == null) return null;

        if (valor < actual.valor) {
            actual.izq = eliminarRec(actual.izq, valor);
        } else if (valor > actual.valor) {
            actual.der = eliminarRec(actual.der, valor);
        } else {
            // Nodo encontrado: Resolver los 3 Casos

            // Caso 1: Nodo sin hijos (Hoja)
            if (actual.izq == null && actual.der == null) {
                return null;
            }

            // Caso 2: Nodo con un solo hijo
            if (actual.izq == null) return actual.der;
            if (actual.der == null) return actual.izq;

            // Caso 3: Nodo con dos hijos
            // Se busca el sucesor en orden (el valor más pequeño del subárbol derecho)
            int sucesorValor = encontrarMinimo(actual.der);
            actual.valor = sucesorValor; // Reemplazar valor
            actual.der = eliminarRec(actual.der, sucesorValor); // Eliminar el sucesor duplicado
        }
        return actual;
    }

    private int encontrarMinimo(Nodo actual) {
        int min = actual.valor;
        while (actual.izq != null) {
            min = actual.izq.valor;
            actual = actual.izq;
        }
        return min;
    }

    // --- RECORRIDOS DE IMPRESIÓN ---
    public void recorridoInOrder() {
        inOrderRec(raiz);
        System.out.println();
    }
    private void inOrderRec(Nodo actual) {
        if (actual != null) {
            inOrderRec(actual.izq);
            System.out.print(actual.valor + " ");
            inOrderRec(actual.der);
        }
    }

    public void recorridoPreOrder() {
        preOrderRec(raiz);
        System.out.println();
    }
    private void preOrderRec(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.valor + " ");
            preOrderRec(actual.izq);
            preOrderRec(actual.der);
        }
    }

    public void recorridoPostOrder() {
        postOrderRec(raiz);
        System.out.println();
    }
    private void postOrderRec(Nodo actual) {
        if (actual != null) {
            postOrderRec(actual.izq);
            postOrderRec(actual.der);
            System.out.print(actual.valor + " ");
        }
    }

    // --- MÉTODO PRINCIPAL PARA PRUEBA EN VIVO (Para tu Video) ---
    public static void main(String[] args) {
        BST arbol = new BST();

        System.out.println("--- PRUEBA DE INSERCIÓN (5 VALORES) ---");
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);

        System.out.print("Recorrido In-Order actual: ");
        arbol.recorridoInOrder();

        System.out.println("\n--- PRUEBA DE BÚSQUEDA ---");
        System.out.println("¿Existe el 40?: " + arbol.search(40));
        System.out.println("¿Existe el 90?: " + arbol.search(90));

        System.out.println("\n--- PRUEBA DE ELIMINACIÓN ---");
        System.out.println("Eliminando nodo 20 (Caso 1: Hoja)...");
        arbol.delete(20);
        
        System.out.println("Eliminando nodo 30 (Caso 3: Dos Hijos)...");
        arbol.delete(30);

        System.out.print("\nRecorrido In-Order final: ");
        arbol.recorridoInOrder();
        System.out.print("Recorrido Pre-Order final: ");
        arbol.recorridoPreOrder();
        System.out.print("Recorrido Post-Order final: ");
        arbol.recorridoPostOrder();
    }
}
