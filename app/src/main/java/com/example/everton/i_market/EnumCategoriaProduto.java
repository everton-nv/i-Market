package com.example.everton.i_market;

public enum EnumCategoriaProduto {
    LATICINIO("Laticinio"),FRUTA("Fruta"),HIGIENE("Higiene"),
    PEIXE("Peixe"),CARNEVERMELHA("Carne Vermelha"),AVE("Ave");

    private final String valor;

    EnumCategoriaProduto(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static String[] enumCategoriaProdutoLista(){
        EnumCategoriaProduto[] listaCategoriaProduto = EnumCategoriaProduto.values();
        String[] lista = new String[listaCategoriaProduto.length];
        for (int i =0; i<listaCategoriaProduto.length;i++){
            lista[i] = listaCategoriaProduto[i].getValor();
        }
        return  lista;
    }
}
