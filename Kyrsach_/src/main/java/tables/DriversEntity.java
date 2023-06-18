package tables;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers", schema = "public", catalog = "postgres")
public class DriversEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "id_buying")
    private Integer idBuying;
    @Basic
    @Column(name = "id_user_data")
    private Integer idUserData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getIdBuying() {
        return idBuying;
    }

    public void setIdBuying(Integer idBuying) {
        this.idBuying = idBuying;
    }

    public Integer getIdUserData() {
        return idUserData;
    }

    public void setIdUserData(Integer idUserData) {
        this.idUserData = idUserData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversEntity that = (DriversEntity) o;

        if (id != that.id) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (idBuying != null ? !idBuying.equals(that.idBuying) : that.idBuying != null) return false;
        if (idUserData != null ? !idUserData.equals(that.idUserData) : that.idUserData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (idBuying != null ? idBuying.hashCode() : 0);
        result = 31 * result + (idUserData != null ? idUserData.hashCode() : 0);
        return result;
    }
}