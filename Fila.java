public class Fila {
    
    Celula frente;
    Celula tras;

    public Fila() {
        frente = new Celula(-1);
        tras = frente;
    }

    public boolean vazia() {
        return(frente == tras);
    }

    public void enfileirar(Celula elemento) {
        this.tras.prox = elemento;
        this.tras = this.tras.prox;
        this.tras.prox = null;
    }

    public Celula desenfileirar() throws Exception {
        Celula item = null;
        if(this.vazia()) {
            throw new Exception ("Erro: A fila está vazia.");
        }

        item = this.frente.prox;
        frente.prox = item.prox;
        item.prox = null;
        if(tras == item) {
            tras = frente;
        }

        return item;
    }

    public void exibir() {
        if(vazia()) {
            System.out.println("\nNão há elementos na fila.");
        } else {
            Celula aux = frente.prox;
            while (aux != null) {
                System.out.println("\n\relemento = " +aux.valor);
            }
        }
    }
}
