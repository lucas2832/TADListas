class ListaSE {

    Celula primeiro;

    ListaSE() {
        primeiro = null;
    }

    public boolean vazia() {
        return (primeiro == null);
    }

    public void inserirAoFinal(Celula c) {
        if (vazia()) {
            primeiro = c;
        } else {
            Celula aux = primeiro;
            while (aux.prox != null) {
                aux = aux.prox;
                aux.prox = c;
            }
        } // fim do else
    }

    public void inserirNoInicio(Celula c) {
        c.prox = primeiro;
        primeiro = c;
    }

    public void imprimir() {
        Celula aux = primeiro;
        while (aux != null) {
            System.out.println("Valor = " + aux.valor);
            aux = aux.prox;
        }
    }

    public void inserirNoMeio(Celula c) {
        Celula aux = primeiro;
        if (aux == null) {
            primeiro = c;
        } else {
            if (aux.valor > c.valor) {
                c.prox = aux;
                aux = c;
            }
            while (aux.prox != null && (aux.prox).valor < c.valor) {
                aux = aux.prox;
            }
            c.prox = aux.prox;
            aux.prox = c;
        }
    }

    public Celula pesquisar(int v) {
        if (vazia()) {
            return null;
        } else {
            Celula aux = primeiro;
            while (aux != null && aux.valor != v) {
                aux = aux.prox;
            }
            return aux;
        }
    }

    public boolean removerInicio() {
        if (vazia()) {
            return false;
        } else {
            Celula aux = primeiro;
            if (aux.prox == null) {
                primeiro = null;
            } else {
                primeiro = aux.prox;
                aux.prox = null;
            }
            // delete aux; - Não faço isso em linguagens que possuem garbage collection
            return true;
        }
    }

    /*
     * public boolean removerFinal(){
     * if(vazia()){
     * return false;
     * }
     * else{
     * Celula ant = primeiro;
     * Celula atual = primeiro.prox;
     * if(atual != null){
     * while(atual.prox != null){
     * ant = atual;
     * atual = atual.prox;
     * }
     * ant.prox = null;
     * }
     * else{
     * atual = primeiro;
     * primeiro = null;
     * }
     * //delete atual; - Não preciso disso em linguagem com garbage collection
     * return true;
     * }
     * }
     */

    public boolean removerFinal() {
        if (vazia()) {
            return false;
        } else {
            Celula aux = primeiro;
            while (aux.prox.prox != null) {
                aux = aux.prox;
            }

            aux.prox = null;
        }
        return true;
    }

    public boolean removerEspecifico(int v) {
        if (vazia()) {
            return false;
        } else {
            Celula aux = primeiro;
            if (aux.valor == v) {
                removerInicio();
                return true;
            } else {
                if (aux.prox.valor == v) {
                    aux.prox = null;
                    return true;
                } else {
                    while (aux.prox.valor != v) {
                        aux = aux.prox;
                        if (aux.prox == null) {
                            return false;
                        }
                    }
                }
            }
            aux.prox = null;
            return true;
        }
    }

    public void insercaoOrdenada(Celula c) {
        Celula aux = primeiro;
        Celula aux2 = aux.prox;
        if (vazia()) {
            primeiro = c;
        } else if (aux.prox == null && c.valor > aux.valor) {
            inserirAoFinal(c); // No caso de uma lista muito grande, não usar o método inserirAoFinal() pois percorre a lista toda novamente.
        } else if (aux.prox == null && c.valor < aux.valor) {
            inserirNoInicio(c);
        }
         else {
            while (c.valor > aux2.valor) {
                aux = aux2;
                aux2 = aux2.prox;
            }
            if(aux2.prox == null && aux2.valor < c.valor) {
                inserirAoFinal(c);
            }
            else {
                aux.prox = c;
                c.prox = aux2;
            }
        }
    }
}