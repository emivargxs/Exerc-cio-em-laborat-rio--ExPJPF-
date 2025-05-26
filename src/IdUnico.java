public class IdUnico {
    private static int idProximo =  100;
    private int id;
    
    public IdUnico(){
        this.id = idProximo++;
    }

    public int getId(){
        return id;
  }
}
