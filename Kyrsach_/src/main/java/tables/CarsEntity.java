package tables;

import jakarta.persistence.*;

@Entity
@Table(name = "cars", schema = "public", catalog = "postgres")
public class CarsEntity {
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "view trailer")
    private String viewTrailer;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_buying")
    private Integer idBuying;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getViewTrailer() {
        return viewTrailer;
    }

    public void setViewTrailer(String viewTrailer) {
        this.viewTrailer = viewTrailer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        CarsEntity that = (CarsEntity) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (viewTrailer != null ? !viewTrailer.equals(that.viewTrailer) : that.viewTrailer != null) return false;
        if (idBuying != null ? !idBuying.equals(that.idBuying) : that.idBuying != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (viewTrailer != null ? viewTrailer.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (idBuying != null ? idBuying.hashCode() : 0);
        return result;
    }
}
