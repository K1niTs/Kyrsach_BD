package tables;

import jakarta.persistence.*;

@Entity
@Table(name = "buying", schema = "public", catalog = "postgres")
public class BuyingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "weight")
    private Integer weight;
    @Basic
    @Column(name = "data")
    private Integer data;
    @Basic
    @Column(name = "color")
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuyingEntity that = (BuyingEntity) o;

        if (id != that.id) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
