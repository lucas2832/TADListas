class Pilha {
    
    Celula topo;

    Pilha() {
        topo = null;
    }

    public boolean vazia() {
        return (topo == null);
    }

    public void empilhar(Celula c) {
        c.prox = topo;
        topo = c;
    }

    public boolean desempilhar() {
        if (vazia()) {
            return false;
        } else {
            Celula aux = topo;
            if (aux.prox == null) {
                topo = null;
            } else {
                topo = aux.prox;
                aux.prox = null;
            }
            // delete aux; - Não faço isso em linguagens que possuem garbage collection
            return true;
        }
    }

    public void esvaziar() {
        topo = null; // só funcina em linguagens com coleta de lixo 
    }
}