	
	showStructuresDetail : function(list, index, node, record) {
		if (record) {
			if (!this.structuresDetail) {
				this.structuresDetail = Ext
						.create("VivreANantes.view.structures.StructuresDetails");
			}
			// Ajout du type
			var descriptionTraduit = "";
			if (record.data["modesCollecte"] != null && record.data["modesCollecte"] !== "") {
				var label = this.stringUpperFirstLetter(this
						.translate("label_type"));
				var modeCollecteTraduit = "";
				var typeTraduit = "";
				if (record.data["modesCollecte"] != null
						&& record.data["modesCollecte"] !== "") {
					// On d�coupe modesCollecte, puis on traduit
					var arModesCollecte = record.data["modesCollecte"].split(",");
					for (var i = 0; i < arModesCollecte.length; i++) {
						var unModeCollecte = arModesCollecte[i];
						if (i>0) {
							modeCollecteTraduit = modeCollecteTraduit + ", ";
						}
						modeCollecteTraduit = modeCollecteTraduit + this.translate("label_"	+ unModeCollecte);
					}
					// Dans le cas de distribution Trisac on ajoute le type
					if (record.data["modesCollecte"]==="modco_distrisac") {
						typeTraduit = " - " + record.data["type"];
					}
				}
				
				descriptionTraduit += label + " : " + modeCollecteTraduit + " "
						+ typeTraduit + "<br/><br/>";
			}
			// Ajout de la description
			if (record.data["description_fr"] != null
					&& record.data["description_fr"] !== "") {
				descriptionTraduit += record.data["description_fr"]
						+ "<br/><br/>";
			}
			if (record.data["adresseTemp"] != null
					&& record.data["adresseTemp"] !== "") {
				var label = this.stringUpperFirstLetter(this
						.translate("label_adresse"));
				descriptionTraduit += label + " : "
						+ record.data["adresseTemp"] + "<br/><br/>";
			}
			if (record.data["numeroTemp"] != null
					&& record.data["numeroTemp"] !== "") {
				var label = this.stringUpperFirstLetter(this
						.translate("label_telephone"));
				descriptionTraduit += label + " : " + record.data["numeroTemp"]
						+ "<br/><br/>";
			}
			if (record.data["plagesHoraires_lisible"] != null
					&& record.data["plagesHoraires_lisible"] !== "") {
				var label = this.stringUpperFirstLetter(this
						.translate("label_horaires"));
				descriptionTraduit += label + " : "
						+ record.data["plagesHoraires_prochainsJours"]
						+ "<br/>" + record.data["plagesHoraires_lisible"]
						+ "<br/><br/>";
			}
			if (record.data["src"] != null && record.data["src"] !== "") {
				// var label =
				// this.stringUpperFirstLetter(this.translate("label_source"));
				descriptionTraduit += record.data["src"] + "<br/><br/>";
			}
			this.setDataElement(this.structuresDetail,
					"structuresDetails_description", {
						'description' : descriptionTraduit
					})

			// Ajout des conseils
			var conseils = "";
			if (record.data["conseils"] !== "") {
				conseils = record.data["conseils"] + ",";
			}
			var arraysItemsAdvices = this.getItemsAdvices(conseils);
			this.setItemsElement(this.structuresDetail,
					"structuresDetails_advices", arraysItemsAdvices);

			// Affectation du titre
			var stType = record.data["type"];
			var title = "<I>" + stType + "</I>" + " "
					+ this.stringUpperFirstLetter(record.data["libelle"]);
			this.structuresDetail.setTitle(title);
			
			// Ajout des commentaires
			var code = record.data["code"];
			this.setItemsElement(this.structuresDetail,
					"structuresDetails_comments", this.getItemsComments(code, title));

			// Bind the record onto the show contact view
			this.structuresDetail.setData(record.data);
			// Push this view into the navigation view
			this.getStructuresView().push(this.structuresDetail);
		}
	},


	old_getDaysOfWeekString : function(strsDaysOfWeek) {

		var result = "";
		// 2. Si pas lu-ma, ma-me, me-je, je-ve, ve-sa, sa-di, on met de
		// "du...au"
		if (strsDaysOfWeek.length == 5) {
			var dayOfWeekStart = strsDaysOfWeek.substring(0, 2);
			var dayOfWeekEnd = strsDaysOfWeek.substring(3, 5);
			if (strsDaysOfWeek != "lu-ma" && strsDaysOfWeek != "ma-me"
					&& strsDaysOfWeek != "me-je" && strsDaysOfWeek != "je-ve"
					&& strsDaysOfWeek != "ve-sa" && strsDaysOfWeek != "sa-di") {
				result = "du " + this.getDayString(dayOfWeekStart, 1) + " au "
						+ this.getDayString(dayOfWeekEnd, 1);
			} else {
				result = this.getDayString(dayOfWeekStart, 1) + " et "
						+ this.getDayString(dayOfWeekEnd, 1);
			}
		} else {
			var posFirstNumber = this
					.utilPosFirstNumberInString(strsDaysOfWeek);
			if (posFirstNumber != -1) {
				strsDaysOfWeek = strsDaysOfWeek.substring(0, posFirstNumber);
			}
			var arDays = strsDaysOfWeek.split(this.separatorEt);
			for (var i = 0; i < arDays.length; i++) {
				var day = arDays[i];
				result += this.getDayString(day, i);
				if (i != (arDays.length - 1)) {
					result += ", ";
				}
			}
		}
		return result;
	},



	// ///////////////////////////////////////////////////////////////////////////////
	/*
	 * Renvoie les horaires (ou complete ceux existant) horaires "de 14h30 �
	 * 19h00", debut "Tue Jan 01 2013 00:00:00 GMT+0100 (Paris, Madrid)"
	 * horaires "de 14h30 � 19h00 et de 14h30 � 19h00"
	 */
	old_getAttributes_HoursFromToAsTextAndDaysFromToAsTextAttribute : function(
			arPlagesHoraires, dateDebut, dateFin, fromToAttribute, timeZone, stLocale) {

		var stLabelDe = this.translate("label_de");
		var stLabelH = this.translate("label_h");
		var stLabelA = this.translate("label_a");
		var stLabelEt = this.translate("label_et");

		var arHeures = timeZone.split(this.separatorEt);
		
		var result = "";
		for (var i = 0; i < arHeures.length; i++) {
			var heures = arHeures[i];
			var indexFinHeure = heures.indexOf(this.separatorJusquA, 0);
			var heureDebut = heures.substring(0, indexFinHeure);
			var heureFin = heures.substring(indexFinHeure + 1);
			if (heureDebut != null) {
				var heuresDebutInt = parseInt(heureDebut.substring(0, 2));
				var minutesDebut = heureDebut.substring(3, 5);
			}
			if (heureFin != null) {
				var heuresFinInt = parseInt(heureFin.substring(0, 2));
				var minutesFin = heureFin.substring(3, 5);
			}
			var stHoraires = stLabelDe + " " + heuresDebutInt + stLabelH
					+ minutesDebut + " " + stLabelA + " " + heuresFinInt + stLabelH
					+ minutesFin;
			if (result!="") {
				// On ajoute "Et de 19h45 � 20h30"
				result = result + " " + stLabelEt + " " + stHoraires;
			} else {
				// On ajoute "19h45 � 20h30"
				result = result + stHoraires;
			}
			/*var estPresent = false;
			for (var i = 0; i < arPlagesHoraires.length; i++) {
				// meme jour : "du 0101 au 3112"
				// et meme jour de la semaine ex "Toute l'ann�e (du lundi au mercredi)"
				if (arPlagesHoraires[i]["dateDebut"].toString() === dateDebut
						.toString()
						&& arPlagesHoraires[i]["dateFin"].toString() === dateFin
								.toString()
						&& arPlagesHoraires[i]["fromTo"].toString() === fromToAttribute) {
					// On compl�te les horaires
					stSchedule = arPlagesHoraires[i]["schedule"] + " " + stLabelEt
							+ " " + stHoraires;
					estPresent = true;
				}
			}
			if (estPresent === false) {
				// On ajoute l"horaire
				stSchedule = stHoraires;
			}*/
		}

		/*var stSchedule;*/
		return result;
	},


	
	getDayString : function(strDay, firstLetterInUpper) {
		result = strDay;
		if (strDay == "lu") {
			result = "label_lundi"
		} else if (strDay == "ma") {
			result = "label_mardi"
		} else if (strDay == "me") {
			result = "label_mercredi"
		} else if (strDay == "je") {
			result = "label_jeudi"
		} else if (strDay == "ve") {
			result = "label_vendredi"
		} else if (strDay == "sa") {
			result = "label_samedi"
		} else if (strDay == "di") {
			result = "label_dimanche"
		}
		result = this.translate(result);
		if (firstLetterInUpper == 0) {
			this.stringUpperFirstLetter(result);
		}
		return result;
	},
	
	old_fillAttributs_PlagesHoraires : function(objStructures) {
		var stPlagesHoraire = objStructures.get("plagesHoraires");

		var bOuvertAujourdhui = false;
		var bOuvertDemain = false;

		var stTodayFerieSpecialDay = this.old_getTodaySpecialDay();
		var stTomorrowSpecialDay = this.old_getTomorrowSpecialDay();


		// Ce qui sera ajout� � l"objet Structures
		var arNewAttributes = Array();
		if (stPlagesHoraire != null && stPlagesHoraire != "") {

			// Split la cha�ne de caract�re "plagesHoraires" pour fabriquer le
			// tableau des plages horaires
			var arPlagesHoraires = stPlagesHoraire.split(",");

			// R�cup�re le contenu de la z�ne des jours f�ri�s
			var specialDayZone = "";
			for (var i = 0; i < arPlagesHoraires.length; i++) {
				var plageHoraire = arPlagesHoraires[i];
				if (plageHoraire.substring(0, 5) == "sauf_") {
					specialDayZone = plageHoraire;
				}
			}

			// Parcours le tableau des plages horaires pour obtenir plusieurs
			// �v�nements
			for (var i = 0; i < arPlagesHoraires.length; i++) {
				var plageHoraire = arPlagesHoraires[i];
				// On traite hors zone Jour ferie et si il y a des donn�es
				if (plageHoraire != specialDayZone && plageHoraire.length > 0) {
					var indexSeparator1 = plageHoraire.indexOf("_", 0);
					var indexSeparator2 = plageHoraire.indexOf("_",
							indexSeparator1 + 1);
					var indexseparatorEt = plageHoraire.indexOf("_",
							indexseparatorEt + 1);
					var timeZones = this
							.old_getTimeZone_JourDebutMoisDebutJourFinMoisFin(plageHoraire);
					var jourDebutJJ = timeZones.jourDebutJJ;
					var moisDebutMM = timeZones.moisDebutMM;
					var jourFinJJ = timeZones.jourFinJJ;
					var moisFinMM = timeZones.moisFinMM;
					var jourDebut = timeZones.jourDebut;
					var moisDebut = timeZones.moisDebut;
					var jourFin = timeZones.jourFin;
					var moisFin = timeZones.moisFin;
					var currentYearAAAA = this.utilGetStringCurrentYearAAAA();
					// daysOfWeekZone vaut me120613 ou lu-ma
					var daysOfWeekZone = plageHoraire.substring(indexSeparator1
									+ 1, indexSeparator2);
					var timeZone = plageHoraire.substring(indexSeparator2 + 1);
					// En javascript on met "0" pour le premier mois (donc on
					// fait "-1")
					var dateDebut = new Date(currentYearAAAA, moisDebut - 1,
							jourDebut);
					// En javascript on met "0" pour le premier mois (donc on
					// fait "-1")
					var dateFin = new Date(currentYearAAAA, moisFin - 1,
							jourFin);
					var fromToAttribute = this.old_getAttribute_FromTo(jourDebutJJ,
							moisDebutMM, jourFinJJ, moisFinMM, true,
							daysOfWeekZone, 3)
					var stSchedule = this
							.old_getAttributes_HoursFromToAsTextAndDaysFromToAsTextAttribute(
									arNewAttributes, dateDebut, dateFin, fromToAttribute, timeZone);

					// -- verifie si
					var obAujoudhuiDemain = this.old_VerifieOuvertAujourdhuiDemain(
							stTodayFerieSpecialDay, stTomorrowSpecialDay,
							dateDebut, dateFin, daysOfWeekZone, specialDayZone);
					if (obAujoudhuiDemain["bOuvertAujourdhui"] == true) {
						bOuvertAujourdhui = true;
					}
					if (obAujoudhuiDemain["bOuvertDemain"] == true) {
						bOuvertDemain = true;
					}
					// -- on regroupe par journee (meme journee et meme jour de semaines
					var isPresent = false;
					for (var j = 0; j < arNewAttributes.length; j++) {
						if (arNewAttributes[j]["jourDebutJJ"] == jourDebutJJ
								&& arNewAttributes[j]["moisDebutMM"] == moisDebutMM
								&& arNewAttributes[j]["jourFinJJ"] == jourFinJJ
								&& arNewAttributes[j]["moisFinMM"] == moisFinMM
								&& arNewAttributes[j]["fromTo"] == fromToAttribute) {
							isPresent = true;
						}
					}
					if (isPresent == false) {
						// on ajoute
						arNewAttributes.push({
									"fromTo" : fromToAttribute,
									"jourDebutJJ" : jourDebutJJ,
									"moisDebutMM" : moisDebutMM,
									"jourFinJJ" : jourFinJJ,
									"moisFinMM" : moisFinMM,
									"schedule" : stSchedule,
									"dateDebut" : dateDebut,
									"dateFin" : dateFin
								});
					}
				}
			}
			var stplagesHoraires = "";
			// Parcours tous les �v�nements obtenus
			for (var i = 0; i < arNewAttributes.length; i++) {
				stplagesHoraires = stplagesHoraires + "- "
						+ arNewAttributes[i]["fromTo"] + " "
						+ arNewAttributes[i]["schedule"] + "<br/>";

			}
			if (specialDayZone != "") {
				stplagesHoraires = stplagesHoraires + "- "
						+ this.translate("label_sauf_ferie");
			}
		}

		if (bOuvertAujourdhui == true && bOuvertDemain == true) {
			var stOuvertAujourdhuiEtDemain = "<FONT COLOR=red>"
					+ this.translate("label_ouvert_aujourdhui_et_demain")
					+ "</FONT>"
		} else if (bOuvertAujourdhui == true && bOuvertDemain == false) {
			stOuvertAujourdhuiEtDemain = "<FONT COLOR=red>"
					+ this.translate("label_ouvert_aujourdhui") + "</FONT>"
		} else if (bOuvertAujourdhui == false && bOuvertDemain == true) {
			stOuvertAujourdhuiEtDemain = "<FONT COLOR=red>"
					+ this.translate("label_ouvert_demain") + "</FONT>"
		} else {
			var stOuvertAujourdhuiEtDemain = " ";
		}
		
		objStructures.data["plagesHoraires_lisible"] = stplagesHoraires;
		objStructures.data["plagesHoraires_prochainsJours"] = stOuvertAujourdhuiEtDemain;
	},

	/* renvoie une chaine de caract�re */
	old_getTimeZone_JourDebutMoisDebutJourFinMoisFin : function(plageHoraire) {
		var index1 = plageHoraire.indexOf("_", 0);
		if (index1 == 9) {
			// On est sur une plage horaire
			var periodZone = plageHoraire.substring(0, index1);
			var indexFinHeure = periodZone.indexOf(this.separatorJusquA, 0);
			var strDateDebut = periodZone.substring(0, indexFinHeure);
			var jourDebutJJ = strDateDebut.substring(0, 2);
			var moisDebutMM = strDateDebut.substring(2, 4);
			var strDateFin = periodZone.substring(indexFinHeure + 1);
			var jourFinJJ = strDateFin.substring(0, 2);
			var moisFinMM = strDateFin.substring(2, 4);
		} else if (index1 == 6) {
			// On est dans le cas d"une date pr�cise
			var stDate = plageHoraire.substring(0, index1);
			if (stDate.length === 6) {
				var jourDebutJJ = stDate.substring(0, 2);
				var moisDebutMM = stDate.substring(2, 4);
				var jourFinJJ = jourDebutJJ;
				var moisFinMM = moisDebutMM;
			} else if (stDate.length === 9) {
				var jourDebutJJ = stDate.substring(0, 2);
				var moisDebutMM = stDate.substring(2, 4);
				var jourFinJJ = stDate.substring(5, 7);
				var moisFinMM = stDate.substring(7, 9);
			}
		}
		var jourDebut = parseInt(jourDebutJJ);
		var moisDebut = parseInt(moisDebutMM);
		var jourFin = parseInt(jourFinJJ);
		var moisFin = parseInt(moisFinMM);

		return {
			"jourDebut" : jourDebut,
			"moisDebut" : moisDebut,
			"jourFin" : jourFin,
			"moisFin" : moisFin,
			"jourDebutJJ" : jourDebutJJ,
			"moisDebutMM" : moisDebutMM,
			"jourFinJJ" : jourFinJJ,
			"moisFinMM" : moisFinMM
		};
	}

	/*
	 * exemple "Le Mercredi 15 janvier"
	 */
	,
	old_getAttribute_FromTo : function(jourDebut, moisDebut, jourFin, moisFin,
			allDays, daysOfWeekZone, deleteBetweenActualDay) {
		var result = "";
		var stLabelDu = this.translate("label_du");
		var stLabelLe = this.translate("label_le");
		// var stLabelTouteLAnnee = this.translate("label_toutelannee");
		var stLabelAu = this.translate("label_au");

		var stDays = this.old_getDaysOfWeekString(daysOfWeekZone);
		if (allDays == true) {
			if (jourDebut == "01" && moisDebut == "01" && jourFin == "31"
					&& moisFin == "12") {
				// result = stLabelTouteLAnnee + " (" + stDays + ")";
				result = stDays;
			} else if (jourDebut == jourFin && moisDebut == moisFin) {
				result = stLabelLe + " " + stDays + " " + jourDebut + " "
						+ this.convertDayNumberToString(moisDebut);
			} else {
				result = stLabelDu + " " + jourDebut + " "
						+ this.convertDayNumberToString(moisDebut) + " "
						+ stLabelAu + " " + jourFin + " "
						+ this.convertDayNumberToString(moisFin) + " " + stDays;
			}
		}
		return result;
	},

	separatorEt : "+",
	separatorJusquA : "-",
	
	old_VerifieOuvertAujourdhuiDemain : function(stTodayFerieSpecialDay,
			stTomorrowSpecialDay, dateDebut, dateFin, daysOfWeekZone,
			specialDayZone) {

		var today = this.utilGetDateTodayWithoutSeconds();
		var todayTwoDays = this.utilGetDayOfWeekTwoCharacters(today);
		var tomorrow = this.utilGetDateTomorrowWithoutSeconds();
		var tomorrowTwoDays = this.utilGetDayOfWeekTwoCharacters(tomorrow);
		var bOuvertAujourdhui = false;
		var bOuvertDemain = false;

		var arDays = daysOfWeekZone.split(this.separatorEt);

		if (today >= dateDebut && today <= dateFin
				&& this.utilArrayContainObject(arDays, todayTwoDays)) {
			bOuvertAujourdhui = true;
		}

		if (tomorrow >= dateDebut && tomorrow <= dateFin
				&& this.utilArrayContainObject(arDays, tomorrowTwoDays)) {
			bOuvertDemain = true;
		}
		// 3 - V�rif les jours f�ri�s
		if (this.verifSpecialDay(stTodayFerieSpecialDay, specialDayZone)) {
			bOuvertAujourdhui = false;
		}
		if (this.verifSpecialDay(stTomorrowSpecialDay, specialDayZone)) {
			bOuvertDemain = false;
		}

		return {
			"bOuvertAujourdhui" : bOuvertAujourdhui,
			"bOuvertDemain" : bOuvertDemain
		}
	},


	/**
	 * Renvoie une chaine correspondant au nom du jour ferie de aujourd'hui.
	 * Exemple : renvoie "sauf_saint_sylvestre"
	 */
	old_getTodaySpecialDay : function() {
		var today = this.utilGetDateTodayWithoutSeconds();
		return this.old_getSpecialDay(today);
	},

	/**
	 * Renvoie une chaine correspondant au nom du jour ferie de demain.
	 * Exemple : renvoie "sauf_saint_sylvestre"
	 */
	old_getTomorrowSpecialDay : function() {
		var tomorrow = this.utilGetDateTomorrowWithoutSeconds();
		return this.old_getSpecialDay(tomorrow);
	},

	/**
	 * Renvoie une chaine correspondant au nom du jour ferie de la date fournie.
	 * Exemple : la date "01/01/2014" renvoie "sauf_saint_sylvestre"
	 */
	old_getSpecialDay : function(date) {

		return _old_getSpecialDay(date);
	},

	/**
	 * Valorise les options des listes d�roulantes "quartier"
	 */
	setOptionsQuartier_old : function(selectField) {

		selectField.setOptions([{
					text : 'Tous',
					value : 'all'
				}, {
					text : "Bellevue Chantenay",
					value : "Bellevue Chantenay"
				}, {
					text : "Breil Barberie",
					value : "Breil Barberie"
				}, {
					text : "Centre-ville",
					value : "Centre-ville"
				}, {
					text : "Dervalli�res Zola",
					value : "Dervallieres Zola"
				}, {
					text : "Doulon Botti�re",
					value : "Doulon Bottiere"
				}, {
					text : "Hauts-Pav�s Saint-F�lix",
					value : "Hauts-Paves Saint-Felix"
				}, {
					text : "�le de Nantes",
					value : "Ile de Nantes"
				}, {
					text : "Malakoff Saint-Donatien",
					value : "Malakoff Saint-Donatien"
				}, {
					text : "Nantes Erdre",
					value : "Nantes Erdre"
				}, {
					text : "Nantes Nord",
					value : "Nantes Nord"
				}, {
					text : "Nantes Sud",
					value : "Nantes Sud"
				}]);
	},

	/**
	 * transforme une chaine spliter en chaine traduite. ex : "au,du" + "," renvoie "au du"  
	 */
	utilGetStringFromSplitString : function(string) {
		var result = "";
		var arElements = string.split(",");
		for (var i = 0; i < arElements.length; i++) {
			var element = arElements[i];
			result = result + this.translate(element) + " ";
		}
		if (result.length>0) {
			result = result.substring(0, result.length-1);
		}
		return result;
	},
	