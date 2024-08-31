public class ListaDE {

    CelulaD primeiro;

    ListaDE(){
        primeiro = null;
    }

    public boolean vazia() {
        return(primeiro == null);
    }

    public void inserirAoFinal(CelulaD c) {
        if(vazia()) {
            primeiro = c;
        } else {
            CelulaD aux = primeiro;
            
            while(aux.prox != null) {
                aux = aux.prox;
            }

            aux.prox = c;
            c.ant = aux;
        }
    }

    public void inserirNoInicio(CelulaD c) {
        if(vazia()) {
            c.prox = primeiro;
        }

        primeiro = c;
    }

    public CelulaD pesquisar(int v) {
        if(vazia()) {
            return null;
        }else {
            CelulaD aux = primeiro;

            while(aux != null && aux.valor != v) {
                aux = aux.prox;
            }

            return aux;
        }
    }

    public boolean removerInicio() {
        if(vazia()) {
            return false;
        } else {
            CelulaD aux = primeiro;
            
            if(aux.prox == null) {
                primeiro = null;
            } else {
                primeiro = aux.prox;
                aux.prox = null;
                primeiro.ant = null;
            }
        }
        return true;
    }

    public boolean Removerfinal() {
        if(vazia()) {
            return false;
        } else {
            CelulaD aux = primeiro;
            
            while(aux.prox != null) {
                aux = aux.prox;
            }
            
            if(aux.ant != null) {
                (aux.ant).prox = null;
            }
            aux.ant = null;
            return true;
        }
    }
}
