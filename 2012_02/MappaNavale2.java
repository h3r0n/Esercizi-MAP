
import java.util.*;

class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y){
        this.x =x;
        this.y =y;
    }
    
    public String toString(){
        return "x:"+x+" y:"+y;

    }
}

class Nave{}

public class MappaNavale2 {
    private HashMap<Coordinate,ArrayList<Nave>> map = new HashMap<Coordinate,ArrayList<Nave>>();
    private int limitX,limitY;

    public MappaNavale2(){}
    
    public void creaMappa(int x, int y){
        limitX = x;
        limitY = y;
    }

    public void assegnaNaveACella(Coordinate c,Nave n){
        try{
            checkCoordinate(c);
            if(map.containsKey(c)){
                if(containValue(n)){
                    removeValue(n);
                }
                ArrayList<Nave> tempList = map.get(c);
                tempList.add(n);
            }else{
                if(containValue(n)){
                    removeValue(n);
                }
                ArrayList<Nave> tempList = new ArrayList<Nave>();
                tempList.add(n);
                map.put(c,tempList);                
            }   
        }catch(Exception e ){
            System.out.println(e);
            return;
        }
    }

    private void checkCoordinate(Coordinate c) throws Exception{
        if(c.x < 0 || c.x > limitX){
            throw new Exception("x coordinate bad");
        }
        if(c.y < 0 || c.x > limitY){
            throw new Exception("y coordinate bad");
        }
    }
    
    private void removeValue(Nave n){
        Collection<ArrayList<Nave>> c = map.values();
        Iterator<ArrayList<Nave>>  it = c.iterator();
        int sum = 0;
        while(it.hasNext()){
            ArrayList<Nave> tmp = it.next();
            if(tmp.contains(n)){
                tmp.remove(n);
            }
        }
    }
    
    private boolean containValue(Nave n){
        Collection<ArrayList<Nave>> c = map.values();
        Iterator<ArrayList<Nave>>  it = c.iterator();
        int sum = 0;
        while(it.hasNext()){
            if(it.next().contains(n)){
                return true;
            }
        }
        return false;
    }

    public int contaNavi(){
        Collection<ArrayList<Nave>> c = map.values();
        Iterator<ArrayList<Nave>>  it = c.iterator();
        int sum = 0;
        while(it.hasNext()){
            sum += it.next().size();
        }

        return sum;
        
    }

    public String toString(){
        return map.toString();

    }


    public static void main(String[] args){
        MappaNavale2 map = new MappaNavale2();
        map.creaMappa(10,5);
        Nave naveTest = new Nave();
        map.assegnaNaveACella(new Coordinate(0,0), new Nave());
        map.assegnaNaveACella(new Coordinate(0,0), new Nave());
        map.assegnaNaveACella(new Coordinate(1,0), naveTest);
        map.assegnaNaveACella(new Coordinate(0,1), naveTest);
        
        
        System.out.println(map);

        System.out.println(map.contaNavi());
    }
    

}
