package pojo;

import java.util.List;

public class ProdutoPojo {

    private String produtoNome;
    private double produtoValor;
    private List<String> produtoCores;
    private String produtoUrlMock;
    private List<ComponentePojo> produtoComponente;

    public ProdutoPojo(String produtoNome, double produtoValor, List<String> produtoCores, String produtoUrlMock, List<ComponentePojo> produtoComponente){
        this.produtoNome = produtoNome;
        this.produtoValor = produtoValor;
        this.produtoCores = produtoCores;
        this.produtoUrlMock = produtoUrlMock;
        this.produtoComponente = produtoComponente;
    }

    public double getProdutoValor() {
        return produtoValor;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public List<String> getProdutoCor() {
        return produtoCores;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public void setProdutoCor(List<String> produtoCor) {
        this.produtoCores = produtoCor;
    }

    public List<ComponentePojo> getProdutoComponente() {
        return produtoComponente;
    }

    public void setProdutoValor(double produtoValor) {
        this.produtoValor = produtoValor;
    }

    public void setProdutoComponente(List<ComponentePojo> produtoComponente) {
        this.produtoComponente = produtoComponente;
    }

    public String getProdutoUrlMock() {
        return produtoUrlMock;
    }

    public void setProdutoUrlMock(String produtoUrlMock) {
        this.produtoUrlMock = produtoUrlMock;
    }
}
