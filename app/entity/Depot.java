package entity;

import java.util.Arrays;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "depot")
public class Depot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date_creation", length= 256, nullable = false)
	private String createDate;
	
	@Column(name = "suject", length= 256 ,nullable = true)
	private String subject;
	
	@Column(name = "body", nullable = true)
	private String body;
	
	@Column(name = "disponibiilte", nullable = false)
	private String disponibilite;
	

	@Column(name = "from_id")
	private Integer from;
	
  @Column(name = "residence_id", nullable = true)
  private Integer residenceId;
  
	
	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "name", nullable = true)
  private String name;
	
	
	
	
	public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Depot() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

  public byte[] getImage()
  {
    return image;
  }

  public void setImage(byte[] image)
  {
    this.image = image;
  }
  

  public Integer getResidenceId()
  {
    return residenceId;
  }

  public void setResidenceId(Integer residenceId)
  {
    this.residenceId = residenceId;
  }
  
  

  public String getDisponibilite()
  {
    return disponibilite;
  }

  public void setDisponibilite(String disponibilite)
  {
    this.disponibilite = disponibilite;
  }

  @Override
  public String toString()
  {
    return "Depot [id=" + id + ", createDate=" + createDate + ", subject=" + subject + ", body=" + body + ", from="
        + from + ", residenceId=" + residenceId + ", image=" + Arrays.toString(image) + "]";
  }




}
