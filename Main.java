import java.util.*;

public class Main{

    public static void main(String[] args){
        
        //Je demande à l'utilisateur de renseigner le nom de la toDo list
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom de votre toDo list :");
        //Je récupere la chaine que l'utilisateur a entrée
        String recupNomToDoList = sc.nextLine();

        //Je créé ma liste
        ToDo maListe = new ToDo(recupNomToDoList);

        //Je renvoi une ligne pour mieux voir
        System.out.println("-------------------------------------------");
        
        //Je vais demander à l'utilisateur de mettre une tache
        //Cette variable me permet de boucler, si la personne veut remettre une tache 
        //par la suite ( en continu )
        boolean ajoutTache = false;

        //Tant que #ajoutTache n'est pas vrai, l'utilisateur entre une tache
        while(ajoutTache == false){

            System.out.println("---------------- NOUVELLE TACHE -----------------");
            //Je dois remettre a zero mon scanner
            //Pour corriger le bug du eux .nextLine des que passe la deuxieme iteration
            sc = new Scanner(System.in);
            //Je demande le nom de la tache
            System.out.println("Entrez le nom de votre tache :");
            //Je recupere le nom de la tache
            //sc.nextLine();
            String recupNomTache = sc.nextLine();
            
            //Je demande la description de la tache
            System.out.println("Entrez la description de votre tache :");
            //Je recupere la description de la tache
            String recupDescTache = sc.nextLine();

            //Je demande l"état de la tache
            System.out.println("Entrez l'état de votre tache (1 = finis, 0 = a faire) :");

            //Cette variable me permet de convertir le 1 et 0
            boolean recupEtatTache;
            //Si je recupere 1 alors je passe a true mon etat
            if(sc.nextInt() == 1){
                recupEtatTache = true;
            }else{
                //Sinon je passe a false
                recupEtatTache = false;
            }
            
            //J'ajoute la tache (création de ma tache)
            Taches tacheAjout = new Taches(recupNomTache, recupDescTache, recupEtatTache);

            //J'ajoute a la tache a ma liste
            maListe.addTaches(tacheAjout);

            //Lorsque j'ai ajouté la tache
            //Je vais demander à l'utilisateur si il veut continuer ou pas
            System.out.println("Voulez-vous ajouter une tache (1 = oui, 0 = non)");

            if(sc.nextInt() == 0){
                ajoutTache = true;
            }
            
        }

        //Je ferme le scanner
        sc.close();

        maListe.getListeTaches();

        

    }

}