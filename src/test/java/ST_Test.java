import com.wjf.github.algorithm.struct.ArraySortST;
import org.junit.Test;

public class ST_Test {

    @Test
    public void ArraySortST_Test(){
        ArraySortST<Integer,Integer> sortST = new ArraySortST<>();
        sortST.put(2,4);
        sortST.put(13,3);
        sortST.put(3,5);
        sortST.put(22,4);
        sortST.put(13,3);
        sortST.put(34,5);
        sortST.put(21,4);
        sortST.put(103,3);
        sortST.put(33,5);
        sortST.put(25,4);
        sortST.put(13,3);
        sortST.put(13,5);
        sortST.put(4,4);
        sortST.put(7,3);
        sortST.put(8,5);
        sortST.put(2,4);
        sortST.put(13,3);
        sortST.put(3,5);
        System.out.println(sortST.rank(333));
    }

}
