package Niyamitra.niyamitra.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    
    private String role;


    private String orgname;

    private String orgtype;

    private String contactnumber;

    private String contactemail;

    private String address;
    
    private String manageremail;
    
    private String managername;
    
  
  
    
    
}

