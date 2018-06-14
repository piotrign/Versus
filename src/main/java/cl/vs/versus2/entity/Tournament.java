package cl.vs.versus2.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tournament")
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "torunament_id")
	private int id;
	
	@Column(name = "name")
	@NotEmpty(message = "*Please provide name of tournament")
	private String name;
	
	@Column(name = "date_of_tournament")
	private Date tournamentDate;
	
	@Column(name = "place_of_tournament")
	private String tournamentPlace;
	
	@Column(name = "tournament_city")
	private String tournamentCity;
	
	@Column(name = "tournament_country")
	private String tournamentCountry;
	
	@Column(name = "tournament_region")
	private String tournamentRegion;
	
	private String description;
	
	@CreationTimestamp
	private Date created;
	
	@UpdateTimestamp
	private Date updated;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tournament_participant", joinColumns = @JoinColumn(name = "user_id"))
	private Set<User> participant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTournamentDate() {
		return tournamentDate;
	}

	public void setTournamentDate(Date tournamentDate) {
		this.tournamentDate = tournamentDate;
	}

	public String getTournamentPlace() {
		return tournamentPlace;
	}

	public void setTournamentPlace(String tournamentPlace) {
		this.tournamentPlace = tournamentPlace;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<User> getParticipant() {
		return participant;
	}

	public void setParticipant(Set<User> participant) {
		this.participant = participant;
	}

	public String getTournamentCountry() {
		return tournamentCountry;
	}

	public void setTournamentCountry(String tournamentCountry) {
		this.tournamentCountry = tournamentCountry;
	}

	public String getTournamentRegion() {
		return tournamentRegion;
	}

	public void setTournamentRegion(String tournamentRegion) {
		this.tournamentRegion = tournamentRegion;
	}

	public String getTournamentCity() {
		return tournamentCity;
	}

	public void setTournamentCity(String tournamentCity) {
		this.tournamentCity = tournamentCity;
	}
	
}
