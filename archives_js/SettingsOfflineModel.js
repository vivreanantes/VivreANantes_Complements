Ext.define('MieuxTrierANantes.model.Online', {
 extend: 'Ext.data.Model',
  config: {
    fields: [
      'name'
    ],
    identifier:'uuid', // needed to avoid console warnings!
    proxy: {
      type: 'localstorage',
      id  : 'news'
    }
  }
});