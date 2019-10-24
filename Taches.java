public class Taches{

    //Déclarations des attributs
    private String nom;
	private String description;
	private boolean etat;

    //Création du constructeur
    public Taches(String _nom, String _description, boolean _etat){
        //Initialisation des attributs
        nom = _nom;
        description = _description;
        etat = _etat;
    }

    //Cette méthode permet recuperer le nom de la tache
    public String getNomTache(){
        return nom;
    }

    //Cette méthode permet recuperer le nom de la tache
    public String getDescriptionTache(){
        return description;
    }

    //Cette méthode permet recuperer le nom de la tache
    public boolean getEtatTache(){
        return etat;
    }

    //Cette méthode permet recuperer le nom de la tache
    public void setNomTache(String _nom){
        nom =  _nom;
    }
    
    //Cette méthode permet recuperer le nom de la tache
    public void setDescriptionTache(String _description){
        description = _description;
    }
    
    //Cette méthode permet recuperer le nom de la tache
    public void setEtatTache(boolean _etat){
        etat = _etat;
    }

    //Re-définition du toString
    @Override
    public String toString(){
        return "Nom : "+nom+" - Description : "+description+" - état : "+etat;
    }
    
}