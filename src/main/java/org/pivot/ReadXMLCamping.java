package org.pivot;
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Date;
import org.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.objects.Category;
import org.hibernate.objects.City;
//import org.hibernate.objects.Criteria;
import org.hibernate.objects.Interest;
import org.hibernate.objects.Medium;
 
public class ReadXMLCamping {
    
    
    public ReadXMLCamping(){
    }
    
    public void load(String file){
        try {
            File fXmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("offre");
            //System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        parsePOI(nNode, xml2cat(file));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public Integer xml2cat(String file) {
      Integer category=null;
      if ("Camping.xml".equals(file)) category=1;
      if ("ChambreHote.xml".equals(file)) category=1;       
      if ("DecouverteDivertissement.xml".equals(file)) category=8;   
      if ("Evenement.xml".equals(file)) category=9;      
      if ("Gite.xml".equals(file)) category=1;      
      if ("Hotel.xml".equals(file)) category=1;      
      if ("Meuble.xml".equals(file)) category=1;      
      if ("OrganismeTouristique.xml".equals(file)) category=3;      

      return category;
    }   
    
    public static void main(String argv[]) {
      
        ReadXMLCamping xml = new ReadXMLCamping();  
        xml.load("Camping.xml");
        xml.load("ChambreHote.xml");
        xml.load("DecouverteDivertissement.xml");
        xml.load("Evenement.xml");
        xml.load("Gite.xml");
        xml.load("Hotel.xml");
        xml.load("Meuble.xml");
        xml.load("OrganismeTouristique.xml");
    }
  
    public void parsePOI(Node node, Integer categoryId) {
        Element eElement = (Element) node;
        String codePostal=eElement.getElementsByTagName("cp").item(0).getTextContent(),
               province=eElement.getElementsByTagName("province").item(0).getTextContent();
        if (codePostal==null || "".equals(codePostal)) return; //code postal non spéficié

        Integer cp= new Integer(codePostal);
        //keep only 6782,6780,6781,6630,6792,6791,6790,6717,6706,6700,6704
        if (!cp.equals(new Integer(6782)) &&
            !cp.equals(new Integer(6780)) &&
            !cp.equals(new Integer(6781)) &&
            !cp.equals(new Integer(6630)) &&
            !cp.equals(new Integer(6792)) &&
            !cp.equals(new Integer(6791)) &&
            !cp.equals(new Integer(6790)) &&
            !cp.equals(new Integer(6717)) &&
            !cp.equals(new Integer(6706)) &&
            !cp.equals(new Integer(6700)) &&
            !cp.equals(new Integer(6704))     
                /*&& "Luxembourg".equals(province)*/ ) return; // bypassé ce qui n'est pas arlon mais est de la province de lux
                  // pour éviter des doublons avec HADES, 
                  // on pourrait charger HADES pour les données prov Lux
                  // et PIVOT pour les données hors prov Lux


        Session session = HibernateUtil.getSessionFactory().openSession();

        // traitement cities
        session.beginTransaction();
        Query query=session.createQuery("from City where zip="+cp+"");
        query.setMaxResults(1);
        City city= (City) query.uniqueResult();
        if (city==null) {
            // first city creation test
            //city=new City("arlon3", new Float(2.2),new Float(2.3),new Date(),new Date());
            city=new City();
            city.setCity(eElement.getElementsByTagName("localite").item(0).getTextContent());
            city.setZip(cp);
            city.setCreated_at(new Date());
            city.setUpdated_at(new Date());

            session.save(city); 
            session.getTransaction().commit();
            System.out.println("city"+city.getCity()+"CREATED");
        } else {
            session.getTransaction().rollback();
        }

        // traitement POI
        session.beginTransaction();
        String cgt_code=eElement.getElementsByTagName("codeCGT").item(0).getTextContent();
        query=session.createQuery("from Interest where cgt_code='"+cgt_code+"'");
        query.setMaxResults(1);
        Interest interest= (Interest) query.uniqueResult();
        if (interest==null) {
            interest= new Interest();
            /* Category category=new Category();
            Criteria criteria=new Criteria();*/
            interest.setAddress(eElement.getElementsByTagName("rue").item(0).getTextContent()+","+
                                eElement.getElementsByTagName("numero").item(0).getTextContent()/*+"/"+
                                eElement.getElementsByTagName("boite").item(0).getTextContent()*/);
            interest.setZip(cp);
            interest.setCgt_code(cgt_code);
            interest.setLatitude(new Float(eElement.getElementsByTagName("coord_geo_latitude").item(0).getTextContent()));
            interest.setLongitude(new Float(eElement.getElementsByTagName("coord_geo_longitude").item(0).getTextContent()));
            interest.setDescription(eElement.getElementsByTagName("descriptif").item(0).getTextContent());
            interest.setName(eElement.getElementsByTagName("nom").item(0).getTextContent());
            interest.setCreated_at(new Date());
            interest.setUpdated_at(new Date());
            interest.setSource("PIVOT");
            interest.setCategory_id(new Integer(categoryId)); 

            //TODO: changer id city
            interest.setCity_id(city.getId()); // Arlon

            // Moyens de communications
            NodeList moyenComs=eElement.getElementsByTagName("tmoyencom");
            for (int temp = 0; temp < moyenComs.getLength(); temp++) {

                    Node moyenCom = moyenComs.item(temp);
                    //System.out.println("\nCurrent Element :" + moyenCom.getNodeName());

                    if (moyenCom.getNodeType() == Node.ELEMENT_NODE) {

                            //parsePOI(nNode);
                            Element comElement = (Element) moyenCom;
                            //NodeList moyenom=eElement.getElementsByTagName("tmoyencom");
                            String type= comElement.getElementsByTagName("type").item(0).getTextContent();
                            if ("Téléphone".equals(type) || 
                                "Courriel".equals(type)  ||
                                "Site internet".equals(type) ) {
                                String val= comElement.getElementsByTagName("coordonnees_moyen_com").item(0).getTextContent();
                                System.out.println(type+"--"+val); 
                                if ("Téléphone".equals(type)) interest.setPhone(val);
                                if ("Courriel".equals(type)) interest.setEmail(val);
                                if ("Site internet".equals(type)) interest.setWebsite(val);

                             }
                    }
            }    

            session.save(interest); 

            session.getTransaction().commit();
            System.out.println("Poi:"+interest.getCgt_code()+"CREATED");
            
            
            // annexe medias
            NodeList medias=eElement.getElementsByTagName("tannexes");
            for (int temp = 0; temp < medias.getLength(); temp++) {

                    Node media = medias.item(temp);

                    //System.out.println("\nCurrent Element :" + media.getNodeName());

                    if (media.getNodeType() == Node.ELEMENT_NODE) {

                            //parsePOI(nNode);
                            Element comElement = (Element) media;
                            //NodeList moyenom=eElement.getElementsByTagName("tmoyencom");
                            String url= comElement.getElementsByTagName("url").item(0).getTextContent().trim();
                            String type= comElement.getElementsByTagName("type").item(0).getTextContent().trim();
                            // transformation du type du medium
                            if (type!=null) {
                                if ("0".endsWith(type)) type = "Picture";
                                else if ("2".endsWith(type)) type = "Video";
                                else type="";
                            }

                            if (  (!"".equals(type)) &&
                                (url!=null) && (!"".equals(url)) ) {

                                session.beginTransaction();

                                Medium medium=new Medium();
                                medium.setCreated_at(new Date());
                                medium.setUpdated_at(new Date());
                                medium.setInterest_id(interest.getId());
                                medium.setType(type);
                                medium.setUrl(url);

                                session.save(medium); 
                                session.getTransaction().commit();

                            }
                    }
            }                

        } else {
            //cas udpate interest
            interest.setCity_id(city.getId()); // au lieu du 1 par defaut pour Arlon
            session.update(interest); 
            session.getTransaction().commit();
            System.out.println("Poi:"+interest.getCgt_code()+" already exist");
        }




  }
 
}