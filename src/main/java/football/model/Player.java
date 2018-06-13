package football.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private int height;
    private String nationality;
    private String position;

    public Player(){}

    @ManyToOne
    @JoinColumn(name = "teamfootball_id")
    private TeamFootball teamFootball;

    public Player(String name, int age, int height, String nationality, String position) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.nationality = nationality;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TeamFootball getTeamFootball() {
        return teamFootball;
    }

    public void setTeamFootball(TeamFootball teamFootball) {
        this.teamFootball = teamFootball;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", nationality='" + nationality + '\'' +
                ", position='" + position + '\'' +
                ", teamFootball=" + teamFootball +
                '}';
    }
}
