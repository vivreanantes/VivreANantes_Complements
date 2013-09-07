import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Main_ConvertData_DeuxiemeVie extends Abstract_ConvertData {
	
	public static void main(String[] args) throws XMLStreamException,
			FileNotFoundException {

		String src = FILE_DIRECTORY + RESSOURCES_DIRECTORY
				+ DEUXIEME_VIE_DIRECTORY + "data.xml"; // args[0]
		String dst = FILE_DIRECTORY + RES_DIRECTORY + DEUXIEME_VIE_DIRECTORY
				+ "deuxieme_vie_data.csv"; // args[1]
		new Main_ConvertData_DeuxiemeVie().convertXMLToCSV(
				new BufferedInputStream(new FileInputStream(src)),
				new BufferedOutputStream(new FileOutputStream(dst)));
	}



	static public final String DEUXIEME_VIE_DIRECTORY = "deuxieme_vie\\";
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

	static public final String ROOT = "markers";
	static public final String ITEM = "marker";
	static public final String ITEM0 = "lat";
	static public final String ITEM1 = "lng";
	static public final String ITEM2 = "category";
	static public final String ITEM3 = "objet";
	static public final String ITEM4 = "nom";
	static public final String ITEM5 = "adresse";
	static public final String ITEM6 = "codepostal";
	static public final String ITEM7 = "ville";
	static public final String ITEM8 = "commentaire";
	static public final String ITEM9 = "horaire";
	static public final String ITEM10 = "telephone";
	static public final String ITEM11 = "fax";
	static public final String ITEM12 = "courriel";
	static public final String ITEM13 = "siteinternet";

	static public final String NEW_ITEM_CODE = "code";
	static public final String NEW_ITEM_CODE_VALUE = "stco_reemploi";
	static public final String NEW_ITEM_SRC_ = "src";
	static public final String NEW_ITEM_SRC__VALUE = "deuxiemeVie";
	static public final String NEW_ITEM2 = "modesCollecte";
	static public final String NEW_ITEM3 = "string_horaires";
	static public final String NEW_ITEM3_VALUE = " ";
	static public final String NEW_ITEM4 = "quartier";
	static public final String NEW_ITEM4_VALUE = " ";
	static public final String NEW_ITEM5 = "type";
	static public final String NEW_ITEM5_VALUE_DECHETERIE = "modco_decheterie";
	static public final String NEW_ITEM5_VALUE_ECOPOINT = "modco_ecopoint";
	static public final String NEW_ITEM5_VALUE_REEMPLOI = "modco_reemploi";
	static public final String NEW_ITEM6_VALUE_REEMPLOI = "Récupération";
	static public final String NEW_ITEM6_VALUE_ECOPOINT = "Ecopoint";
	static public final String NEW_ITEM6_VALUE_DECHETERIE = "Décheterie";

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
		System.out.println("Conversion commencée...");

		Map<String, StoreElement> storeElements = new HashMap<String, StoreElement>();

		writer.println(NEW_ITEM_CODE + SEPARATOR + ITEM0 + SEPARATOR + ITEM1
				+ SEPARATOR + ITEM2
				+ SEPARATOR
				+ ITEM3 //
				+ SEPARATOR + ITEM4 + SEPARATOR + ITEM5
				+ SEPARATOR
				+ ITEM6 //
				+ SEPARATOR + ITEM7 + SEPARATOR + ITEM8
				+ SEPARATOR
				+ ITEM9 //
				+ SEPARATOR + ITEM10 + SEPARATOR + ITEM11
				+ SEPARATOR
				+ ITEM12 //
				+ SEPARATOR + ITEM13 + SEPARATOR + NEW_ITEM_SRC_
				+ SEPARATOR
				+ NEW_ITEM2 //
				+ SEPARATOR + NEW_ITEM3 + SEPARATOR + NEW_ITEM4 + SEPARATOR
				+ NEW_ITEM5); //
		xmlStreamReader.nextTag();
		// <MARKERS>
		xmlStreamReader.require(XMLStreamConstants.START_ELEMENT, null, ROOT);
		while (xmlStreamReader.hasNext()) {
			// <MARKER> ou </MARKERS>
			xmlStreamReader.nextTag();
			if (xmlStreamReader.isEndElement()) {
				break;
			}
			xmlStreamReader.require(XMLStreamConstants.START_ELEMENT, null,
					ITEM);

			String name = xmlStreamReader.getAttributeValue(7);
			String category = xmlStreamReader.getAttributeValue(2);
			String object = xmlStreamReader.getAttributeValue(3);
			String collectMod = "";
			String type = "";
			if (category.equals("Dechetterie")) {
				if (name.equals("CHANTENAY") || name.equals("DERVALLIERES")
						|| name.equals("VIARME") || name.equals("LA BEAUJOIRE")) {
					collectMod = NEW_ITEM5_VALUE_ECOPOINT;
					type = NEW_ITEM6_VALUE_ECOPOINT;

				} else {
					collectMod = NEW_ITEM5_VALUE_DECHETERIE;
					type = NEW_ITEM6_VALUE_DECHETERIE;
				}
			} else {
				collectMod = NEW_ITEM5_VALUE_REEMPLOI;
				type = NEW_ITEM6_VALUE_REEMPLOI;
			}
			String columnA = NEW_ITEM_CODE_VALUE;
			String itemA = xmlStreamReader.getAttributeValue(0);
			String itemB = xmlStreamReader.getAttributeValue(1);

			String columnD = type;

			String columnE = object;
			String itemE = xmlStreamReader.getAttributeValue(4);
			String itemF = xmlStreamReader.getAttributeValue(5);
			String itemG = xmlStreamReader.getAttributeValue(6);

			String itemH = name;
			String townInInnerCase = translateName(name);

			String itemI = xmlStreamReader.getAttributeValue(8);
			String horaires = xmlStreamReader.getAttributeValue(9);
			String itemJ = horaires;
			String itemK = xmlStreamReader.getAttributeValue(10);
			String itemL = xmlStreamReader.getAttributeValue(11);
			String itemM = xmlStreamReader.getAttributeValue(12);
			String itemN = xmlStreamReader.getAttributeValue(13);
			String itemO = NEW_ITEM_SRC__VALUE;
			String itemP = category.replaceAll("Entreprise", "smco_reemp"). //
					replaceAll("Association", "smco_reemp"). //
					replaceAll("Dechetterie", "modco_decheterie") + //
					object.replaceAll("Dechets", ""). //
							replaceAll("Informatique", "info"). //
							replaceAll("Electromenager", "electromenag"). //
							replaceAll("Cartouche", "cartouchetoner"). //
							replaceAll("Livres_Revue_CD_BD", "livreCD"). //
							replaceAll("Meuble", "meuble"). //
							replaceAll("Autres", "divers"). //
							replaceAll("Vetement", "vet"). //
							replaceAll("Jeux_Jouet", "jouet");
			String newHoraires = this.tranlateHoraires(horaires);
			String itemQ = newHoraires;
			String itemR = townInInnerCase;

			String itemS = collectMod;
			// String itemS = NEW_ITEM5_VALUE;
			StoreElement elt = new StoreElement(columnA, itemA, itemB, columnD,
					columnE, itemE, itemF, itemG, itemH, itemI, itemJ, itemK,
					itemL, itemM, itemN, itemO, itemP, itemQ, itemR, itemS);

			// On filtre ce qui n'est pas sur Nantes
			// VIGNEUX DE BRETAGNE est proche de Orvault
			//
			if (!name.equals(StructureName.SAINT_ANDRE_DES_EAUX.toString())
					&& !name.equals(StructureName.PAIMBOEUF.toString())
					&& !name.equals(StructureName.FROSSAY.toString())
					&& !name.equals(StructureName.SAINT_PERE_EN_RETZ.toString())
					&& !name.equals(StructureName.DONGES.toString())
					&& !name.equals(StructureName.SAINT_BREVIN_LES_PINS.toString())
					&& !name.equals(StructureName.SAINT_MALO_DE_GUERSAC.toString())
					&& !name.equals(StructureName.SAINT_JOACHIM.toString())
					&& !name.equals(StructureName.PORNICHET.toString())
					&& !name.equals(StructureName.CUNEIX.toString())
					&& !name.equals(StructureName.MEAN_PENHOET_SAINT_NAZAIRE.toString())) {
				boolean estDejaPresent = false;
				StoreElement oldElement = storeElements.get(itemA);
				if (storeElements.containsKey(itemA)) {
					oldElement.setItem15(oldElement.getItem15()
							+ SEPARATOR_BETWEEN_2_ELEMENTS + itemP);
					estDejaPresent = true;
				}

				if (!estDejaPresent) {
					storeElements.put(itemA, elt);
				}
			}
			xmlStreamReader.nextTag();
			xmlStreamReader.require(XMLStreamConstants.END_ELEMENT, null, ITEM);
		}
		// sortie
		int i = 1;
		for (String mapKey : storeElements.keySet()) {
			// utilise ici hashMap.get(mapKey) pour accéder aux valeurs
			StoreElement storeElement = storeElements.get(mapKey);
			writer. //
			append(esc(storeElement.getItem00() + i)).append(SEPARATOR). //
					append(esc(storeElement.getItem1())).append(SEPARATOR). //
					append(esc(storeElement.getItem0())).append(SEPARATOR). //
					append(esc(storeElement.getItem2())).append(SEPARATOR). //
					append(esc(storeElement.getItem3())).append(SEPARATOR). //
					append(esc(storeElement.getItem4())).append(SEPARATOR). //
					append(esc(storeElement.getItem5())).append(SEPARATOR). //
					append(esc(storeElement.getItem6())).append(SEPARATOR). //
					append(esc(storeElement.getItem7())).append(SEPARATOR). //
					append(esc(storeElement.getItem8())).append(SEPARATOR). //
					append(esc(storeElement.getItem9())).append(SEPARATOR). //
					append(esc(storeElement.getItem10())).append(SEPARATOR). //
					append(esc(storeElement.getItem11())).append(SEPARATOR). //
					append(esc(storeElement.getItem12())).append(SEPARATOR). //
					append(esc(storeElement.getItem13())).append(SEPARATOR). //
					append(esc(storeElement.getItem14())).append(SEPARATOR). //
					append(esc(storeElement.getItem15())).append(SEPARATOR). //
					append(esc(storeElement.getItem16())).append(SEPARATOR). //
					append(esc(storeElement.getItem17())).append(SEPARATOR). //
					append(esc(storeElement.getItem18())); //

			i++;

			writer.println();
		}
		xmlStreamReader.require(XMLStreamConstants.END_ELEMENT, null, ROOT);
		writer.close();
		System.out.println("Conversion terminée.");

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