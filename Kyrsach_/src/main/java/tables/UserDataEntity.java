package tables;

import jakarta.persistence.*;

@Entity
@Table(name = "user_data", schema = "public", catalog = "postgres")
public class UserDataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "name_of_buying")
    private String nameOfBuying;
    @Basic
    @Column(name = "track_number")
    private Integer trackNumber;
    @Basic
    @Column(name = "id_buying")
    private Integer idBuying;
    @Basic
    @Column(name = "id_drivers")
    private Integer idDrivers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNameOfBuying() {
        return nameOfBuying;
    }

    public void setNameOfBuying(String nameOfBuying) {
        this.nameOfBuying = nameOfBuying;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Integer getIdBuying() {
        return idBuying;
    }

    public void setIdBuying(Integer idBuying) {
        this.idBuying = idBuying;
    }

    public Integer getIdDrivers() {
        return idDrivers;
    }

    public void setIdDrivers(Integer idDrivers) {
        this.idDrivers = idDrivers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDataEntity that = (UserDataEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (nameOfBuying != null ? !nameOfBuying.equals(that.nameOfBuying) : that.nameOfBuying != null) return false;
        if (trackNumber != null ? !trackNumber.equals(that.trackNumber) : that.trackNumber != null) return false;
        if (idBuying != null ? !idBuying.equals(that.idBuying) : that.idBuying != null) return false;
        if (idDrivers != null ? !idDrivers.equals(that.idDrivers) : that.idDrivers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nameOfBuying != null ? nameOfBuying.hashCode() : 0);
        result = 31 * result + (trackNumber != null ? trackNumber.hashCode() : 0);
        result = 31 * result + (idBuying != null ? idBuying.hashCode() : 0);
        result = 31 * result + (idDrivers != null ? idDrivers.hashCode() : 0);
        return result;
    }
}
