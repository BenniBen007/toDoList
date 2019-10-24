import java.util.*;

public class ToDo{

    //Déclaration des attributs
    private String nomToDoList;
    private Collection<Taches> mesTaches;
    private Collection<String> mesTachesLogs;

    //Création du constructeur
    public ToDo(String _nomtoDoList){
        //Initialisation des attributs
        nomToDoList = _nomtoDoList;
        mesTaches = new ArrayList<>();
        mesTachesLogs = new ArrayList<>();
    }

    //Cette méthode permet d'ajouter une tache
    public void addTaches(Taches nouvelleTache){
        //Je mets dans ma collection ma tache
        mesTaches.add(nouvelleTache);
    }   

    //Cette méthode permet de lister les taches de ma liste
    public void getListeTaches(){
        Iterator<Taches> it = mesTaches.iterator();

        //Je boucle tant que j'ai element
        while(it.hasNext()){
            Taches myElement = it.next();
            System.out.println(myElement);
        }
    }

    //Cette méthode permet de lister les logs des modifications
    public void getListeTachesLogs(){
        Iterator<String> it = mesTachesLogs.iterator();

        //Je boucle tant que j'ai element
        while(it.hasNext()){
            String myElement = it.next();
            System.out.println(myElement);
        }
    }

    //Cette méthode permet de supprimer une tache
    public boolean removeTache(String _nomTache){
        //Cette variable va me faire passer le resultat de la suppression
        boolean result = false;
        Iterator<Taches> it = mesTaches.iterator();

        //Je boucle tant que j'ai element
        while(it.hasNext()){
            Taches myElement = it.next();
            //Si le nom de ma tache est egal a mon de tache
            if(myElement.getNomTache().equals(_nomTache)){
                //Je vais mettre dans la log la tache supprimée
                mesTachesLogs.add("Suppression de la tache "+_nomTache);
                //alors je passe a true le result
                result = true;
                //Et je supprime cette element
                it.remove();
            }
        }
        //Et je retourne le resultat
        return result;
    }

    //Cette méthode permet de remonter le nombre de tache
    public int getNombreDeTache(){
        return mesTaches.size();
    }

    //Cette méthode permet de remonter le nombre de logs 
    public int getNombreDeTacheLogs(){
        return mesTachesLogs.size();
    }

    //Cette méthode permet d'afficher une tache en particulier
    public String getTacheEnParticulier(String _nomTache){
        //Création du string de retour
        String result = "";
        Iterator<Taches> it = mesTaches.iterator();

        //Je boucle tant que j'ai element
        while(it.hasNext()){
            Taches myElement = it.next();
            //Si le nom de ma tache est egal a mon de tache
            if(myElement.getNomTache().equals(_nomTache)){
                result = "Nom : "+myElement.getNomTache()+" - Description : "+myElement.getDescriptionTache()+" - état : "+myElement.getEtatTache();
            }
        }

        return result;
    }

    //Cette méthode permet de modifier une tache
    public boolean editNomTache(String _nomTacheBase, String _nouveaunomTache){
        //Cette variable va contenir le resultat de la méthode
        //Par défaut elle est sur false
        boolean result = false;

        Iterator<Taches> it = mesTaches.iterator();

        //Je boucle tant que j'ai element
        while(it.hasNext()){
            Taches myElement = it.next();
            //Si le nom de ma tache est egal a mon de tache
            if(myElement.getNomTache().equals(_nomTacheBase)){
                //J'ajoute la tache dans les logs
                mesTachesLogs.add("Changement de nom pour la tache "+_nomTacheBase+" en "+_nouveaunomTache);
                //Je mets a jour le nom de la tache
                myElement.setNomTache(_nouveaunomTache);
                //Je retourne true
                result = true;
            }
        }

        return result;
    }


    public boolean editDescriptionTache(String _nomTacheBase, String _nouvelleDescription){
        //Cette variable va contenir le resultat de la méthode
        //Par défaut elle est sur false
        boolean result = false;

        Iterator<Taches> it = mesTaches.iterator();

        //Je boucle tant que j'ai element
        while(it.hasNext()){
            Taches myElement = it.next();
            //Si le nom de ma tache est egal a mon de tache
            if(myElement.getNomTache().equals(_nomTacheBase)){
                //J'ajoute la tache dans les logs
                mesTachesLogs.add("Changement de la description de la tache "+_nomTacheBase+" : de "+myElement.getDescriptionTache()+ " en "+_nouvelleDescription);
                //Je mets a jour la description de la tache
                myElement.setDescriptionTache(_nouvelleDescription);
                //Je retourne true
                result = true;
            }
        }

        return result;
    }

    public boolean editEtatTache(String _nomTacheBase, int _nouvelleEtat){
        //Cette variable va contenir le resultat de la méthode
        //Par défaut elle est sur false
        boolean result = false;
        //Cette variable me permet de stocker mon etat
        boolean monEtatNouveau = false;

        //Je convertis mon int en bool (a l'ancienne)
        if(_nouvelleEtat == 0){
            monEtatNouveau = false;
        }else{
            monEtatNouveau = true;
        }

        Iterator<Taches> it = mesTaches.iterator();

        //Je boucle tant que j'ai element
        while(it.hasNext()){
            Taches myElement = it.next();
            //Si le nom de ma tache est egal a mon de tache
            if(myElement.getNomTache().equals(_nomTacheBase)){
                //J'ajoute la tache dans les logs
                mesTachesLogs.add("Changement de l'état de la tache "+_nomTacheBase+" de : "+myElement.getEtatTache()+" en "+monEtatNouveau);
                //Je mets a jour l'état de la tache
                myElement.setEtatTache(monEtatNouveau);
                //Je retourne true
                result = true;
            }
        }

        return result;
    }

}