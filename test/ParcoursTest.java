import genielogiciel.*;
import java.util.ArrayList;
import junit.framework.TestCase;


public class ParcoursTest extends TestCase{
    
    Metro m=new Metro();
    
//    public void testdijkstra(){
//        Parcours p=new Parcours(m.getStation(0),m.getStation(7));
//        ArrayList a=p.dijkstra();
//       // int lignes=  m.getNombreLignes();
//        ArrayList res=new ArrayList();
//         Station s= new Station("S2",200,230);
//       Station ss=new Station("S3",220,250);
//       Station sss=new Station("S4",260,270);
//       // Station ss2=new Station("SS3",30,40);
//       //Station sss3=new Station("SS4",40,50);
//        Station ssss=new Station("SS4",60,50);
//        
//        res.add(new Arete("S2-S3",1,s,ss));
//        res.add(new Arete("S3-S4",1,ss,sss));
//        res.add(new Arete("S4-SS4",2,sss,ssss));
//        int chn=p.getCorrespondance();
//      //  for(int i=0;i<res.size();i++){
//            assertEquals(res,a);
//         //   assertEquals(2,chn);
//       // }
//    }
    
    public void testdijkstraParPoint(){
                ArrayList res=new ArrayList();
         Station s= new Station("S2",200,230);
       Station ss=new Station("S3",220,250);
       Station sss=new Station("S4",260,270);
       Station ss2= new Station("SS2",50,15);
       ss= new Station("SS2",50,15);
       // Station ss2=new Station("SS3",30,40);
       //Station sss3=new Station("SS4",40,50);
        Station ssss=new Station("SS4",60,50);      
        res.add(new Arete("S2-S3",1,s,ss));
        res.add(new Arete("S3-S4",1,ss,sss));
        res.add(new Arete("S4-SS2",2,sss,ss2));
        res.add(new Arete("S4-SS2",2,ss2,ss));
        res.add(new Arete("S4-SS4",2,sss,ssss));       
        
        m.creerReseau();
        Parcours p=new Parcours(m.getStation(0),m.getStation(7));
         ArrayList res2=p.dijkstraParPoint(m.getStation(5));       
        assertEquals(res,res2);
        //assertEquals(2,p.getCorrespondance());
             
    }
    
    
    public void testdijkstraChangements(){
         Parcours p=new Parcours(m.getStation(0),m.getStation().get(11));
         Station ss2=new Station("SS3",50,20);
         ArrayList s= p.dijkstraChangements(p.getDepart(),p.getArrivee());
         ss2.setLigne(2);
         
        assertEquals(ss2,s);
    }
    
    
    public static void assertEquals(ArrayList o,ArrayList r){
        for(int i=0;i<r.size();i++){
            o.get(i).equals(r.get(i));
        }
    }
    
}
