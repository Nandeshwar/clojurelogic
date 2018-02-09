(ns clojurelogic.sorting)

(defn remove-first-occurence [item items]
  (let [matched-items (filter #(= % item) items)
        new-items-after-remove (remove #(=  % item) items)
        final-items (if (> (count matched-items) 1)
                      (conj (vec new-items-after-remove) (last matched-items))
                      new-items-after-remove)]
    final-items))

(defn sortFun
  ([unSortedItems]
   (sortFun unSortedItems [] ))

  ([unSortedItems sortedItems ]
   (if (empty? unSortedItems)
     sortedItems
     (let [smallest (apply min unSortedItems)
           new-sorted-items (conj sortedItems smallest)
           new-unsorted-list (remove-first-occurence smallest unSortedItems)]
       (recur new-unsorted-list new-sorted-items)))))


