package tables;

import jakarta.persistence.*;

@Entity
@Table(name = "headdress", schema = "public", catalog = "postgres")
public class HeaddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "season")
    private String season;
    @Basic
    @Column(name = "forms")
    private String forms;
    @Basic
    @Column(name = "id_tovar")
    private Integer idTovar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getForms() {
        return forms;
    }

    public void setForms(String forms) {
        this.forms = forms;
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

        HeaddressEntity that = (HeaddressEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (season != null ? !season.equals(that.season) : that.season != null) return false;
        if (forms != null ? !forms.equals(that.forms) : that.forms != null) return false;
        if (idTovar != null ? !idTovar.equals(that.idTovar) : that.idTovar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (season != null ? season.hashCode() : 0);
        result = 31 * result + (forms != null ? forms.hashCode() : 0);
        result = 31 * result + (idTovar != null ? idTovar.hashCode() : 0);
        return result;
    }
}