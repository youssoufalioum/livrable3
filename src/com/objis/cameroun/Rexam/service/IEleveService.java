package com.objis.cameroun.Rexam.service;

import java.util.List;

import com.objis.cameroun.Rexam.domaine.Abonnes;
import com.objis.cameroun.Rexam.domaine.Eleve;

public interface IEleveService  {
	
	public void addElevesService(Eleve eleve);
	public List<Eleve> getEleveParMtService(String matricule);
	public void addAbonnesService(Abonnes abonnes);
	public void addExcelFileService(String nomfichier);
	public List<Eleve> listElevesService();
}