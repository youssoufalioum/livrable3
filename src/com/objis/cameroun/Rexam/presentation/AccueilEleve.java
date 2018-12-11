package com.objis.cameroun.Rexam.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.objis.cameroun.Rexam.domaine.Abonnes;
import com.objis.cameroun.Rexam.domaine.Eleve;
import com.objis.cameroun.Rexam.service.IEleveService;
import com.objis.cameroun.Rexam.service.impl.EleveService;



/**interface entre utilisateur final et le programme
 * @author youssouf
 *@version 1.0 rexam
 */
public class AccueilEleve {

	public static void main(String[] args)  {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Choisir:");
			System.out.println("1- Pour enregistrer l'élève.");
			System.out.println("2- Pour enregistrer les éléves via fichier Excel.");
			System.out.println("3- Pour afficher la liste de tous les éléves.");
			System.out.println("4- Pour consulter le résultat de l'élève via son matricule.");
			System.out.println("5- Abonnement");
			
			int choix=sc.nextInt();
			
			switch(choix) {
			
			case 1: {
				sauvegarder();	
			break;
			}
			

			case 2: {
				fichierExcel();	
			break;
			}
			
			case 3: {
				tousLesEleves();
				break;
			}
			
			case 4: {
				afficher();
			break;
			}
			
			case 5: {
				abonne();
				break;
			}
	
	}
			aurevoir();
			sc.close();
	}
	
	
	//liste des methodes à appeller dans la methode principale.
	public static void sauvegarder() {

		Scanner sc = new Scanner(System.in);
		IEleveService ies=new EleveService();
		System.out.println("Sauvegarder les donnees de l'élève dans la base des données.");
		System.out.println();
		System.out.print("Matricule: "); String mt=sc.nextLine();
		System.out.print("Nom et Prenom: "); String np=sc.nextLine();
		System.out.print("Date de Naissance: "); String dn=sc.nextLine();
		System.out.print("Lieu de Naissance: "); String ln=sc.nextLine();
		System.out.print("Serie: "); String se=sc.nextLine();
		System.out.print("Decision du jury: "); String dj=sc.nextLine();
		
		Eleve el =new Eleve(mt, np, dn, ln, se, dj);
		ies.addElevesService(el);
		System.out.println();
		System.out.println("Sauvegarde réussie");
		System.out.println();
		sc.close();
		
	}
	
	public static void afficher() {
		
		Scanner af = new Scanner(System.in);
		IEleveService ies=new EleveService();
		System.out.print("Saisisez votre matricule: ");
		String matricule=af.nextLine();
		
		List<Eleve>	eleves = ies.getEleveParMtService(matricule);
		
		for(Eleve e:eleves) {
			System.out.println();
			System.out.println("Matricule: "+e.getMatricule());
			System.out.println("Nom et Prenom: "+e.getNomprenom());
			System.out.println("Date de Naissance: "+e.getDatenaissance());
			System.out.println("Lieu de Naissance: "+e.getLieunaissance());
			System.out.println("Serie: "+e.getSerie());
			System.out.println("Decision du jury: "+e.getDecisionjuge());
			System.out.println();	
			af.close();
	}
	}
	
	
	public static void abonne() {
		Scanner ab = new Scanner(System.in);
		Scanner st = new Scanner(System.in);
		IEleveService ies=new EleveService();
		System.out.println("Abonnez vous ici");
		System.out.print("votre numéro téléphone: "); 
		int phone=ab.nextInt();
		System.out.print("votre matricule: "); 
		String matric=st.nextLine();
		Abonnes abo= new Abonnes(phone,matric);
		ies.addAbonnesService(abo);
		System.out.println();
		System.out.println("Abonnement reussi vous recevrez un SMS vous informant de votre resultat le jour de la sortie de l'examen");
		ab.close();
		st.close();
	}

	public static void aurevoir() {
		JFrame frame = new JFrame("Rexam");
		frame.getContentPane().setBackground(Color.white);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300,100));
        frame.setLocationRelativeTo(null);
       
        frame.getContentPane().add(new JLabel("                Au revoir."));
        
        frame.setVisible(true);
	}
	
	public static void fichierExcel () {
		
		Scanner fe=new Scanner(System.in);
		IEleveService ief=new EleveService();
		System.out.println("Saisir le nom du fichier Excel");
		String nomfichier=fe.nextLine();
		ief.addExcelFileService(nomfichier);
	}
	
	
	public static void tousLesEleves() {
		
		IEleveService iesc=new EleveService();
		List<Eleve>	eleves = iesc.listElevesService();
		
		for(Eleve e:eleves) {
			System.out.println();
			System.out.println("Matricule: "+e.getMatricule());
			System.out.println("Nom et Prenom: "+e.getNomprenom());
			System.out.println("Date de Naissance: "+e.getDatenaissance());
			System.out.println("Lieu de Naissance: "+e.getLieunaissance());
			System.out.println("Serie: "+e.getSerie());
			System.out.println("Decision du jury: "+e.getDecisionjuge());
			System.out.println();	
	}
		System.out.println("Nombre Total des Eleves = "+eleves.size());
	}
	
	
	
	}	