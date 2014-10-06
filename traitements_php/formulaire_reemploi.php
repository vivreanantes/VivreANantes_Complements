<!DOCTYPE HTML> 
<html>
<head>
<meta charset="utf-8">
<style>
.error {color: #FF0000;}
</style>
</head>
<body> 

<?php
// define variables and set to empty values
$nameErr = $emailErr = $infoPubliqueErr = $websiteErr = "";
$name = $email = $infoPublique = $comment = $website = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
   if (empty($_POST["nom"])) {
     $nameErr = "Nom est obligatoire";
   } else {
    /* $name = test_input($_POST["name"]);
     // check if name only contains letters and whitespace
     if (!preg_match("/^[a-zA-Z ]*$/",$name)) {
       $nameErr = "Only letters and white space allowed"; 
     }*/
   }
   
   if (empty($_POST["email"])) {
     $emailErr = "Email est obligatoire";
   } else {
     $email = test_input($_POST["email"]);
     // check if e-mail address est well-formed
     if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
       $emailErr = "Invalid email format"; 
     }
   }
     
   if (empty($_POST["website"])) {
     $website = "";
   } else {
     $website = test_input($_POST["website"]);
     // check if URL address syntax est valid (this regular expression also allows dashes in the URL)
     if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) {
       $websiteErr = "Invalid URL"; 
     }
   }

   if (empty($_POST["comment"])) {
     $comment = "";
   } else {
     $comment = test_input($_POST["comment"]);
   }

   if (empty($_POST["infoPublique"])) {
     $infoPubliqueErr = "infoPublique est obligatoire";
   } else {
     $infoPublique = test_input($_POST["infoPublique"]);
   }
}

function test_input($data) {
   $data = trim($data);
   $data = stripslashes($data);
   $data = htmlspecialchars($data);
   return $data;
}
?>

<h2>Inscription association ou entreprise de réemploi</h2>
<p>
Bonjour,<br/>
Nous vous contactons car nous joignons les associations/entreprises de réemploi de Loire-Atlantique qui étaient recensées par le site www.deuxieme-vie.org. Ce site est fermé, mais nous souhaitons maintenir les informations.<br/>
<br/>
Nous sommes 2 bénévoles et nous développons un programme gratuit 'Mieux Trier A Nantes' - voir www.mieuxtrieranantes.fr - dont l'objectif est d'aider les habitants de Nantes Métropole à trier : plus régulièrement, plus scrupuleusement.<br/>
<br/>
Comment nous fournir ces informations ?<br/>
- soit nous répondre par mail <br/>
- soit sur ce formulaire.<br/>
<br/>
Pour toutes questions envoyez-nous un mail ou appelez le 06_74_43_78_43.<br/>
<br/>
Merci de votre collaboration.<br/>
<br/>
Christian Renoulin, Romain Debernardi
</p>

<p><span class="error">* Champs obligatoires.</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"> 

   Acceptez-vous que ces informations soient publiques ? *<br/>
   <i>Si ces informations sont publiques, des sites internet comme ourecycler.fr ou openstreetmap peuvent les utiliser. Elles seront visibles sur www.mieuxtrieranantes.fr page "réemploi" </i>.
   <input type="radio" name="infoPublique" <?php if (isset($infoPublique) && $infoPublique=="oui") echo "checked";?>  value="oui">Oui
   <input type="radio" name="infoPublique" <?php if (isset($infoPublique) && $infoPublique=="non") echo "checked";?>  value="non">Non
   <span class="error">* <?php echo $infoPubliqueErr;?></span>
   <br><br>

<p>



<h3>A propos de la personne qui réalise l'inscription</h3>
Ceci nous permet de vous recontacter si les données n'ont pas été mise à jour depuis très longtemps

 
06.33.63.35.52
 
responsable *
 
<h3>L'association ou l'entreprise de réemploi</h3>
Type
  <input type="checkbox" name="options[]" value="Injection au méthane">&nbsp;Association<br/>
 <input type="checkbox" name="options[]" value="Injection au méthane">&nbsp;Entreprise<br/>
 <input type="checkbox" name="options[]" value="Injection au méthane">&nbsp;Autre : <input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 <br><br>
Nom *
<input type="text" name="nom" value="<?php echo $nom;?>">
   <span class="error">* <?php echo $nomErr;?></span>
<br><br> 
Email
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br> 
Tel
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br> 
Site Internet
<input type="text" name="website" value="<?php echo $website;?>">
   <span class="error">* <?php echo $websiteErr;?></span>
<br><br> 
Facebook
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br> 
Google+
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br> 
Twiter
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br> 
Fax
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br> 
Logo : emplacement de l'image
<i>Site Internet ou page Internet où trouver l'image. Vous pouvez nous l'envoyer par mail</i>
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 <br><br>
Logo : vos conditions pour la réutilisation de l'image
<i>Certains images ne peuvent pas être reproduites. Dites-le nous./i>
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 
<h3>Local ouvert au public : Local 1</h3>

Adresse : rue/route
<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br>
Adresse : complément<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 <br><br>
Adresse: code postal<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 <br><br>
Adresse : ville<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 
Adresse : cedex<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 
Latitude
exemple : -1.624346<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br> 
Longitude
exemple : 47.197236<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 <br><br>
Nantes : quartier administratif<br/>
<i>Liste des quartiers administratifs nantais dispo ici : http://fr.wikipedia.org/wiki/Liste_des_quartiers_de_Nantes</i>
 <input type="checkbox" name="options[]" value="Injection au méthane">&nbsp;Injection au méthane<br>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Bellevue / Chantenay / Sainte-Anne&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Breil / Barberie&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Centre Ville&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Dervallières / Zola&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Doulon / Bottière&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Hauts Pavés / Saint Félix&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Ile De Nantes&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Malakoff / Saint-Donatien&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Nantes Erdre&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Nantes Nord&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Quartier Nantais : Nantes Sud&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Hors Nantes : au nord de la Loire&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">&nbsp;Hors Nantes : au sud de la Loire&nbsp;<br/>
 <br><br>
 Horaires
 <input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br>
   Horaires (format plage horaire pour nous faciliter le travail) 
   <br/><i/>Exemple "0101-3112_lu+ma+me+je+ve_10h00-12h30+14h00-19h00,0101-3112_sa_10h00-12h30</i>  
   <input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
<br><br>
Déchets récupérés  *
Liste précisément tous les déchets récupérés (au singulier), séparés par une virgule. La rubrique description permet de donner le reste des informations. Exemple : "vélo,cyclomoteur"
   <input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 <br><br>
Catégories de déchets admis
 <input type="checkbox" name="options[]" value="Trois roues de secours">Cartouches encre/tuners&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">Divers&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">Électroménager&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">Informatique&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">Jouet&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">Livres/BD/CD/DVD&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">Meuble&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">Vélo&nbsp;<br/>
 <input type="checkbox" name="options[]" value="Trois roues de secours">Vêtements&nbsp;<br/>
 <br><br>
 Autre : <input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
Je n'ai pas précisé de local, mais bientôt, début mars 2015, un espace sera disponible pour mon atelier boutique à ST Nazaire, près du marché. *
Ce que vous n'avez pas pu mettre dans les champs de saisis
<br><br>
<h3>Autres locaux</h3><input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span> 
Local ouvert au public : Local 2
Les différences par rapport au local 1 : Horaires, emplacement, déchets récupérés...<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
 <br/>
Local ouvert au public : Local 3
Les différences par rapport au local 1 : Horaires, emplacement, déchets récupérés...<input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
</p>
<br><br>
   Nom: <input type="text" name="nom" value="<?php echo $nom;?>">
   <span class="error">* <?php echo $nomErr;?></span>
   <br><br>
   E-mail: <input type="text" name="email" value="<?php echo $email;?>">
   <span class="error">* <?php echo $emailErr;?></span>
   <br><br>
   Website: <input type="text" name="website" value="<?php echo $website;?>">
   <span class="error"><?php echo $websiteErr;?></span>
   <br><br>
   Comment: <textarea name="comment" rows="5" cols="40"><?php echo $comment;?></textarea>
   <br><br>
   <input type="submit" name="submit" value="Submit"> 
</form>

<?php
echo "<h2>Your Input:</h2>";
echo $infoPublique;
echo $name;
echo "<br>";
echo $email;
echo "<br>";
echo $website;
echo "<br>";
echo $comment;
echo "<br>";
;
?>

</body>
</html>




Envoyez nous un mail avec les infos suivantes :

Acceptez-vous que ces informations soient publiques ? (si ces informations sont publiques, des sites internet comme ourecycler.fr ou openstreetmap peuvent les utiliser. Elles seront visibles sur www.mieuxtrieranantes.fr page "réemploi") 

A propos de la personne qui réalise l'inscription : nom, mail, lien entre la personne et la structure

Catégorie : Association / Entreprise / Autre 

Nom

Email

Téléphone

Site Internet

Facebook

Google+

Twiter

Fax

Logo : adresse Internet ou trouver l'image

Logo : vos conditions pour la réutilisation de l'image

Adresse : rue, route...

Adresse : complément

Adresse : code postal

Adresse : ville

Adresse : cedex

Latitude (exemple : -1.624346)

Longitude (exemple : 47.197236)

Nantes : quartier administratif (voir Liste des quartiers administratifs nantais dispo ici : http://fr.wikipedia.org/wiki/Liste_des_quartiers_de_Nantes )
 - Quartier Nantais : Bellevue / Chantenay / Sainte-Anne
 - Quartier Nantais : Breil / Barberie
 - Quartier Nantais : Centre Ville
 - Quartier Nantais : Dervallières / Zola
 - Quartier Nantais : Doulon / Bottière
 - Quartier Nantais : Hauts Pavés / Saint Félix
 - Quartier Nantais : Ile De Nantes
 - Quartier Nantais : Malakoff / Saint-Donatien
 - Quartier Nantais : Nantes Erdre
 - Quartier Nantais : Nantes Nord
 - Quartier Nantais : Nantes Sud
 - Hors Nantes : au nord de la Loire
 - Hors Nantes : au sud de la Loire

Horaires


Objets récupérés (Liste précisément tous les déchets récupérés (au singulier), séparés par une virgule. La rubrique description permet de donner le reste des informations. Exemple : "vélo,cyclomoteur")

Catégories de déchets récupérés
 - Cartouches encre/tuners
 - Divers
 - Électroménager
 - Informatique
 - Jouet
 - Livres/BD/CD/DVD
 - Meuble
 - Vélo
 - Vêtements
 - Autre : préciser les déchets

 Description

 Local 2 : les différences par rapport au local 1

 Local 3 : les différences par rapport au local 1