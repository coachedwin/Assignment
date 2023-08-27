package searchTshirtUsingHibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id ;
import com.opencsv.bean.CsvBindByName;

@Entity
public class Brand {
	@Id 
	@CsvBindByName(column="ID")
	private String id;
	
	@Column(name="NAME")@CsvBindByName(column="NAME")
	private String name;
	
	@Column(name="COLOUR")@CsvBindByName(column="COLOUR")
	private String colour;
	
	@Column(name="GENDER_RECOMMENDATION")@CsvBindByName(column="GENDER_RECOMMENDATION")
	private String gender;
	
	@Column(name="SIZE")@CsvBindByName(column="SIZE")
	private String size;
	
	@Column(name="PRICE")@CsvBindByName(column="PRICE")
	private String price ;
	
	@Column(name="RATING")@CsvBindByName(column="RATING")
	private String rating;
	
	
	
	
	public String getColour() {
		return colour;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getId() {
		return id;
	}
	public String getSize() {
		return size;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getRating() {
		return rating;
	}
	
	
	
	
}
 