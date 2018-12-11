package com.objis.cameroun.Rexam.service.impl;

import java.sql.*;
import java.util.*;

import com.objis.cameroun.Rexam.dao.IDao;
import com.objis.cameroun.Rexam.dao.impl.Dao;
import com.objis.cameroun.Rexam.domaine.Abonnes;
import com.objis.cameroun.Rexam.domaine.Eleve;
import com.objis.cameroun.Rexam.service.IEleveService;


/**Classe qui traite les savoir faire dont l'utilisateur fait appel
 * @version 1.0 rexam
 * @author youssouf
 *
 */
public class EleveService implements IEleveService {
	
	private IDao dao;
	
	

	public EleveService() {
		dao= new Dao();
	}

	@Override
	public void addElevesService(Eleve eleve) {
		
		dao.addElevesDao(eleve);
		
	}

	@Override
	public List<Eleve> getEleveParMtService(String matricule) {
		return dao.getEleveParMtDao(matricule);
	}

	@Override
	public void addAbonnesService(Abonnes abonnes) {
		dao.addAbonnesDao(abonnes);
		
	}

	@Override
	public void addExcelFileService(String nomfichier) {
		 dao.addExcelFileDao(nomfichier);
	}

	@Override
	public List<Eleve> listElevesService() {
		return dao.listElevesDao();
	}
	
	
}