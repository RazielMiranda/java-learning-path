
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pessoa {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public int id;
    public String Nome,Email;



public void salvar() {

    Banco banco = new Banco();
    banco.sqlAtualizacao("INSERT INTO Pessoa (nome, email)VALUES ('" + this.getNome() + "', '" + this.getEmail() + "');");

}


public Pessoa[] consultar() {
int x = 0;
ResultSet rs = null;
Banco b = new Banco();
rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM Pessoa;");
try {
rs.next();
x = Integer.parseInt(rs.getString("total"));
} catch(SQLException e) {
System.out.println(e.getMessage());
} catch(Exception e) {
System.out.println(e.getMessage());
}
if (x == 0) return null;
Pessoa[] p = new Pessoa[x];
rs = b.sqlConsulta("SELECT * FROM Pessoa ORDER BY nome;");
try {
int count = 0;
while (rs.next()) {
Pessoa temp = new Pessoa();
temp.setId(Integer.parseInt(rs.getString("id")));
temp.setNome(rs.getString("nome"));
temp.setEmail(rs.getString("email"));
p[count] = temp;
count++;
}
} catch(SQLException e) {
System.out.println(e.getMessage());
} catch(Exception e) {
System.out.println(e.getMessage());
}
return p;
}


}