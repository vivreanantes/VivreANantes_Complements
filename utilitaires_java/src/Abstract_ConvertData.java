public abstract class Abstract_ConvertData {
	
	static public final String FILE_DIRECTORY = "C:\\dev\\github-repositories\\VivreANantes_Complements\\utilitaires_java\\";
	static public final String RESSOURCES_DIRECTORY = "in\\";
	static public final String RES_DIRECTORY = "out\\";
	
	protected String tranlateHoraires(String horaires) {
		return horaires
				//
				.replace(
						" �t� (Du 1er avril au 30 septembre) : Lundi au Samedi de 9h � 19h. Dimanche de 9h � 12h15. Hiver (du 1er octobre au 31 mars) : Lundi au Samedi de 9h � 18h. Dimanche de 9h � 12h15. Fermeture les jours f�ri�s.", //
						"0109-3103_lu-ma-me-je-ve-sa_09h00-18h00,0104-3008_lu-ma-me-je-ve-sa_09h00-18h00,0101-3112_di_09h00-12h15,sauf_ferie")
				//
				.replace(
						" �t� (Du 1er avril au 30 septembre) : Lundi au Vendredi de 10h � 12h15 et de 14h30 � 19h. Samedi de 9h � 12h15 et de 14h30 � 19h. Hiver (du 1er octobre au 31 mars) : Lundi au Samedi de 9h � 12h15 et de 14h30 � 18h. Fermeture les jours f�ri�s.", //
						"3009-3103_lu-ma-me-je-ve-sa_09h00-12h15,3009-3103_lu-ma-me-je-ve-sa_14h30-19h00,0104-3009_lu-ma-me-je-ve-sa_10h00-12h15,0104-3009_lu-ma-me-je-ve-sa_14h30-18h00,sauf_ferie")
				//
				.replace(
						" �t� (Du 1er avril au 30 septembre) : Lundi de 14h30 � 19h, Mardi au Samedi de 9h � 12h30 et de 14h � 19h, Dimanche de 9h � 12h30. Hiver (du 1er octobre au 31 mars) : Lundi de 14h30 � 18h, Mardi au Samedi de 9h � 12h30 et de 14h � 18h, Dimanche de 9h � 12h30. Fermeture les jours f�ri�s.", //
						"3009-0104_lu_14h30-19h00,3009-3103_ma-me-je-ve-sa_09h00-12h30,3009-3103_ma-me-je-ve-sa_14h00-19h00,0104-3103_lu_14h30-18h00,0104-3103_ma-me-je-ve-sa_09h00-12h30,0104-3103_ma-me-je-ve-sa_14h00-18h00,0104-3103_di_09h00-12h30,sauf_ferie")
				//
				.replace(
						" �t� (Du 1er avril au 30 septembre) : Lundi et mercredi de 14h30 � 19h, samedi de 9h � 12h15 et de 14h30 � 19h. Hiver (du 1er octobre au 31 mars) : Lundi et mercredi de 14h30 � 18h, samedi de 9h � 12h15 et de 14h30 � 18h. Fermeture les jours f�ri�s.", //
						"3009-0104_lu-me_14h30-19h00,3009-3103_sa_09h00-12h15,3009-3103_sa_14h30-19h00,0104-3103_lu-me_14h30-1800,0104-3103_sa_09h00-12h15,0104-3103_sa_14h30-18h00,sauf_ferie")
				//
				.replace(
						"D�p�t d'objets r�utilisables : lundi-samedi de 9h � 12h Boutique solidaire : le samedi de 10h � 18h", //
						"0101-3112_lu-ma-me-je-ve_12h00-14h00")
				//
				// OK COMMENTAIRE //
				.replace(
						"D�p�ts des dons : Mardi, mercredi, vendredi et le samedi de 9h30 � 11h30 et de 13h30 � 16h30. Salle de vente : Le mercredi de 13h30 � 17h30 et le samedi de 9h30 � 11h30 et de 13h30 � 17h30.", //
						"0101-3112_lu-ma-me-je-ve_12h00-14h00")
				//
				.replace(
						"Du lundi au jeudi : de 10h � 12h30 et de 14h30 � 19h00 ; Le vendredi : 10h00 � 19h00 ; Le samedi : 10h00 � 12h30 et de 14h30 � 18h30", //
						"0101-3112_lu-ma-me-je_10h00-12h30,0101-3112_lu-ma-me-je_14h30-19h00,0101-3112_ve_10h00-19h00,0101-3112_sa_10h00-12h30,0101-3112_sa_14h30-18h30")
				//
				.replace(
						"Du lundi au jeudi de 9h00 � 12h30 et de 14h00 � 17h00. Le vendredi de 9h00 � 12h30 et de 14h00 � 16h00.", //
						"0101-3112_lu-ma-me-je_12h00-14h00,0101-3112_lu-ma-me-je_14h00-17h00,0101-3112_ve_09h00-12h30,0101-3112_ve_14h00-16h00")
				//
				.replace(
						"Du lundi au samedi de 10h � 13h et de 14h � 19h", //
						"0101-3112_lu-ma-me-je-ve-sa_10h00-13h00,0101-3112_lu-ma-me-je-ve-sa_14h00-19h00")
				//
				.replace("Du lundi au samedi de 8 heures � 20 heures.", //
						"0101-3112_lu+ma+me+je+ve+sa_08h00-20h00")
				//
				.replace(
						"du lundi au vendredi 7h00-19h00 et le samedi 8h00-19h00", //
						"0101-3112_lu-ma-me-je-ve_07h00-19h00,0101-3112_sa_08h00-19h00")
				//
				.replace(
						"Du lundi au vendredi de 10h � 12h30 et de 14h � 19h00. Le samedi de 10h � 12h30 et de 14h � 18h30", //
						"0101-3112_lu-ma-me-je-ve_10h00-12h30,0101-3112_lu-ma-me-je-ve_14h00-19h00,0101-3112_sa_10h00-12h30,0101-3112_sa_14h00-18h30")
				//
				.replace(
						"Du lundi au vendredi de 10h � 19h00 et le samedi de 10h � 12h et de 14h � 18h30", //
						"0101-3112_lu-ma-me-je-ve_10h00-19h00,0101-3112_sa_10h00-12h00,0101-3112_sa_14h00-18h30")
				//
				.replace(
						"Du lundi au vendredi de 10h � 19h00 et le samedi de 10h � 18h30", //
						"0101-3112_lu-ma-me-je-ve_10h00-19h00")
				//
				.replace(
						"Du lundi au vendredi de 10h � 19h00. Le samedi de 10h � 18h30", //
						"0101-3112_lu-ma-me-je-ve_12h00-14h00,0101-3112_sa_10h00-18h30")
				//
				.replace("Du lundi au vendredi de 8h � 12h et de 13h � 17h.", //
						"0101-3112_lu+ma+me+je+ve_08h00-12h00+13h00-17h00")
				//
				.replace(
						"du lundi au vendredi de 8h � 12h30 et de 14h � 19h ainsi que le samedi matin de 9h � 12h30", //
						"0101-3112_lu-ma-me-je-ve_08h00-12h30,0101-3112_lu-ma-me-je-ve_14h00-19h00,0101-3112_sa_09h00-12h30")
				//
				.replace(
						"Du lundi au vendredi de 9h00 � 12h30 et de 14h00 � 18h00.", //
						"0101-3112_lu-ma-me-je-ve_09h00-12h30,0101-3112_lu-ma-me-je-ve_14h00-18h00")
				//
				.replace("Du lundi au vendredi de 9h00 � 18h00.", //
						"0101-3112_lu-ma-me-je-ve_09h00-18h00")
				//
				.replace("Du lundi au vendredi, 9h-12h et 14h-18h", //
						"0101-3112_lu-ma-me-je-ve_09h00-12h00,0101-3112_lu-ma-me-je-ve_14h00-18h00")
				//
				.replace("Du mardi au samedi de 10h � 12h30 et de 14h30 � 19h", //
						"0101-3112_ma-me-je-ve-sa_12h00-14h00,0101-3112_ma-me-je-ve-sa_14h30-19h00")
				//
				.replace(
						"Du mardi au samedi de 10h � 19h, le lundi de 14h � 19h", //
						"0101-3112_ma-me-je-ve-sa_10h00-19h00,0101-3112_lu_14h00-19h00")
				//
				.replace(
						"ETE (du 2 mai au 30 septembre) : du lundi au jeudi de 10h � 12h et de 14h � 18h. Vendredi et samedi : de 9h � 12h30 et de 13h30 � 18h. HIVER : (du 1er octobre au 31 avril) : lundi de 14h � 18h, du mardi au vendredi de 10h � 12h et de 14h � 18h, et le samedi de 10h � 12h et de 13h � 18h. Ferm� les 1er janvier, 1er mai et 25 d�cembre.", //
						"3009-0205_lu-ma-me-je_10h00-12h00,3009-0205_lu-ma-me-je_14h00-18h00,3009-0205_ve-sa_09h00-12h30,3009-0205_ve-sa_13h30-18h00,0110-3104_lu_14h00-18h00,0110-3104_ma-ve_10h00-12h00,0110-3104_ma-ve_14h00-18h00,0110-3104_sa_10h00-12h00,0110-3104_sa_13h00-18h00,sauf_0101,sauf_0105,sauf_2512")
				//
				.replace(
						"Ferme le mercredi apres midi et le vendredi. Devis meuble le mardi de 14 a 17h et le jeudi de 9 a 12h.", //
						"0101-3112_lu-ma-me-je-ve_12h00-14h00")
				//
				.replace(
						"La boutique est ouverte tous les mercredi et samedi de 9h30 � 12h et de 14h � 16h45. Chacun peut �galement venir y d�poser les objets encore utilisables, aux m�mes jours et heures d�ouverture.", //
						"0101-3112_lu+ma+me+je+ve_12h00-14h00")
				//
				.replace(
						"Le magasin est ouvert du mardi au samedi de 9h30 � 12h30 et de 13h30 � 18h", //
						"0101-3112_ma-me-je-ve-sa_09h30-12h30,0101-3112_ma-me-je-ve-sa_13h30-18h00")
				//
				.replace("Le mardi de 10h � 12 h.", //
						"0101-3112_ma_10h00-12h00")
				//
				.replace(
						"le MERCREDI de 9 h � 12 h, le SAMEDI de 9 h � 12 h 30", //
						"0101-3112_me_09h00-12h00,0101-3112_sa_09h00-12h30")
				//
				.replace(
						"le MERCREDI de 9 h � 17 h 30, le SAMEDI de 9 h � 17 h 30", //
						"0101-3112_me_09h00-17h30,0101-3112_sa_09h00-17h30")
				//
				// OK COMMENTAIRE //
				.replace(
						"Le Samedi de 9h30 � 12h, et en semaine selon les horaires suivants : Meubles : Lundi, Mardi, Mercredi, Jeudi de 14h30 � 17h, Vestiaire : Mardi, un  Mercredi sur deux ( non distribution alimentaire ), Jeudi  :  10h �12h et de 14h30 � 16h30, Jouets : Mardi et Jeudi de 10h � 12h et de 14h30 � 16h30, Biblioth�que : Jeudi de 14h30 � 16h30.  Les d�pots de v�tements, livres, jouets, vaisselle, bibelots peuvent se faire tous les jours, de 9h � 12 h et de 14h30 � 16h30. De pr�f�rence, venez le lundi et le samedi matin. D�pots de meubles toutes les apr�s-midi, du lundi au jeudi, de 14 h � 17 h. ", //
						"0101-3112_lu-ma-me-je-ve_12h00-14h00")
				//
				.replace("Lundi � Vendredi 9h-13h et 14h30-18h30", //
						"0101-3112_lu-ma-me-je-ve_09h00-13h00,0101-3112_lu-ma-me-je-ve_14h30-18h30")
				//
				.replace("Lundi au Samedi de 09H00 � 19H00", //
						"0101-3112_lu-ma-me-je-ve-sa_09h00-19h00")
				//
				.replace(
						"Lundi de 14h � 18h, mercredi de 08h30 � 12h30, et samedi de 09h � 12h30 et de 14h � 18h. Ferm� les 1er janvier, 1er mai et 25 d�cembre.", //
						"0101-3112_lu_14h00-18h00,0101-3112_me_08h30-12h30,0101-3112_sa_09h00-12h30,0101-3112_sa_14h00-18h00,sauf_0101,sauf_0105,sauf_2512")
				//
				.replace(
						"Lundi de 8h30 � 12h30, mercredi de 14h � 18h et samedi de 9h � 12h30 et de 14h � 18h. Ferm� les 1er janvier, 1er mai et 25 d�cembre.", //
						"0101-3112_lu_08h30-12h30,0101-3112_me_14h00-18h00,0101-3112_sa_09h00-12h30,0101-3112_sa_14h00-18h00,sauf_0101,sauf_0105,sauf_2512")
				//
				.replace(
						"Lundi et vendredi de 14h � 18h, du mardi au jeudi de 9h � 12h, et le samedi de 9h � 12h30 et de 14h � 18h30. Ferm� les 1er janvier, 1er mai et 25 d�cembre.", //
						"0101-3112_lu-ve_14h00-18h00,0101-3112_ma-me-je_09h00-12h00,0101-3112_sa_09h00-12h30,0101-3112_sa_14h00-18h30,sauf_0101,sauf_0105,sauf_2512")
				.replace("Lundi, mardi, jeudi, vendredi 9h-13h et 14h00-18h00", //
						"0101-3112_lu-ma-je-ve_09h00-13h00,0101-3112_lu-ma-je-ve_14h00-18h00") //
				.replace("Mardi et jeudi de 9h30 � 12h00 et de 14h00 � 17h00", //
						"0101-3112_ma-je_09h30-12h00,0101-3112_ma-je_14h00-17h00") //
				.replace("Ouvert au public le jeudi de 14h � 17h", //
						"0101-3112_je_14h00-17h00") //
				.replace(
						"Ouvert du Lundi au Samedi de 10h � 18h et Dimanche de 8h30 � 12h (sauf jours f�ri�s)", //
						"0101-3112_lu-ma-me-je-ve-sa_10h00-18h00,0101-3112_di_08h30-12h00,sauf_ferie") //
				.replace(
						"Ouvert du Lundi au Samedi de 10h � 18h et le Dimanche de 8h30 � 12h (sauf jours f�ri�s)", //
						"0101-3112_lu-ma-me-je-ve-sa_10h00-18h00,0101-3112_di_08h30-12h00,sauf_ferie") //
				.replace(
						"Ouvert du Mardi au Samedi de 10h � 17h30 (sauf jours f�ri�s)", //
						"0101-3112_ma+me+je+ve+sa_10h00-17h30,sauf_ferie") //
				.replace(
						"Ouvert le lundi de 13h � 19h ; du mardi au vendredi de 9h � 12h45 et de 13h45 � 19h ; le samedi de 14h � 19h.", //
						"0101-3112_lu_13h00-19h00,0101-3112_ma-me-je-ve_09h00-12h45,0101-3112_ma-me-je-ve_13h45-19h00,0101-3112_sa_14h00-19h00") //
				.replace(
						"Ouvert le Lundi de 14h � 19h, du Mardi au Vendredi de 10h � 13h et de 14h � 19h et le samedi de 10h � 13h et de 14h � 18h", //
						"0101-3112_lu_14h00-19h00,0101-3112_ma-me-je-ve_10h00-13h00,0101-3112_ma-me-je-ve_14h00-19h00,0101-3112_sa_10h00-13h00,0101-3112_sa_14h00-18h00") //
				.replace(
						"Ouvert le Lundi de 14h � 19h, du Mardi au Vendredi de 9h30 � 12h30 et de 14h � 19h et le samedi de 10h � 12h30 et de 14h � 17h", //
						"0101-3112_lu_14h00-19h00,0101-3112_ma-me-je-ve_09h00-12h30,0101-3112_ma-me-je-ve_14h00-19h00,0101-3112_sa_10h00-12h30,0101-3112_sa_14h00-17h00") //
				.replace(
						"Ouvert le lundi de 14h00 � 18h00 - Du mardi au vendredi : 10h00 - 12h30 et de 14h00 � 18h30 - le samedi : 10h00 - 12h30 et de 14h00 � 18h00.", //
						"0101-3112_lu_14h00-18h00,0101-3112_ma+me+je+ve_10h00-12h30+14h00-18h30,0101-3112_sa_10h00-12h30+14h00-18h00") //
				.replace(
						"Ouvert le lundi de 14h15 � 17h45, le mardi et le jeudi de 9h � 12h30 et de 14h15 � 17h45, le mercredi de 9h � 12h et de 14h15 � 17h45, le vendredi de 9h � 12h30 et de 13h30 � 17h30, le samedi de 9h � 12h.", //
						"0101-3112_lu_14h15-17h45,0101-3112_ma-je_09h00-12h30,0101-3112_ma-je_14h15-17h45,0101-3112_me_09h00-12h00,0101-3112_me_14h15-17h45,0101-3112_ve_09h00-12h30,0101-3112_ve_13h30-17h30,0101-3112_sa_09h00-12h00") //
				.replace(
						"Ouvert le mardi, jeudi et vendredi, de 10 h � 12 h et de 14 h � 19 h; le samedi, de 15 h � 18 h.", //
						"0101-3112_ma-je-ve_10h00-12h00,0101-3112_ma-je-ve_14h00-19h00,0101-3112_sa_15h00-18h00") //
				.replace(
						"Ouvert Lundi et Mercredi de 14h � 18h et Samedi de 10h � 18 h (sauf jours f�ri�s)", //
						"0101-3112_lu-ma-me-sa_14h00-18h00,sauf_ferie") //
				.replace(
						"Ouvert Lundi, Mardi, Mercredi, Vendredi et Samedi de 10h � 18h (sauf jours f�ri�s)", //
						"0101-3112_lu-ma-me_10h00-18h00,ve-sa_10h00-18h00,sauf_ferie") //
				.replace(
						"Ouvert tous les jours de 10h � 17h45, dimanche compris (sauf jours f�ri�s)", //
						"0101-3112_lu+ma+me+je+ve+sa+di_10h00-17h45,sauf_ferie") //
				.replace(
						"Ouvert tous les jours de 10h � 18h, dimanche compris (sauf jours f�ri�s)", //
						"0101-3112_lu+ma+me+je+ve+sa+di_10h00-18h00,sauf_ferie"); //
	}
	
}
