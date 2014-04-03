/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockage;

import bataille_navale.TailleGrille;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Christophe
 */
public class DAO_Parametre {

    
    ////////////////////////////// VARIABLES //////////////////////////////////
    
    
    private final String path = "fich_param.xml";
    private Document document;
    private final Element racine;

    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
    
    
    public DAO_Parametre() {
        SAXBuilder sxb = new SAXBuilder();
        try {
            //On crée un nouveau document JDOM avec en argument le fichier XML
            //Le parsing est terminé ;)
            File f = new File(path);
            document = sxb.build(f);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        racine = document.getRootElement();
    }

    
    /**
     * Permet de recuperer les tailles de grille disponible
     * @return une liste des tailles de grille disonible
     */
    public List getTaillesGrille() {
        List grillesXML = racine.getChildren("grille");
        ArrayList<TailleGrille> listeGrilles = new ArrayList<>();
        Iterator i = grillesXML.iterator();
        while (i.hasNext()) {
            Element courant = (Element) i.next();
            TailleGrille tg = new TailleGrille(Integer.parseInt(courant.getChildText("x")), Integer.parseInt(courant.getChildText("y")));
            listeGrilles.add(tg);
        }
        return listeGrilles;
    }
    
    
    public List getDifficultees() {
        Element difficulteXML = racine.getChild("difficulte");
        List modeXML = difficulteXML.getChildren("mode");
        ArrayList<String> listeDifficulte = new ArrayList<>();
        Iterator i = modeXML.iterator();
        while (i.hasNext()) {
            Element courant = (Element) i.next();
            String diff = courant.getText();
            listeDifficulte.add(diff);
        }
        return listeDifficulte;
    }
    
    
}