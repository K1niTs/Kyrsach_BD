package tables;

import jakarta.persistence.*;

@Entity
@Table(name = "socks", schema = "public", catalog = "postgres")
public class SocksEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "compound")
    private String compound;
    @Basic
    @Column(name = "view")
    private String view;
    @Basic
    @Column(name = "id_tovar")
    private Integer idTovar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompound() {
        return compound;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
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

        SocksEntity that = (SocksEntity) o;

        if (id != that.id) return false;
        if (compound != null ? !compound.equals(that.compound) : that.compound != null) return false;
        if (view != null ? !view.equals(that.view) : that.view != null) return false;
        if (idTovar != null ? !idTovar.equals(that.idTovar) : that.idTovar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (compound != null ? compound.hashCode() : 0);
        result = 31 * result + (view != null ? view.hashCode() : 0);
        result = 31 * result + (idTovar != null ? idTovar.hashCode() : 0);
        return result;
    }
}
