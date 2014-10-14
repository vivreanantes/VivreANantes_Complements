/**
 * Carte de l'application, permettant d'afficher les différents points d'intérét
 * Version Open Street Map Doc : http://leafletjs.com/reference.html
 * 
 * Nantes 47.233 -1.583 Toulouse 43.617 1.450
 * 
 * 464,85 (43,617-47,233) (+1,583-1,450) = 0,018 + 13,07 (43,617-47,233) 3,61 ->
 * 464850 m 0,00008 10 m
 * 
 * this.posLatitudeInit: -1.546203 this.longitudeInit: 47.21
 * record.get("longitude"): "47.199656" record.get("latitude"): "-1.624346"
 * ((record.get("longitude")-this.longitudeInit)(record.get("longitude")-this.longitudeInit))+((record.get("latitude")-this.posLatitudeInit)(record.get("latitude")-this.posLatitudeInit))
 * 
 * 
 * "-1.5578842", "longitude" : "47.2143672",
 * 
 * @author redebernardi
 */
Ext.define('MieuxTrierANantes.view.geo.MapOSM', {
	extend : 'Ext.Container',
	xtype : 'maposm_xtype',
	requires : ['Ext.util.Geolocation'],
	config : {
		title : 'Carte',
		iconCls : 'locate',
		detectLocation : true, // TRUE pour activer la geolocalisation a l'init
		// de la carte
		// CHRIS_20141007 defaultLocation : [47.14, -1.60], // Latitude,
		// longitude par défaut a l'init de la carte (avant la geolocalisation
		// eventuelle)
		defaultLocation : [47.21, -1.54], // Latitude, longitude par
		// défaut a l'init de la carte
		// (avant la geolocalisation
		// eventuelle)
		// CHRIS_20141007
		// LIMITE SCROLL CARTE : Agglomeration NANTES / SAINT NAZAIRE
		bounds : {min : [47.84, -2.26], max : [47.11, -1.13]},
		// //
		/*bounds : {
			min : [47.10, -1.30],
			max : [47.37, -1.86]
		}, // LIMITE SCROLL CARTE : NANTES Metropôle
		*/
		defaultZoom : 14,
		minZoom : 11
	},

	/* PRIVATE */
	labelZone5Kms : "Zône de 5 kms",
	tailleZone5Kms : 13,
	distanceZone : 2500,
	distanceAvantRedessiner : 500,
	timeoutGeolocalisation : 60000,
	mesLayers : [],
	layermapping : [],
	controlLayer : null,

	constructor : function() {

		this.callParent(arguments);
	}
});