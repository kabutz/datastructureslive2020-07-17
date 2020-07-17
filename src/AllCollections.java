import java.util.*;
import java.util.concurrent.*;

public class AllCollections {
  public static void main(String... args) {
    Collection<?>[] col = {};
    Set<?>[] sets = {
        new CopyOnWriteArraySet<>(), // thread safe, but slow for large sets
        new HashSet<>(),
        new LinkedHashSet<>() // maintains insertion order
    };
    SortedSet<?>[] sortedSets = {};
    NavigableSet<?>[] navigableSets = {
        new TreeSet<>(),
        new ConcurrentSkipListSet<>() // thread safe, rather use
    };
    List<?>[] lists = {
        new Vector<>(), // thread safe, bit old
        new ArrayList<>(),
        Collections.synchronizedList(new ArrayList<>()), // thread safe
        new LinkedList<>(), // very little application
        new CopyOnWriteArrayList<>(),// thread safe
    };

    Queue<?>[] queues = {
        new ConcurrentLinkedQueue<>(), // thread safe
        new PriorityQueue<>() // priority heap - not stable
    };
    BlockingQueue<?>[] blockingQueues = {
        new ArrayBlockingQueue<>(10), // thread safe
        new LinkedBlockingQueue<>(), // thread safe
        new DelayQueue<>(), // thread safe
        new PriorityBlockingQueue<>(), // thread safe
        new SynchronousQueue<>(), // thread safe
    };
    TransferQueue<?>[] transferQueues = {
        new LinkedTransferQueue<>() // thread safe
    };
    Deque<?>[] deques = {
        new ConcurrentLinkedDeque<>(), // thread safe
        new ArrayDeque<>(),
        new LinkedList<>()
    };
    BlockingDeque<?>[] blockingDeques = {
        new LinkedBlockingDeque<>() // thread safe
    };

    Map<?, ?>[] maps = {
        new HashMap<>(), // don't use unless stack confined
        new Hashtable<>(),// thread safe
        new IdentityHashMap<>(), // hash on Object.hashCode() and equals ==
        new WeakHashMap<>(), // weak reference on keys
        new LinkedHashMap<>(), // sorts the entries either insertion or access order
    };
    SortedMap<?, ?>[] sortedMaps = {};
    NavigableMap<?, ?>[] navigableMaps = {
        new TreeMap<>(),
        new ConcurrentSkipListMap<>()// thread safe
    };
    ConcurrentMap<?, ?>[] concurrentMaps = {
        new ConcurrentHashMap<>(),// thread safe
        new ConcurrentSkipListMap<>()// thread safe
    };

  }
}