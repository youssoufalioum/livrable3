package com.objis.cameroun.Rexam.dao;

import java.util.List;

import com.objis.cameroun.Rexam.domaine.Abonnes;
import com.objis.cameroun.Rexam.domaine.Eleve;

public interface IDao {
	
	public void addElevesDao(Eleve eleve);
	public List<Eleve> getEleveParMtDao(String matricule);
	public void addAbonnesDao(Abonnes abonnes);
	public void addExcelFileDao(String nomfichier);
	public List<Eleve> listElevesDao();

}
