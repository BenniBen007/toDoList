public class Main{

    public static void main(String[] args){
        
        Taches tache1 = new Taches("truc1","ma description1",false);
        Taches tache2 = new Taches("truc2","ma description2",false);
        Taches tache3 = new Taches("truc3","ma description3",false);

        ToDo maListe = new ToDo("ma liste a faire");

        maListe.addTaches(tache1);
        maListe.addTaches(tache2);
        maListe.addTaches(tache3);

        maListe.getListeTaches();

    }

}