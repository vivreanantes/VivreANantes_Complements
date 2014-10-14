/**
 * Controlleur pour les vues et modèles de Carte
 * 
 * <p>
 * Pour information : Classe Carte Wrapper Carte Google Lire :
 * https://developers.google.com/maps/documentation/javascript/reference?hl=fr#ControlPosition
 * http://leafletjs.com/reference.html#marker
 * </p>
 * 
 * 
 * 
 * 
 * 
 */

/* Controlleur Carte */

Ext.define('MieuxTrierANantes.controller.GeoController', {
	extend : 'MieuxTrierANantes.controller.AbstractController',
	config : {
		refs : {
			mapOSM : 'maposm_xtype'
			/*
			 * maposm_xtype : { selector : 'maposm_xtype', xtype :
			 * 'maposm_xtype', autoCreate : true }
			 */
		},
		control : {
			mapOSM : {
				activate : 'onMapActivate'
			}

		}
	},

	/**
	 * Action réalisée lorsqu'on active le panel Carte
	 */
	onMapActivate : function(container, newc) {

		var map = this.getMapOSM();

		if (!Ext.isDefined(this.structureGeoStore)) {
			this.loadStructures(map);

		};

	},

	loadStructures : function(map) {

		for (var layerid in map.layermapping) {
			map.mesLayers[layerid].clearLayers();
		}
		// Ajoute un cercle pour 'zoneLimitee'
		this.ajouteCerclesZoneLimitee(map);
		/* var circle = L.circle([map.latitudeInit,
						map.longitudeInit], map.distanceZone, {
					color : 'green',
					fillColor : '#c2e47e',
					fillOpacity : 0.3
				});
		circle.addTo(map.mesLayers['zoneLimitee']);
		 */

		// Charge le store
		this.structureGeoStore = Ext.create(
				'MieuxTrierANantes.store.StructureGeoStore', {
					autoLoad : false
				});

		this.structureGeoStore.load(function(records, operation, success) {

					records.forEach(function(element, index, array) {

								this.addStructure(map, element);
							});

				}, this);

	},

	init : function(map, geoController) {

		map.geoController = geoController;
		console.debug('LEAFLET : init');

		// INFOS LAYERS
		map.layermapping['zoneLimitee'] = {
			name : 'zoneLimitee',
			iconurl : 'resources/icons/marker-cible.png',
			label : map.labelZone5Kms
					+ ' <img style="width:10%" src="resources/icons/icon-green.png">'
		};
		map.layermapping['smco_reemp'] = {
			name : 'Récup',
			iconurl : 'resources/icons/marker-icon-green.png',
			label : '<img style="width:10%" src="resources/icons/marker-icon-green.png"> Réemploi'
		};
		map.layermapping['modco_distrisac'] = {
			name : 'Distrisac',
			iconurl : 'resources/icons/marker-icon-red.png',
			label : '<img style="width:10%" src="resources/icons/marker-icon-red.png"> Trisac'
		};

		map.layermapping['modco_decheterie'] = {
			name : 'Déchèterie / Ecopoint',
			iconurl : 'resources/icons/marker-icon-pink.png',
			label : '<img style="width:10%" src="resources/icons/marker-icon-pink.png"> Déchèterie / Ecopoint'
		};
		map.layermapping['modco_conteneur'] = {
			name : 'Conteneur',
			iconurl : 'resources/icons/marker-icon-brown.png',
			label : '<img style="width:10%" src="resources/icons/marker-icon-brown.png"> Conteneur'
		};

		map.posLatitudeInit = map.config.defaultLocation[0];
		map.longitudeInit = map.config.defaultLocation[1];

		mapObj = map;

		// Création des couches "GeoJson"
		for (var layerid in map.layermapping) {
			map.mesLayers[layerid] = L.geoJson([], {
				// PointToLayer
				pointToLayer : function(feature, latlng) {
					if (mapObj.layermapping[feature.properties.type] != 'undefined') {
						iconUrl = mapObj.layermapping[feature.properties.type].iconurl;
					}
					myIcon = L.icon({
								iconUrl : iconUrl
							});
					finalMarker = L.marker(latlng, {
								icon : myIcon
							});
					return finalMarker;
				},
				onEachFeature : this.onEachFeature
			});

		}

		// Création de la couche "contrôle"
		overlays = {};
		map.controlLayer = L.control.layers(null, overlays, {
					collapsed : false
				});

		// Creation de la carte (Utilisation HTML DOM) sur évènement "painted"
		this.on('painted', this.onPainted, this);

	},
	/**
	 * Ajout d'un point sur la carte, correspondant à une structure
	 */
	addStructure : function(map, record) {

		var afficheStructure = true;

		// VERIFICATION que toutes les données nécessaires sont présentes
		if (record.get('modesCollecte') == null
				|| record.get('latitude') == null
				|| record.get('longitude') == null) {
			console
					.log('Paramètres manquants pour ajouter la structure à la carte');
			afficheStructure = false;
		}

		// VERIFICATION que l'on est dans la zône
		if (afficheStructure == true && map.zoneLimiteeActif == true) {
			var latLngCentre = L.latLng(map.posLatitudeInit, map.longitudeInit);
			var latLngStructure = L.latLng(record.get("latitude"), record
							.get("longitude"));
			var distanceEnMetre = latLngStructure.distanceTo(latLngCentre);
			if (distanceEnMetre > map.distanceZone) {
				// console.debug("LEAFTMAP : hors zone");
				afficheStructure = false;
			}
		}

		if (afficheStructure == true) {
			modesCollecte = record.get('modesCollecte');

			// Pour simplifier on convertit les modes de collecte
			// (",modco_contembjournmag..."), idem pour écopoints en
			// déchèterie
			if (modesCollecte.substring(0, 10) == ',modco_con') {
				modesCollecte = 'modco_conteneur';
			}
			if (modesCollecte == 'modco_ecopoint') {
				modesCollecte = 'modco_decheterie';
			}

			// FILTER STRUCTURES
			if (modesCollecte != 'modco_distrisac'
					&& modesCollecte != 'modco_decheterie'
					&& modesCollecte != 'smco_reemp'
					&& modesCollecte != 'modco_conteneur') {
				afficheStructure = false;
			}

			layerId = modesCollecte;
			latitude = record.get('latitude');
			longitude = record.get('longitude');

			popuptext = '';

			if (record.get('type') != null && record.get('type') != '') {
				popuptext = popuptext + '<b>' + record.get('type')
						+ '</b><br/>';
			}
			if (record.get('libelle') != null && record.get('libelle') != '') {
				popuptext = popuptext + record.get('libelle') + '<br/>';
			}

			if (record.get('adresseTemp') != null) {
				popuptext = popuptext + record.get('adresseTemp');
			}

			newcoord = [longitude, latitude];

			geojsonFeature = {
				"type" : "Feature",
				"properties" : {
					type : layerId,
					popupContent : popuptext
				},
				"geometry" : {
					"type" : "Point",
					"coordinates" : newcoord
				}
			};

			if (typeof map.mesLayers[layerId] == 'undefined') {
				afficheStructure = false;
			}

		}

		if (afficheStructure == true) {
			// console.debug('ADD POINT (' + latitude + ',' + longitude + ')');
			map.mesLayers[layerId].addData(geojsonFeature);
		}

	},
	
	

	/**
	 * Méthode invoquée lors de l'évènement fin déplacement de zône.
	 */
	onEvenementLeafmapMoveEnd : function(e) {
		// Si je me suis déplacé de 500 mètres, je redessinne la carte
		if (map.pointEstDansZoneLimitee(e.target.getCenter(),
				map.distanceAvantRedessiner) == false) {
			map.posLatitudeInit = e.target.getCenter().lat;
			map.longitudeInit = e.target.getCenter().lng;
			map.geoController.loadStructures(map);
		}
	},

	/**
	 * Vérifie si les coordonnées en paramètre correspondent à un point de la
	 * zône limitée.<br/> Invoque estDansZoneLimitee .
	 */
	pointEstDansZoneLimitee : function(latitude, longitude, distance) {
		var latlng = L.latLng(latitude, longitude);
		var resultat = map.estDansZoneLimitee(latlng, distance);
		return resultat
	},

	/**
	 * Vérifie si le point en paramètre correspond à un point de la zône
	 * limitée.
	 */
	estDansZoneLimitee : function(point, distance) {
		var latlng = L.latLng(map.posLatitudeInit, map.longitudeInit);
		var distanceEnMetre = latlng.distanceTo(point);
		var resultat = distanceEnMetre < distance;
		return resultat;
	},

	/**
	 * On sélectionne une option du menu de contrôle
	 */
	onEventOverlayadd : function(layersControlEvent) {
		if (layersControlEvent.name.substring(0, map.tailleZone5Kms) == map.labelZone5Kms) {
			map.zoneLimiteeActif = true;
			map.geoController.loadStructures(map);
		}
	},

	/**
	 * On déselectionne une option du menu de contrôle
	 */
	onEventOverlayremove : function(layersControlEvent) {
		if (layersControlEvent.name.substring(0, map.tailleZone5Kms) == map.labelZone5Kms) {
			map.zoneLimiteeActif = false;
			map.geoController.loadStructures(map);
		}
	},

	onPainted : function(conteneur) {

		console.debug('LEAFLET : EXT onPainted');

		if (!Ext.isDefined(map.mapobj)) {

			// INIT MAX BOUNDS (Nantes et agglo)
			maxbounds = new L.LatLngBounds(map.config.bounds.min,
					map.config.bounds.max);

			// Base Tile Layer
			osmUrl = 'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
			osmAttrib = '© Openstreetmap';
			osmLayer = new L.TileLayer(osmUrl, {
						attribution : osmAttrib,
						unloadInvisibleTiles : true,
						reuseTiles : true
					});

			console.debug('LEAFLET : MAP CREATE DEFAULT LOCATION LAT : '
					+ map.config.defaultLocation[0] + ', LONG :'
					+ map.config.defaultLocation[1]);

			map.mapobj = new L.Map(map.getId(), {
						layers : [osmLayer],
						maxBounds : maxbounds,
						center : [map.config.defaultLocation[0],
								map.config.defaultLocation[1]],
						zoom : map.config.defaultZoom,
						minZoom : map.config.minZoom
					});

			// Evenement fin déplacement de zône
			map.mapobj.on('moveend', this.onEvenementLeafmapMoveEnd, map);

			// Ajout des cercles sur zône limitée
			this.ajouteCerclesZoneLimitee(map);

			// Ajoute les couches GeoJson
			for (var layerid in map.mesLayers) {

				// Ajoute la couche "GeoJson" à la carte
				map.mesLayers[layerid].addTo(map.mapobj);
				// Ajoute la couche "GeoJson" à la couche "contrôle"
				layerName = map.layermapping[layerid].label;
				map.controlLayer
						.addOverlay(map.mesLayers[layerid], layerName);

			}
			// Ajoute la couche "contrôle" à la carte
			map.controlLayer.addTo(map.mapobj);
			// Ajoute la couche "fond" à la carte
			var geoJson = L.geoJson([]);
			geoJson.addTo(map.mapobj);

			/*
			 * var geojsonFeature = { "type" : "Feature", "properties" : { type :
			 * 'zoneLimitee' }, "geometry" : { "type" : "Point", "coordinates" :
			 * [map.posLatitudeInit, map.longitudeInit] } };
			 * map.mesLayers['zoneLimitee'].addData(geojsonFeature);
			 */
			// geojsonFeature.addTo(map.mesLayers['zoneLimitee']);
			// Evenements : sélection/déselection dans la zône de contrôle
			map.mapobj.on('overlayadd', map.onEventOverlayadd, map);
			map.mapobj.on('overlayremove', map.onEventOverlayremove, map);
			// Par défaut la zone est limitée
			map.zoneLimiteeActif = true;
			// Mettre une image de fond
			// 

			// GEOLOCALISATION ACTIVE ?
			if (map.config.detectLocation) {
				console.log('LEAFLET : Recherche position GPS...');
				var geoLocation = Ext.create('Ext.util.Geolocation', {
							autoUpdate : false,
							timeout : map.timeoutGeolocalisation
						});
				geoLocation.updateLocation(this.onLocationUpdate, map);

			}

		}

	},

	/**
	 * Mettre une image de fond
	 */
	ajouteImageDeFond : function() {
		var imageUrl = 'resources/images/capture_fond_nantes.png';
		var imageBounds = [[47.10, -1.30], [47.37, -1.86]];
		var image = L.imageOverlay(imageUrl, imageBounds);
		image.addTo(map.mesLayers['zoneLimitee']);
	},

	/**
	 * Mettre 2 cercles (un petit et un grand) pour zôneLimitee
	 */
	ajouteCerclesZoneLimitee : function(map) {
		var latitude = map.posLatitudeInit - 0.002;
		var circle = L.circle([latitude, map.longitudeInit],
				map.distanceZone, {
					color : 'green',
					fillColor : '#c2e47e',
					fillOpacity : 0.3
				});
		circle.addTo(map.mesLayers['zoneLimitee']);
		var circle2 = new L.CircleMarker([latitude,
						map.longitudeInit], {
					rayon : 5,
					color : 'darkgreen',
					fillColor : "green",
					fillOpacity : 0.8
				});
		circle2.addTo(map.mesLayers['zoneLimitee']);
	},

	/**
	 * Methode invoquée lors de l'évènement mise-à-jour de la géolocalisation
	 */
	onLocationUpdate : function(map, geoLocation) {

		if (geoLocation !== null) {
			map.posLatitudeInit = geoLocation.getLatitude();
			map.longitudeInit = geoLocation.getLongitude();

			console.debug('LEAFLET : GEOLOCALISATION LAT : '
					+ geoLocation.getLatitude() + ', LONG : '
					+ geoLocation.getLongitude());
			this.resetCenter(map, geoLocation.getLatitude(), geoLocation
							.getLongitude());
		} else {
			console
					.debug('LEAFLET : GEOLOCALISATION : En dehors de la zône prévue');
		}

	},

	/**
	 * Met-à-jour le centre de la carte (appelé lorsque l'on détecte un
	 * changement de géo-localisation)
	 */
	resetCenter : function(map, latitude, longitude) {

		console.debug('LEAFLET : resetCenter LAT : ' + latitude + ', LONG : '
				+ longitude);
		var latlng = L.latLng(latitude, longitude);
		// ??
		// map.mapobj.setView(latlng);
	},

	onEachFeature : function(feature, layer) {

		// does map feature have a property named popupContent?
		if (feature.properties && feature.properties.popupContent) {
			layer.bindPopup(feature.properties.popupContent);
		}
	}


});
