package entity;

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
@Table(name = "fil_actualite")
public class FilActualite
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date_creation", nullable = false)
  private Date createDate;

  @Column(name = "suject", length = 256, nullable = false)
  private String subject;

  @Column(name = "body", nullable = true)
  private String body;

  @Column(name = "from_id")
  private Integer from;
  
  @Column(name = "residence_id", nullable = true)
  private Integer residenceId;
  
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

  public FilActualite()
  {}

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Date getCreateDate()
  {
    return createDate;
  }

  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  public String getSubject()
  {
    return subject;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  public String getBody()
  {
    return body;
  }

  public void setBody(String body)
  {
    this.body = body;
  }

  public Integer getFrom()
  {
    return from;
  }

  public void setFrom(Integer from)
  {
    this.from = from;
  }

  public Integer getResidenceId()
  {
    return residenceId;
  }

  public void setResidenceId(Integer residenceId)
  {
    this.residenceId = residenceId;
  }

  @Override
  public String toString()
  {
    return "FilActualite [id=" + id + ", createDate=" + createDate + ", subject=" + subject + ", body=" + body
        + ", from=" + from + ", residenceId=" + residenceId + "]";
  }



}
