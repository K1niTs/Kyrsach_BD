package tables;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "jeans", schema = "public", catalog = "postgres")
public class JeansEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "strenght")
    private String strenght;
    @Basic
    @Column(name = "size")
    private Integer size;
    @Basic
    @Column(name = "id_tovar")
    private Integer idTovar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrenght() {
        return strenght;
    }

    public void setStrenght(String strenght) {
        this.strenght = strenght;
    }


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getIdTovar() {
        return idTovar;
    }

    public void setIdTovar(Integer idTovar) {
        this.idTovar = idTovar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JeansEntity that = (JeansEntity) o;

        if (id != that.id) return false;
        if (strenght != null ? !strenght.equals(that.strenght) : that.strenght != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (idTovar != null ? !idTovar.equals(that.idTovar) : that.idTovar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (strenght != null ? strenght.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (idTovar != null ? idTovar.hashCode() : 0);
        return result;
    }

    }

