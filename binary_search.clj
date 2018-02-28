(ns clojurelogic.binary-search)

(defn binary-search [item-list item]
  (if (empty? item-list)
    false
    (let [item-list-len (count item-list)
          mid (quot item-list-len
                    2)]

      (cond
        (= item (nth item-list
                     mid))
          true

        (< item (nth item-list
                     mid))
          (let [begin 0
                new-item-list (subvec item-list
                                      begin
                                      mid)]
            (println "new-item-list: " new-item-list)
            (recur (vec new-item-list) item))

        :else
          (let [begin (inc mid)
                new-item-list (if (> begin item-list-len)
                                []
                                (subvec item-list
                                        begin))]
            (recur  (vec new-item-list) item))))))