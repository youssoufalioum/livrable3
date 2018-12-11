package com.objis.cameroun.Rexam.domaine;

/**
 * @author youssouf
 *class enfant de la class Eleve.Elle contient les informations relative aux abonn�s
 */
public class Abonnes extends Eleve {
	
	//l'attribut sp�cifique de la class abonnes
	private int telephone;
	
	//constructeurs
	public Abonnes() {
		super();
	}



	public Abonnes(int telephone,String matricule) {
		super(matricule);
		this.telephone=telephone;
	}
	
	
	//les accesseurs getters et setters
	public int getTelephone() {
		return telephone;
	}





	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}




	//la methode toString
	@Override
	public String toString() {
		return "Abonnes [telephone=" + telephone + "]";
	}
	
	

}