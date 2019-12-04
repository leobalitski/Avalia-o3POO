package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pessoas {
    private int id;
    private String nome;
    private String email;
    


Pessoas(int id, String nome, String email){
this.id=id; 
this.nome=nome; 
this.email=email;

}

Pessoas(String nome, String email){
    String url = "jdbc:mysql://localhost:3306/contas";//NomeDoBanco
        String user = "root";
        String password = "";
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO pessoas (nome,email) VALUES (?,?)";
         
            PreparedStatement statemente = connection.prepareStatement(sql);
            statemente.setString(1, nome);
            statemente.setString(2, email);
            
            
            statemente.execute();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
}

public String getEmail() {
    return email;
}

public int getId() {
    return id;
}

public String getNome() {
    return nome;
}

public void setEmail(String email) {
    this.email = email;
}

public void setId(int id) {
    this.id = id;
}

public void setNome(String nome) {
    this.nome = nome;
}
}