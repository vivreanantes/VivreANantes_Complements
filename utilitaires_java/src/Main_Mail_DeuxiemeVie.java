import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Main_Mail_DeuxiemeVie extends Abstract_ConvertData {

	static public final String SEPARATOR = "\t";
	static public final String ROOT = "markers";
	static public final String ITEM = "marker";
	static public final String SAUT_1_LIGNE = "\r\n"; // "<br/>";

	public static void main(String[] args) throws XMLStreamException,
			FileNotFoundException {
		new Main_Mail_DeuxiemeVie().convertXMLToCSV();
	}

	static public final String DEUXIEME_VIE_DIRECTORY = "deuxieme_vie\\";

	private void convertXMLToCSV() throws FileNotFoundException,
			XMLStreamException, FactoryConfigurationError {

		String FILE_DIRECTORY = CommonUtils.getRessourcesPath(getClass(),
				"/utilitaires_java");
		String src = FILE_DIRECTORY + RESSOURCES_DIRECTORY
				+ DEUXIEME_VIE_DIRECTORY + "data.xml"; // args[0]
		String dst = FILE_DIRECTORY + RES_DIRECTORY + DEUXIEME_VIE_DIRECTORY
				+ "mails_iso-8859-1.csv"; // args[1]

		InputStream in = new BufferedInputStream(new FileInputStream(src));

		OutputStream out = new BufferedOutputStream(new FileOutputStream(dst));
		PrintWriter writer = new PrintWriter(out);
		XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
				.createXMLStreamReader(in);

		System.out.println("Conversion commencée...");

		writer.println("Destinaire" + SEPARATOR + "Message");
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
			String latitude = xmlStreamReader.getAttributeValue(0); // 4
			String longitude = xmlStreamReader.getAttributeValue(1); // -1
			String categorie = xmlStreamReader.getAttributeValue(2);
			String objet = xmlStreamReader.getAttributeValue(3); // Décheterie
			String nom = xmlStreamReader.getAttributeValue(4); // LA BEAUJOIRE
			String adresse = xmlStreamReader.getAttributeValue(5); // adresse 1
			String codePostal = xmlStreamReader.getAttributeValue(6); // code
																		// postal
			String ville = xmlStreamReader.getAttributeValue(7); // ville
			String commentaire = xmlStreamReader.getAttributeValue(8); // dechets
																		// admis
			String horaires = xmlStreamReader.getAttributeValue(9);
			String telephone = xmlStreamReader.getAttributeValue(10); // tel
			String fax = xmlStreamReader.getAttributeValue(11);
			String courriel = xmlStreamReader.getAttributeValue(12);
			String url = xmlStreamReader.getAttributeValue(13); // url

			String message = "Bonjour,"
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "Nous vous contactons car nous joignons toutes les associations/entreprises de réemploi de Loire-Atlantique qui étaient recensées par le site www.deuxieme-vie.org. "
					+ SAUT_1_LIGNE
					+ "Ce site est fermé, mais nous souhaitons maintenir les informations."
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "Nous sommes 2 bénévoles et nous développons un programme gratuit 'Mieux trier à Nantes' (voir www.mieuxtrieranantes.fr) dont l'objectif est d'aider les habitants de Nantes Métropole à trier : plus régulièrement, plus scrupuleusement."
					+ SAUT_1_LIGNE
					+ "Nous souhaiterions que vous nous transmettiez des informations à jour sur votre association/entreprise."
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "Comment nous fournir ces informations ?"
					+ SAUT_1_LIGNE
					+ " - soit en répondant à ce mail en complétant le formulaire à la fin de ce message (message pré-rempli avec les informations que nous avons)"
					+ SAUT_1_LIGNE
					+ " - soit en utilisant le formulaire https://docs.google.com/forms/d/1RXbJqalGzD2MMwE8NGRotiqheezTuyU8WodKqRBdL7I/edit?usp=sharing"
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "Pour toutes questions envoyez-nous un mail ou appelez le 06_74_43_78_43."
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "Merci de votre collaboration."
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "Christian Renoulin, Romain Debernardi"
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "_____________________________________________________"
					+ SAUT_1_LIGNE
					+ "                                  FORMULAIRE"
					+ SAUT_1_LIGNE
					+ "Acceptez-vous que ces informations soient publiques ? OUI (des sites internet comme 'ourecycler.fr' ou 'openstreetmap' peuvent les utiliser. Elles seront visibles sur www.mieuxtrieranantes.fr page 'réemploi') ou NON (uniquement l'application 'Mieux trier à Nantes')" 
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "________________ A propos de la personne qui réalise l'inscription ________________"
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ " - nom de la personne ayant réalisé l'inscription : "
					+ SAUT_1_LIGNE
					+ " - email de la personne ayant réalisé l'inscription : "
					+ SAUT_1_LIGNE
					+ " - lien entre la personne ayant réalisé l'inscription et l'association/entreprise : "
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ "________________ L'association ou l'entreprise de reémploi ________________"
					+ SAUT_1_LIGNE
					+ SAUT_1_LIGNE
					+ " - nom : " + nom + SAUT_1_LIGNE
					+ " - catégorie : " + categorie + SAUT_1_LIGNE
					+ " - objet récupérés : " + objet + SAUT_1_LIGNE + " - latitude : "
					+ latitude + SAUT_1_LIGNE + " - longitude : " + longitude
					+ SAUT_1_LIGNE + " - adresse : " + adresse + SAUT_1_LIGNE
					+ " - code postal : " + codePostal + SAUT_1_LIGNE
					+ " - ville : " + ville + SAUT_1_LIGNE
					+ " - commentaire : " + commentaire + SAUT_1_LIGNE
					+ " - horaires : " + horaires + SAUT_1_LIGNE
					+ " - téléphone : " + telephone + SAUT_1_LIGNE
					+ " - fax : " + fax + SAUT_1_LIGNE + " - courriel : "
					+ courriel + SAUT_1_LIGNE + " - url : " + url
					+ SAUT_1_LIGNE;

			writer.append(CommonUtils.esc(courriel)).append(SEPARATOR);
			writer.append(CommonUtils.esc(message)).append(SEPARATOR);

			writer.println();
			xmlStreamReader.nextTag();
			xmlStreamReader.require(XMLStreamConstants.END_ELEMENT, null, ITEM);
		}
		xmlStreamReader.require(XMLStreamConstants.END_ELEMENT, null, ROOT);
		writer.close();
		writer.close();
		System.out.println("Conversion terminée.");
	}

}