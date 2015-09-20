/**
 * Vue principale des Actualités
 * 
 * Ext.define('MieuxTrierANantes.view.news.News', { extend:
 * 'Ext.NavigationView', xtype : 'news_xtype', config: { fullscreen: true, tpl: '
 * <p>
 * The ID is {id}
 * </p>
 * <p>
 * The content is {content}
 * </p>' } });
 */
Ext.define('MieuxTrierANantes.view.home.HomeOld', {
	extend : 'Ext.navigation.View',
	xtype : 'homeold_xtype',
	config : {
		autoDestroy : false,
		title : 'Déchets',
		items : [{
					// xtype : 'homeContainer_xtype'
					xtype : 'homeContainer_xtype'
			}
		],
		navigationBar : {
			items : [{
					xtype : 'button',
					iconCls : 'home',
					// ui : 'round', // bouton arrondi
					align : 'right',
					id : 'garbagehomeButton',
					disabled : false
				}
			],
			docked : 'top'
		},
		defaultBackButtonText : "Retour"
	}
});