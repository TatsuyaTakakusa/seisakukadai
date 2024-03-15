package jp.ac.ohara.E.seisaku.model.form;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Form{
	@Column(name="name", length=255)
	private String name;
	
	@Column(name="password")
	private String password;
}