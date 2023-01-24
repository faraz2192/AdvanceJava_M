package pojo;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name="user_table1")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "first_name",length = 20)
	private String firstName;
	
	@Column(name = "last_name",length = 20)
	private String lastName;
	
	@Column(length = 20,unique = true)	
	private String email;
	
	@Column(length = 20,nullable = false)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(name = "join_date")
	private LocalDate date;
	
	@Column(name="reg_amount")
	private double regAmount;
	
	@Lob
	private byte[] image;
	
	@Column(name = "user_role",length = 20)
	private Role userRole;

	public Employee(String firstName, String lastName, String email, String password, String confirmPassword,
			LocalDate date, double regAmount, byte[] image, Role userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.date = date;
		this.regAmount = regAmount;
		this.image = image;
		this.userRole = userRole;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", date=" + date + ", regAmount="
				+ regAmount + ", userRole=" + userRole + "]";
	}
	
	
	

}
