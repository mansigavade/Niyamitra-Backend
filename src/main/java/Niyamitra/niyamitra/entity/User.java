package Niyamitra.niyamitra.entity;


import jakarta.persistence.*;


import lombok.*;

@Entity
@Table(name = "register")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role; // SUPER_ADMIN / ADMIN
    
    @Column
    private String orgname;
    
    @Column
    private String orgtype;
    
    @Column
    private String contactemail;
    
    @Column
    private String contactnumber;
    
    @Column
    private String address;
    
    @Column
    private String manageremail;
    
    @Column
    private String managername;
    
   

}
