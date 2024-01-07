### Implementation Overview

- I created a class `HashMapCode` (To avoid name conflict with Java standard HashMap, I used HashMapCode as the name). 
- The class `HashMapCode` has a subclass _Node_ which stores the `<K,V>(key, value)` pair information.
- The `arrayLinkedList` stores `LinkedList<Node>` at each index (which I call a bucket).
- Initially, I initialized the `arrayLinkedList` with size 2 and a `thresholdValue` of 2 (this value is used for rehashing).

#### Rehashing
- Whenever $nodeSize/bucketSize \geq thresholdValue$, we need to do the rehashing i.e. increase the size of the buckets so that we have an average time complexity of $O(thresholdValue)$ (constant time complexity).
- In rehashing, I am increasing the `bucketSize` twice and copying old values of `arrayLinkedList` to the new increased size of `arrayLinkedList`.
