package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lop")
public class Lop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "tenLop")
    private String tenLop;
    @OneToMany(mappedBy = "lop",fetch = FetchType.LAZY, orphanRemoval = true )
    private List<Student> listStudents;
    public Lop() {
    }

    public Lop(int id, String tenLop, List<Student> listStudents) {
        this.id = id;
        this.tenLop = tenLop;
        this.listStudents = listStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
}
