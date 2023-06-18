package tables;

import jakarta.persistence.*;

@Entity
@Table(name = "tovar", schema = "public", catalog = "postgres")
public class TovarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "buying")
    private String buying;
    @Basic
    @Column(name = "quanity")
    private Integer quanity;
    @Basic
    @Column(name = "id_buying")
    private Integer idBuying;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuying() {
        return buying;
    }

    public void setBuying(String buying) {
        this.buying = buying;
    }

    public Integer getQuanity() {
        return quanity;
    }

    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
    }

    public Integer getIdBuying() {
        return idBuying;
    }

    public void setIdBuying(Integer idBuying) {
        this.idBuying = idBuying;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TovarEntity that = (TovarEntity) o;

        if (id != that.id) return false;
        if (buying != null ? !buying.equals(that.buying) : that.buying != null) return false;
        if (quanity != null ? !quanity.equals(that.quanity) : that.quanity != null) return false;
        if (idBuying != null ? !idBuying.equals(that.idBuying) : that.idBuying != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (buying != null ? buying.hashCode() : 0);
        result = 31 * result + (quanity != null ? quanity.hashCode() : 0);
        result = 31 * result + (idBuying != null ? idBuying.hashCode() : 0);
        return result;
    }
}
