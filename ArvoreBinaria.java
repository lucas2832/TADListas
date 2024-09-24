class ArvoreBinaria {

    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }

    private boolean vazia() {
        return raiz == null;
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

    private No encontrarElemento(No atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor > atual.valor) {
            if (atual.direita != null) {
                if (atual.direita.valor == valor) {
                    return atual;
                }
            }
        } else {
            if (atual.esquerda != null) {
                if (atual.esquerda.valor == valor) {
                    return atual;
                }
            }
        }

        if (atual.valor > valor) {
            return encontrarElemento(atual.esquerda, valor);
        }

        if (atual.valor < valor) {
            return encontrarElemento(atual.direita, valor);
        }

        return null;
    }

    boolean remover(int valor) {
        if (raiz == null) {
            return false; //Árvore vazia
        } else {
            No pai;
            No noX;

            if (raiz.valor == valor) {
                pai = raiz;
                noX = raiz;
            } else {
                pai = encontrarElemento(raiz, valor);

                if (pai.valor < valor) {
                    noX = pai.direita;
                } else {
                    noX = pai.esquerda;
                }
            }

            if (noX.direita == null && noX.esquerda == null) { //Caso 1 nó folha
                if (pai.valor < valor) {
                    pai.direita = null;
                } else {
                    pai.esquerda = null;
                }
            // Fim do caso 1
            } else {
                if(noX.direita != null && noX.esquerda != null){ // Caso 3 - DOIS FILHOS
                    No noPaiDireitaEsquerda = maisEsquerdaPossivel(noX, noX.direita);
                    No substituto = noPaiDireitaEsquerda.esquerda;
                    noPaiDireitaEsquerda.esquerda = null; //REMOVI embaixo
                    substituto.direita = noX.direita; //Sem perder as referências das subárvores
                    substituto.esquerda = noX.esquerda;
                    noX.esquerda = null; //Remoção do elemento
                    noX.direita = null; //Remoção do elemento
                    //delete noX
                    if(pai.valor < valor) pai.direita = substituto; // Ou pai.direita == noX
                    else pai.esquerda = substituto;
                } else {
                    if(noX.direita == null){
                        if(pai.valor < valor) pai.direita = noX.esquerda; // Ou pai.direita == noX
                        else pai.esquerda = noX.esquerda;
                        noX.esquerda = null;
                    }
                    if(noX.esquerda == null){
                        if(pai.valor > valor) pai.direita = noX.direita;
                        else pai.esquerda = noX.direita;
                        noX.direita = null;
                    }
                }
            }
        }

        return true;
    }

    private No maisEsquerdaPossivel(No pai, No filhoAtual){
    
        if(filhoAtual.esquerda == null)
    
        return pai;
    
        return maisEsquerdaPossivel(filhoAtual, filhoAtual.esquerda);
    }
    

    //Questão 1 "tp6"
    private static int cont1 = 0;

    private int privateContarNos(No elemento) {

        if (vazia()) {
            return 0;
        }
        if(elemento != null) {
            cont1++;
            privateContarNos(elemento.esquerda);
            privateContarNos(elemento.direita);
        }
        return cont1;
    }

    public int contarNos() {
        return privateContarNos(raiz);
    }

    //Questão 2 "tp6"
    private static int cont2 = 0;

    private int privateContarNosNaoFolha(No elemento) {

        if (vazia()) {
            return 0;
        }
        if(elemento != null) {
            if (elemento.esquerda != null || elemento.direita != null) {
                cont2++;
            }
            privateContarNosNaoFolha(elemento.esquerda);
            privateContarNosNaoFolha(elemento.direita);
        }
        return cont2;
    }

    public int contarNosNaoFolha() {
        return privateContarNosNaoFolha(raiz);
    }

    //Questão 3 "tp6"
    private static int cont3 = 0;

    private int privateContarNosFolha(No elemento) {

        if (vazia()) {
            return 0;
        }
        if(elemento != null) {
            if (elemento.esquerda == null && elemento.direita == null) {
                cont3++;
            }
            privateContarNosFolha(elemento.esquerda);
            privateContarNosFolha(elemento.direita);
        }
        return cont3;
    }

    public int contarNosFolha() {
        return privateContarNosFolha(raiz);
    }

    //Questão 4 "tp6"
    public int alturaArvore() {
        return privateAlturaArvore(raiz);
    }
    
    private int privateAlturaArvore(No elemento) {

        if (elemento == null) {
            return 0;
        }

        int alturaEsquerda = privateAlturaArvore(elemento.esquerda);
        int alturaDireita = privateAlturaArvore(elemento.direita);    
        
        return Math.max(alturaEsquerda , alturaDireita ) + 1;
    }

    public void removerPares() {
        privateRemoverPares(raiz);
    }

    private void privateRemoverPares(No elemento) {
        
    }
}
