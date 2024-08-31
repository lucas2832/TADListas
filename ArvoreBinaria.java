class ArvoreBinaria {

    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }
    private No inserirNovo(No novo, No atual) { // Está inserindo ao contrário
        if(atual == null) {
            return novo;
        }
        if(atual.valor < novo.valor) {
            atual.direita = inserirNovo(novo, atual.direita);
        }
        if(atual.valor > novo.valor){
            atual.esquerda = inserirNovo(novo, atual.esquerda);
        }
        return atual;
    }

    void inserir(No novo) {
        raiz = inserirNovo(novo, raiz);
    }

    private void PrivatePreOrdem(No elemento) {
        if(elemento != null) {
            System.out.println(elemento.valor + "\n"); //R
            PrivatePreOrdem(elemento.esquerda); //E
            PrivatePreOrdem(elemento.direita); //D
        }
    }

    void preOrdem() {
        PrivatePreOrdem(raiz);
    }

    private void PrivateEmOrdem(No elemento) {
        if(elemento != null) {
            PrivateEmOrdem(elemento.esquerda); //E
            System.out.println(elemento.valor + "\n"); //R
            PrivateEmOrdem(elemento.direita); //D
        }
    }

    void emOrdem() {
        PrivateEmOrdem(raiz);
    }

    private void PrivatePosOrdem(No elemento) {
        if(elemento != null) {
            PrivatePosOrdem(elemento.esquerda); //E
            PrivatePosOrdem(elemento.direita); //D
            System.out.println(elemento.valor + "\n"); //R
        }
    }
    void posOrdem() {
        PrivatePosOrdem(raiz);
    }

    private No encontrarElementoParaRemocao(No atual, int valor) {
        if(atual == null) {
            return null;
        }

        if(atual.direita != null) {
            if(atual.direita.valor == valor) {
                return atual;
            }
        }

        if(atual.esquerda != null) {
            if(atual.esquerda.valor == valor) {
                return atual;
            }
        }

        if(atual.valor > valor) {
            return encontrarElementoParaRemocao(atual.direita, valor);
        }
        
        if(atual.valor < valor) {
            return encontrarElementoParaRemocao(atual.esquerda, valor);
        }
        return null;
    }

    boolean remover(int valor) {
        if(raiz == null) {
            return false; //caso 1
        } else {
            No pai;
            No noX;

            if(raiz.valor != valor) {
                pai = encontrarElementoParaRemocao(raiz, valor);
                if(pai.valor > valor) {
                    noX = pai.direita;
                } else {
                    noX = pai.esquerda;
                }
            } else {
                pai = raiz;
                noX = raiz;
            }

            //Caso 2
            if(noX.direita == null) {
                if(pai.valor > valor) {
                    pai.esquerda = noX.esquerda;
                } else {
                    pai.esquerda = noX.esquerda;
                }
            }
            
            if(noX.esquerda == null) {
                if(pai.valor > valor) {
                    pai.direita = noX.direita;
                } else {
                    pai.esquerda = noX.direita;
                }
            }
            
            return true;
        }
    }
}