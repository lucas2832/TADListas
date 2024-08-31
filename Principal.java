public class Principal {
    
    public static void main(String[]args){

        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(new No(10));
        arvore.inserir(new No(5));
        arvore.inserir(new No(20));
        arvore.inserir(new No(40));
        arvore.inserir(new No(15));
        arvore.inserir(new No(30));

        //arvore.preOrdem();
        arvore.emOrdem();
        //arvore.posOrdem();

        arvore.remover(30);

        arvore.emOrdem();
    }
    
}
