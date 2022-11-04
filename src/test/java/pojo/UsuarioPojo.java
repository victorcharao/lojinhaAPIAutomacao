package pojo;

public class UsuarioPojo {

    private String usuarioNome;
    private String usuarioLogin;
    private String usuarioSenha;

    public UsuarioPojo(String usuarioNome, String usuarioLogin, String usuarioSenha){
        this.usuarioNome = usuarioNome;
        this.usuarioLogin = usuarioLogin;
        this.usuarioSenha = usuarioSenha;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

}
