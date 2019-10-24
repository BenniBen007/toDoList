import java.util.*;

public class ToDo{

    //Déclaration des attributs
    String nomToDoList;
    Collection<Taches> mesTaches;

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


}