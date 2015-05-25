package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "residence")
public class Residence {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false, length = 128)
  private String name;
  
	@Column(name = "number", nullable = false)
	private int number;

	@Column(name = "street_name", nullable = false, length = 256)
	private String streetName;

	@Column(name = "city", nullable = false, length = 256)
	private String city;

	@Column(name = "zip_code", nullable = false, length = 128)
	private String zipCode;

	public Residence() {
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "Address [id=" + id + ", name=" + name + ", number=" + number + ", streetName=" + streetName + ", city="
        + city + ", zipCode=" + zipCode + "]";
  }

	
}
