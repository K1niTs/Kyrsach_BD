package tables;

import jakarta.persistence.*;

@Entity
@Table(name = "shoes", schema = "public", catalog = "postgres")
public class ShoesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "material")
    private String material;
    @Basic
    @Column(name = "foot_size")
    private Integer footSize;
    @Basic
    @Column(name = "viewe")
    private String viewe;
    @Basic
    @Column(name = "id_tovar")
    private Integer idTovar;
    @Basic
    @Column(name = "brand")
    private String brand;
    @Basic
    @Column(name = "quanity")
    private Integer quanity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getFootSize() {
        return footSize;
    }

    public void setFootSize(Integer footSize) {
        this.footSize = footSize;
    }

    public String getViewe() {
        return viewe;
    }

    public void setViewe(String viewe) {
        this.viewe = viewe;
    }

    public Integer getIdTovar() {
        return idTovar;
    }

    public void setIdTovar(Integer idTovar) {
        this.idTovar = idTovar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuanity() {
        return quanity;
    }

    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoesEntity that = (ShoesEntity) o;

        if (id != that.id) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (footSize != null ? !footSize.equals(that.footSize) : that.footSize != null) return false;
        if (viewe != null ? !viewe.equals(that.viewe) : that.viewe != null) return false;
        if (idTovar != null ? !idTovar.equals(that.idTovar) : that.idTovar != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (quanity != null ? !quanity.equals(that.quanity) : that.quanity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (footSize != null ? footSize.hashCode() : 0);
        result = 31 * result + (viewe != null ? viewe.hashCode() : 0);
        result = 31 * result + (idTovar != null ? idTovar.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (quanity != null ? quanity.hashCode() : 0);
        return result;
    }
}
