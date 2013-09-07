
public enum StructureName {
	  //Objets directement construits
	SAINT_ANDRE_DES_EAUX("SAINT-ANDR�-DES-EAUX"),
	PAIMBOEUF("PAIMBOEUF"),
	FROSSAY("FROSSAY"),
	SAINT_PERE_EN_RETZ("SAINT PERE EN RETZ"),
	DONGES("DONGES"),
	SAINT_BREVIN_LES_PINS("SAINT-BR�VIN LES PINS"),
	SAINT_MALO_DE_GUERSAC("SAINT-MALO-DE-GUERSAC"),
	SAINT_JOACHIM("SAINT-JOACHIM"),
	PORNICHET("PORNICHET"),
	CUNEIX("CUNEIX"),
	MEAN_PENHOET_SAINT_NAZAIRE("M�AN PENHO�T SAINT-NAZAIRE");
	    
	  private String name = "";
	    
	  //Constructeur
	  StructureName(String name){
	    this.name = name;
	  }
	    
	  public String toString(){
	    return name;
	  }
}
