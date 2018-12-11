package com.objis.cameroun.Rexam.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.objis.cameroun.Rexam.dao.ConnectionMYSQL;
import com.objis.cameroun.Rexam.dao.IDao;
import com.objis.cameroun.Rexam.domaine.Abonnes;
import com.objis.cameroun.Rexam.domaine.Eleve;

public class Dao implements IDao {

	@Override
	public void addElevesDao(Eleve elev) {
		
         try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connect= ConnectionMYSQL.getInstance();
			PreparedStatement ps=connect.prepareStatement("insert into eleves(matricule,nom_prenom,date_naissance,lieu_naissance,serie,decision_jury) values(?,?,?,?,?,?)");
			ps.setString(1, elev.getMatricule());
			ps.setString(2, elev.getNomprenom());
			ps.setString(3, elev.getDatenaissance());
			ps.setString(4, elev.getLieunaissance());
			ps.setString(5, elev.getSerie());
			ps.setString(6, elev.getDecisionjuge());
			ps.executeUpdate();
			
			ps.close();
			connect.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public List<Eleve> getEleveParMtDao(String matricule) {
		List<Eleve> eleves=new ArrayList<Eleve>();
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connect=ConnectionMYSQL.getInstance();
			PreparedStatement ps=connect.prepareStatement("select * from eleves where matricule like ?");
			
			ps.setString(1, matricule);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Eleve eleve = new Eleve();
				
				eleve.setMatricule(rs.getString(2));
				eleve.setNomprenom(rs.getString(3));
				eleve.setDatenaissance(rs.getString(4));
				eleve.setLieunaissance(rs.getString(5));
				eleve.setSerie(rs.getString(6));
				eleve.setDecisionjuge(rs.getString(7));
				eleves.add(eleve);
			}
			ps.close();
			connect.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return eleves;
	}

	@Override
	public void addAbonnesDao(Abonnes abonnes) {

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connect = ConnectionMYSQL.getInstance();
			PreparedStatement ps = connect.prepareStatement("insert into abonnes(telephone,matricule) values(?,?)");
			ps.setInt(1, abonnes.getTelephone());
			ps.setString(2, abonnes.getMatricule());
			ps.executeUpdate();
			ps.close();
			connect.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Rexam.dao.IDao#addExcelFileDao(java.lang.String)
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public void addExcelFileDao(String nomfichier) {
		List<String> ls = new ArrayList<String>();
		
		// r�cup�ration des donn�es depuis le fichier.
		
		try {
			InputStream input = new FileInputStream(nomfichier+".xls");
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet =wb.getSheetAt(0);
			Iterator lignes = sheet.rowIterator();
			
			while(lignes.hasNext()) {
				ls.clear();
				HSSFRow ligne = (HSSFRow) lignes.next();
				Iterator cellules = ligne.cellIterator();
		
				while(cellules.hasNext()) {
					
					HSSFCell cellule = (HSSFCell) cellules.next();
					if (HSSFCell.CELL_TYPE_NUMERIC==cellule.getCellType()) {
						ls.add(Integer.toString((int)cellule.getNumericCellValue()));
					}else if (HSSFCell.CELL_TYPE_STRING==cellule.getCellType()) {
						ls.add(cellule.getStringCellValue());
					}
				}
				
				// insertion dans la base des donnees.
				
				 try {
						
						//Class.forName("com.mysql.jdbc.Driver");
					 
						Connection connect= ConnectionMYSQL.getInstance();
						PreparedStatement ps=connect.prepareStatement("insert into eleves(matricule,nom_prenom,date_naissance,lieu_naissance,serie,decision_jury) values(?,?,?,?,?,?)");
						ps.setString(1, ls.get(0));
						ps.setString(2, ls.get(1));
						ps.setString(3, ls.get(2));
						ps.setString(4, ls.get(3));
						ps.setString(5, ls.get(4));
						ps.setString(6, ls.get(5));
						int count=ps.executeUpdate();
						
						// Message de succes
						
						/*if (count>0) {
							System.out.println("Enregistrement effectu�!");
						}*/
						
						//ps.close();
						//connect.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
				
			}
			System.out.println("Enregistrement effectu�!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Eleve> listElevesDao() {
		
		List<Eleve> eleves=new ArrayList<Eleve>();
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connect=ConnectionMYSQL.getInstance();
			PreparedStatement ps=connect.prepareStatement("select * from eleves");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				Eleve eleve = new Eleve();
				
				eleve.setMatricule(rs.getString(2));
				eleve.setNomprenom(rs.getString(3));
				eleve.setDatenaissance(rs.getString(4));
				eleve.setLieunaissance(rs.getString(5));
				eleve.setSerie(rs.getString(6));
				eleve.setDecisionjuge(rs.getString(7));
				eleves.add(eleve);
			}
			ps.close();
			connect.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return eleves;
	}

}
