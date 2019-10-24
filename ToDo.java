import java.util.*;

public class ToDo{

    //Déclaration des attributs
    private String nomToDoList;
    private Collection<Taches> mesTaches;

    //Création du constructeur
    public ToDo(String _nomtoDoList){
        //Initialisation des attributs
        nomToDoList = _nomtoDoList;
        mesTaches = new ArrayList<>();
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
                //alors je passe a true le result
                result = true;
                //Et je supprime cette element
                it.remove();
            }
        }
        //Et je retourne le resultat
        return result;
    }

    //Cette méthode permet de remonte la nombre de tache que je possde
    public int getNombreDeTache(){
        return mesTaches.size();
    }


}