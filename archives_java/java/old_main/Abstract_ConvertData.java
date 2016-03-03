import org.apache.xpath.operations.String;

public abstract class Abstract_ConvertData {

	static public final String FILE_DIRECTORY = "C:\\dev\\github-repositories\\VivreANantes_Complements\\utilitaires_java\\";
	static public final String RESSOURCES_DIRECTORY = "in\\";
	static public final String RES_DIRECTORY = "out\\";
	static public final String BRBR = "<br/><br/>";

	static public final String HORAIRES_01 = "Depots des dons : Mardi, mercredi, vendredi et le samedi de 9h30 à 11h30 et de 13h30 à 16h30. Salle de vente : Le mercredi de 13h30 à 17h30 et le samedi de 9h30 à 11h30 et de 13h30 à 17h30.";
	static public final String HORAIRES_02 = "La boutique est ouverte tous les mercredi et samedi de 9h30 à 12h et de 14h à 16h45. Chacun peut �galement venir y d�poser les objets encore utilisables, aux m�mes jours et heures d�ouverture.";
	static public final String HORAIRES_03 = "Le Samedi de 9h30 à 12h, et en semaine selon les horaires suivants : Meubles : Lundi, Mardi, Mercredi, Jeudi de 14h30 à 17h, Vestiaire : Mardi, un  Mercredi sur deux ( non distribution alimentaire ), Jeudi  :  10h a 12h et de 14h30 à 16h30, Jouets : Mardi et Jeudi de 10h à 12h et de 14h30 à 16h30, Biblioth�que : Jeudi de 14h30 à 16h30.  Les d�pots de v�tements, livres, jouets, vaisselle, bibelots peuvent se faire tous les jours, de 9h à 12 h et de 14h30 à 16h30. De pr�f�rence, venez le lundi et le samedi matin. D�pots de meubles toutes les apr�s-midi, du lundi au jeudi, de 14 h à 17 h. ";
	static public final String HORAIRES_04 = "Lundi de 14h à 18h, mercredi de 08h30 à 12h30, et samedi de 09h à 12h30 et de 14h à 18h. Ferm� les 1er janvier, 1er mai et 25 decembre.";
	static public final String HORAIRES_05 = "Lundi de 8h30 à 12h30, mercredi de 14h à 18h et samedi de 9h à 12h30 et de 14h à 18h. Ferm� les 1er janvier, 1er mai et 25 decembre.";
	static public final String HORAIRES_06 = "Lundi et vendredi de 14h à 18h, du mardi au jeudi de 9h à 12h, et le samedi de 9h à 12h30 et de 14h à 18h30. Ferm� les 1er janvier, 1er mai et 25 decembre.";
	static public final String HORAIRES_07 = "La boutique est ouverte tous les mercredi et samedi de 9h30 à 12h et de 14h à 16h45. Chacun peut également venir y déposer les objets encore utilisables, aux mêmes jours et heures d’ouverture.";
	static public final String HORAIRES_08 = "Dépôts des dons : Mardi, mercredi, vendredi et le samedi de 9h30 à 11h30 et de 13h30 à 16h30. Salle de vente : Le mercredi de 13h30 à 17h30 et le samedi de 9h30 à 11h30 et de 13h30 à 17h30.";
	static public final String HORAIRES_09 = "Boutiques PANNECE - jeudi 14h/17h30 et samedi 9h30/12h30 Boutique BELLIGNE - Lundi 9h/12h et samedi 9h/12h Boutique LE CELLIER - Vendredi 14h/17h et samedi 9h/12h horaires dépots: du mardi au samedi de 9h30 à 12h30 et le jeudi de 14h à 17h30 Possibilité de collecte à domicile";
	static public final String HORAIRES_10 = "Dépôt d'objets réutilisables : lundi-samedi de 9h à 12h Boutique solidaire : le samedi de 10h à 18h";
	static public final String HORAIRES_11 = "Le Samedi de 9h30 à 12h, et en semaine selon les horaires suivants : Meubles : Lundi, Mardi, Mercredi, Jeudi de 14h30 à 17h, Vestiaire : Mardi, un  Mercredi sur deux ( non distribution alimentaire ), Jeudi  :  10h à12h et de 14h30 à 16h30, Jouets : Mardi et Jeudi de 10h à 12h et de 14h30 à 16h30, Bibliothèque : Jeudi de 14h30 à 16h30.  Les dépots de vêtements, livres, jouets, vaisselle, bibelots peuvent se faire tous les jours, de 9h à 12 h et de 14h30 à 16h30. De préférence, venez le lundi et le samedi matin. Dépots de meubles toutes les après-midi, du lundi au jeudi, de 14 h à 17 h. ";

	protected String addComment(String horaires) {
		String result = "";
		switch (horaires) {
		case HORAIRES_01:
			result = BRBR + HORAIRES_01;
			break;
		case HORAIRES_02:
			result = BRBR + HORAIRES_02;
			break;
		case HORAIRES_03:
			result = BRBR + HORAIRES_03;
			break;
		case HORAIRES_04:
			result = BRBR + HORAIRES_04;
			break;
		case HORAIRES_05:
			result = BRBR + HORAIRES_05;
			break;
		case HORAIRES_06:
			result = BRBR + HORAIRES_06;
			break;
		case HORAIRES_07:
			result = BRBR + HORAIRES_07;
			break;
		case HORAIRES_08:
			result = BRBR + HORAIRES_08;
			break;
		case HORAIRES_09:
			result = BRBR + HORAIRES_09;
			break;
		case HORAIRES_10:
			result = BRBR + HORAIRES_10;
			break;
		case HORAIRES_11:
			result = BRBR + HORAIRES_11;
			break;
		}
		return result;
	}

	protected String tranlateHoraires(String horaires) {
		String result = "";

		switch (horaires) {
		case " &#201;t&#233; (Du 1er avril au 30 septembre) : Lundi au Samedi de 9h à 19h. Dimanche de 9h à 12h15. Hiver (du 1er octobre au 31 mars) : Lundi au Samedi de 9h à 18h. Dimanche de 9h à 12h15. Fermeture les jours fériés.":
			result = "0109-3103_lu+ma+me+je+ve+sa_09h00-18h00,0104-3008_lu+ma+me+je+ve+sa_09h00-18h00,0101-3112_di_09h00-12h15,sauf_ferie";
			break;
		case " &#201;t&#233; (Du 1er avril au 30 septembre) : Lundi au Vendredi de 10h à 12h15 et de 14h30 à 19h. Samedi de 9h à 12h15 et de 14h30 à 19h. Hiver (du 1er octobre au 31 mars) : Lundi au Samedi de 9h à 12h15 et de 14h30 à 18h. Fermeture les jours fériés.":
			result = "3009-3103_lu+ma+me+je+ve+sa_09h00-12h15,3009-3103_lu+ma+me+je+ve+sa_14h30-19h00,0104-3009_lu+ma+me+je+ve+sa_10h00-12h15,0104-3009_lu+ma+me+je+ve+sa_14h30-18h00,sauf_ferie";
			break;
		case " &#201;t&#233; (Du 1er avril au 30 septembre) : Lundi de 14h30 à 19h, Mardi au Samedi de 9h à 12h30 et de 14h à 19h, Dimanche de 9h à 12h30. Hiver (du 1er octobre au 31 mars) : Lundi de 14h30 à 18h, Mardi au Samedi de 9h à 12h30 et de 14h à 18h, Dimanche de 9h à 12h30. Fermeture les jours fériés.":
			result = "3009-0104_lu_14h30-19h00,3009-3103_ma+me+je+ve+sa_09h00-12h30,3009-3103_ma+me+je+ve+sa_14h00-19h00,0104-3103_lu_14h30-18h00,0104-3103_ma+me+je+ve+sa_09h00-12h30,0104-3103_ma+me+je+ve+sa_14h00-18h00,0104-3103_di_09h00-12h30,sauf_ferie";
			break;
		case " &#201;t&#233; (Du 1er avril au 30 septembre) : Lundi et mercredi de 14h30 à 19h, samedi de 9h à 12h15 et de 14h30 à 19h. Hiver (du 1er octobre au 31 mars) : Lundi et mercredi de 14h30 à 18h, samedi de 9h à 12h15 et de 14h30 à 18h. Fermeture les jours fériés.":
			result = "3009-0104_lu+me_14h30-19h00,3009-3103_sa_09h00-12h15,3009-3103_sa_14h30-19h00,0104-3103_lu+me_14h30-1800,0104-3103_sa_09h00-12h15,0104-3103_sa_14h30-18h00,sauf_ferie";
			break;
		case "D�p�t d'objets r�utilisables : lundi-samedi de 9h à 12h Boutique solidaire : le samedi de 10h à 18h":
			result = "0101-3112_lu+ma+me+je+ve_12h00-14h00";
			break;
		case HORAIRES_01: // Horaires mis en plus en commentaires
			result = "0101-3112_lu+ma+me+je+ve_12h00-14h00";
			break;
		case "Du lundi au jeudi : de 10h à 12h30 et de 14h30 à 19h00 ; Le vendredi : 10h00 à 19h00 ; Le samedi : 10h00 à 12h30 et de 14h30 à 18h30":
			result = "0101-3112_lu+ma+me+je_10h00-12h30,0101-3112_lu+ma+me+je_14h30-19h00,0101-3112_ve_10h00-19h00,0101-3112_sa_10h00-12h30,0101-3112_sa_14h30-18h30";
			break;
		case "Du lundi au jeudi de 9h00 à 12h30 et de 14h00 à 17h00. Le vendredi de 9h00 à 12h30 et de 14h00 à 16h00.":
			result = "0101-3112_lu+ma+me+je_12h00-14h00,0101-3112_lu+ma+me+je_14h00-17h00,0101-3112_ve_09h00-12h30,0101-3112_ve_14h00-16h00";
			break;
		case "Du lundi au samedi de 10h à 13h et de 14h à 19h":
			result = "0101-3112_lu+ma+me+je+ve+sa_10h00-13h00,0101-3112_lu+ma+me+je+ve+sa_14h00-19h00";
			break;
		case "Du lundi au samedi de 8 heures à 20 heures.":
			result = "0101-3112_lu+ma+me+je+ve+sa_08h00-20h00";
			break;
		case "du lundi au vendredi 7h00-19h00 et le samedi 8h00-19h00":
			result = "0101-3112_lu+ma+me+je+ve_07h00-19h00,0101-3112_sa_08h00-19h00";
			break;
		case "Du lundi au vendredi de 10h à 12h30 et de 14h à 19h00. Le samedi de 10h à 12h30 et de 14h à 18h30":
			result = "0101-3112_lu+ma+me+je+ve_10h00-12h30,0101-3112_lu+ma+me+je+ve_14h00-19h00,0101-3112_sa_10h00-12h30,0101-3112_sa_14h00-18h30";
			break;
		case "Du lundi au vendredi de 10h à 19h00 et le samedi de 10h à 12h et de 14h à 18h30":
			result = "0101-3112_lu+ma+me+je+ve_10h00-19h00,0101-3112_sa_10h00-12h00,0101-3112_sa_14h00-18h30";
			break;
		case "Du lundi au vendredi de 10h à 19h00 et le samedi de 10h à 18h30":
			result = "0101-3112_lu+ma+me+je+ve_10h00-19h00";
			break;
		case "Du lundi au vendredi de 10h à 19h00. Le samedi de 10h à 18h30":
			result = "0101-3112_lu+ma+me+je+ve_12h00-14h00,0101-3112_sa_10h00-18h30";
			break;
		case "Du lundi au vendredi de 8h à 12h et de 13h à 17h.":
			result = "0101-3112_lu+ma+me+je+ve_08h00-12h00+13h00-17h00";
			break;
		case "du lundi au vendredi de 8h à 12h30 et de 14h à 19h ainsi que le samedi matin de 9h à 12h30":
			result = "0101-3112_lu+ma+me+je+ve_08h00-12h30,0101-3112_lu+ma+me+je+ve_14h00-19h00,0101-3112_sa_09h00-12h30";
			break;
		case "Du lundi au vendredi de 9h00 à 12h30 et de 14h00 à 18h00.":
			result = "0101-3112_lu+ma+me+je+ve_09h00-12h30,0101-3112_lu+ma+me+je+ve_14h00-18h00";
			break;
		case "Du lundi au vendredi de 9h00 à 18h00.":
			result = "0101-3112_lu+ma+me+je+ve_09h00-18h00";
			break;
		case "Du lundi au vendredi, 9h-12h et 14h-18h":
			result = "0101-3112_lu+ma+me+je+ve_09h00-12h00,0101-3112_lu+ma+me+je+ve_14h00-18h00";
			break;
		case "Du mardi au samedi de 10h à 12h30 et de 14h30 à 19h":
			result = "0101-3112_ma+me+je+ve+sa_12h00-14h00,0101-3112_ma+me+je+ve+sa_14h30-19h00";
			break;
		case "Du mardi au samedi de 10h à 19h, le lundi de 14h à 19h":
			result = "0101-3112_ma+me+je+ve+sa_10h00-19h00,0101-3112_lu_14h00-19h00";
			break;
		case "ETE (du 2 mai au 30 septembre) : du lundi au jeudi de 10h à 12h et de 14h à 18h. Vendredi et samedi : de 9h à 12h30 et de 13h30 à 18h. HIVER : (du 1er octobre au 31 avril) : lundi de 14h à 18h, du mardi au vendredi de 10h à 12h et de 14h à 18h, et le samedi de 10h à 12h et de 13h à 18h. Ferm� les 1er janvier, 1er mai et 25 d�cembre.":
			result = "3009-0205_lu+ma+me+je_10h00-12h00,3009-0205_lu+ma+me+je_14h00-18h00,3009-0205_ve+sa_09h00-12h30,3009-0205_ve+sa_13h30-18h00,0110-3104_lu_14h00-18h00,0110-3104_ma+ve_10h00-12h00,0110-3104_ma+ve_14h00-18h00,0110-3104_sa_10h00-12h00,0110-3104_sa_13h00-18h00,sauf_0101,sauf_0105,sauf_2512";
			break;
		case "Ferme le mercredi apres midi et le vendredi. Devis meuble le mardi de 14 a 17h et le jeudi de 9 a 12h.":
			result = "0101-3112_lu+ma+me+je+ve_12h00-14h00";
			break;
		case HORAIRES_02: // Horaires mis en plus en commentaires
			result = "0101-3112_lu+ma+me+je+ve_12h00-14h00";
			break;
		case "Le magasin est ouvert du mardi au samedi de 9h30 à 12h30 et de 13h30 à 18h":
			result = "0101-3112_ma+me+je+ve+sa_09h30-12h30,0101-3112_ma+me+je+ve+sa_13h30-18h00";
			break;
		case "Le mardi de 10h à 12 h.":
			result = "0101-3112_ma_10h00-12h00";
			break;
		case "le MERCREDI de 9 h à 12 h, le SAMEDI de 9 h à 12 h 30":
			result = "0101-3112_me_09h00-12h00,0101-3112_sa_09h00-12h30";
			break;
		case "le MERCREDI de 9 h à 17 h 30, le SAMEDI de 9 h à 17 h 30":
			result = "0101-3112_me_09h00-17h30,0101-3112_sa_09h00-17h30";
			break;
		case HORAIRES_03: // Horaires mis en plus en commentaires
			result = "0101-3112_lu+ma+me+je+ve_12h00-14h00";
			break;
		case "Lundi à Vendredi 9h-13h et 14h30-18h30":
			result = "0101-3112_lu+ma+me+je+ve_09h00-13h00,0101-3112_lu+ma+me+je+ve_14h30-18h30";
			break;
		case "Lundi au Samedi de 09H00 à 19H00":
			result = "0101-3112_lu+ma+me+je+ve+sa_09h00-19h00";
			break;
		case HORAIRES_04: // Horaires mis en plus en commentaires
			result = "0101-3112_lu_14h00-18h00,0101-3112_me_08h30-12h30,0101-3112_sa_09h00-12h30,0101-3112_sa_14h00-18h00,sauf_0101,sauf_0105,sauf_2512";
			break;
		case HORAIRES_05: // Horaires mis en plus en commentaires
			result = "0101-3112_lu_08h30-12h30,0101-3112_me_14h00-18h00,0101-3112_sa_09h00-12h30,0101-3112_sa_14h00-18h00,sauf_0101,sauf_0105,sauf_2512";
			break;
		case HORAIRES_06: // Horaires mis en plus en commentaires
			result = "0101-3112_lu+ve_14h00-18h00,0101-3112_ma+me+je_09h00-12h00,0101-3112_sa_09h00-12h30,0101-3112_sa_14h00-18h30,sauf_0101,sauf_0105,sauf_2512";
			break;
		case "Lundi, mardi, jeudi, vendredi 9h-13h et 14h00-18h00":
			result = "0101-3112_lu+ma+je+ve_09h00-13h00,0101-3112_lu+ma+je+ve_14h00-18h00";
			break;
		case "Mardi et jeudi de 9h30 à 12h00 et de 14h00 à 17h00":
			result = "0101-3112_ma+je_09h30-12h00,0101-3112_ma+je_14h00-17h00";
			break;
		case "Ouvert au public le jeudi de 14h à 17h":
			result = "0101-3112_je_14h00-17h00";
			break;
		case "Ouvert du Lundi au Samedi de 10h à 18h et Dimanche de 8h30 à 12h (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+ve+sa_10h00-18h00,0101-3112_di_08h30-12h00,sauf_ferie";
			break;
		case "Ouvert du Lundi au Samedi de 10h à 18h et le Dimanche de 8h30 à 12h (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+ve+sa_10h00-18h00,0101-3112_di_08h30-12h00,sauf_ferie";
			break;
		case "Ouvert du Mardi au Samedi de 10h à 17h30 (sauf jours fériés)":
			result = "0101-3112_ma+me+je+ve+sa_10h00-17h30,sauf_ferie";
			break;
		case "Ouvert le lundi de 13h à 19h ; du mardi au vendredi de 9h à 12h45 et de 13h45 à 19h ; le samedi de 14h à 19h.":
			result = "0101-3112_lu_13h00-19h00,0101-3112_ma+me+je+ve_09h00-12h45,0101-3112_ma+me+je+ve_13h45-19h00,0101-3112_sa_14h00-19h00";
			break;
		case "Ouvert le Lundi de 14h à 19h, du Mardi au Vendredi de 10h à 13h et de 14h à 19h et le samedi de 10h à 13h et de 14h à 18h":
			result = "0101-3112_lu_14h00-19h00,0101-3112_ma+me+je+ve_10h00-13h00,0101-3112_ma+me+je+ve_14h00-19h00,0101-3112_sa_10h00-13h00,0101-3112_sa_14h00-18h00";
			break;
		case "Ouvert le Lundi de 14h à 19h, du Mardi au Vendredi de 9h30 à 12h30 et de 14h à 19h et le samedi de 10h à 12h30 et de 14h à 17h":
			result = "0101-3112_lu_14h00-19h00,0101-3112_ma+me+je+ve_09h00-12h30,0101-3112_ma+me+je+ve_14h00-19h00,0101-3112_sa_10h00-12h30,0101-3112_sa_14h00-17h00";
			break;
		case "Ouvert le lundi de 14h00 à 18h00 - Du mardi au vendredi : 10h00 - 12h30 et de 14h00 à 18h30 - le samedi : 10h00 - 12h30 et de 14h00 à 18h00.":
			result = "0101-3112_lu_14h00-18h00,0101-3112_ma+me+je+ve_10h00-12h30+14h00-18h30,0101-3112_sa_10h00-12h30+14h00-18h00";
			break;
		case "Ouvert le lundi de 14h15 à 17h45, le mardi et le jeudi de 9h à 12h30 et de 14h15 à 17h45, le mercredi de 9h à 12h et de 14h15 à 17h45, le vendredi de 9h à 12h30 et de 13h30 à 17h30, le samedi de 9h à 12h.":
			result = "0101-3112_lu_14h15-17h45,0101-3112_ma+je_09h00-12h30,0101-3112_ma+je_14h15-17h45,0101-3112_me_09h00-12h00,0101-3112_me_14h15-17h45,0101-3112_ve_09h00-12h30,0101-3112_ve_13h30-17h30,0101-3112_sa_09h00-12h00";
			break;
		case "Ouvert le mardi, jeudi et vendredi, de 10 h à 12 h et de 14 h à 19 h; le samedi, de 15 h à 18 h.":
			result = "0101-3112_ma+je+ve_10h00-12h00,0101-3112_ma+je+ve_14h00-19h00,0101-3112_sa_15h00-18h00";
			break;
		case "Ouvert Lundi et Mercredi de 14h à 18h et Samedi de 10h à 18 h (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+sa_14h00-18h00,sauf_ferie";
			break;
		case "Ouvert Lundi, Mardi, Mercredi, Vendredi et Samedi de 10h à 18h (sauf jours fériés)":
			result = "0101-3112_lu+ma+me_10h00-18h00,ve+sa_10h00-18h00,sauf_ferie";
			break;
		case "Ouvert tous les jours de 10h à 17h45, dimanche compris (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+ve+sa+di_10h00-17h45,sauf_ferie";
			break;
		case "Ouvert tous les jours de 10h à 18h, dimanche compris (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+ve+sa+di_10h00-18h00,sauf_ferie";
			break;
		case "Ouvert tous les jours de 10h à  17h45, dimanche compris (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+ve+sa+di_10h00-17h45,sauf_ferie";
			break;
		case HORAIRES_07: // Horaires mis en plus en commentaires
			result = "0101-3112_me+sa_09h30-12h00+14h00-16h45";
			break;
		case "Ouvert tous les jours de 10h à  18h, dimanche compris (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+ve+sa+di_10h00-18h00,sauf_ferie";
			break;
		case "Pour effectuer vos dépôts : du lundi au samedi de 8h00 à  11h30 et de 14h à  17h30":
			result = "0101-3112_lu+ma+me+je+ve+sa_08h00-11h30+14h00-17h30";
			break;
		case "Ouvert Lundi, Mardi, Mercredi, Vendredi et Samedi de 10h à  18h (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+ve+sa_10h00-18h00,sauf_ferie";
			break;
		case " Été (Du 1er avril au 30 septembre) : Lundi au Samedi de 9h à 19h. Dimanche de 9h à 12h15. Hiver (du 1er octobre au 31 mars) : Lundi au Samedi de 9h à 18h. Dimanche de 9h à 12h15. Fermeture les jours fériés.":
			result = "0104-3008_lu+ma+me+je+ve+sa_09h00-19h00,0104-3008_di_09h00-12h15,0101-3103+0109-3112_lu+ma+me+je+ve+sa_09h00-18h00,0101-3103+0109-3112_di_09h00-12h15,sauf_ferie";
			break;
		case "Ouvert du Lundi au Samedi de 10h à  18h et le Dimanche de 8h30 à  12h (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+ve+sa_10h00-18h00,0101-3112_di_08h30-12h00,sauf_ferie";
			break;
		case "Ouvert Lundi et Mercredi de 14h à  18h et Samedi de 10h à  18 h (sauf jours fériés)":
			result = "0101-3112_lu+ma+me_14h00-18h00,0101-3112_sa_10h00-18h00,sauf_ferie";
			break;
		case HORAIRES_08: // Horaires mis en plus en commentaires
			result = "0101-3112_ma+me+ve+sa_09h30-11h30+13h30-16h30,0101-3112_me_13h30-17h30,0101-3112_sa_09h30-11h30+13h30-17h30,";
			break;
		case "Ouvert le Lundi de 14h à  19h, du Mardi au Vendredi de 10h à  13h et de 14h à  19h et le samedi de 10h à  13h et de 14h à  18h":
			result = "0101-3112_lu_14h00-19h00,0101-3112_ma+me+je+ve_10h00-13h00+14h00-19h00,0101-3112_sa_10h00-13h00+14h00-18h00";
			break;
		case "du lundi au samedi de 10h à 18h30":
			result = "0101-3112_lu+ma+me+je+ve+sa_10h00-18h30";
			break;
		case "Du lundi au vendredi de 9h00 à  18h00.":
			result = "0101-3112_lu+ma+me+je+ve_09h00-18h00";
			break;
		case "Ouvert le Lundi de 14h à  19h, du Mardi au Vendredi de 9h30 à  12h30 et de 14h à  19h et le samedi de 10h à  12h30 et de 14h à  17h":
			result = "0101-3112_lu_14h00-19h00,0101-3112_ma+me+je+ve_09h30-12h30+14h00-19h00,0101-3112_sa_10h00-12h30+14h00-17h00";
			break;
		case "Du lundi au vendredi de 9h00 à  12h30 et de 14h00 à  18h00.":
			result = "0101-3112_lu+ma+me+je+ve_09h00-12h30+14h00-18h00,";
			break;
		case " Été (Du 1er avril au 30 septembre) : Lundi au Vendredi de 10h à 12h15 et de 14h30 à 19h. Samedi de 9h à 12h15 et de 14h30 à 19h. Hiver (du 1er octobre au 31 mars) : Lundi au Samedi de 9h à 12h15 et de 14h30 à 18h. Fermeture les jours fériés.":
			result = "0104-3008_lu+ma+me+je+ve_10h00-12h15+14h30-19h00,0104-3008_sa_09h00-12h15+14h30-19h00,0101-3103+0109-3112_lu+ma+me+je+ve+sa_09h00-12h15+14h30-18h00,sauf_ferie";
			break;
		case HORAIRES_09: // Horaires mis en plus en commentaires
			result = "0101-3112_je_14h00-17h30,0101-3112_sa_09h30-12h30,0101-3112_lu+sa_09h00-12h00,0101-3112_ve_14h00-17h00,0101-3112_sa_09h00-12h00,0101-3112_ma+me+je+ve+sa_09h30-12h30,0101-3112_je_14h00-17h30,";
			break;
		case "Ouvert du Lundi au Samedi de 10h à  18h et Dimanche de 8h30 à  12h (sauf jours fériés)":
			result = "0101-3112_lu+ma+me+je+sa_10h00-18h00,0101-3112_di_08h30-12h00,,sauf_ferie";
			break;
		case HORAIRES_10: // Horaires mis en plus en commentaires
			result = "0101-3112_lu+ma+me+je+ve_09h00-12h00,0101-3112_sa_10h00-18h00";
			break;
		case HORAIRES_11: // Horaires mis en plus en commentaires
			result = "0101-3112_lu+ma+me+je+ve+sa+di_00h00-23h59";
			break;
		case "du lundi au jeudi de 9h à 12h30 et de 13h30 à 18h et le vendredi à 17h":
			result = "0101-3112_lu+ma+me+je_09h00-12h30+13h30-18h00,0101-3112_ve_09h00-12h30+13h30-17h00";
			break;
		case "Tous les jours du lundi au vendredi de 9h à 12h et de 14h à 17h":
			result = "0101-3112_lu+ma+me+je+ve_09h00-12h00+14h00-17h00";
			break;
		case "Ouvert du Mardi au Samedi de 10h à  17h30 (sauf jours fériés)":
			result = "0101-3112_ma+me+je+ve+sa_10h00-17h30,sauf_ferie";
			break;
		case "Le jeudi de 9h à 12h et de 14h à 17h30 ":
			result = "0101-3112_je_09h00-12h00+14h00-17h30";
			break;
		}
		return result;
	}
}
