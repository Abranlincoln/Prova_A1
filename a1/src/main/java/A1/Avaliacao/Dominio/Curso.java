package A1.Avaliacao.Dominio;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Curso")
public class Curso {
    private Long id;
    private String nome;
    private String campus;

    public Curso(Long id, String nome, String campus) {
        this.id = id;
        this.nome = nome;
        this.campus = campus;
    }

    @DynamoDBHashKey
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @DynamoDBAttribute
    public String getCampus() {
        return campus;
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", campus=" + campus + "]";
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((campus == null) ? 0 : campus.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (campus == null) {
            if (other.campus != null)
                return false;
        } else if (!campus.equals(other.campus))
            return false;
        return true;
    }
}
