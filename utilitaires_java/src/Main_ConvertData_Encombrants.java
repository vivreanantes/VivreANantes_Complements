import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Main_ConvertData_Encombrants extends Abstract_ConvertData {
	public static void main(String[] args) throws XMLStreamException,
			FileNotFoundException {

		String src = FILE_DIRECTORY + RESSOURCES_DIRECTORY
				+ DEUXIEME_VIE_DIRECTORY + "data.xml"; // args[0]
		String dst = FILE_DIRECTORY + RES_DIRECTORY + DEUXIEME_VIE_DIRECTORY
				+ "encombrants_data.csv"; // args[1]
		new Main_ConvertData_Encombrants().convertXMLToCSV(
				new BufferedInputStream(new FileInputStream(src)),
				new BufferedOutputStream(new FileOutputStream(dst)));
	}

	static public final String DEUXIEME_VIE_DIRECTORY = "collecte_encombrants_nantes_metropole_export_kml\\";
	static public final String SEPARATOR_BETWEEN_2_ELEMENTS = ",";

	static public final String QUARTIER_HORS_NANTES = "Hors Nantes";
	static public final String QUARTIER_NANTES = "Nantes";
	static public final String QUARTIER_ORVAULT = "Orvault";
	static public final String QUARTIER_VIARME = "Viarme";
	static public final String QUARTIER_CHANTENAY = "Chantenay";
	static public final String QUARTIER_BREIL = "Breil Dervallières Bellevue";
	static public final String QUARTIER_ERDRE = "Erdre Ranzay Bottière Perray";
	static public final String QUARTIER_MALKOFF = "Malakoff";
	static public final String QUARTIER_BARBERIE = "Nantes Nord Barberie";
	static public final String QUARTIER_SAINT_DONATIEN = "Saint Donatien";

	// static public final String QUARTIER_NANTES = "Nantes";

	static public final String ROOT = "Document";
	static public final String ITEM = "Placemark";
	static public final String ITEM1 = "description"; // possède des données
														// CDATA
	static public final String ITEM2 = "styleUrl";
	static public final String ITEM3 = "objet";
	static public final String ITEM4 = "Point"; // possède un noeud fils

	static public final String COL_A = "code";
	static public final String COL_A_VALUE = "stco_e";
	static public final String COL_B = "name";
	static public final String COL_C = "quartier";
	static public final String COL_D = "modesCollecte";
	static public final String COL_D_VALUE = "modco_encombrants";
	static public final String COL_E = "soustype";
	static public final String COL_E_VALUE = "";
	static public final String COL_F = "adresse";
	static public final String COL_F_VALUE = "";
	static public final String COL_G = "coordinates"; // possède un noeud fils
	static public final String COL_H = "plage_horaire";
	static public final String COL_H_VALUE = "";
	static public final String COL_J = "src";
	static public final String COL_J_VALUE = "Infos reprises de Google Maps publiée par Nantes Métropôle";
	static public final String COL_I = "conseils";
	static public final String COL_I_VALUE = "";
	static public final String COL_K = "type";
	// static public final String COL_K_VALUE = "Point collecte encombrants";
	static public final String COL_K_VALUE = "";
	static public final String COL_L = "description";
	static public final String COL_L_VALUE = "";

	static public final String SEPARATOR = ",";

	public void convertXMLToCSV(InputStream in, OutputStream out)
			throws XMLStreamException {

		PrintWriter writer = new PrintWriter(out);
		XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
				.createXMLStreamReader(in);
		convertXMLToCSV(xmlStreamReader, writer);
	}

	public void convertXMLToCSV(XMLStreamReader xmlStreamReader,
			PrintWriter writer) throws XMLStreamException {

		writer.println(COL_A + SEPARATOR + COL_B + SEPARATOR + COL_C
				+ SEPARATOR + COL_D + SEPARATOR + COL_E + SEPARATOR + COL_F
				+ SEPARATOR + COL_G + SEPARATOR + COL_H + SEPARATOR + COL_I
				+ SEPARATOR + COL_J + SEPARATOR + COL_K + SEPARATOR + COL_L); //

		xmlStreamReader.nextTag();
		List<StoreElement> users = new ArrayList<StoreElement>();
		while (xmlStreamReader.hasNext()) {
			// Récupération du type de l'élement
			int type = xmlStreamReader.next();

			switch (type) {
			case XMLStreamReader.START_ELEMENT:
				// Si c'est un début de balise user, alors on lance le
				// traitement d'un utilisateur
				if ("Placemark".equals(xmlStreamReader.getLocalName()))
					processUser(users, xmlStreamReader);
				break;
			}
		}

		// sortie
		int i = 1;
		for (StoreElement user : users) {
			writer. //
			append(esc(user.getItem00() + i)).append(SEPARATOR). //
					append(esc(user.getItem0())).append(SEPARATOR). //
					append(esc(user.getItem1())).append(SEPARATOR). //
					append(esc(user.getItem2())).append(SEPARATOR). //
					append(esc(user.getItem3())).append(SEPARATOR). //
					append(esc(user.getItem4())).append(SEPARATOR). //
					append(esc(user.getItem5())).append(SEPARATOR). //
					append(esc(user.getItem6())).append(SEPARATOR). //
					append(esc(user.getItem7())).append(SEPARATOR). //
					append(esc(user.getItem8())).append(SEPARATOR). //
					append(esc(user.getItem9())).append(SEPARATOR). //
					append(esc(user.getItem10())).append(SEPARATOR). //
					append(esc(user.getItem11())).append(SEPARATOR). //
					append(esc(user.getItem12())).append(SEPARATOR). //
					append(esc(user.getItem13())).append(SEPARATOR). //
					append(esc(user.getItem14())).append(SEPARATOR). //
					append(esc(user.getItem15())).append(SEPARATOR). //
					append(esc(user.getItem16())); //
			i++;

			writer.println();
		}
		// xmlStreamReader.require(XMLStreamConstants.END_ELEMENT, null, ROOT);
		writer.close();
		System.out.println("Conversion terminée.");
	}

	private static void processUser(List<StoreElement> users,
			XMLStreamReader reader) throws XMLStreamException {

		int flag = 0;
		final int FLAG_NONE = 0;
		final int FLAG_USERNAME = 1;
		final int FLAG_PASSWORD = 2;
		final int FLAG_DESCRIPTION = 3;

		String description = "";
		String quartier = "";
		String name = "";
		String plage_horaire = "";
		String coordinates = "";

		boolean state = true;
		while (reader.hasNext() && state) {
			int type = reader.next();

			switch (type) {
			// Si c'est un début d'elément, on garde son type
			case XMLStreamReader.START_ELEMENT:
				if (reader.getLocalName().equals("name"))
					flag = FLAG_USERNAME;
				else if (reader.getLocalName().equals("coordinates"))
					flag = FLAG_PASSWORD;
				else if (reader.getLocalName().equals("description"))
					flag = FLAG_DESCRIPTION;
				else
					flag = FLAG_NONE;
				break;

			// Si c'est du texte ou une zone CDATA ...
			case XMLStreamReader.CDATA:
			case XMLStreamReader.CHARACTERS:
				switch (flag) {
				case FLAG_DESCRIPTION:
					// et que ce n'est pas une chaîne de blancs
					if (!(reader.isWhiteSpace())) {
						description = reader.getText();
					}
					description = description
							.replaceAll("<div dir=\"ltr\">", "")
							.replace("</div>", "").replace("<br>", "");
					// La collecte des encombrants pour l&#39;habitat vertical ou habitat collectif a lieu à cette adresse 
					plage_horaire = description
							.replace(
									"La collecte des encombrants pour l&#39;habitat vertical ou habitat collectif a lieu à cette adresse ",
									"");
					break;
				case FLAG_PASSWORD:
					// et que ce n'est pas une chaine de blanc
					if (!(reader.isWhiteSpace())) {
						coordinates = reader.getText();
					}
					break;
				case FLAG_USERNAME:
					// et que ce n'est pas une chaine de blanc
					if (!(reader.isWhiteSpace())) {
						name = reader.getText();
					}
					quartier = name
							.replace(
									"Collecte encombrants en habitat vertical - Quartier ",
									"")
							.replace(
									"habitat vertical ou habitat collectif a lieu à cette adresse tous les vendredi après-midis de chaque mois.",
									"").replace("Repère 44", "")
							.replace("Repère 45", "");
					break;
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				// Si c'est la fin de la balise user, on change l'indicateur de
				// boucle
				if (reader.getLocalName().equals("Placemark"))
					state = false;
				break;
			}
		}
		StoreElement elt = new StoreElement(COL_A_VALUE, name, quartier,
				COL_D_VALUE, COL_E_VALUE, COL_F_VALUE, coordinates,
				plage_horaire, COL_I_VALUE, COL_J_VALUE, COL_K_VALUE,
				description, "", "", "", "", "", "");

		users.add(elt);
		// users.add(UserBuilder.createUser());
	}


	private String esc(String string) {

		if (string.indexOf(',') != -1)
			string = '"' + string + '"';
		return string;
	}


	private String translateName(String town) {
		return town.replaceAll("CEDEX", "");
	}

}