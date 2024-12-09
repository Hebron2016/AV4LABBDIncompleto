package com.csv.Herois.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Table(name="heroi")
public class Heroi {
	@Id
	@Column(name="id", nullable=false)
	private int id;
	@Column(name="name", length=80, nullable=false)
	private String name;
	@Column(name="gender", length=6, nullable=false)
	private String gender;
	@Column(name="eyeColor", length=20, nullable=true)
	private String eyeColor;
	@Column(name="race", length=50, nullable=true)
	private String race;
	@Column(name="hairColor", length=20, nullable=true)
	private String hairColor;
	@Column(name="height", nullable=false)
	private Double height;
	@Column(name="publish", length=20, nullable=false)
	private String publish;
	@Column(name="skinColor", length=20, nullable=true)
	private String skinColor;
	@Column(name="alignment", length=4, nullable=false)
	private String alignment;
	@Column(name="weight", nullable=false)
	private Double weight;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getSkinColor() {
		return skinColor;
	}
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	@Override
	public int hashCode() {
		return Objects.hash(alignment, eyeColor, gender, hairColor, height, id, name, publish, race, skinColor, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heroi other = (Heroi) obj;
		return Objects.equals(alignment, other.alignment) && Objects.equals(eyeColor, other.eyeColor)
				&& Objects.equals(gender, other.gender) && Objects.equals(hairColor, other.hairColor)
				&& Objects.equals(height, other.height) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(publish, other.publish) && Objects.equals(race, other.race)
				&& Objects.equals(skinColor, other.skinColor) && Objects.equals(weight, other.weight);
	}
	@Override
	public String toString() {
		return "Heroi [id=" + id + ", nome=" + name + ", gender=" + gender + ", eyeColor=" + eyeColor + ", race=" + race
				+ ", hairColor=" + hairColor + ", height=" + height + ", publish=" + publish + ", skinColor="
				+ skinColor + ", alignment=" + alignment + ", weight=" + weight + "]";
	}

	
}
