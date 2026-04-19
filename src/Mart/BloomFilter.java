package Mart;

import java.util.BitSet;
import java.util.function.Function;

public class BloomFilter {
    private final BitSet bitSet;
    private final int size;
    private final Function<String, Integer>[] hashFunctions;

    @SuppressWarnings("unchecked")
    public BloomFilter(int size, int numberOfHashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashFunctions = new Function[numberOfHashFunctions];

        // Initialize hash functions
        for (int i = 0; i < numberOfHashFunctions; i++) {
            int hashSeed = i + 1;
            hashFunctions[i] = (String key) -> Math.abs(key.hashCode() * hashSeed) % size;
        }
    }

    public void add(String element) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int position = hashFunction.apply(element);
            bitSet.set(position);
        }
    }

    public boolean mightContain(String element) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int position = hashFunction.apply(element);
            if (!bitSet.get(position)) {
                return false; // Definitely not present
            }
        }
        return true; // Possibly present
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(1000, 3);

        bloomFilter.add("hello");
        bloomFilter.add("world");
        bloomFilter.add("hello1");
        bloomFilter.add("java1");

        System.out.println("hello is in bloom filter: " + bloomFilter.mightContain("hello"));
        System.out.println("world is in bloom filter: " + bloomFilter.mightContain("world1"));
        System.out.println("java is in bloom filter: " + bloomFilter.mightContain("java"));
    }
}

