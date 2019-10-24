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

        //Création du menu
        boolean arretMenu = false;
        while (!arretMenu){
            System.out.println("--------------- MENU ----------------");
            System.out.println("1. Ajouter une/des tache(s)");
            System.out.println("2. Modifier une tache");
            System.out.println("3. Supprimer une tache");
            System.out.println("4. Afficher les taches");
            System.out.println("5. Afficher les taches (logs)");
            System.out.println("6. Quitter");

            switch(sc.nextInt()){
                case 1 : 
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
                    break;
                case 2 : 
                    //Je remets a zero mon scanner
                    sc = new Scanner(System.in);
                    //Je demande à l'utilisateur d'entrée le nom de la tache a modifier
                    System.out.println("Entrez le nom de la tache a modifier :");
                    String recupTacheEntreePourEdit = sc.nextLine();
                    //Je vais chercher les informations de la tache en fonction de son nom 
                    System.out.println(maListe.getTacheEnParticulier(recupTacheEntreePourEdit));
                    //Je vais demander à l'utilisateur, si il veut modifier le nom ou la description ou l'etat
                    System.out.println("Vous voulez modifier :");
                    System.out.println("1. Le nom");
                    System.out.println("2. La description");
                    System.out.println("3. L'état");
                    switch(sc.nextInt()){
                        case 1:
                            sc = new Scanner(System.in);
                            System.out.println("Entrez le nouveau nom :");
                            //Je change le nom de la tache
                            if(maListe.editNomTache(recupTacheEntreePourEdit, sc.nextLine()) == true){
                                System.out.println("Mise à jour ok");
                            }else{
                                System.out.println("Erreur lors de modification");
                            }
                            break;
                        case 2:
                            sc = new Scanner(System.in);
                            System.out.println("Entrez la nouvelle description :");
                            //Je change le nom de la tache
                            if(maListe.editDescriptionTache(recupTacheEntreePourEdit, sc.nextLine()) == true){
                                System.out.println("Mise à jour ok");
                            }else{
                                System.out.println("Erreur lors de modification");
                            }
                            break;
                        case 3: 
                            sc = new Scanner(System.in);
                            System.out.println("Entrez le nouvelle état : (1 = finis, 0 = a faire)");
                            //Je change le nom de la tache
                            if(maListe.editEtatTache(recupTacheEntreePourEdit, sc.nextInt()) == true){
                                System.out.println("Mise à jour ok");
                            }else{
                                System.out.println("Erreur lors de modification");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 3 : 
                    //Je remets a zero mon scanner
                    sc = new Scanner(System.in);
                    //Je demande à l'utilisateur d'entrée le nom de la tache a supprimer
                    System.out.println("Entrez le nom de la tache a supprimer :");
                    String recupTacheEntree = sc.nextLine();
                    //Je supprime la tache
                    if(maListe.removeTache(recupTacheEntree) == true){
                        //Si je trouve la tache, j'affiche ce message
                        System.out.println("La tache "+recupTacheEntree+" est supprimée");
                    }else{
                        //Si je ne trouve pas le nom de la tache alors j'affiche ce message
                        System.out.println("La tache n'existe pas.");
                    }
                    break;
                case 4: 
                    //Je vais afficher un message si je n'ai pas de tache
                    if(maListe.getNombreDeTache() == 0){
                        System.out.println("Aucune tache.");
                    }else{
                        //Sinon j'affiche mes taches
                        maListe.getListeTaches();
                    }
                    break;
                case 5: 
                    //Sinon j'affiche mes taches
                    maListe.getListeTachesLogs();
                    break;
                case 6:
                    arretMenu = true;
                    sc.close();
                    break;
                default:
                    System.out.println("Entrez un choix entre 1 et 5"); 
                    break;
            }

        }
        

        
    }

}