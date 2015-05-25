package entity;

import java.util.Arrays;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "depot")
public class Depot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	private Date createDate;
	
	@Column(name = "subject", length= 256 ,nullable = true)
	private String subject;
	
	@Column(name = "body", nullable = true)
	private String body;
	
	@Column(name = "from_id", nullable = false)
	private Integer from;
	
	@Column(name = "image")
	private byte[] image;
	
	
	
	
	public Depot() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
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

  @Override
  public String toString()
  {
    return "Depot [id=" + id + ", createDate=" + createDate + ", subject=" + subject + ", body=" + body + ", from="
        + from + ", image=" + Arrays.toString(image) + "]";
  }


}
