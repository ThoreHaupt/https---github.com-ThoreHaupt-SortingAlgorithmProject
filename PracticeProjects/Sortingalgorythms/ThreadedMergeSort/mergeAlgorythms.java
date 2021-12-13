package PracticeProjects.Sortingalgorythms.ThreadedMergeSort;

import java.util.ArrayList;
import java.util.HashMap;

import PracticeProjects.TLinkedList;
import PracticeProjects.TNode;
import PracticeProjects.Sortingalgorythms.Common;

public class mergeAlgorythms {
    
    public static <T> void mergeChunks(TLinkedList<T> sortList, Chunk<T> chunk1, Chunk<T> chunk2, HashMap<String, Integer> referenceMap) {
        
        int c = chunk1.getFirstIndex();
        int i = chunk2.getFirstIndex();

        TNode<T> firstNodeNewChunk = chunk1.getFirstNode();
        ArrayList<TNode<T>> chunkNodes = new ArrayList<TNode<T>>();
        chunkNodes.add(chunk1.getFirstNode());
        chunkNodes.add(chunk2.getFirstNode());
        chunkNodes.add(chunk2.getUpperNode());
        

        while (i < chunk2.getUpperIndex()) { // interates over 2nd listpart

            if (Common.firstStringbool(chunkNodes.get(1).getValue(), chunkNodes.get(0).getValue(), referenceMap)) {

                TNode<T> insertedNode = sortList.insert(chunkNodes.get(1).getValue(), chunkNodes.get(0));

                sortList.remove(chunkNodes.get(1)); // remove old element i, but it is moved bc of the insert (--> +1)

                // set firstNodeNewChunk, if this is the first comparison, if i comes before c.
                // (--> then this if statement is called)
                if (c == chunk1.getFirstIndex() && i == chunk2.getFirstIndex()) {
                    firstNodeNewChunk = insertedNode;
                }
                i++;
                c++; // c index has to move bc i was inserted before it. --> compare next element
                     // from i to c
                chunkNodes.set(1, chunkNodes.get(1).getNextNode()); // take next word from 2nd chunk(move i to the
                                                                    // right)
            } else {
                c++;
                chunkNodes.set(0, chunkNodes.get(0).getNextNode()); // compare to next character
            }
            if (chunkNodes.get(1) == null || c >= i) {
                break;
            }

        }
        chunk1.setFirstNode(firstNodeNewChunk);   
        chunk1.extend(true, chunk2.getSize(), chunkNodes.get(1));
        chunk2.remove();     
        }
}
