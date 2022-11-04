package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {

    public static ProdutoPojo criarProdutoComumComOValorIgualA(double valor){
        List<String> cores = new ArrayList<>();
        cores.add("preto");

        List<ComponentePojo> componentes = new ArrayList<>();
        ComponentePojo componente = new ComponentePojo("Controle", 2);
        componentes.add(componente);

        ProdutoPojo produto = new ProdutoPojo("PlayStation 5", valor, cores, "", componentes);

        return produto;
    }
}
