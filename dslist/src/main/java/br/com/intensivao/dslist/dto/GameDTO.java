package br.com.intensivao.dslist.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.intensivao.dslist.entities.Game;

/**
 * O DTO foi criado para realizar uma padronização do projeto, e além disso dependendo do relacionamento da entidade, 
 * Além disso ele ajuda a evitar ciclos não desejados que podem gerr um loop
 * @author alifi
 *
 */
@Component
public class GameDTO {
	
	private Long 		id;
	private String		title;
	private Integer		year;
	private String 		genre;
	private String		platforms;
	private Double		score;
	private String 		imgUrl;
	private String 		shortDescription;
	private String 		longDescription;
	
	public GameDTO() {
		// TODO Auto-generated constructor stub
	}

	public GameDTO(Game entity) {
		//copiando as propriedades de uma entidade para outra
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDTO other = (GameDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "GameDto [id=" + id + ", title=" + title + ", year=" + year + ", genre=" + genre + ", platforms="
				+ platforms + ", score=" + score + ", imgUrl=" + imgUrl + ", shortDescription=" + shortDescription
				+ ", longDescription=" + longDescription + "]";
	}
	
}
