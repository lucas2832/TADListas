public class ListaSEC {
    
    Celula cabeca;

    ListaSEC(){ //Construtor
        cabeca = new Celula(-1);
        cabeca.prox = cabeca;
        }
        
        public boolean vazia(){
        return (cabeca.prox== cabeca);
    }

    public void inserirAoFinal(Celula c){
        if(vazia()){ cabeca.prox = c; c.prox = cabeca; }
        else{
        Celula aux = cabeca.prox;
        while(aux.prox != cabeca) { aux = aux.prox; }
        aux.prox = c;
        c.prox = cabeca;
        }//fim do else
        }
        void inserirNoInicio(Celula c){
        Celula aux = cabeca.prox;
        cabeca.prox = c;
        c.prox = aux;
    }

    public Celula pesquisar(int v){
        if(vazia()) return null;
        else{
        Celula aux = cabeca.prox;
        while(aux != cabeca && aux.valor != v)
        {
        aux = aux.prox;
        }
        if(aux == cabeca) return null;
        return aux;
        }
    }

    public boolean removerInicio(){
        if(vazia()){ return false; }
        else{
        Celula aux = cabeca.prox;
        cabeca.prox = aux.prox;
        aux.prox = null;
        //delete aux; Precisamos?
        return true;
        }
    }

    public boolean removerFinal(){
        if(vazia()){ return false; }
        else{
        Celula aux = cabeca.prox;
        if(aux.prox != cabeca){
        while( (aux.prox).prox != cabeca) { aux = aux.prox;}
        Celula aux2 = aux.prox;
        aux.prox = cabeca;
        aux2.prox = null;
        //delete aux2
        return true;
        }//if
        else{
        cabeca.prox = cabeca;
        aux.prox = null;
        //delete aux;
        }
        return true;
        }
    }

    public void imprimir() {
        Celula aux = cabeca.prox;
        while (aux != cabeca) {
            System.out.println("Valor = " + aux.valor);
        }
    }

    
}
